package Facade;

import Facade.FacadePerson;
import entity.Person;
import javax.persistence.Persistence;

public class FacadeTest {
    public static void main(String[] args) {
        FacadePerson f = new FacadePerson(Persistence.createEntityManagerFactory("courseassignment"));
        Person newPerson = new Person("jens", "henningsen");
        System.out.println(f.updatePerson(20, newPerson));
    }
}
