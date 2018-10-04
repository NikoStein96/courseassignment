package entity;

import entity.Adress;
import entity.Phone;
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
@StaticMetamodel(InfoEntity.class)
public class InfoEntity_ { 

    public static volatile ListAttribute<InfoEntity, Phone> phones;
    public static volatile SingularAttribute<InfoEntity, Adress> adress;
    public static volatile SingularAttribute<InfoEntity, Long> id;
    public static volatile SingularAttribute<InfoEntity, String> email;

}