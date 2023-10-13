package hw8.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс View реализует интерфейс IView и взаимодействует с пользователем.
 */
public class View implements IView {
    private static Scanner scanner;

    /**
     * Конструктор класса View.
     */
    public View() {
        scanner = new Scanner(System.in);
    }

    @Override
    public List<String> requestCustomerData() {
        // Запрос данных клиента
        List<String> customerData = new ArrayList<>();

        // Ввод фамилии
        System.out.println("Введите фамилию:");
        customerData.add(scanner.nextLine());

        // Ввод имени
        System.out.println("Введите имя:");
        customerData.add(scanner.nextLine());

        // Ввод телефона
        customerData.add(getPhoneNumber());

        // Ввод email
        System.out.println("Введите email:");
        customerData.add(scanner.nextLine());

        System.out.println("--------------------------------------");

        return customerData;
    }

    @Override
    public void displayCustomerOrderInfo(String customerInfo, String orderInfo) {
        System.out.println("Информация о клиенте:");
        System.out.println(customerInfo);
        System.out.println("-------------------");
        System.out.println("Информация о заказе:");
        System.out.println(orderInfo);
        System.out.println("--------------------------------------");
    }


    @Override
    public int selectTable() {
        // Выбор столика
        System.out.println("Выберите номер столика:");
        return scanner.nextInt();
    }

    @Override
    public void confirmOrder() {
        // Подтверждение заказа
        System.out.println("Заказ подтвержден!");
        System.out.println("--------------------------------------");
    }

    // Получение валидного номера телефона
    private static String getPhoneNumber() {
        String numberPhone;
        boolean isValidPhone = false;
        System.out.println("Введите номер телефона:");
        do {
            numberPhone = scanner.nextLine();
            if (numberPhone.matches("\\+?\\d+")) {
                isValidPhone = true;
            } else {
                System.err.println("Неверные данные, попробуйте снова ввести телефон:");
            }
        } while (!isValidPhone);
        return numberPhone;
    }
}
