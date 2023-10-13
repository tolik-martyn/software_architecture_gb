package hw2.concreteProducts;

import hw2.products.GameItem;

/**
 * Класс предмета Платина.
 */
public class PlatinumReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Открыт предмет: Платина");
    }
}
