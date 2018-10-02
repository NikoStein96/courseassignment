package jpa;

import java.util.HashMap;
import javax.persistence.Persistence;

public class Structure {
    public static void main(String[] args) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.sql-load-script-source", "Scripts/ClearDB.sql");
        Persistence.generateSchema("courseassignment", properties);
        
        properties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("courseassignment", properties);  
    }
}
