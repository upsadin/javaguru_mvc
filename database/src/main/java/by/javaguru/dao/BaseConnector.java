package by.javaguru.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseConnector {
    private static final String URL_KEY = PropertiesUtil.get("db.url");
    private static final String LOGIN = PropertiesUtil.get("db.login");
    private static final String PASSWORD = PropertiesUtil.get("db.password");

    private BaseConnector() {
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(URL_KEY, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Connection open = open();
        try {

            System.out.println(open.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
