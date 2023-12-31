package hw3.fuelling;

/**
 * Интерфейс для видов топлива.
 */
public interface FuelType {
    void refuel();

    /*
    Принцип инверсии зависимости (DIP) соблюден, так как код в пакете fuelling опирается
    на абстракцию (интерфейс FuelType) для видов топлива, а не на конкретные реализации.
    Класс FuelStation работает с интерфейсом FuelType, что позволяет расширять и добавлять
    новые виды топлива без изменения существующего кода. Таким образом, высокоуровневые
    модули (классы из пакета fuelling) зависят от абстракции (интерфейса FuelType),
    а не от деталей (конкретных реализаций).
     */
}
