package hw7.adapter;

/**
 * Абстрактный класс ReportAdapter является базовым классом для адаптеров отчетов.
 * Он реализует интерфейс IAdapter и предоставляет общую функциональность для обработки
 * запросов на формирование отчетов и возвращения результатов.
 *
 * @param <TRequest>  Тип запроса, который будет обрабатываться адаптером.
 * @param <TResponse> Тип ответа, который будет возвращаться адаптером.
 */
public abstract class ReportAdapter<TRequest, TResponse> implements IAdapter<TRequest, TResponse>{

}
