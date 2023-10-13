package hw4.services;

import hw4.interfaces.IUserRepo;
import hw4.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для работы с пользователями.
 */
public class UserRepository implements IUserRepo {
    private static UserRepository userRepository;
    private List<User> users; // Здесь хранятся пользователи

    /**
     * Приватный конструктор для Singleton-реализации.
     */
    private UserRepository() {
        users = new ArrayList<>();
        initializeDummyUsers(); // Заполнение фиктивными данными
    }

    /**
     * Получает экземпляр репозитория пользователей.
     *
     * @return экземпляр репозитория пользователей
     */
    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    @Override
    public int create(String userName, int passwordHash, long cardNumber) {
        User newUser = new User(userName, passwordHash, cardNumber);
        users.add(newUser);
        return newUser.getId();
    }

    @Override
    public User read(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User read(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(users);
    }

    @Override
    public boolean update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        return users.remove(user);
    }

    /**
     * Вспомогательный метод для заполнения репозитория фиктивными данными.
     */
    private void initializeDummyUsers() {
        users.add(new User("User1", 111, 123456789));
        users.add(new User("User2", 222, 987654321));
    }
}
