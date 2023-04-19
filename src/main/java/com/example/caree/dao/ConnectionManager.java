package com.example.caree.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/caree";
    private static final String USER = "Térence";
    private static final String PASSWORD = "33(Tetenoking)33";

    private static Connection INSTANCE;

    private ConnectionManager() {
    }

    public static Connection getInstance() {
        if (INSTANCE == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                INSTANCE = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return INSTANCE;
    }

    public static void closeConnection() throws SQLException {
        if (INSTANCE != null && !INSTANCE.isClosed()) {
            INSTANCE.close();
        }
    }

}
