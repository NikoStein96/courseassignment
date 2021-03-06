package Facade;

import DTO.PersonDTO;
import Exceptions.PersonNotFoundException;
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

    public List<PersonDTO> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> listDTO = new ArrayList();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select p from Person p");
            List<Person> p = query.getResultList();
            for (Person person : p) {
                PersonDTO pDTO = new PersonDTO(person);
                listDTO.add(pDTO);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return listDTO;
    }

    public PersonDTO getPersonInformation(int phoneNumber) {
        EntityManager em = emf.createEntityManager();
        Person p = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select ie From InfoEntity ie INNER JOIN ie.phones p where p.number = :phoneNumber");
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
            Query query = em.createQuery("Select p From Person p INNER JOIN p.hobbier h Where h.name = :hobby");
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
            Query query = em.createQuery("Select ie from InfoEntity ie Where Type(ie) = Person AND ie.adress.cInfo.zipCode = :zipCode");
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
        List<Person> hobbySize = new ArrayList();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select p From Person p INNER JOIN p.hobbier h Where h.name = :hobby");
            query.setParameter("hobby", hobby);
            hobbySize = query.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return hobbySize.size();
    }

    public PersonDTO createPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        PersonDTO pDTO = null;
        try {
            em.getTransaction().begin();
            Person person = new Person(p.getFirstName(), p.getLastName());
            em.persist(person);
            pDTO = new PersonDTO(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return pDTO;
    }

    public PersonDTO deletePerson(long id) {
        EntityManager em = emf.createEntityManager();
        PersonDTO pDTO = null;
        try {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            pDTO = new PersonDTO(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return pDTO;
    }

    public PersonDTO updatePerson(long id, Person newPerson) {
        EntityManager em = emf.createEntityManager();
        PersonDTO pDTO = null;
        try {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            //p.setAdress(newPerson.getAdress());
            //p.setEmail(newPerson.getEmail());
            p.setFirstName(newPerson.getFirstName());
            //p.setHobbier(newPerson.getHobbier());
            p.setLastName(newPerson.getLastName());
            //p.setPhones(newPerson.getPhones());
            pDTO = new PersonDTO(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return pDTO;
    }

    public PersonDTO getPersonById(long id) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        Person p = null;
        PersonDTO pDTO = null;
        try {
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            if(p == null) {
            throw new PersonNotFoundException("Person doesn't exist..");
            }
            em.persist(p);
            pDTO = new PersonDTO(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return pDTO;
    }

}
