package hw4.client;

import hw4.core.UserProvider;
import hw4.models.User;

/**
 * Класс для аутентификации пользователей.
 */
public class Authentication {
    private UserProvider userProvider;

    public Authentication(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    /**
     * Проверяет аутентификацию пользователя по имени пользователя и хэшу пароля.
     *
     * @param userName     Имя пользователя.
     * @param passwordHash Хэш пароля.
     * @return true, если аутентификация успешна, иначе false.
     */
    public boolean authenticate(String userName, int passwordHash) {
        User user = userProvider.getUserByName(userName);
        return user != null && user.getPasswordHash() == passwordHash;
    }
}
