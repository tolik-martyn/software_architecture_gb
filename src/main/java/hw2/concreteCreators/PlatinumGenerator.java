package hw2.concreteCreators;

import hw2.concreteProducts.PlatinumReward;
import hw2.creator.ItemGenerator;
import hw2.products.GameItem;

/**
 * Класс-генератор для предмета Платина.
 */
public class PlatinumGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new PlatinumReward();
    }
}
