package hw8.model;

/**
 * Класс Customer представляет сущность клиента.
 */
public class Customer {

    private final String lastName;
    private final String firstName;

    private final String phone;
    private final String email;

    /**
     * Конструктор класса Customer.
     *
     * @param lastName  Фамилия клиента.
     * @param firstName Имя клиента.
     * @param phone     Телефон клиента.
     * @param email     Email клиента.
     */
    public Customer(String lastName, String firstName, String phone, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName +
                "\nтелефон: " + phone +
                "\nemail: " + email;
    }
}
