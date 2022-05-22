package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Connection connection;

    public static Connection getConnection() {

        String URL = "jdbc:mysql://localhost:3306/sys";
        String USERNAME = "root";
        String PASSWORD = "MySQLNhfycajhvfnjh_97531";


        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }


            if (connection.isClosed()) {
                System.out.println("Соединение с БД закрыто");
            }

        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера!");
            e.printStackTrace();
        }
        return connection;
    }


//    public static Connection getConnection() {
//
//
//
//
//        Connection connection = null;
//        connection = DriverManager.getConnection(id, name, lastName, age);
//    }
    // реализуйте настройку соеденения с БД
}
