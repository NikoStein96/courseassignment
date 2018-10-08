package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.3.v20180807-rNA", date="2018-10-08T12:58:11")
@StaticMetamodel(Company.class)
public class Company_ extends InfoEntity_ {

    public static volatile SingularAttribute<Company, Integer> numEmployees;
    public static volatile SingularAttribute<Company, String> name;
    public static volatile SingularAttribute<Company, String> description;
    public static volatile SingularAttribute<Company, Integer> marketValue;
    public static volatile SingularAttribute<Company, Integer> cvr;

}