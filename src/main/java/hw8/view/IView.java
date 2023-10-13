package hw8.view;

import java.util.List;

/**
 * Интерфейс IView определяет методы для взаимодействия с пользователем.
 */
public interface IView {

    /**
     * Метод для запроса данных клиента.
     *
     * @return Список строк, содержащий данные клиента.
     */
    List<String> requestCustomerData();

    /**
     * Метод для отображения данных о клиенте и заказе.
     *
     * @param customerInfo  Данные о клиенте.
     * @param orderInfo     Данные а заказе.
     */
    void displayCustomerOrderInfo(String customerInfo, String orderInfo);

    /**
     * Метод для выбора столика.
     *
     * @return Номер выбранного столика.
     */
    int selectTable();

    /**
     * Метод для подтверждения заказа.
     */
    void confirmOrder();
}
