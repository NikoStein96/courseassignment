package entity;

import entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-06T14:25:40")
=======
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-06T20:07:41")
>>>>>>> 189ea7497b148c0524a6fea395d36fb772dcb03a
@StaticMetamodel(Hobby.class)
public class Hobby_ { 

    public static volatile ListAttribute<Hobby, Person> persons;
    public static volatile SingularAttribute<Hobby, String> name;
    public static volatile SingularAttribute<Hobby, String> description;
    public static volatile SingularAttribute<Hobby, Long> id;

}