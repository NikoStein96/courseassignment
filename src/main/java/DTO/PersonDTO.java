package DTO;

import entity.Hobby;
import entity.Person;

public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String hobbyer;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        for (Hobby o : person.getHobbier()) {
            this.hobbyer = o.getName();
        }

    }

    public PersonDTO(Long id, String firstName, String lastName, String hobbyer) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbyer = hobbyer;
    }

    public PersonDTO(String firstName, String lastName, String hobbyer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbyer = hobbyer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHobbyer() {
        return hobbyer;
    }

    public void setHobbyer(String hobbyer) {
        this.hobbyer = hobbyer;
    }

}
