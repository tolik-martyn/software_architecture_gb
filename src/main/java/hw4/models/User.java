package hw4.models;

/**
 * Класс, представляющий информацию о пользователе.
 */
public class User {
    private static int nextId = 1;
    private int id;
    private String userName;
    private int passwordHash;
    private long cardNumber;

    /**
     * Конструктор класса User.
     *
     * @param userName     имя пользователя
     * @param passwordHash хеш пароля пользователя
     * @param cardNumber   номер кредитной карты пользователя
     */
    public User(String userName, int passwordHash, long cardNumber) {
        this.id = nextId++;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.cardNumber = cardNumber;
    }

    /**
     * Получает идентификатор пользователя.
     *
     * @return идентификатор пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Получает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Получает хеш пароля пользователя.
     *
     * @return хеш пароля пользователя
     */
    public int getPasswordHash() {
        return passwordHash;
    }

    /**
     * Получает номер кредитной карты пользователя.
     *
     * @return номер кредитной карты пользователя
     */
    public long getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Пользователь {" +
                "Идентификатор=" + id +
                ", Имя='" + userName + '\'' +
                ", Хеш пароля=" + passwordHash +
                ", Номер карты=" + cardNumber +
                '}';
    }
}
