package hw4.models;

/**
 * Класс, представляющий информацию о перевозчике.
 */
public class Carrier {
    private static int nextId = 1;
    private int id;
    private String name;
    private String route;

    /**
     * Конструктор класса Carrier.
     *
     * @param name  название перевозчика
     * @param route маршрут перевозчика
     */
    public Carrier(String name, String route) {
        this.id = nextId++;
        this.name = name;
        this.route = route;
    }

    /**
     * Получает идентификатор перевозчика.
     *
     * @return идентификатор перевозчика
     */
    public int getId() {
        return id;
    }

    /**
     * Получает название перевозчика.
     *
     * @return название перевозчика
     */
    public String getName() {
        return name;
    }

    /**
     * Получает маршрут перевозчика.
     *
     * @return маршрут перевозчика
     */
    public String getRoute() {
        return route;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Carrier carrier = (Carrier) obj;

        return id == carrier.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Перевозчик {" +
                "Идентификатор=" + id +
                ", Название='" + name + '\'' +
                ", Маршрут='" + route + '\'' +
                '}';
    }
}
