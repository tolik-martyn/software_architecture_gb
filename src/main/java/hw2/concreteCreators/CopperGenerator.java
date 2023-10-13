package hw2.concreteCreators;

import hw2.concreteProducts.CopperReward;
import hw2.creator.ItemGenerator;
import hw2.products.GameItem;

/**
 * Класс-генератор для предмета Медь.
 */
public class CopperGenerator extends ItemGenerator {
    @Override
    public GameItem createItem() {
        return new CopperReward();
    }
}
