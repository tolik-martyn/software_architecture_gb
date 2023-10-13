package hw7.logic;

import hw7.adapter.IAdapter;
import hw7.data.IData;

/**
 * Класс ReportLogic представляет логику для взаимодействия с клиентом и базой данных
 * при создании и отправке отчетов.
 *
 * @param <TRequest>    Тип данных для запросов от клиента.
 * @param <TResponse>   Тип данных для ответов клиенту.
 * @param <TTableName>  Тип данных для информации о таблице в базе данных.
 * @param <TData>       Тип данных, представляющий данные в таблице базы данных.
 */
public class ReportLogic<TRequest, TResponse, TTableName, TData> {

    private final IAdapter<TRequest, TResponse> adapter;
    private final IData<TTableName, TData> dataProvider;

    /**
     * Конструктор класса ReportLogic, инициализирующий адаптер и поставщика данных.
     *
     * @param adapter       Адаптер для взаимодействия с клиентом.
     * @param dataProvider  Поставщик данных для работы с базой данных.
     */
    public ReportLogic(IAdapter<TRequest, TResponse> adapter, IData<TTableName, TData> dataProvider) {
        this.adapter = adapter;
        this.dataProvider = dataProvider;
    }

    /**
     * Отправляет данные клиенту с использованием адаптера.
     *
     * @param data Данные для отправки клиенту.
     */
    public void sendToClient(TResponse data) {
        adapter.sendToClient(data);
    }

    /**
     * Получает запрос от клиента с использованием адаптера.
     *
     * @return Запрос от клиента.
     */
    public TRequest receiveFromClient() {
        return adapter.receiveFromClient();
    }

    /**
     * Выполняет процедуру аутентификации с использованием адаптера.
     *
     * @param authenticationData Данные аутентификации.
     */
    public void login(TRequest authenticationData) {
        adapter.login(authenticationData);
    }

    /**
     * Устанавливает настройки с использованием адаптера.
     *
     * @param preferences Настройки клиента.
     */
    public void setPreferences(TRequest preferences) {
        adapter.setPreferences(preferences);
    }

    /**
     * Выполняет задачу с использованием адаптера.
     *
     * @param task Задача для выполнения.
     */
    public void executeTask(TRequest task) {
        adapter.executeTask(task);
    }

    /**
     * Устанавливает соединение с базой данных с использованием поставщика данных.
     *
     * @param connectionInfo Информация для подключения к базе данных.
     */
    public void connectToDatabase(TTableName connectionInfo) {
        dataProvider.connectToDatabase(connectionInfo);
    }

    /**
     * Создает таблицу в базе данных с использованием поставщика данных.
     *
     * @param tableName Имя таблицы для создания.
     */
    public void createTable(TTableName tableName) {
        dataProvider.createTable(tableName);
    }

    /**
     * Получает данные из таблицы базы данных с использованием поставщика данных.
     *
     * @param tableName Имя таблицы, из которой нужно получить данные.
     * @return Данные из таблицы базы данных.
     */
    public TData getData(TTableName tableName) {
        return dataProvider.getData(tableName);
    }

    /**
     * Вставляет данные в таблицу базы данных с использованием поставщика данных.
     *
     * @param tableName Имя таблицы, в которую нужно вставить данные.
     * @param data      Данные для вставки.
     */
    public void insertData(TTableName tableName, TData data) {
        dataProvider.insertData(tableName, data);
    }
}
