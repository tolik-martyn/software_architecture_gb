package hw8.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс Order представляет сущность заказа.
 */
public class Order {
    private static int nextOrderId = 1; // Статическое поле для автоматического увеличения id
    private final int id; // Уникальный номер заказа
    private final LocalDateTime bookingDateTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private final Table table;
    private final Customer customer;
    private final double totalAmount;

    /**
     * Конструктор класса Order.
     *
     * @param table     Экземпляр столика.
     * @param customer  Экземпляр клиента.
     */
    public Order(Table table, Customer customer) {
        this.id = nextOrderId++; // Увеличиваем orderId и присваиваем его текущему заказу
        this.bookingDateTime = LocalDateTime.now();
        this.table = table;
        this.customer = customer;
        this.totalAmount = 0.0; // Изначально сумма заказа - 0
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm");
        String bookingDateTimeStr = bookingDateTime.format(formatter);
        String startTimeStr = startTime != null ? startTime.format(formatter) : "N/A";
        String endTimeStr = endTime != null ? endTime.format(formatter) : "N/A";

        return  "номер заказа: " + id +
                "\nдата и время оформления: " + bookingDateTimeStr +
                "\nдата и время начала: " + startTimeStr +
                "\nдата и время завершения: " + endTimeStr +
                "\nномер столика: " + table.getTableNumber() +
                "\nколичество мест: " + table.getNumberOfPersons() +
                "\nсумма заказа: " + totalAmount;
    }
}
