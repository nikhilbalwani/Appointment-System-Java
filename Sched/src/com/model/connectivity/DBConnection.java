package com.model.connectivity; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException, Exception {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/schedschema?autoReconnect=true&useSSL=false";

        //  Database credentials
        final String USER = "root";
        final String PASS = "cheesy123";

        Connection conn = null;

        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        return conn;
    }

    public static void main(String[] args) {

        try {
        Connection conn = getConnection();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}