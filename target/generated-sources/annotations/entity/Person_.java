package entity;

import entity.Hobby;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-08T11:13:52")
=======
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-08T11:10:14")
>>>>>>> 224bf03f34bd26e8a534d47d383a24b6a4ecc443
@StaticMetamodel(Person.class)
public class Person_ extends InfoEntity_ {

    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile ListAttribute<Person, Hobby> hobbier;

}