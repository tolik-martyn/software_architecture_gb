package hw8.model;

/**
 * Класс Table представляет сущность столика в ресторане.
 */
public class Table {

    private final int tableNumber;
    private final int numberOfPersons;

    private boolean isAvailable;

    /**
     * Конструктор класса Table.
     *
     * @param tableNumber     Номер столика.
     * @param numberOfPersons Количество персон.
     */
    public Table(int tableNumber, int numberOfPersons) {
        this.tableNumber = tableNumber;
        this.numberOfPersons = numberOfPersons;
        this.isAvailable = true; // По умолчанию при создании столик свободен
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
