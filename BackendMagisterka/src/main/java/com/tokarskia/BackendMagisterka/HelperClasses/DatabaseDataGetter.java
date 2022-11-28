package com.tokarskia.BackendMagisterka.HelperClasses;

import org.springframework.data.util.Pair;
import java.sql.*;

public class DatabaseDataGetter {
    static public Pair<String, String> getTexts(String textsLength, String textsType, String dbmsType){
        switch (dbmsType){
            case "mysql":
                return getTextsFromMySQL(textsLength, textsType);
            case "mssql":
                return getTextsFromMsSQL(textsLength, textsType);
            case "oracledb":
                return getTextsFromOracleDB(textsLength, textsType);
            default:
                System.out.println("Nieprawidłowy typ bazy danych");
                return Pair.of("a","a");
        }
    }

    private static Pair<String, String> getTextsFromOracleDB(String textsLength, String textsType) {

        return Pair.of("a","a");
    }

    private static Pair<String, String> getTextsFromMsSQL(String textsLength, String textsType) {
        try {
            String connectionString = "jdbc:sqlserver://AREKSLAPTOP\\SQLEXPRESS;databaseName=baza_tekstow;encrypt=true;trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(connectionString,"ns","Mssq.001464");
            Statement stmt = conn.createStatement();
            String sql = String.format("select tekst_%s from tekty_%s", textsType, textsLength);
            ResultSet rl = stmt.executeQuery(sql);
            rl.next();
            String text1 = rl.getString(String.format("tekst_%s", textsType));
            rl.next();
            String text2 = rl.getString(String.format("tekst_%s", textsType));
            return Pair.of(text1, text2);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("En SQL Error Occured");
            return Pair.of("a", "a");
        }
    }

    private static Pair<String, String> getTextsFromMySQL(String textsLength, String textsType){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/baza_tekstow";
            Connection conn = DriverManager.getConnection(connectionString,"root", "Mysq.001464");
            Statement stmt = conn.createStatement();
            String sql = String.format("select tekst_%s from baza_tekstow.tekty_%s", textsType, textsLength);
            ResultSet rl = stmt.executeQuery(sql);
            rl.next();
            String text1 = rl.getString(String.format("tekst_%s", textsType));
            rl.next();
            String text2 = rl.getString(String.format("tekst_%s", textsType));
            return Pair.of(text1, text2);
        } catch (SQLException e) {
            System.out.println("En SQL Error Occured");
            return Pair.of("a", "a");
        } catch (ClassNotFoundException e) {
            System.out.println("En ClassNotFoundException Error Occured");
            return Pair.of("b", "b");
        }
    }
}
