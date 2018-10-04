package entity;

import entity.CityInfo;
import entity.InfoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-04T10:40:02")
=======
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-04T10:17:39")
>>>>>>> 8511b8e6a8b76abf7f49184d7d41fd1943ac1796
=======
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-04T11:19:24")
>>>>>>> 4dd732a8bbf6028417cae603f8b1147d35222597
@StaticMetamodel(Adress.class)
public class Adress_ { 

    public static volatile SingularAttribute<Adress, CityInfo> cInfo;
    public static volatile ListAttribute<Adress, InfoEntity> entities;
    public static volatile SingularAttribute<Adress, String> street;
    public static volatile SingularAttribute<Adress, String> additionalInfo;
    public static volatile SingularAttribute<Adress, Long> id;

}