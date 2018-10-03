package Facade;

import entity.Company;
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
}
