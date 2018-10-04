package Facade;

import DTO.CityInfoDTO;
import entity.CityInfo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class FacadeCity {
    private EntityManagerFactory emf;

    public FacadeCity(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<CityInfoDTO> danishZipcodes() {
        EntityManager em = emf.createEntityManager();
        List<CityInfo> danishZip = null;
        List<CityInfoDTO> listDTO = new ArrayList();
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("Select z from CityInfo z WHERE z.zipCode BETWEEN 1000 and 9999");
        danishZip = query.getResultList();
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        for (CityInfo c : danishZip) {
            CityInfoDTO cDTO = new CityInfoDTO(c);
            listDTO.add(cDTO);
        }
        return listDTO;
    }
}
