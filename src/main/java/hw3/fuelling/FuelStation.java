package hw3.fuelling;

import hw3.vehicles.Car;

/**
 * Класс Заправочная станция.
 */
public class FuelStation {
    private FuelType fuelType;
    private Car car;

    public FuelStation(FuelType fuelType, Car car) {
        this.fuelType = fuelType;
        this.car = car;
    }

    public void refuelCar() {
        fuelType.refuel();
        System.out.println(car.getBrand() + " " + car.getModel());
    }
}
