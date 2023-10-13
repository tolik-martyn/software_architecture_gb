package hw4.interfaces;

import hw4.core.UserProvider;
import hw4.models.Ticket;
import hw4.models.User;

import java.util.Date;
import java.util.List;

/**
 * Интерфейс для работы с клиентами системы.
 */
public interface ICustomer {
    /**
     * Получает список выбранных билетов клиента.
     *
     * @return список выбранных билетов
     */
    List<Ticket> getSelectedTickets();

    /**
     * Устанавливает список выбранных билетов клиента.
     *
     * @param selectedTickets список выбранных билетов
     */
    void setSelectedTickets(List<Ticket> selectedTickets);

    /**
     * Получает информацию о клиенте.
     *
     * @return информация о клиенте
     */
    User getUser();

    /**
     * Устанавливает информацию о клиенте.
     *
     * @param client информация о клиенте
     */
    void setUser(User client);

    /**
     * Получает провайдера пользователей.
     *
     * @return провайдер пользователей
     */
    UserProvider getUserProvider();

    /**
     * Покупает билет для клиента.
     *
     * @param ticket билет для покупки
     * @return true, если покупка успешна, иначе false
     */
    boolean buyTicket(Ticket ticket);

    /**
     * Выполняет поиск билетов по дате и маршруту.
     *
     * @param date  дата для поиска
     * @param route маршрут для поиска
     * @return список найденных билетов
     */
    List<Ticket> searchTicket(Date date, int route);
}
