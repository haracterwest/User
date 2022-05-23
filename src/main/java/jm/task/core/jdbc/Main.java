package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Иван", "Иванов", (byte) 30);
        userService.saveUser("Сергей", "Сергеевич", (byte) 32);
        userService.saveUser("Александр", "Александров", (byte) 22);
        userService.saveUser("Алексей", "Навальный", (byte) 45);
        userService.getAllUsers();
        System.out.println((userService.getAllUsers()));
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
