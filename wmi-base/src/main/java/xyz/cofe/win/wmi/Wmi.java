package xyz.cofe.win.wmi;

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
}
