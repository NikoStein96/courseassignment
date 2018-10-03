package Facade;

import entity.CityInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class FacadeCity {
    private EntityManagerFactory emf;

    public FacadeCity(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<CityInfo> danishZipcodes() {
        EntityManager em = emf.createEntityManager();
        List<CityInfo> danishZip = null;
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select z from CityInfo z WHERE z.zipCode BETWEEN 1000 and 9999");
        danishZip = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        return danishZip;
    }
}
