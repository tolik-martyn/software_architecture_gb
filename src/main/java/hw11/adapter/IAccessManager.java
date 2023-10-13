package hw11.adapter;

import hw11.logic.User;

/**
 * Интерфейс для аутентификации пользователей.
 */
public interface IAccessManager {

    /**
     * Регистрация нового пользователя.
     *
     * @return Возвращает созданного пользователя.
     */
    User registerUser();

    /**
     * Аутентификация пользователя.
     *
     * @return Возвращает аутентифицированного пользователя.
     */
    User authenticateUser();

    /**
     * Вывод данных на экран.
     *
     * @param message Сообщение для вывода.
     */
    void dataOutput(String message);

    /**
     * Метод для получения данных от пользователя через консоль.
     *
     * @return Возвращает введенную пользователем строку.
     */
    String getUserInput();
}
