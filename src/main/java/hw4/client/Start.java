package hw4.client;

import hw4.core.UserProvider;
import hw4.core.TicketProvider;
import hw4.core.CashProvider;
import hw4.models.Ticket;
import hw4.models.User;

import java.util.List;
import java.util.Date;

/**
 * Класс для старта приложения и взаимодействия с пользователем.
 */
public class Start {
    private UserProvider userProvider;
    private TicketProvider ticketProvider;
    private CashProvider cashProvider;

    public Start(UserProvider userProvider, TicketProvider ticketProvider, CashProvider cashProvider) {
        this.userProvider = userProvider;
        this.ticketProvider = ticketProvider;
        this.cashProvider = cashProvider;
    }

    /**
     * Запуск приложения.
     */
    public void startApp() {
        System.out.println("Добро пожаловать!");

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вход");
            System.out.println("2. Регистрация");
            System.out.println("3. Поиск билетов");
            System.out.println("4. Выход");

            int choice = EnterData.enterInt("Введите номер действия");

            switch (choice) {
                case 1 -> loginUser();
                case 2 -> registerUser();
                case 3 -> searchTickets();
                case 4 -> {
                    System.out.println("Спасибо за использование приложения. До свидания!");
                    return;
                }
                default -> System.out.println("Неправильный выбор. Пожалуйста, выберите действие из списка.");
            }
        }
    }

    private void loginUser() {
        String userName = EnterData.enterString("Введите имя пользователя");
        int passwordHash = EnterData.enterInt("Введите пароль");

        Authentication authentication = new Authentication(userProvider);
        User user = userProvider.getUserByName(userName);

        if (authentication.authenticate(userName, passwordHash)) {
            System.out.println("Вход выполнен успешно.");
        } else{
            System.out.println("Неверное имя пользователя или пароль.");
        }
    }

    private void registerUser() {
        String userName = EnterData.enterString("Введите имя пользователя");
        int passwordHash = EnterData.enterInt("Введите пароль");
        long cardNumber = EnterData.enterInt("Введите номер карты");

        User user = userProvider.createUser(userName, passwordHash, cardNumber);
        if (user.getId() != -1) {
            System.out.println("Регистрация успешно завершена. Ваш ID: " + user.getId());
        } else {
            System.out.println("Ошибка при регистрации пользователя.");
        }
    }

    private void searchTickets() {
        int routeNumber = EnterData.enterInt("Введите номер маршрута");
        Date date = new Date(); // Здесь можно добавить логику для ввода даты

        List<Ticket> tickets = ticketProvider.getTicketsByRoute(routeNumber);

        if (tickets.isEmpty()) {
            System.out.println("Билеты не найдены.");
        } else {
            System.out.println("Найденные билеты:");
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }
}
