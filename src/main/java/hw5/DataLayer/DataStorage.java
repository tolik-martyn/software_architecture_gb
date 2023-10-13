package hw5.DataLayer;

/**
 * Интерфейс для хранения данных моделей и рендерных данных.
 */
public interface DataStorage {
    /**
     * Сохраняет модельные данные.
     *
     * @param modelData Данные модели для сохранения.
     */
    void saveModel(ModelData modelData);

    /**
     * Сохраняет рендерные данные.
     *
     * @param renderData Рендерные данные для сохранения.
     */
    void saveRender(RenderData renderData);
}
