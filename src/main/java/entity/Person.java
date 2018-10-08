package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person extends InfoEntity implements Serializable {


    private static final long serialVersionUID = 1L;
    
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    
    private String firstName;
    private String lastName;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Hobby> hobbier;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String email) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
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
    
    public List<Hobby> getHobbier() {
        return hobbier;
    }

    public void setHobbier(List<Hobby> hobbier) {
        this.hobbier = hobbier;
    }
    
    public void addHobbier(Hobby hobby) {
        this.hobbier.add(hobby);
    }

    @Override
    public String toString() {
        return "Person: " + "firstName: " + firstName + ", lastName: " + lastName + ", hobbier: " + hobbier;
    }
    
}
