package hw5.BusinessLogic;

import hw5.DataLayer.ModelData;
import hw5.DataLayer.RenderData;

/**
 * Интерфейс для рендеринга моделей.
 */
public interface Renderer {
    /**
     * Выполняет рендеринг модели.
     *
     * @param modelData Модель данных для рендеринга.
     * @return Рендерные данные после выполнения рендеринга.
     */
    RenderData renderModel(ModelData modelData);
}
