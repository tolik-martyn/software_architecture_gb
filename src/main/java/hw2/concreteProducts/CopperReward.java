package hw2.concreteProducts;

import hw2.products.GameItem;

/**
 * Класс предмета Медь.
 */
public class CopperReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Открыт предмет: Медь");
    }
}
