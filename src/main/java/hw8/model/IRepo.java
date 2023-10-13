package hw8.model;

import java.util.List;

/**
 * Интерфейс IRepo определяет методы для работы с данными.
 */
public interface IRepo {

    /**
     * Метод для создания экземпляра Customer на основе данных клиента.
     *
     * @param customerData Список строк с данными клиента.
     * @return Экземпляр класса Customer.
     */
    Customer createCustomer(List<String> customerData);

    /**
     * Метод для создания экземпляра Table на основе номера столика.
     *
     * @param tableNumber Номер столика.
     */
    void createTable(int tableNumber, int numberOfPersons);

    /**
     * Метод для создания экземпляра Order на основе клиента и столика.
     *
     * @param customer Экземпляр класса Customer.
     * @param table    Экземпляр класса Table.
     * @return Экземпляр класса Order.
     */
    Order createOrder(Table table, Customer customer);

    /**
     * Метод для получения данных о столике по идентификатору.
     *
     * @param tableNumber идентификатору столика.
     * @return Экземпляр класса Table.
     */
    Table getTable(int tableNumber);

    /**
     * Метод для получения списка свободных столов.
     */
    List<Table> getAvailableTables();
}
