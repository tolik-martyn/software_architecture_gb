package hw8.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Repo реализует интерфейс IRepo и выполняет работу с данными.
 */
public class Repo implements IRepo {
    private final List<Customer> customers;
    private final List<Table> tables;
    private final List<Order> orders;

    public Repo() {
        customers = new ArrayList<>();
        tables = new ArrayList<>();
        orders = new ArrayList<>();
        createTable(1, 4);
        createTable(2, 6);
    }

    @Override
    public Customer createCustomer(List<String> customerData) {
        // Логика создания экземпляра Customer на основе данных клиента
        // Добавление созданного экземпляра в список клиентов
        Customer customer = new Customer(
                customerData.get(0),
                customerData.get(1),
                customerData.get(2),
                customerData.get(3));
        customers.add(customer);
        return customer;
    }

    @Override
    public void createTable(int tableNumber, int numberOfPersons) {
        // Логика создания экземпляра Table на основе номера столика и количества персон
        // Добавление созданного экземпляра в список столов
        Table table = new Table(tableNumber, numberOfPersons);
        tables.add(table);
    }

    @Override
    public Order createOrder(Table table, Customer customer) {
        // Логика создания экземпляра Order на основе клиента и столика
        // Добавление созданного экземпляра в список заказов
        Order order = new Order(table, customer);
        //
        orders.add(order);
        return order;
    }

    @Override
    public Table getTable(int tableNumber) {
        // Поиск и возврат экземпляра Table по номеру столика
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }
        return null; // Вернуть null, если не найден
    }

    public List<Table> getAvailableTables() {
        List<Table> availableTables = new ArrayList<>();
        for (Table table : tables) {
            if (table.isAvailable()) {
                availableTables.add(table);
            }
        }
        return availableTables;
    }
}
