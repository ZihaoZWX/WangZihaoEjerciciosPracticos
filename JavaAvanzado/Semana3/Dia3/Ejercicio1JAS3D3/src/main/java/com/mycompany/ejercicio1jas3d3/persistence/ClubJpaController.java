
package com.mycompany.ejercicio1jas3d3.persistence;

import com.mycompany.ejercicio1jas3d3.models.Club;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.ejercicio1jas3d3.models.GamesPlayed;
import com.mycompany.ejercicio1jas3d3.persistence.exceptions.NonexistentEntityException;
import com.mycompany.ejercicio1jas3d3.persistence.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zihao Wang
 */
public class ClubJpaController implements Serializable {

    public ClubJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ClubJpaController(){
        emf=Persistence.createEntityManagerFactory("basketPersistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Club club) throws PreexistingEntityException, Exception {
        if (club.getGames() == null) {
            club.setGames(new ArrayList<GamesPlayed>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<GamesPlayed> attachedGames = new ArrayList<GamesPlayed>();
            for (GamesPlayed gamesGamesPlayedToAttach : club.getGames()) {
                gamesGamesPlayedToAttach = em.getReference(gamesGamesPlayedToAttach.getClass(), gamesGamesPlayedToAttach.getId());
                attachedGames.add(gamesGamesPlayedToAttach);
            }
            club.setGames(attachedGames);
            em.persist(club);
            for (GamesPlayed gamesGamesPlayed : club.getGames()) {
                Club oldClubOfGamesGamesPlayed = gamesGamesPlayed.getClub();
                gamesGamesPlayed.setClub(club);
                gamesGamesPlayed = em.merge(gamesGamesPlayed);
                if (oldClubOfGamesGamesPlayed != null) {
                    oldClubOfGamesGamesPlayed.getGames().remove(gamesGamesPlayed);
                    oldClubOfGamesGamesPlayed = em.merge(oldClubOfGamesGamesPlayed);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClub(club.getName()) != null) {
                throw new PreexistingEntityException("Club " + club + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Club club) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Club persistentClub = em.find(Club.class, club.getName());
            List<GamesPlayed> gamesOld = persistentClub.getGames();
            List<GamesPlayed> gamesNew = club.getGames();
            List<GamesPlayed> attachedGamesNew = new ArrayList<GamesPlayed>();
            for (GamesPlayed gamesNewGamesPlayedToAttach : gamesNew) {
                gamesNewGamesPlayedToAttach = em.getReference(gamesNewGamesPlayedToAttach.getClass(), gamesNewGamesPlayedToAttach.getId());
                attachedGamesNew.add(gamesNewGamesPlayedToAttach);
            }
            gamesNew = attachedGamesNew;
            club.setGames(gamesNew);
            club = em.merge(club);
            for (GamesPlayed gamesOldGamesPlayed : gamesOld) {
                if (!gamesNew.contains(gamesOldGamesPlayed)) {
                    gamesOldGamesPlayed.setClub(null);
                    gamesOldGamesPlayed = em.merge(gamesOldGamesPlayed);
                }
            }
            for (GamesPlayed gamesNewGamesPlayed : gamesNew) {
                if (!gamesOld.contains(gamesNewGamesPlayed)) {
                    Club oldClubOfGamesNewGamesPlayed = gamesNewGamesPlayed.getClub();
                    gamesNewGamesPlayed.setClub(club);
                    gamesNewGamesPlayed = em.merge(gamesNewGamesPlayed);
                    if (oldClubOfGamesNewGamesPlayed != null && !oldClubOfGamesNewGamesPlayed.equals(club)) {
                        oldClubOfGamesNewGamesPlayed.getGames().remove(gamesNewGamesPlayed);
                        oldClubOfGamesNewGamesPlayed = em.merge(oldClubOfGamesNewGamesPlayed);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = club.getName();
                if (findClub(id) == null) {
                    throw new NonexistentEntityException("The club with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Club club;
            try {
                club = em.getReference(Club.class, id);
                club.getName();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The club with id " + id + " no longer exists.", enfe);
            }
            List<GamesPlayed> games = club.getGames();
            for (GamesPlayed gamesGamesPlayed : games) {
                gamesGamesPlayed.setClub(null);
                gamesGamesPlayed = em.merge(gamesGamesPlayed);
            }
            em.remove(club);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Club> findClubEntities() {
        return findClubEntities(true, -1, -1);
    }

    public List<Club> findClubEntities(int maxResults, int firstResult) {
        return findClubEntities(false, maxResults, firstResult);
    }

    private List<Club> findClubEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Club.class));
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

    public Club findClub(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Club.class, id);
        } finally {
            em.close();
        }
    }

    public int getClubCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Club> rt = cq.from(Club.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
