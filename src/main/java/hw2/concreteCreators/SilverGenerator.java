package hw2.concreteCreators;

import hw2.concreteProducts.SilverReward;
import hw2.creator.ItemGenerator;
import hw2.products.GameItem;

/**
 * Класс-генератор для предмета Серебро.
 */
public class SilverGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new SilverReward();
    }
}
