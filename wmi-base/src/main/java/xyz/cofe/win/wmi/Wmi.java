package xyz.cofe.win.wmi;

import java.util.List;
import java.util.function.Consumer;

/**
 * Выполнение запросов к <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices">WMI сервису</a>
 */
public interface Wmi {
    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @param wmiObjectConsumer приемник выборки
     */
    void execQuery(String query, Consumer<WmiObj> wmiObjectConsumer);

    /**
     * Получение объекта по его WMI "пути"
     * @param path путь
     * @return объект
     */
    WmiObj getObject(String path);

    public List<WmiObj> subclassesOf();
    public void subclassesOf(Consumer<WmiObj> consumer);

    public List<WmiObj> subclassesOf(String superclass);
    public void subclassesOf(String superclass, Consumer<WmiObj> consumer);

    public List<WmiObj> subclassesOf(String superclass, int flags);
    public void subclassesOf(String superclass, int flags, Consumer<WmiObj> consumer);
}
