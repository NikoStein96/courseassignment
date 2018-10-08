package entity;

import entity.CityInfo;
import entity.InfoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-08T11:13:52")
=======
@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-08T11:10:14")
>>>>>>> 224bf03f34bd26e8a534d47d383a24b6a4ecc443
@StaticMetamodel(Adress.class)
public class Adress_ { 

    public static volatile SingularAttribute<Adress, CityInfo> cInfo;
    public static volatile ListAttribute<Adress, InfoEntity> entities;
    public static volatile SingularAttribute<Adress, String> street;
    public static volatile SingularAttribute<Adress, String> additionalInfo;
    public static volatile SingularAttribute<Adress, Long> id;

}