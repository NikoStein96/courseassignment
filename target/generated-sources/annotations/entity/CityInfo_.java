package entity;

import entity.Adress;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-04T11:19:24")
@StaticMetamodel(CityInfo.class)
public class CityInfo_ { 

    public static volatile SingularAttribute<CityInfo, Integer> zipCode;
    public static volatile ListAttribute<CityInfo, Adress> address;
    public static volatile SingularAttribute<CityInfo, String> city;
    public static volatile SingularAttribute<CityInfo, Long> id;

}