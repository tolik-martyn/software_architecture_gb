package hw11.logic;

import java.util.Objects;

/**
 * Класс, представляющий пользователя.
 */
public class User {

    private String username;
    private final String login;
    private final String password;

    /**
     * Конструктор класса User для регистрации пользователя.
     *
     * @param username Имя пользователя.
     * @param login    Логин пользователя.
     * @param password Пароль пользователя.
     */
    public User(String username, String login, String password) {
        this.username = username;
        this.login = login;
        this.password = password;
    }

    /**
     * Конструктор класса User для аутентификации пользователя.
     *
     * @param login    Логин пользователя.
     * @param password Пароль пользователя.
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Получить логин пользователя.
     *
     * @return Логин пользователя.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Получить пароль пользователя.
     *
     * @return Пароль пользователя.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Установить имя пользователя.
     *
     * @param username Имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

}
