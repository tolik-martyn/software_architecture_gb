package hw4.core;

import hw4.interfaces.IUserRepo;
import hw4.models.User;
import hw4.services.UserRepository;

import java.util.List;

/**
 * Класс, предоставляющий функциональность для работы с пользователями.
 */
public class UserProvider {
    private IUserRepo userRepository;

    public UserProvider() {
        this.userRepository = UserRepository.getUserRepository();
    }

    /**
     * Создает нового пользователя.
     *
     * @param userName     имя пользователя
     * @param passwordHash хэш пароля пользователя
     * @param cardNumber   номер карты пользователя
     * @return созданный пользователь
     */
    public User createUser(String userName, int passwordHash, long cardNumber) {
        int userId = userRepository.create(userName, passwordHash, cardNumber);
        return userRepository.read(userId);
    }

    /**
     * Получает пользователя по его ID.
     *
     * @param id ID пользователя
     * @return найденный пользователь или null, если не найден
     */
    public User getUserById(int id) {
        return userRepository.read(id);
    }

    /**
     * Получает пользователя по его имени.
     *
     * @param userName имя пользователя
     * @return найденный пользователь или null, если не найден
     */
    public User getUserByName(String userName) {
        return userRepository.read(userName);
    }

    /**
     * Получает список всех пользователей.
     *
     * @return список всех пользователей
     */
    public List<User> getAllUsers() {
        return userRepository.readAll();
    }

    /**
     * Обновляет информацию о пользователе.
     *
     * @param user пользователь для обновления
     * @return true, если обновление успешно выполнено, иначе false
     */
    public boolean updateUser(User user) {
        return userRepository.update(user);
    }

    /**
     * Удаляет пользователя.
     *
     * @param user пользователь для удаления
     * @return true, если удаление успешно выполнено, иначе false
     */
    public boolean deleteUser(User user) {
        return userRepository.delete(user);
    }
}
