package hw11.adapter;

import hw11.logic.User;

import java.util.Scanner;

/**
 * Класс, реализующий интерфейс IAccessManager для аутентификации пользователей.
 */
public class AccessManager implements IAccessManager {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Регистрация нового пользователя.
     *
     * @return Возвращает созданного пользователя.
     */
    @Override
    public User registerUser() {

        System.out.println("Введите имя:");
        String username = getUserInput();

        System.out.println("Введите логин:");
        String login = getUserInput();

        System.out.println("Введите пароль:");
        String password = getUserInput();

        return new User(username, login, password);
    }

    /**
     * Аутентификация пользователя.
     *
     * @return Возвращает аутентифицированного пользователя.
     */
    @Override
    public User authenticateUser() {
        System.out.println("Введите логин:");
        String login = getUserInput();

        System.out.println("Введите пароль:");
        String password = getUserInput();

        return new User(login, password);
    }

    /**
     * Вывод данных на экран.
     *
     * @param message Сообщение для вывода.
     */
    @Override
    public void dataOutput(String message) {
        System.out.println(message);
    }

    /**
     * Метод для получения данных от пользователя через консоль.
     *
     * @return Возвращает введенную пользователем строку.
     */
    @Override
    public String getUserInput() {
        String input = scanner.nextLine();
        if (input == null) {
            return "";
        }
        return input;
    }
}
