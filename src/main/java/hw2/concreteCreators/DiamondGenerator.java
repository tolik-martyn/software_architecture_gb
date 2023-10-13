package hw2.concreteCreators;

import hw2.concreteProducts.DiamondReward;
import hw2.creator.ItemGenerator;
import hw2.products.GameItem;

/**
 * Класс-генератор для предмета Алмаз.
 */
public class DiamondGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new DiamondReward();
    }
}
