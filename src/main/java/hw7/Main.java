package hw7;

import hw7.adapter.OpenAPIReportAdapter;
import hw7.adapter.IAdapter;
import hw7.data.DatabaseReportData;
import hw7.data.IData;
import hw7.logic.ReportLogic;

public class Main {

    public static void main(String[] args) {

        // Создаем экземпляры адаптера и провайдера данных
        IAdapter<String, String> adapter = new OpenAPIReportAdapter();
        IData<String, String> dataProvider = new DatabaseReportData();

        // Создаем экземпляр класса ReportLogic и передаем ему адаптер и провайдер данных
        ReportLogic<String, String, String, String> reportLogic = new ReportLogic<>(adapter, dataProvider);

        // Примеры использования методов для работы с клиентом
        reportLogic.login("user123");
        reportLogic.setPreferences("preferences123");
        String clientRequest = reportLogic.receiveFromClient();

        // Обработка clientRequest
        reportLogic.executeTask("task123");
        String responseData = "Response Data"; // Фиктивные данные для отправки клиенту
        reportLogic.sendToClient(responseData);

        // Примеры использования методов для работы с базой данных
        reportLogic.connectToDatabase("databaseConnectionInfo");
        reportLogic.createTable("newTable");
        String tableData = reportLogic.getData("existingTable");
        reportLogic.insertData("existingTable", "newData");
    }
}
