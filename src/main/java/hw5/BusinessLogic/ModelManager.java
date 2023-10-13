package hw5.BusinessLogic;

import hw5.DataLayer.ModelData;
import hw5.DataLayer.RenderData;

/**
 * Менеджер моделей, отвечающий за создание, редактирование и рендеринг моделей.
 */
public interface ModelManager {

    /**
     * Создает новую модель данных.
     *
     * @return Созданная модель данных.
     */
    ModelData createModel();

    /**
     * Выполняет рендеринг модели и сохраняет рендерные данные.
     *
     * @param modelData Модель данных для рендеринга.
     * @return Рендерные данные после выполнения рендеринга.
     */
    RenderData renderModel(ModelData modelData);

    /**
     * Редактирует вершины модели.
     *
     * @param modelData Модель данных для редактирования вершин.
     */
    void editVertices(ModelData modelData);

    /**
     * Редактирует текстуры модели.
     *
     * @param modelData Модель данных для редактирования текстур.
     */
    void editTextures(ModelData modelData);
}
