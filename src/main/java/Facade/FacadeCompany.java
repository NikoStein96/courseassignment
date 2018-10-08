package Facade;

import DTO.CompanyDTO;
import entity.Company;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class FacadeCompany {

    private EntityManagerFactory emf;

    public FacadeCompany(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public CompanyDTO getCompanyInformation(int phoneNumber) {
        EntityManager em = emf.createEntityManager();
        Company c = null;
        CompanyDTO cDTO = null;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select ie From InfoEntity ie INNER JOIN ie.phones p where p.number= :phoneNumber");
        query.setParameter("phoneNumber",phoneNumber);
        c = (Company) query.getSingleResult();
        cDTO = new CompanyDTO(c);
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return cDTO;
    }
    
    public List<CompanyDTO> getCompanyByEmployees(int employeesNumber) {
        EntityManager em = emf.createEntityManager();
        List<Company> companyList = null;
        List<CompanyDTO> dtoList = new ArrayList();
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select c from Company c WHERE c.numEmployees >= :employeesNumber");
        query.setParameter("employeesNumber",employeesNumber);
        companyList = query.getResultList();
        em.getTransaction().commit();
        for (Company company : companyList) {
            CompanyDTO cDTO = new CompanyDTO(company);
            dtoList.add(cDTO);
        }
        } finally {
            em.close();
        }
        return dtoList;
    }
    
    public List<CompanyDTO> getAllCompanies() {
        EntityManager em = emf.createEntityManager();
        List<Company> c = null;
        List<CompanyDTO> dtoList = new ArrayList();
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Company p");
        c = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        for (Company company : c) {
            CompanyDTO cDTO = new CompanyDTO(company);
            dtoList.add(cDTO);
        }
        return dtoList;
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
