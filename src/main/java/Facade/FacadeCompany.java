package Facade;

import DTO.PersonDTO;
import entity.Company;
import entity.Hobby;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class FacadeCompany {

    private EntityManagerFactory emf;

    public FacadeCompany(EntityManagerFactory emf) {
        this.emf = emf;
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
    
    public List<Company> getCompanyByEmployees(int employeesNumber) {
        EntityManager em = emf.createEntityManager();
        List<Company> c = null;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Company p WHERE p.numEmployees >= :employeesNumber");
        query.setParameter("employeesNumber",employeesNumber);
        c = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }
    
    public List<Company> getAllCompanies() {
        EntityManager em = emf.createEntityManager();
        List<Company> c = null;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Company p");
        c = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }
    
    public Company createCompany(String name, String desc, int cvr, int empNum, int marketValue) {
        EntityManager em = emf.createEntityManager();
        Company c = null;
        try {
        em.getTransaction().begin();
        c = new Company(name, desc, cvr, empNum, marketValue);
        em.persist(c);
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }
    
    public Company deleteCompanyById(long id) {
        EntityManager em = emf.createEntityManager();
        Company c = null;
        try {
        em.getTransaction().begin();
        c = em.find(Company.class, id);
        em.remove(c);
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }
    
    public Company updateCompanyById(long id, Company company) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Company c = null;
        try {
        c = em.find(Company.class, id);
        c.setAdress(company.getAdress());
        c.setCvr(company.getCvr());
        c.setDescription(company.getDescription());
        c.setEmail(company.getEmail());
        c.setMarketValue(company.getMarketValue());
        c.setName(company.getName());
        c.setNumEmployees(company.getNumEmployees());
        c.setPhones(company.getPhones());
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }
}
