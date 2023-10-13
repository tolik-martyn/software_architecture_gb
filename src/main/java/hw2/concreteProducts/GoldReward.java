package hw2.concreteProducts;

import hw2.products.GameItem;

/**
 * Класс предмета Золото.
 */
public class GoldReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Открыт предмет: Золото");
    }
}
