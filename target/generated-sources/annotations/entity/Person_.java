package entity;

import entity.Hobby;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-08T14:29:16")
@StaticMetamodel(Person.class)
public class Person_ extends InfoEntity_ {

    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile ListAttribute<Person, Hobby> hobbier;

}