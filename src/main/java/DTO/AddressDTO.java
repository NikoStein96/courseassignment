package DTO;

import entity.Adress;
import entity.CityInfo;
import entity.InfoEntity;
import java.util.Collection;
import java.util.List;

public class AddressDTO {

    private long id;
    private String street;
    private String additionalInfo;
    private String IE;
    private String cityInfo;

    public AddressDTO(Adress adress) {
        this.street = adress.getStreet();
        this.additionalInfo = adress.getAdditionalInfo();
        this.IE = adress.getEntities().toString();
        for (InfoEntity o : adress.getEntities()) {
            this.IE = o.getEmail();
        }
        this.cityInfo = adress.getcInfo().getCity();
    }

    public AddressDTO(long id, String street, String additionalInfo, String IE, String cityInfo) {
        this.id = id;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.IE = IE;
        this.cityInfo = cityInfo;
    }

    public AddressDTO(String street, String additionalInfo, String IE, String cityInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.IE = IE;
        this.cityInfo = cityInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(String cityInfo) {
        this.cityInfo = cityInfo;
    }
    

}
