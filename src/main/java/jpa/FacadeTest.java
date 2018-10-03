package jpa;

import javax.persistence.Persistence;

public class FacadeTest {
    public static void main(String[] args) {
        Facade f = new Facade(Persistence.createEntityManagerFactory("courseassignment"));
        System.out.println(f.getPersonByCity(4600));
    }
}
