package myapp.dao;

import javax.persistence.*;

import myapp.model.Person;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
     EntityManager em;


    public Person addPerson(Person p) {
        em.persist(p);
        return (p);
    }

    public Person getPersonById(Long id) {
        return em.find(Person.class, id);
    }

    public void updatePerson(Person person) {
        em.merge(person);
    }

    public void deletePerson(Long id) {
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
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