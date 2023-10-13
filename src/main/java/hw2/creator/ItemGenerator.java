package hw2.creator;

import hw2.products.GameItem;

/**
 * Абстрактный класс генератора предметов.
 */
public abstract class ItemGenerator {
    /**
     * Метод для открытия награды.
     * Создает предмет с помощью фабричного метода и вызывает его метод открытия.
     */
    public void openReward() {
        GameItem gameItem = createItem();
        gameItem.open();
    }

    /**
     * Абстрактный метод для создания игрового предмета.
     */
    public abstract GameItem createItem();
}
