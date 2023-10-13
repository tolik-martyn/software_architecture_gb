package hw2.concreteCreators;

import hw2.concreteProducts.GoldReward;
import hw2.creator.ItemGenerator;
import hw2.products.GameItem;

/**
 * Класс-генератор для предмета Золото.
 */
public class GoldGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new GoldReward();
    }
}
