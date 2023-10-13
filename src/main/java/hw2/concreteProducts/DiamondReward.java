package hw2.concreteProducts;

import hw2.products.GameItem;

/**
 * Класс предмета Алмаз.
 */
public class DiamondReward implements GameItem {
    @Override
    public void open() {
        System.out.println("Открыт предмет: Алмаз");
    }
}
