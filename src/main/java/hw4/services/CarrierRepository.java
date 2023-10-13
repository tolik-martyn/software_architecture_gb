package hw4.services;

import hw4.interfaces.ICarrierRepo;
import hw4.models.Carrier;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для хранения информации о перевозчиках.
 */
public class CarrierRepository implements ICarrierRepo {
    private static CarrierRepository carrierRepository;
    private List<Carrier> carriers; // Здесь хранятся перевозчики

    /**
     * Приватный конструктор для Singleton-реализации.
     */
    private CarrierRepository() {
        carriers = new ArrayList<>();
        initializeDummyCarriers(); // Заполнение фиктивными данными
    }

    /**
     * Получает экземпляр репозитория перевозчиков.
     *
     * @return экземпляр репозитория перевозчиков
     */
    public static CarrierRepository getCarrierRepository() {
        if (carrierRepository == null) {
            carrierRepository = new CarrierRepository();
        }
        return carrierRepository;
    }

    @Override
    public Carrier read(int id) {
        for (Carrier carrier : carriers) {
            if (carrier.getId() == id) {
                return carrier;
            }
        }
        return null;
    }

    /**
     * Вспомогательный метод для заполнения репозитория фиктивными данными.
     */
    private void initializeDummyCarriers() {
        carriers.add(new Carrier("Перевозчик 1", "Маршрут A"));
        carriers.add(new Carrier("Перевозчик 2", "Маршрут B"));
        carriers.add(new Carrier("Перевозчик 3", "Маршрут C"));
    }
}
