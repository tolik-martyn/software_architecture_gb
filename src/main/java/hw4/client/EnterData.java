package hw4.client;

import java.util.Scanner;

/**
 * Класс для ввода данных от пользователя.
 */
public class EnterData {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Вводит целое число от пользователя.
     *
     * @param prompt Подсказка для пользователя.
     * @return Введенное целое число.
     */
    public static int enterInt(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }

    /**
     * Вводит строку от пользователя.
     *
     * @param prompt Подсказка для пользователя.
     * @return Введенная строка.
     */
    public static String enterString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.next();
    }

    /**
     * Вводит дату от пользователя в формате "дд.мм.гггг".
     *
     * @param prompt Подсказка для пользователя.
     * @return Введенная дата.
     */
    public static String enterDate(String prompt) {
        System.out.print(prompt + " (дд.мм.гггг): ");
        return scanner.next();
    }

    /**
     * Вводит сумму от пользователя.
     *
     * @param prompt Подсказка для пользователя.
     * @return Введенная сумма.
     */
    public static int enterAmount(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }
}
