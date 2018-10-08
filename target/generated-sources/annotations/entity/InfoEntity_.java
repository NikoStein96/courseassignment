package entity;

import entity.Adress;
import entity.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-08T11:13:52")
=======
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-08T11:10:14")
>>>>>>> 224bf03f34bd26e8a534d47d383a24b6a4ecc443
@StaticMetamodel(InfoEntity.class)
public class InfoEntity_ { 

    public static volatile ListAttribute<InfoEntity, Phone> phones;
    public static volatile SingularAttribute<InfoEntity, Adress> adress;
    public static volatile SingularAttribute<InfoEntity, Long> id;
    public static volatile SingularAttribute<InfoEntity, String> email;

}