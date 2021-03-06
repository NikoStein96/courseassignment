package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Adress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String additionalInfo;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<InfoEntity> entities;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private CityInfo cInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adress)) {
            return false;
        }
        Adress other = (Adress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<InfoEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<InfoEntity> entities) {
        this.entities = entities;
    }

    public CityInfo getcInfo() {
        return cInfo;
    }

    public void setcInfo(CityInfo cInfo) {
        this.cInfo = cInfo;
    }

    @Override
    public String toString() {
        return "Adress: " + "id: " + id + ", street: " + street + ", additionalInfo: " + additionalInfo + ", entities: " + entities + ", cInfo: " + cInfo;
    }

    
    
}
