package Facade;

import DTO.PersonDTO;
import entity.CityInfo;
import entity.Company;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class FacadePerson {

    private EntityManagerFactory emf;

    public FacadePerson(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PersonDTO getPersonInformation(int phoneNumber) {
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
        PersonDTO pDTO = new PersonDTO(p);
        return pDTO;
    }
    
    
    
    public List<PersonDTO> getPersonsByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        List<Person> p = null;
        List<PersonDTO> listDTO = new ArrayList();
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Person p WHERE p.hobbier.name = :hobby");
        query.setParameter("hobby", hobby);
        p = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        for (Person person : p) {
            PersonDTO pDTO = new PersonDTO(person);
            listDTO.add(pDTO);
        }
        return listDTO;
    }
    
    public List<PersonDTO> getPersonByCity(int zipCode) {
        EntityManager em = emf.createEntityManager();
        List<Person> p = null;
        List<PersonDTO> listDTO = new ArrayList();
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Person p Where p.adress.cInfo.zipcode = :zipCode");

        query.setParameter("zipCode", zipCode);
        p = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        for (Person person : p) {
            PersonDTO pDTO = new PersonDTO(person);
            listDTO.add(pDTO);
        }
        return listDTO;
    }
    
    public int getHobbySizeByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        int hobbySize = 0;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Person p WHERE p.hobbier.name = :hobby");
        query.setParameter("hobby", hobby);
        hobbySize = query.getResultList().size();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return hobbySize;
    }
    
}
