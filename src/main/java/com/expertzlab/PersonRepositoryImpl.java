package com.expertzlab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonRepositoryImpl implements PersonRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("XYZ");
    private EntityManager em;

    public PersonRepositoryImpl() {
        em = emf.createEntityManager();
    }

    @Override
    public Person create(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        return person;
    }

    @Override
    public Person read(Long id) {
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.getTransaction().commit();
        return person;
    }

    @Override
    public Person update(Person person) {
        em.getTransaction().begin();
        person = em.merge(person);
        em.getTransaction().commit();
        return person;
    }

    @Override
    public void delete(Person person) {
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }


}