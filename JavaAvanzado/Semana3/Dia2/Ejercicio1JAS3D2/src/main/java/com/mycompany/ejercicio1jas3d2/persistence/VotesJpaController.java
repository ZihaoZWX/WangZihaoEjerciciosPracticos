
package com.mycompany.ejercicio1jas3d2.persistence;

import com.mycompany.ejercicio1jas3d2.models.Votes;
import com.mycompany.ejercicio1jas3d2.persistence.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Zihao Wang
 */
public class VotesJpaController implements Serializable {

    public VotesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public VotesJpaController(){
        emf=Persistence.createEntityManagerFactory("votesPersistence");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Votes votos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(votos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Votes votos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            votos = em.merge(votos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = votos.getId();
                if (findVotos(id) == null) {
                    throw new NonexistentEntityException("The votos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Votes votos;
            try {
                votos = em.getReference(Votes.class, id);
                votos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The votos with id " + id + " no longer exists.", enfe);
            }
            em.remove(votos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Votes> findVotosEntities() {
        return findVotosEntities(true, -1, -1);
    }

    public List<Votes> findVotosEntities(int maxResults, int firstResult) {
        return findVotosEntities(false, maxResults, firstResult);
    }

    private List<Votes> findVotosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Votes.class));
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

    public Votes findVotos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Votes.class, id);
        } finally {
            em.close();
        }
    }

    public int getVotosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Votes> rt = cq.from(Votes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
