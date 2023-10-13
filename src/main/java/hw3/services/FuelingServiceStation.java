package hw3.services;

import hw3.vehicles.Car;

/**
 * Класс с реализацией заправочных услуг.
 */
public class FuelingServiceStation implements FuelingService {
    @Override
    public void cleanWindshield(Car car) {
        System.out.println("Протирка лобового стекла: " + car.getBrand() + " " + car.getModel());
    }

    @Override
    public void cleanHeadlights(Car car) {
        System.out.println("Протирка фар: " + car.getBrand() + " " + car.getModel());
    }

    @Override
    public void cleanMirrors(Car car) {
        System.out.println("Протирка зеркал: " + car.getBrand() + " " + car.getModel());
    }
}
