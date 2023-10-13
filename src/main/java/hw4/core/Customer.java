package hw4.core;

import hw4.models.BankAccount;
import hw4.models.Ticket;
import hw4.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий клиента системы.
 */
public class Customer {
    private List<Ticket> selectedTickets;
    private User user;
    private CashProvider cashProvider;
    private TicketProvider ticketProvider;

    public Customer(User user, CashProvider cashProvider, TicketProvider ticketProvider) {
        this.user = user;
        this.cashProvider = cashProvider;
        this.ticketProvider = ticketProvider;
        selectedTickets = new ArrayList<>();
    }

    /**
     * Выбирает билеты для покупки.
     *
     * @param tickets список выбранных билетов
     */
    public void selectTickets(List<Ticket> tickets) {
        selectedTickets.addAll(tickets);
    }

    /**
     * Покупает выбранные билеты.
     *
     * @return список успешно купленных билетов
     */
    public List<Ticket> buySelectedTickets() {
        List<Ticket> successfullyBoughtTickets = new ArrayList<>();

        for (Ticket ticket : selectedTickets) {
            if (buyTicket(ticket)) {
                successfullyBoughtTickets.add(ticket);
            }
        }

        selectedTickets.removeAll(successfullyBoughtTickets);
        return successfullyBoughtTickets;
    }

    /**
     * Покупает билет.
     *
     * @param ticket билет для покупки
     * @return true, если покупка успешно выполнена, иначе false
     */
    private boolean buyTicket(Ticket ticket) {
        BankAccount clientAccount = cashProvider.findAccountByAccountNumber(1); // временная заглушка: accountNumber = 1
        BankAccount carrierAccount = cashProvider.findAccountByAccountNumber(2); // временная заглушка: accountNumber = 2

        if (!cashProvider.isClientAuthorized(clientAccount)) {
            System.out.println("Ошибка: авторизация клиента не удалась.");
            return false;
        }

        if (clientAccount == null || carrierAccount == null) {
            System.out.println("Ошибка: неверный клиентский или перевозчикский аккаунт.");
            return false;
        }

        if (cashProvider.makeTransaction(ticket.getPrice(), clientAccount.getAccountNumber(), carrierAccount.getAccountNumber())) {
            ticket.setSold(true);
            ticketProvider.updateTicket(ticket);
            System.out.println("Покупка билета выполнена успешно.");
            return true;
        } else {
            System.out.println("Ошибка: покупка билета не удалась.");
            return false;
        }
    }

    /**
     * Поиск билетов по дате и маршруту.
     *
     * @param route номер маршрута
     * @return список найденных билетов
     */
    public List<Ticket> searchTickets(int route) {
        return ticketProvider.getTicketsByRoute(route);
    }
}
