package hw8;

import hw8.controller.Controller;
import hw8.model.IRepo;
import hw8.model.Repo;
import hw8.view.IView;
import hw8.view.View;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты View, Repo и Controller
        IView view = new View();
        IRepo repo = new Repo();
        Controller controller = new Controller(view, repo);

        // Вызываем метод processReservation для бронирования столика
        controller.processReservation();
    }
}
