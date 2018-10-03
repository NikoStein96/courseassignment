package DTO;

import entity.InfoEntity;
import entity.Phone;

public class InfoEntityDTO {

    private long id;
    private String email;
    private int phone;
    private String adress;

    public InfoEntityDTO(InfoEntity infoentity) {
        this.email = infoentity.getEmail();
        for (Phone o : infoentity.getPhones()) {
            this.phone = o.getNumber();
        }

        this.adress = infoentity.getAdress().getStreet();
    }

    public InfoEntityDTO(long id, String email, int phone, String adress) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
    }

    public InfoEntityDTO(String email, int phone, String adress) {
        this.email = email;
        this.phone = phone;
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
