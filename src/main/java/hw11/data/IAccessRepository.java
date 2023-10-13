package hw11.data;

import hw11.logic.Token;
import hw11.logic.User;

/**
 * Интерфейс для хранения и управления токенами доступа.
 */
public interface IAccessRepository {

    /**
     * Сохраняет токен для пользователя.
     *
     * @param user  Пользователь.
     * @param token Токен доступа.
     */
    void saveToken(User user, Token token);

    /**
     * Проверяет, существует ли указанный токен для пользователя.
     *
     * @param user  Пользователь.
     * @param token Токен доступа.
     * @return true, если токен существует, иначе false.
     */
    boolean isTokenExists(User user, Token token);

    /**
     * Проверяет по логину, существует ли пользователь в хранилище токенов.
     *
     * @param userToCheck Пользователь.
     * @return true, если пользователь существует, иначе false.
     */
    boolean isUserExists(User userToCheck);
}
