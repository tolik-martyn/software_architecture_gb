package hw3.vehicles;

import hw3.vehicles.features.FuelsType;
import hw3.vehicles.features.TransmissionType;

import java.awt.*;

/**
 * Класс-наследник от автомобиля с электрическим двигателем.
 */
public class ElectricCar extends Car {
    public ElectricCar(String brand, String model, Color color, String bodyType, int numberOfWheels,
                       TransmissionType transmissionType, double engineVolume) {
        super(brand, model, color, bodyType, numberOfWheels, FuelsType.ELECTRIC, transmissionType, engineVolume);
    }

    @Override
    public void move() {
        System.out.println("Электромобиль " + this.getBrand() + " " + this.getModel() + " движется.");
    }

    @Override
    public void service() {
        System.out.println("Электромобиль " + this.getBrand() + " " + this.getModel() + " на техобслуживании.");
    }

    @Override
    public void shiftGears() {
        System.out.println("Электромобиль " + this.getBrand() + " " + this.getModel() + " переключает передачи.");
    }

    @Override
    public void turnOnHeadlights() {
        System.out.println("Электромобиль " + this.getBrand() + " " + this.getModel() + " включает фары.");
    }

    @Override
    public void turnOnWipers() {
        System.out.println("Электромобиль " + this.getBrand() + " " + this.getModel() + " включает дворники.");
    }
}
