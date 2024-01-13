
package com.mycompany.ejercicio1jas3d3.persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.ejercicio1jas3d3.models.Club;
import com.mycompany.ejercicio1jas3d3.models.GamesPlayed;
import com.mycompany.ejercicio1jas3d3.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zihao Wang
 */
public class GamesPlayedJpaController implements Serializable {

    public GamesPlayedJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public GamesPlayedJpaController(){
        emf=Persistence.createEntityManagerFactory("basketPersistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GamesPlayed gamesPlayed) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Club club = gamesPlayed.getClub();
            if (club != null) {
                club = em.getReference(club.getClass(), club.getName());
                gamesPlayed.setClub(club);
            }
            Club club2 = gamesPlayed.getClub2();
            if (club2 != null) {
                club2 = em.getReference(club2.getClass(), club2.getName());
                gamesPlayed.setClub2(club2);
            }
            em.persist(gamesPlayed);
            if (club != null) {
                club.getGames().add(gamesPlayed);
                club = em.merge(club);
            }
            if (club2 != null) {
                club2.getGames().add(gamesPlayed);
                club2 = em.merge(club2);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GamesPlayed gamesPlayed) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GamesPlayed persistentGamesPlayed = em.find(GamesPlayed.class, gamesPlayed.getId());
            Club clubOld = persistentGamesPlayed.getClub();
            Club clubNew = gamesPlayed.getClub();
            Club club2Old = persistentGamesPlayed.getClub2();
            Club club2New = gamesPlayed.getClub2();
            if (clubNew != null) {
                clubNew = em.getReference(clubNew.getClass(), clubNew.getName());
                gamesPlayed.setClub(clubNew);
            }
            if (club2New != null) {
                club2New = em.getReference(club2New.getClass(), club2New.getName());
                gamesPlayed.setClub2(club2New);
            }
            gamesPlayed = em.merge(gamesPlayed);
            if (clubOld != null && !clubOld.equals(clubNew)) {
                clubOld.getGames().remove(gamesPlayed);
                clubOld = em.merge(clubOld);
            }
            if (clubNew != null && !clubNew.equals(clubOld)) {
                clubNew.getGames().add(gamesPlayed);
                clubNew = em.merge(clubNew);
            }
            if (club2Old != null && !club2Old.equals(club2New)) {
                club2Old.getGames().remove(gamesPlayed);
                club2Old = em.merge(club2Old);
            }
            if (club2New != null && !club2New.equals(club2Old)) {
                club2New.getGames().add(gamesPlayed);
                club2New = em.merge(club2New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = gamesPlayed.getId();
                if (findGamesPlayed(id) == null) {
                    throw new NonexistentEntityException("The gamesPlayed with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GamesPlayed gamesPlayed;
            try {
                gamesPlayed = em.getReference(GamesPlayed.class, id);
                gamesPlayed.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gamesPlayed with id " + id + " no longer exists.", enfe);
            }
            Club club = gamesPlayed.getClub();
            if (club != null) {
                club.getGames().remove(gamesPlayed);
                club = em.merge(club);
            }
            Club club2 = gamesPlayed.getClub2();
            if (club2 != null) {
                club2.getGames().remove(gamesPlayed);
                club2 = em.merge(club2);
            }
            em.remove(gamesPlayed);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GamesPlayed> findGamesPlayedEntities() {
        return findGamesPlayedEntities(true, -1, -1);
    }

    public List<GamesPlayed> findGamesPlayedEntities(int maxResults, int firstResult) {
        return findGamesPlayedEntities(false, maxResults, firstResult);
    }

    private List<GamesPlayed> findGamesPlayedEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GamesPlayed.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public GamesPlayed findGamesPlayed(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GamesPlayed.class, id);
        } finally {
            em.close();
        }
    }

    public int getGamesPlayedCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GamesPlayed> rt = cq.from(GamesPlayed.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
