package hw5.DataLayer;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

/**
 * Реализация интерфейса DataStorage для сохранения данных в файловой системе.
 */
public class FileDataStorage implements DataStorage {
    private String basePath;
    private static final Logger logger = Logger.getLogger(FileDataStorage.class.getName());

    /**
     * Конструктор.
     *
     * @param basePath Базовый путь для сохранения файлов.
     */
    public FileDataStorage(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public void saveModel(ModelData modelData) {
        String filePath = basePath + "/model.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(modelData);
            logger.info("Модель сохранена в файл: " + filePath);
        } catch (Exception e) {
            logger.severe("Ошибка при сохранении модели в файл: " + e.getMessage());
        }
    }

    @Override
    public void saveRender(RenderData renderData) {
        String filePath = basePath + "/render.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(renderData);
            logger.info("Рендер сохранен в файл: " + filePath);
        } catch (Exception e) {
            logger.severe("Ошибка при сохранении рендера в файл: " + e.getMessage());
        }
    }
}
