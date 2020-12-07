package xyz.cofe.win.activex;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Доступ к элементам коллекции только на чтение
 */
public interface ArrayView<A,SELF extends ArrayView<A,SELF>> extends Iterable<A> {
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

    /**
     * Создание пустой коллекции
     * @return пустая коллеция
     */
    public SELF clear();

    /**
     * Клонирование коллекции и добавление элементов
     * @param items добавляемые элементы
     * @return коллекция с добавленными элементами
     */
    @SuppressWarnings("UnusedReturnValue")
    public SELF append(Iterable<? extends A> items);

    public default SELF filter(Predicate<A> condition){
        if( condition==null )throw new IllegalArgumentException("condition==null");
        ArrayList<A> lst = new ArrayList<>();
        forEach(a -> {
            if( condition.test(a) ){
                lst.add(a);
            }
        });
        return clear().append(lst);
    }

    public default Optional<A> first(){
        if( size()<1 ){
            return Optional.empty();
        }else{
            return Optional.of(get(0));
        }
    }

    public default <B> List<B> map(Function<A,B> mapper){
        if( mapper==null )throw new IllegalArgumentException("mapper==null");
        ArrayList<B> lst = new ArrayList<>();
        forEach(a -> {
            lst.add(mapper.apply(a));
        });
        return lst;
    }

    public default <B> Optional<B> first(Function<A,B> mapper){
        if( mapper==null )throw new IllegalArgumentException("mapper==null");
        if( size()<1 ){
            return Optional.empty();
        }else {
            return Optional.of(mapper.apply(get(0)));
        }
    }
}
