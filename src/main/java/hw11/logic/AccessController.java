package hw11.logic;

import hw11.adapter.IAccessManager;
import hw11.data.IAccessRepository;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Класс, управляющий доступом пользователей.
 */
public class AccessController {
    private final IAccessManager accessManager;
    private final IAccessRepository accessRepository;

    /**
     * Конструктор класса AccessController.
     *
     * @param accessManager    Менеджер доступа.
     * @param accessRepository Репозиторий доступа.
     */
    public AccessController(IAccessManager accessManager, IAccessRepository accessRepository) {
        this.accessManager = accessManager;
        this.accessRepository = accessRepository;
    }

    /**
     * Регистрация нового пользователя.
     */
    public void registerUser() {
        User user = accessManager.registerUser();

        // Проверяем, существует ли пользователь с таким логином в репозитории
        if (accessRepository.isUserExists(user)) {
            accessManager.dataOutput("Пользователь с таким логином уже существует. Хотите авторизоваться? (да/нет)");

            String response = accessManager.getUserInput();

            if (response.equalsIgnoreCase("да")) {
                authenticateExistingUser(user);
            } else {
                accessManager.dataOutput("Отказано в регистрации.");
            }
        } else {
            Token token = authenticate(user);
            accessRepository.saveToken(user, token);
            accessManager.dataOutput("Регистрация успешно завершена.");
        }
    }

    /**
     * Аутентификация пользователя.
     */
    public void authenticateUser() {
        User user = accessManager.authenticateUser();
        Token token = authenticate(user);

        if (accessRepository.isTokenExists(user, token)) {
            accessManager.dataOutput("Авторизация успешно завершена.");
        } else if (accessRepository.isUserExists(user)) {
            accessManager.dataOutput("Авторизация не удалась. Проверьте логин и пароль.");
        } else {
            accessManager.dataOutput("Пользователь не найден. Хотите зарегистрироваться? (да/нет)");

            String response = accessManager.getUserInput();

            if (response.equalsIgnoreCase("да")) {
                registerUser();
            } else {
                accessManager.dataOutput("Отказано в регистрации.");
            }
        }
    }

    /**
     * Аутентифицирует существующего пользователя после попытки регистрации.
     *
     * @param user Пользователь для аутентификации.
     */
    private void authenticateExistingUser(User user) {
        Token token = authenticate(user);

        if (accessRepository.isTokenExists(user, token)) {
            accessManager.dataOutput("Авторизация успешно завершена.");
        } else {
            accessManager.dataOutput("Авторизация не удалась. Проверьте логин и пароль.");
        }
    }

    /**
     * Аутентифицирует пользователя и генерирует токен доступа на основе его логина и пароля.
     *
     * @param user Пользователь для аутентификации.
     * @return Токен доступа.
     */
    private Token authenticate(User user) {
        // Генерация токена с использованием Base64
        String userCredentials = user.getLogin() + ":" + user.getPassword();
        byte[] tokenBytes = userCredentials.getBytes(StandardCharsets.UTF_8);
        String encodedToken = Base64.getEncoder().encodeToString(tokenBytes);
        return new Token(encodedToken);
    }
}
