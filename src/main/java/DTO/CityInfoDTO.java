package DTO;

import entity.Adress;
import entity.CityInfo;

public class CityInfoDTO {

    private long id;
    private int zipCode;
    private String city;
    private String Address;

    public CityInfoDTO(CityInfo cityinfo) {
        this.zipCode = cityinfo.getZipCode();
        this.city = cityinfo.getCity();
        for (Adress o : cityinfo.getAddress()) {
            this.Address = o.toString();
        }

    }

    public CityInfoDTO(long id, int zipCode, String city, String Address) {
        this.id = id;
        this.zipCode = zipCode;
        this.city = city;
        this.Address = Address;
    }

    public CityInfoDTO(int zipCode, String city, String Address) {
        this.zipCode = zipCode;
        this.city = city;
        this.Address = Address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

}
