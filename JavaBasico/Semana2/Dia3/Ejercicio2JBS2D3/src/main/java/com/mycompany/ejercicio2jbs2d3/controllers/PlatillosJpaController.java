
package com.mycompany.ejercicio2jbs2d3.controllers;

import com.mycompany.ejercicio2jbs2d3.controllers.exceptions.NonexistentEntityException;
import com.mycompany.ejercicio2jbs2d3.models.Platillos;
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
public class PlatillosJpaController implements Serializable {

    public PlatillosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PlatillosJpaController(){
        emf=Persistence.createEntityManagerFactory("restauranteJPA");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Platillos platillos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(platillos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Platillos platillos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            platillos = em.merge(platillos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = platillos.getId();
                if (findPlatillos(id) == null) {
                    throw new NonexistentEntityException("The platillos with id " + id + " no longer exists.");
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
            Platillos platillos;
            try {
                platillos = em.getReference(Platillos.class, id);
                platillos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The platillos with id " + id + " no longer exists.", enfe);
            }
            em.remove(platillos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Platillos> findPlatillosEntities() {
        return findPlatillosEntities(true, -1, -1);
    }

    public List<Platillos> findPlatillosEntities(int maxResults, int firstResult) {
        return findPlatillosEntities(false, maxResults, firstResult);
    }

    private List<Platillos> findPlatillosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Platillos.class));
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

    public Platillos findPlatillos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Platillos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlatillosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Platillos> rt = cq.from(Platillos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
