package hw7.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Класс OpenAPIReportAdapter представляет собой адаптер для взаимодействия с клиентами через OpenAPI.
 * Он специализируется на отправке и приеме данных в формате JSON, а также на аутентификации клиента
 * и выполнении задач по запросу.
 */
public class OpenAPIReportAdapter extends ReportAdapter<String, String> {

    private final ObjectMapper objectMapper;

    /**
     * Конструктор класса OpenAPIReportAdapter, инициализирует ObjectMapper для работы с JSON.
     */
    public OpenAPIReportAdapter() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Отправляет данные клиенту в формате JSON.
     *
     * @param data Данные для отправки клиенту.
     */
    @Override
    public void sendToClient(String data) {
        try {
            String jsonData = objectMapper.writeValueAsString(data);
            // TODO: 02.09.2023 Реализация отправки данных клиенту в формате JSON
        } catch (Exception e) {
            System.err.println("Ошибочка при отправке данных!");
        }
    }

    /**
     * Получает данные от клиента через OpenAPI.
     *
     * @return Полученные данные от клиента.
     */
    @Override
    public String receiveFromClient() {
        // TODO: 02.09.2023 Реализация получения данных от клиента через OpenAPI
        return "";
    }

    /**
     * Аутентифицирует клиента.
     *
     * @param authenticationData Данные аутентификации клиента.
     */
    @Override
    public void login(String authenticationData) {
        // TODO: 02.09.2023 Реализация аутентификации клиента
    }

    /**
     * Устанавливает настройки клиента.
     *
     * @param preferences Настройки клиента.
     */
    @Override
    public void setPreferences(String preferences) {
        // TODO: 02.09.2023 Реализация установки настроек клиента
    }

    /**
     * Выполняет задачу по запросу клиента.
     *
     * @param task Задача для выполнения.
     */
    @Override
    public void executeTask(String task) {
        // TODO: 02.09.2023 Реализация выполнения задачи по запросу клиента
    }
}
