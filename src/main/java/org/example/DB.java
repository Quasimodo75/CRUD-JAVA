package org.example;
import java.sql.*;


public class DB {


    public static Connection getConnection() throws ClassNotFoundException, SQLException {


        String url = "jdbc:postgresql://localhost:5432/CRUD";
        String user = "postgres";
        String password = "Letsdoit";
        Connection conn = null;

        Class.forName(
                "org.postgresql.Driver"); // Driver name


        Connection connection = DriverManager.getConnection(
                url, user, password);
        System.out.println(
                "Connection was successfully");
        return null;
    }
}






















