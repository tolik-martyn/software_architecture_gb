package hw4.models;

import java.util.Date;

/**
 * Класс, представляющий информацию о билете.
 */
public class Ticket {
    private static int nextId = 1;
    private int id;
    private int routeNumber;
    private String passengerName;
    private Date date;
    private int price;
    private boolean isSold;

    /**
     * Конструктор класса Ticket.
     *
     * @param routeNumber   номер маршрута
     * @param passengerName имя пассажира
     * @param date          дата билета
     * @param price         цена билета
     */
    public Ticket(int routeNumber, String passengerName, Date date, int price) {
        this.id = nextId++;
        this.routeNumber = routeNumber;
        this.passengerName = passengerName;
        this.date = date;
        this.price = price;
        this.isSold = false;
    }

    /**
     * Получает идентификатор билета.
     *
     * @return идентификатор билета
     */
    public int getId() {
        return id;
    }

    /**
     * Получает номер маршрута билета.
     *
     * @return номер маршрута билета
     */
    public int getRouteNumber() {
        return routeNumber;
    }

    /**
     * Получает имя пассажира.
     *
     * @return имя пассажира
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * Получает дату билета.
     *
     * @return дата билета
     */
    public Date getDate() {
        return date;
    }

    /**
     * Получает цену билета.
     *
     * @return цена билета
     */
    public int getPrice() {
        return price;
    }

    /**
     * Проверяет, продан ли билет.
     *
     * @return true, если билет продан, иначе false
     */
    public boolean isSold() {
        return isSold;
    }

    /**
     * Устанавливает статус продажи билета.
     *
     * @param sold true, если билет продан, иначе false
     */
    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Ticket ticket = (Ticket) obj;

        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Билет {" +
                "Номер билета=" + id +
                ", Номер маршрута=" + routeNumber +
                ", Пассажир='" + passengerName + '\'' +
                ", Дата=" + date +
                ", Цена=" + price +
                ", Продан=" + (isSold ? "Да" : "Нет") +
                '}';
    }
}
