package entity;

import entity.Adress;
import entity.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-06T14:25:40")
=======
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-06T20:07:41")
>>>>>>> 189ea7497b148c0524a6fea395d36fb772dcb03a
@StaticMetamodel(InfoEntity.class)
public class InfoEntity_ { 

    public static volatile ListAttribute<InfoEntity, Phone> phones;
    public static volatile SingularAttribute<InfoEntity, Adress> adress;
    public static volatile SingularAttribute<InfoEntity, Long> id;
    public static volatile SingularAttribute<InfoEntity, String> email;

}