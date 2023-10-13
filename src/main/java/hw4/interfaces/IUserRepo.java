package hw4.interfaces;

import hw4.models.User;
import java.util.List;

/**
 * Интерфейс для работы с пользователями.
 */
public interface IUserRepo {
    /**
     * Создает нового пользователя.
     *
     * @param userName имя пользователя
     * @param passwordHash хеш пароля пользователя
     * @param cardNumber номер карты пользователя
     * @return ID созданного пользователя
     */
    int create(String userName, int passwordHash, long cardNumber);

    /**
     * Получает пользователя по его ID.
     *
     * @param id ID пользователя
     * @return объект пользователя или null, если не найден
     */
    User read(int id);

    /**
     * Получает пользователя по его имени.
     *
     * @param userName имя пользователя
     * @return объект пользователя или null, если не найден
     */
    User read(String userName);

    /**
     * Получает список всех пользователей.
     *
     * @return список пользователей
     */
    List<User> readAll();

    /**
     * Обновляет информацию о пользователе.
     *
     * @param client объект пользователя для обновления
     * @return true, если обновление успешно, иначе false
     */
    boolean update(User client);

    /**
     * Удаляет пользователя.
     *
     * @param client объект пользователя для удаления
     * @return true, если удаление успешно, иначе false
     */
    boolean delete(User client);
}
