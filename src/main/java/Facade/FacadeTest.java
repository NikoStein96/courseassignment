package Facade;

import Facade.FacadePerson;
import javax.persistence.Persistence;

public class FacadeTest {
    public static void main(String[] args) {
        FacadePerson f = new FacadePerson(Persistence.createEntityManagerFactory("courseassignment"));
        System.out.println(f.getPersonByCity(4600));
    }
}
