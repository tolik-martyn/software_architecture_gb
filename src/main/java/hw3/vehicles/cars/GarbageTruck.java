package hw3.vehicles.cars;

import hw3.vehicles.CargoTransport;
import hw3.vehicles.DieselCar;
import hw3.vehicles.FogLights;
import hw3.vehicles.features.TransmissionType;

import java.awt.*;

/**
 * Класс Мусоровоз - наследник от DieselCar.
 */
public class GarbageTruck extends DieselCar implements FogLights, CargoTransport {
    public GarbageTruck(String brand, String model, Color color, String bodyType, TransmissionType transmissionType,
                        double engineVolume) {
        super(brand, model, color, bodyType, 4, transmissionType, engineVolume);
    }

    @Override
    public void turnOnFogLights() {
        System.out.println("Мусоровоз " + this.getBrand() + " " + this.getModel() + " включает противотуманные фары.");
    }

    @Override
    public void transportCargo() {
        System.out.println("Мусоровоз " + this.getBrand() + " " + this.getModel() + " перевозит мусор.");
    }

    /**
     * Метод подметания улицы.
     */
    public void sweepStreet() {
        System.out.println("Мусоровоз " + this.getBrand() + " " + this.getModel() + " подметает улицу.");
    }
    /*
    SRP (Принцип единственной ответственности):
    Классы и интерфейсы имеют узкую ответственность и занимаются только своими функциями.
    Например, классы-наследники реализуют специфичные методы для каждого типа автомобиля (подметание улицы).
    А интерфейсы предоставляют независимые возможности (включение противотуманных фар и перевозка груза).

    OCP (Принцип открытости или закрытости):
    Новая функциональность (методы из интерфейсов) добавляется без изменения существующего кода.
    В данном случае, добавление методов turnOnFogLights и transportCargo не требует изменений в существующих классах.

    LSP (Принцип подстановки Барбары Лисков):
    Классы-наследники корректно расширяют функциональность родительского класса и сохраняют его контракт.
    Класс GarbageTruck наследуется от DieselCar и добавляет новые методы и интерфейсы,
    не нарушая ожидаемое поведение базового класса.

    ISP (Принцип разделения интерфейсов):
    Интерфейсы определяют четко выделенные независимые функциональные возможности (FogLights и CargoTransport).
    Таким образом, классы могут реализовывать только те интерфейсы, которые соответствуют их назначению.
     */
}
