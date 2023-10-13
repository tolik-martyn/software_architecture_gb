package hw3.fuelling;

/**
 * Реализации интерфейса FuelType для зарядки электроэнергией.
 */
public class ElectricFuel implements FuelType {
    @Override
    public void refuel() {
        System.out.print("Зарядка электроэнергией: ");
    }
}
