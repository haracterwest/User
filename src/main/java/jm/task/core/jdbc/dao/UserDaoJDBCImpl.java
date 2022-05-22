package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public Connection connection;
    public Statement statement;

    public UserDaoJDBCImpl() {
        connection = Util.getConnection();
        System.out.println("База данных подключена");
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUsersTable() {
//        String request = "CREATE TABLE sys.user (user INT PRIMARY KEY AUTO_INCREMENT," +
//                "id int(20)" +
//                "name varchar(45)" +
//                "lastName varchar(45)" +
//                "age int(3))"
//                ;
        String request = ("CREATE TABLE sys.user (" +
                "id bigint AUTO_INCREMENT primary key," +
                "name VARCHAR(45) NOT NULL," +
                "lastName varchar(45) NOT NULL, " +
                "age int(3))");

        try {
            statement.executeUpdate(request);
            System.out.println("Таблица создана");
        } catch (SQLException e) {
           // e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String request = ("DROP TABLE sys.user");

        try {
            statement.executeUpdate(request);
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String request = ("INSERT INTO sys.user (name, lastName, age) Values(?, ?, ?)");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User " + name + " добавлен!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String request = ("DELETE FROM sys.user WHERE Id = ?");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setLong(1, id);
            Integer count = preparedStatement.executeUpdate();
            System.out.println("user удалён, " + count + " строк удалено");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String request = ("SELECT * FROM sys.user");
        List list = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                Long a = resultSet.getLong("id");
                String b = resultSet.getString("name");
                String c = resultSet.getString("lastName");
                Byte d = resultSet.getByte("age");

                //User user = new User(a, b, c, d);
                User user = new User(a, b, c, d);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        String request = ("DELETE FROM sys.user");

        try {
            statement.executeUpdate(request);
            System.out.println("Данные таблицы удалены");
        } catch (SQLException e) {
            //e.printStackTrace();
        }

    }
}
