package hw7.data;

/**
 * Абстрактный базовый класс для данных отчетов.
 * Этот класс реализует интерфейс IData и предоставляет общую основу
 * для классов, предназначенных для хранения данных, необходимых для создания отчетов.
 *
 * @param <TTableName> Тип данных, представляющий имя таблицы или источника данных.
 * @param <TData>      Тип данных, представляющий собой сами данные отчета.
 */
public abstract class ReportData<TTableName, TData> implements IData<TTableName, TData> {

}