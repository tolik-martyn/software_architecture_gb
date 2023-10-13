package hw11.data;

import hw11.logic.Token;
import hw11.logic.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Реализация интерфейса IAccessRepository для хранения токенов.
 */
public class AccessRepository implements IAccessRepository {
    private final Map<User, Token> tokenMap = new HashMap<>();

    /**
     * Сохраняет токен для пользователя.
     *
     * @param user  Пользователь.
     * @param token Токен доступа.
     */
    @Override
    public void saveToken(User user, Token token) {
        tokenMap.put(user, token);
    }

    /**
     * Проверяет, существует ли указанный токен для пользователя.
     *
     * @param user  Пользователь.
     * @param token Токен доступа.
     * @return true, если токен существует, иначе false.
     */
    @Override
    public boolean isTokenExists(User user, Token token) {
        Token storedToken = tokenMap.get(user);
        return storedToken != null && storedToken.equals(token);
    }

    /**
     * Проверяет по логину, существует ли пользователь в хранилище токенов.
     *
     * @param userToCheck Пользователь.
     * @return true, если пользователь существует, иначе false.
     */
    @Override
    public boolean isUserExists(User userToCheck) {
        String loginToCheck = userToCheck.getLogin();
        for (User user : tokenMap.keySet()) {
            if (user.getLogin().equals(loginToCheck)) {
                return true; // Нашли пользователя с таким логином
            }
        }
        return false; // Не нашли пользователя с таким логином
    }
}
