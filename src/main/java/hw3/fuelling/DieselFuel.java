package hw3.fuelling;

/**
 * Реализации интерфейса FuelType для заправки дизелем.
 */
public class DieselFuel implements FuelType {
    @Override
    public void refuel() {
        System.out.print("Заправка дизелем: ");
    }
}
