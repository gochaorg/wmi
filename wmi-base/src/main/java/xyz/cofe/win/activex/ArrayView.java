package xyz.cofe.win.activex;

/**
 * Доступ к элементам коллекции только на чтение
 */
public interface ArrayView<A> extends Iterable<A> {
    /**
     * Кол-во элементов
     * @return кол-во
     */
    public int getSize();

    /**
     * Кол-во элементов
     * @return кол-во
     */
    public default int size(){ return getSize(); }

    /**
     * Получение элемента по его индексу
     * @param idx индекс
     * @return свойство
     */
    public A get(int idx);
}
