package com.tokarskia.BackendMagisterka.HelperClasses;

import org.springframework.data.util.Pair;

import javax.xml.transform.Result;
import java.sql.*;

public class DatabaseDataGetter {
    static public Pair<String, String> getTexts(){
        try{
            Connection conn = DriverManager.getConnection("connectionString");
            Statement stmt = conn.createStatement();
            String sql = "select costam";
            ResultSet rl = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("En SQL Error Occured");
        }
        return Pair.of("a", "b");
    }
}
