package hw3.vehicles;

import hw3.vehicles.features.FuelsType;
import hw3.vehicles.features.TransmissionType;

import java.awt.*;

/**
 * Базоввый абстактный класс автомобиля.
 */
public abstract class Car {
    /**
     * Марка авто.
     */
    protected String brand;

    /**
     * Модель авто.
     */
    protected String model;

    /**
     * Цвет авто.
     */
    protected Color color;

    /**
     * Тип кузова.
     */
    protected String bodyType;

    /**
     * Количество колес.
     */
    protected int numberOfWheels;

    /**
     * Тип топлива.
     */
    protected FuelsType fuelType;

    /**
     * Тип коробки передач
     */
    protected TransmissionType transmissionType;

    /**
     * Объём двигателя.
     */
    protected double engineVolume;

    public Car(String brand, String model, Color color, String bodyType, int numberOfWheels,
               FuelsType fuelType, TransmissionType transmissionType, double engineVolume) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.bodyType = bodyType;
        this.numberOfWheels = numberOfWheels;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.engineVolume = engineVolume;
    }

    /**
     * Метод для получения марки авто.
     * @return наименование марки авто.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Метод для получения модели авто.
     * @return наименование модели авто.
     */
    public String getModel() {
        return model;
    }

    /**
     * Метод движения автомобиля.
     */
    public abstract void move();

    /**
     * Метод обслуживания автомобиля.
     */
    public abstract void service();

    /**
     * Метод переключения передач.
     */
    public abstract void shiftGears();

    /**
     * Метод включения фар.
     */
    public abstract void turnOnHeadlights();

    /**
     * Метод включения дворников.
     */
    public abstract void turnOnWipers();
}
