package hw2.concreteProducts;

import hw2.products.GameItem;

/**
 * Класс предмета Серебро.
 */
public class SilverReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Открыт предмет: Серебро");
    }
}
