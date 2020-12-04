package xyz.cofe.win.activex;

/**
 * <a href="https://docs.microsoft.com/ru-ru/windows/win32/wmisdk/swbemmethod">Описание метода</a>
 */
public interface SWbemMethod extends GetWmiQualifiers {
    /**
     * Возвращает имя метода
     * @return имя метода
     */
    String getName();

    /**
     * The Origin property of the SWbemMethod object returns the name
     * of the class in which this method was introduced.
     *
     * For classes with deep inheritance hierarchies,
     * it is often desirable to know which methods were declared in which classes.
     *
     * <p>
     * This property is read-only.
     *
     * <p>
     * Свойство Origin объекта SWbemMethod возвращает имя класса,
     * в котором был представлен этот метод.
     * Для классов с глубокой иерархией наследования часто бывает желательно знать,
     * какие методы в каких классах были объявлены.
     *
     * <p>
     * Это свойство доступно только для чтения.
     * @return
     *   the name of the class in which this method was introduced /
     *   возвращает имя класса, в котором был представлен этот метод
     */
    String getOrigin();

    /**
     * The InParameters property of the SWbemMethod object is an SWbemObject object whose properties
     * define the input parameters for this method.
     *
     * <p>
     * This property is read-only. Note that any changes that
     * are made to this object are not reflected in the underlying method definition.
     *
     * <p>
     * Свойство InParameters объекта SWbemMethod - это объект SWbemObject,
     * свойства которого определяют входные параметры для этого метода.
     *
     * <p>
     * Это свойство доступно только для чтения.
     *
     * <p>
     * Обратите внимание, что любые изменения, внесенные в этот объект,
     * не отражаются в определении базового метода.
     * @return Аргументы метода
     */
    SWbemPropertySet getInParameters();

    /**
     * The OutParameters property of the SWbemMethod object is an SWbemObject object
     * whose properties define the out parameters and return type of this method.
     *
     * <p>
     * This property is read-only.
     *
     * <p>
     * Свойство OutParameters объекта SWbemMethod - это объект SWbemObject,
     * свойства которого определяют параметры вывода и тип возвращаемого значения этого метода.
     *
     * <p>
     * Это свойство доступно только для чтения.
     * @return Результаты метода
     */
    SWbemPropertySet getOutParameters();
}
