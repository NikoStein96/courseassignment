package jpa;

import entity.Company;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class Facade {

    private EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Person getPersonInformation(int phoneNumber) {
        EntityManager em = emf.createEntityManager();
        Person p = null;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Person p WHERE p.phones.number = :phoneNumber");
        query.setParameter("phoneNumber", phoneNumber);
        p = (Person) query.getSingleResult();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }
    
    public Company getCompanyInformation(int phoneNumber) {
        EntityManager em = emf.createEntityManager();
        Company c = null;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Company p WHERE p.phones.number = :phoneNumber");
        query.setParameter("phoneNumber",phoneNumber);
        c = (Company) query.getSingleResult();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }
    
    public List<Person> getPersonsByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        List<Person> p = null;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Person p WHERE p.hobbier.name = :hobby");
        query.setParameter("hobby", hobby);
        p = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }
    
    public List<Person> getPersonByCity(int zipCode) {
        EntityManager em = emf.createEntityManager();
        List<Person> p = null;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Person p Where p.adress. = :zipCode");
        //Query query = em.createQuery("Select ie from InfoEntity ie WHERE TYPE(ie) = Person and ie.adress.cInfo.zipCode = :zipCode");
        query.setParameter("zipCode", zipCode);
        p = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }
}
