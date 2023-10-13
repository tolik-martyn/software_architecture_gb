package hw4;

import hw4.client.Start;
import hw4.core.CashProvider;
import hw4.core.TicketProvider;
import hw4.core.UserProvider;

public class Main {
    public static void main(String[] args) {
        UserProvider userProvider = new UserProvider();
        TicketProvider ticketProvider = new TicketProvider();
        CashProvider cashProvider = new CashProvider();

        Start start = new Start(userProvider, ticketProvider, cashProvider);
        start.startApp();
    }
}
