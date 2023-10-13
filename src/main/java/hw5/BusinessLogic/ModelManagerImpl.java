package hw5.BusinessLogic;

import hw5.DataLayer.DataStorage;
import hw5.DataLayer.ModelData;
import hw5.DataLayer.RenderData;

/**
 * Реализация интерфейса ModelManager.
 */
public class ModelManagerImpl implements ModelManager {
    private DataStorage dataStorage;
    private Renderer renderer;

    /**
     * Конструктор.
     *
     * @param dataStorage Хранилище данных.
     * @param renderer    Рендерер для выполнения рендеринга моделей.
     */
    public ModelManagerImpl(DataStorage dataStorage, Renderer renderer) {
        this.dataStorage = dataStorage;
        this.renderer = renderer;
    }

    @Override
    public ModelData createModel() {
        ModelData modelData = new ModelData();
        dataStorage.saveModel(modelData);
        return modelData;
    }

    @Override
    public RenderData renderModel(ModelData modelData) {
        RenderData renderData = renderer.renderModel(modelData);
        dataStorage.saveRender(renderData);
        return renderData;
    }

    @Override
    public void editVertices(ModelData modelData) {
        // реализация редактирования вершин
    }

    @Override
    public void editTextures(ModelData modelData) {
        // реализация редактирования текстур
    }
}
