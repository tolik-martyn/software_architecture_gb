package hw4.interfaces;

import hw4.models.Ticket;

import java.util.Date;
import java.util.List;

/**
 * Интерфейс для работы с билетами.
 */
public interface ITicketRepo {
    /**
     * Добавляет новый билет в список, где хранятся билеты.
     *
     * @param ticket билет для создания
     * @return true, если добавление успешно, иначе false
     */
    boolean addTicket(Ticket ticket);

    /**
     * Получает список билетов по номеру маршрута.
     *
     * @param routeNumber номер маршрута
     * @return список билетов
     */
    List<Ticket> readAll(int routeNumber);

    /**
     * Обновляет информацию о билете.
     *
     * @param ticket билет для обновления
     * @return true, если обновление успешно, иначе false
     */
    boolean update(Ticket ticket);

    /**
     * Удаляет билет.
     *
     * @param ticket билет для удаления
     * @return true, если удаление успешно, иначе false
     */
    boolean delete(Ticket ticket);

    /**
     * Создаёт новый билет
     *
     * @param routeNumber   номер маршрута
     * @param passengerName имя пассажира
     * @param date          дата билета
     * @param price         цена билета
     * @return              возвращает ID созданного билета
     */
    Ticket createTicket(int routeNumber, String passengerName, Date date, int price);
}
