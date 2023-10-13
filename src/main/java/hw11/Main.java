package hw11;

import hw11.adapter.AccessManager;
import hw11.adapter.IAccessManager;
import hw11.data.AccessRepository;
import hw11.data.IAccessRepository;
import hw11.logic.AccessController;

public class Main {
    public static void main(String[] args) {

        IAccessManager accessManager = new AccessManager();
        IAccessRepository accessRepository = new AccessRepository();
        AccessController accessController = new AccessController(accessManager, accessRepository);

        System.out.println("Демонстрация успешной регистрации:");
        accessController.registerUser(); // Введите имя: Alice, логин: alice123, пароль: secret

        System.out.println("\nДемонстрация неуспешной регистрации (пользователь с таким логином уже существует):");
        accessController.registerUser(); // Введите имя: Bob, логин: alice123, пароль: secret

        // Демонстрация успешной авторизации
        System.out.println("\nДемонстрация успешной авторизации:");
        accessController.authenticateUser(); // Введите логин: alice123, пароль: secret

        // Демонстрация неуспешной авторизации (неверный пароль)
        System.out.println("\nДемонстрация неуспешной авторизации (неверный пароль):");
        accessController.authenticateUser(); // Введите логин: alice123, пароль: wrongpassword

        // Демонстрация неуспешной авторизации (неверный логин)
        System.out.println("\nДемонстрация неуспешной авторизации (неверный логин):");
        accessController.authenticateUser(); // Введите логин: alice321, пароль: secret
    }
}
