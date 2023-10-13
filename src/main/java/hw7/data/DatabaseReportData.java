package hw7.data;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Класс `DatabaseReportData` предоставляет функциональность для работы с базой данных в контексте отчетов.
 * Он обеспечивает подключение к базе данных, создание таблиц, получение данных и вставку данных в указанную таблицу.
 */
public class DatabaseReportData extends ReportData<String, String>{

    @Override
    public void connectToDatabase(String connectionInfo) {
        try {
            Connection connection = DriverManager.getConnection(connectionInfo);
            // TODO: 02.09.2023 Реализация подключения к базе данных с использованием переданных параметров подключения
        } catch (Exception e) {
            System.err.println("Ошибочка при подключении к базе данных!");
        }
    }

    @Override
    public void createTable(String tableName) {
        // TODO: 02.09.2023 Реализация создания новой таблицы в базе данных
    }

    @Override
    public void insertData(String tableName, String data) {
        // TODO: 02.09.2023 Реализация вставки данных в указанную таблицу
    }

    @Override
    public String getData(String tableName) {
        // TODO: 02.09.2023 Реализация получения данных из указанной таблицы
        return null;
    }
}
