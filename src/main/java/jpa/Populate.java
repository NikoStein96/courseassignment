package jpa;

import java.util.HashMap;
import javax.persistence.Persistence;

public class Populate {
    public static void main(String[] args) {
         HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.sql-load-script-source", "Scripts/Populate.sql");
        Persistence.generateSchema("courseassignment", properties);
    }
}
