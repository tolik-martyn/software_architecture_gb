package hw4.core;

import hw4.interfaces.ITicketRepo;
import hw4.models.Ticket;
import hw4.services.TicketRepository;

import java.util.Date;
import java.util.List;

/**
 * Класс, предоставляющий функциональность для работы с билетами.
 */
public class TicketProvider {
    private ITicketRepo ticketRepository;

    public TicketProvider() {
        this.ticketRepository = TicketRepository.getTicketRepository();
    }

    /**
     * Получает список билетов по номеру маршрута.
     *
     * @param routeNumber номер маршрута
     * @return список билетов
     */
    public List<Ticket> getTicketsByRoute(int routeNumber) {
        return ticketRepository.readAll(routeNumber);
    }

    /**
     * Обновляет информацию о билете.
     *
     * @param ticket билет для обновления
     */
    public void updateTicket(Ticket ticket) {
        ticketRepository.update(ticket);
    }

    /**
     * Создает новый билет.
     *
     * @param routeNumber    номер маршрута
     * @param passengerName  имя пассажира
     * @param date           дата поездки
     * @param price          цена билета
     * @return созданный билет
     */
    public Ticket createTicket(int routeNumber, String passengerName, Date date, int price) {
        Ticket newTicket = ticketRepository.createTicket(routeNumber, passengerName, date, price);
        if (ticketRepository.addTicket(newTicket)) {
            return newTicket;
        }
        return null;
    }
}
