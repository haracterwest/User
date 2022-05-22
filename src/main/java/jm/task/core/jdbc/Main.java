package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Иван", "Иванов", (byte) 30);
        userDaoJDBC.saveUser("Сергей", "Сергеевич", (byte) 32);
        userDaoJDBC.saveUser("Александр", "Александров", (byte) 22);
        userDaoJDBC.saveUser("Алексей", "Навальный", (byte) 45);
        userDaoJDBC.getAllUsers();
        System.out.println((userDaoJDBC.getAllUsers()));
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}


//    Создание таблицы User(ов)
//          Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
//         Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
//         Очистка таблицы User(ов)
//         Удаление таблицы