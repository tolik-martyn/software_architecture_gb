package hw3.fuelling;

/**
 * Реализации интерфейса FuelType для заправки бензином.
 */
public class GasolineFuel implements FuelType {
    @Override
    public void refuel() {
        System.out.print("Заправка бензином: ");
    }
}
