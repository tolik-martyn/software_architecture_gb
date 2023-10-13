package hw4.interfaces;

/**
 * Интерфейс для работы с денежными транзакциями.
 */
public interface ICashRepo {
    /**
     * Выполняет денежную транзакцию между двумя банковскими счетами.
     *
     * @param payment    сумма платежа
     * @param cardFrom   номер банковского счета отправителя
     * @param cardTo     номер банковского счета получателя
     * @return true, если транзакция успешно выполнена, иначе false
     */
    boolean transaction(int payment, long cardFrom, long cardTo);
}
