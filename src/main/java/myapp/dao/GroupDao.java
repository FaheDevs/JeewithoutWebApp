package myapp.dao;

import myapp.model.GroupTable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
@Transactional
public class GroupDao {

    @PersistenceContext
    private EntityManager em;

    public GroupTable addGroup(GroupTable group) {
        em.persist(group);
        return group;
    }

    public GroupTable getGroupById(Long id) {
        return em.find(GroupTable.class, id);
    }

    public void updateGroup(GroupTable group) {
        em.merge(group);
    }

    public void deleteGroup(Long id) {
        GroupTable group = em.find(GroupTable.class, id);
        if (group != null) {
            em.remove(group);
        }
    }

    public <T> T find(Class<T> clazz, Object id) {
        return em.find(clazz, id);
    }

    public <T> Collection<T> findAll(String query, Class<T> clazz) {
        TypedQuery<T> q = em.createQuery(query, clazz);
        return q.getResultList();
    }

    public <T> T add(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T update(T entity) {
        return em.merge(entity);
    }

    public <T> void remove(Class<T> clazz, Object pk) {
        T entity = em.find(clazz, pk);
        if (entity != null) {
            em.remove(entity);
        }
    }
}
