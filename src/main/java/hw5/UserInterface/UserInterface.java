package hw5.UserInterface;

import hw5.DataLayer.ModelData;
import hw5.DataLayer.RenderData;

/**
 * Интерфейс пользовательского интерфейса для взаимодействия с пользователем.
 */
public interface UserInterface {
    /**
     * Загружает модель.
     */
    void loadModel();

    /**
     * Редактирует модель.
     *
     * @param modelData Модель данных для редактирования.
     */
    void editModel(ModelData modelData);

    /**
     * Отображает рендер.
     *
     * @param renderData Рендерные данные для отображения.
     */
    void viewRender(RenderData renderData);

    /**
     * Создает и отображает модель.
     */
    void createAndRenderModel();
}
