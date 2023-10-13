package hw4.services;

import hw4.interfaces.ITicketRepo;
import hw4.models.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Репозиторий для работы с билетами.
 */
public class TicketRepository implements ITicketRepo {
    private static TicketRepository ticketRepository;
    private List<Ticket> tickets; // Здесь хранятся билеты

    /**
     * Приватный конструктор для Singleton-реализации.
     */
    private TicketRepository() {
        tickets = new ArrayList<>();
        initializeDummyTickets(); // Заполнение фиктивными данными
    }

    /**
     * Получает экземпляр репозитория билетов.
     *
     * @return экземпляр репозитория билетов
     */
    public static TicketRepository getTicketRepository() {
        if (ticketRepository == null) {
            ticketRepository = new TicketRepository();
        }
        return ticketRepository;
    }

    @Override
    public boolean addTicket(Ticket ticket) {
        tickets.add(ticket);
        return true;
    }

    @Override
    public List<Ticket> readAll(int routeNumber) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getRouteNumber() == routeNumber) {
                result.add(ticket);
            }
        }
        return result;
    }

    @Override
    public boolean update(Ticket ticket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == ticket.getId()) {
                tickets.set(i, ticket);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Ticket ticket) {
        return tickets.remove(ticket);
    }

    @Override
    public Ticket createTicket(int routeNumber, String passengerName, Date date, int price) {
        return new Ticket(routeNumber, passengerName, date, price);
    }

    // Вспомогательный метод для заполнения фиктивными данными
    private void initializeDummyTickets() {
        tickets.add(new Ticket( 1, "User 1", new Date(),  100));
        tickets.add(new Ticket( 2, "User 2", new Date(),  150));
        tickets.add(new Ticket( 1, "User 3", new Date(),  120));
    }
}
