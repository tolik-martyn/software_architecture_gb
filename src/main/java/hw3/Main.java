package hw3;

import hw3.fuelling.*;
import hw3.services.FuelingService;
import hw3.services.FuelingServiceStation;
import hw3.vehicles.Car;
import hw3.vehicles.DieselCar;
import hw3.vehicles.ElectricCar;
import hw3.vehicles.GasolineCar;
import hw3.vehicles.cars.GarbageTruck;
import hw3.vehicles.features.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // Использование заправочных станций:
        FuelType gasolineFuel = new GasolineFuel();
        Car car1 = new GasolineCar("Toyota", "Camry", Color.BLUE, "Sedan", 4,
                TransmissionType.AUTOMATIC, 2.5);
        FuelStation gasolineStation = new FuelStation(gasolineFuel, car1);
        gasolineStation.refuelCar();

        FuelType dieselFuel = new DieselFuel();
        Car car2 = new DieselCar("Ford", "Focus", Color.RED, "Hatchback", 4,
                TransmissionType.MANUAL, 1.8);
        FuelStation dieselStation = new FuelStation(dieselFuel, car2);
        dieselStation.refuelCar();

        FuelType electricFuel = new ElectricFuel();
        Car car3 = new ElectricCar("Tesla", "Model S", Color.BLACK, "Sedan", 4,
                TransmissionType.AUTOMATIC, 0.0); // Электромотор без объема
        FuelStation electricStation = new FuelStation(electricFuel, car3);
        electricStation.refuelCar();

        // Использование заправочных услуг:
        FuelingService fuelingService = new FuelingServiceStation();
        fuelingService.cleanWindshield(car1);
        fuelingService.cleanHeadlights(car2);
        fuelingService.cleanMirrors(car3);

        System.out.println();

        // Использование мусоровоза:
        GarbageTruck garbageTruck = new GarbageTruck("Mercedes", "Actros", Color.GREEN, "Truck",
                TransmissionType.AUTOMATIC, 10.0);

        garbageTruck.move();
        garbageTruck.service();
        garbageTruck.shiftGears();
        garbageTruck.turnOnHeadlights();
        garbageTruck.turnOnWipers();
        garbageTruck.turnOnFogLights();
        garbageTruck.transportCargo();
        garbageTruck.sweepStreet();

        // Заправка мусоровоза:
        FuelType garbageTruckFuel = new DieselFuel();
        FuelStation garbageTruckStation = new FuelStation(garbageTruckFuel, garbageTruck);
        garbageTruckStation.refuelCar();

        // Использование заправочных услуг для мусоровоза:
        FuelingService garbageTruckService = new FuelingServiceStation();
        garbageTruckService.cleanWindshield(garbageTruck);
        garbageTruckService.cleanHeadlights(garbageTruck);
        garbageTruckService.cleanMirrors(garbageTruck);
    }

    /*
    1. SRP (Принцип единственной ответственности):
    Классы FuelType, FuelStation, GasolineFuel, DieselFuel, ElectricFuel, GarbageTruck, FuelingService,
    FuelingServiceStation имеют четко определенные обязанности.Например, FuelType определяет виды топлива,
    FuelStation - структуру заправок, GarbageTruck - функциональность мусоровоза.

    2. OCP (Принцип открытости или закрытости):
    Новые виды топлива и функциональности могут быть легко добавлены, не изменяя существующий код.
    Пример - добавление новых видов топлива и расширение методов в FuelingService.

    3. LSP (Принцип подстановки Барбары Лисков):
    Классы-наследники (например, DieselCar, GarbageTruck) корректно расширяют функциональность базовых классов
    и сохраняют их контракты.

    4. ISP (Принцип разделения интерфейсов):
    Интерфейсы FuelType, FuelingService разделяют функциональности на независимые части,
    позволяя классам реализовывать только необходимые методы.

    5. DIP (Принцип инверсии зависимости):
    Классы из пакета fuelling и services зависят от абстракций, а не от конкретных реализаций.
    Например, FuelStation и FuelingServiceStation зависят от интерфейсов FuelType и FuelingService,
    а не от конкретных видов топлива и услуг.
     */
}
