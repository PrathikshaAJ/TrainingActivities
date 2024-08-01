package com.mindsprint.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    public static Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mindsprint";
        String username = "root";
        String password = "prathi@2002";
        Connection conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Error while connecting");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Class Not Found: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}