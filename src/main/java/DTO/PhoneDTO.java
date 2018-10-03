package DTO;

import entity.InfoEntity;
import entity.Phone;

public class PhoneDTO {

    private Long id;
    private int number;
    private String description;
    private String entity;

    public PhoneDTO(Phone phone) {
        this.number = phone.getNumber();
        this.description = phone.getDescription();
        this.entity = phone.getEntity().toString();
    }
        public PhoneDTO(Long id, int number, String description, String entity) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.entity = entity;
    }

            public PhoneDTO(int number, String description, String entity) {
        this.number = number;
        this.description = description;
        this.entity = entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }


}
