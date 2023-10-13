package hw5.UserInterface;

import hw5.BusinessLogic.ModelManager;
import hw5.BusinessLogic.Renderer;
import hw5.DataLayer.ModelData;
import hw5.DataLayer.RenderData;

/**
 * Реализация интерфейса UserInterface.
 */
public class UserInterfaceImpl implements UserInterface {
    private ModelManager modelManager;
    private Renderer renderer;

    /**
     * Конструктор.
     *
     * @param modelManager Менеджер моделей.
     * @param renderer     Рендерер для выполнения рендеринга моделей.
     */
    public UserInterfaceImpl(ModelManager modelManager, Renderer renderer) {
        this.modelManager = modelManager;
        this.renderer = renderer;
    }

    @Override
    public void loadModel() {
        // реализация загрузки модели
    }

    @Override
    public void editModel(ModelData modelData) {
        // реализация редактирования модели
        modelManager.editVertices(modelData);
        modelManager.editTextures(modelData);
    }

    @Override
    public void viewRender(RenderData renderData) {
        // реализация просмотра рендера
    }

    @Override
    public void createAndRenderModel() {
        ModelData modelData = modelManager.createModel();
        RenderData renderData = modelManager.renderModel(modelData);
        viewRender(renderData);
    }
}
