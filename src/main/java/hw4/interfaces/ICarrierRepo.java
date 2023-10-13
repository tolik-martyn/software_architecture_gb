package hw4.interfaces;

import hw4.models.Carrier;

/**
 * Интерфейс для доступа к данным о перевозчиках.
 */
public interface ICarrierRepo {

    /**
     * Возвращает информацию о перевозчике по его идентификатору.
     *
     * @param id Идентификатор перевозчика.
     * @return Объект перевозчика или null, если перевозчик не найден.
     */
    Carrier read(int id);
}
