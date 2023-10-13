package hw8.controller;

import hw8.model.*;
import hw8.view.IView;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс Controller управляет бронированием столика и взаимодействует с пользовательским интерфейсом.
 */
public class Controller {
    private final IView view;
    private final IRepo repo;

    /**
     * Конструктор класса Controller.
     *
     * @param view Интерфейс IView для взаимодействия с пользователем.
     * @param repo Интерфейс IRepo для работы с данными.
     */
    public Controller(IView view, IRepo repo) {
        this.view = view;
        this.repo = repo;
    }

    /**
     * Метод для обработки процесса бронирования столика.
     */
    public void processReservation() {
        // Шаг 1: Запрос данных о клиенте
        List<String> customerData = view.requestCustomerData();
        Customer customer = repo.createCustomer(customerData);

        // Шаг 2: Вывод свободных столов
        List<Table> availableTables = repo.getAvailableTables();
        displayAvailableTables(availableTables);

        // Шаг 3: Выбор столика
        int tableNumber = view.selectTable();
        Table table = repo.getTable(tableNumber);

        if (table == null) {
            System.err.println("Столик с указанным номером не найден.");
            System.out.println("--------------------------------------");
            return;
        }

        if (!table.isAvailable()) {
            System.err.println("Столик уже занят.");
            System.out.println("--------------------------------------");
            return;
        }
        table.setAvailable(false);
        System.out.println("--------------------------------------");

        // Шаг 4: Создание заказа
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2); // Пример: заказ на 2 часа

        Order order = repo.createOrder(table, customer);
        order.setStartTime(startTime);
        order.setEndTime(endTime);

        // Шаг 5: Подтверждение заказа
        view.confirmOrder();

        // Шаг 6: Вывод информации о заказе
        String customerInfo = customer.toString();
        String orderInfo = order.toString();
        view.displayCustomerOrderInfo(customerInfo, orderInfo);
    }

    private void displayAvailableTables(List<Table> availableTables) {
        System.out.println("Свободные столики:");
        for (Table table : availableTables) {
            System.out.println("Номер: " + table.getTableNumber() +
                    ", мест: " + table.getNumberOfPersons());
        }
        System.out.println("--------------------------------------");
    }
}
