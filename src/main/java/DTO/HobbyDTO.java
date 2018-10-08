package DTO;

import entity.Hobby;
import entity.Person;

public class HobbyDTO {

    private long id;
    private String name;
    private String description;
    private String persons;

    public HobbyDTO(Hobby hobby) {
        this.id = hobby.getId();
        this.name = hobby.getName();
        this.description = hobby.getDescription();
    }

    public HobbyDTO(long id, String name, String description, String persons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.persons = persons;
    }

    public HobbyDTO(String name, String description, String persons) {
        this.name = name;
        this.description = description;
        this.persons = persons;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

}
