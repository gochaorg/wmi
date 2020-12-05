package xyz.cofe.win.wmi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Выполнение запросов к <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices">WMI сервису</a>
 */
public interface Wmi {
    //region execQuery()
    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @param wmiObjectConsumer приемник выборки
     * @see #execQuery(String, Optional, Optional, Consumer)
     */
    void execQuery(String query, Consumer<WmiObj> wmiObjectConsumer);

    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @return результат выборки
     * @see #execQuery(String, Optional, Optional, Consumer)
     */
    public default List<WmiObj> execQuery(String query){
        if( query==null )throw new IllegalArgumentException("query==null");
        ArrayList<WmiObj> lst = new ArrayList<>();
        execQuery(query,lst::add);
        return lst;
    }

    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @param flags флаги
     * @param wmiObjectConsumer приемник выборки
     * @see #execQuery(String, Optional, Optional, Consumer)
     */
    public void execQuery(
        String query,
        int flags,
        Consumer<WmiObj> wmiObjectConsumer
    );

    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @param flags флаги
     * @return результат выборки
     * @see #execQuery(String, Optional, Optional, Consumer)
     */
    public default List<WmiObj> execQuery(String query, int flags){
        if( query==null )throw new IllegalArgumentException("query==null");
        ArrayList<WmiObj> lst = new ArrayList<>();
        execQuery(query,flags,lst::add);
        return lst;
    }

    /**
     * The ExecQuery method of the SWbemServices object executes a query to retrieve objects. These objects are available through the returned SWbemObjectSet collection.
     * @param query Required. String that contains the text of the query. This parameter cannot be blank. For more information on building WMI query strings, see Querying with WQL and the WQL reference.
     * @param queryLanguage String that contains the query language to be used. If specified, this value must be "WQL".
     * @param flags Integer that determines the behavior of the query and determines whether this call returns immediately. The default value for this parameter is wbemFlagReturnImmediately. This parameter can accept the following values.
     *              <ul>
     *              <li>wbemFlagForwardOnly (32 (0x20))
     *                <br> Causes a forward-only enumerator to be returned. Forward-only enumerators are generally much faster and use less memory than conventional enumerators, but they do not allow calls to SWbemObject.Clone_.
     *                <br> Вызывает возвращение перечислителя только для пересылки. Перечислители, работающие только в прямом направлении, обычно намного быстрее и используют меньше памяти, чем обычные перечислители, но они не позволяют вызывать SWbemObject.Clone_.
     *              <li>wbemFlagBidirectional (0 (0x0))
     *                <br> Causes WMI to retain pointers to objects of the enumeration until the client releases the enumerator.
     *                <br> Заставляет WMI сохранять указатели на объекты перечисления до тех пор, пока клиент не освободит перечислитель.
     *              <li>wbemFlagReturnImmediately (16 (0x10))
     *                <br> Causes the call to return immediately.
     *                <br> Вызывает немедленный возврат вызова.
     *              <li>wbemFlagReturnWhenComplete (0 (0x0))
     *                <br> Causes this call to block until the query is complete. This flag calls the method in the synchronous mode.
     *                <br> Вызывает блокировку этого вызова до завершения запроса. Этот флаг вызывает метод в синхронном режиме.
     *              <li>wbemQueryFlagPrototype (2 (0x2))
     *                <br> Used for prototyping. This flag stops the query from happening and returns an object that looks like a typical result object.
     *                <br> Используется для прототипирования. Этот флаг останавливает выполнение запроса и возвращает объект, который выглядит как типичный объект результата.
     *              <li>wbemFlagUseAmendedQualifiers (131072 (0x20000))
     *                <br> Causes WMI to return class amendment data with the base class definition. For more information, see Localizing WMI Class Information.
     *                <br> Заставляет WMI возвращать данные об изменении класса с определением базового класса. Дополнительные сведения см. В разделе «Локализация информации о классе WMI».
     *              </ul>
     * @param wmiObjectConsumer приемник выборки
     */
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public void execQuery(
        String query,
        Optional<String> queryLanguage,
        Optional<Integer> flags,
        Consumer<WmiObj> wmiObjectConsumer
    );
    //endregion

    /**
     * Получение объекта по его WMI "пути"
     * @param path путь
     * @return объект
     */
    WmiObj getObject(String path);

    //region subclassesOf()
    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @return классы
     */
    public List<WmiObj> subclassesOf();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param consumer классы
     */
    public void subclassesOf(Consumer<WmiObj> consumer);

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param superclass родительский класс
     * @return дочерние классы
     */
    public List<WmiObj> subclassesOf(String superclass);

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param superclass родительский класс
     * @param consumer дочерние классы
     */
    public void subclassesOf(String superclass, Consumer<WmiObj> consumer);

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param superclass дочерние классы
     * @param flags дополнительные флаги
     * @return дочерние классы
     */
    public List<WmiObj> subclassesOf(String superclass, int flags);

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param superclass дочерние классы
     * @param flags дополнительные флаги
     * @param consumer дочерние классы
     */
    public void subclassesOf(String superclass, int flags, Consumer<WmiObj> consumer);
    //endregion

    //region associatorsOf()
    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        return associatorsOf(
            objectPath,
            Optional.empty(),Optional.empty(),
            Optional.empty(),Optional.empty(),
            Optional.empty(),Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.empty(),
            Optional.empty(),Optional.empty(),
            Optional.empty(),Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.of(resultClass),
            Optional.empty(),Optional.empty(),
            Optional.empty(),Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param resultRole указывает, что возвращаемые конечные точки должны играть определенную роль в их ассоциации с исходным объектом
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.of(resultClass),
            Optional.of(resultRole),Optional.empty(),
            Optional.empty(),Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param resultRole указывает, что возвращаемые конечные точки должны играть определенную роль в их ассоциации с исходным объектом
     * @param role указывает, что возвращаемые конечные точки должны участвовать в ассоциации с исходным объектом, в котором исходный объект играет определенную роль. Роль определяется именем указанного свойства (которое должно быть ссылочным свойством)
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.of(resultClass),
            Optional.of(resultRole),Optional.of(role),
            Optional.empty(),Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param resultRole указывает, что возвращаемые конечные точки должны играть определенную роль в их ассоциации с исходным объектом
     * @param role указывает, что возвращаемые конечные точки должны участвовать в ассоциации с исходным объектом, в котором исходный объект играет определенную роль. Роль определяется именем указанного свойства (которое должно быть ссылочным свойством)
     * @param classesOnly указывающее, следует ли возвращать список имен классов, а не фактические экземпляры классов.
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.of(resultClass),
            Optional.of(resultRole),Optional.of(role),
            Optional.of(classesOnly),Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param resultRole указывает, что возвращаемые конечные точки должны играть определенную роль в их ассоциации с исходным объектом
     * @param role указывает, что возвращаемые конечные точки должны участвовать в ассоциации с исходным объектом, в котором исходный объект играет определенную роль. Роль определяется именем указанного свойства (которое должно быть ссылочным свойством)
     * @param classesOnly указывающее, следует ли возвращать список имен классов, а не фактические экземпляры классов.
     * @param schemaOnly указывающее, применяется ли запрос к схеме, а не к данным.
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.of(resultClass),
            Optional.of(resultRole),Optional.of(role),
            Optional.of(classesOnly),Optional.of(schemaOnly),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param resultRole указывает, что возвращаемые конечные точки должны играть определенную роль в их ассоциации с исходным объектом
     * @param role указывает, что возвращаемые конечные точки должны участвовать в ассоциации с исходным объектом, в котором исходный объект играет определенную роль. Роль определяется именем указанного свойства (которое должно быть ссылочным свойством)
     * @param classesOnly указывающее, следует ли возвращать список имен классов, а не фактические экземпляры классов.
     * @param schemaOnly указывающее, применяется ли запрос к схеме, а не к данным.
     * @param requiredAssocQualifier указывает, что возвращаемые конечные точки должны быть связаны с исходным объектом через класс ассоциации, который включает указанный квалификатор.
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredAssocQualifier,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredAssocQualifier
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredAssocQualifier==null )throw new IllegalArgumentException("requiredAssocQualifier==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.of(resultClass),
            Optional.of(resultRole),Optional.of(role),
            Optional.of(classesOnly),Optional.of(schemaOnly),
            Optional.of(requiredAssocQualifier),
            Optional.empty(),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param resultRole указывает, что возвращаемые конечные точки должны играть определенную роль в их ассоциации с исходным объектом
     * @param role указывает, что возвращаемые конечные точки должны участвовать в ассоциации с исходным объектом, в котором исходный объект играет определенную роль. Роль определяется именем указанного свойства (которое должно быть ссылочным свойством)
     * @param classesOnly указывающее, следует ли возвращать список имен классов, а не фактические экземпляры классов.
     * @param schemaOnly указывающее, применяется ли запрос к схеме, а не к данным.
     * @param requiredAssocQualifier указывает, что возвращаемые конечные точки должны быть связаны с исходным объектом через класс ассоциации, который включает указанный квалификатор.
     * @param requiredQualifier Строка, содержащая имя квалификатора. Если указан, этот параметр указывает, что возвращаемые конечные точки должны включать указанный квалификатор.
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredAssocQualifier,
        String requiredQualifier,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredAssocQualifier,
        String requiredQualifier
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredAssocQualifier==null )throw new IllegalArgumentException("requiredAssocQualifier==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.of(resultClass),
            Optional.of(resultRole),Optional.of(role),
            Optional.of(classesOnly),Optional.of(schemaOnly),
            Optional.of(requiredAssocQualifier),
            Optional.of(requiredQualifier),
            Optional.empty());
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param resultRole указывает, что возвращаемые конечные точки должны играть определенную роль в их ассоциации с исходным объектом
     * @param role указывает, что возвращаемые конечные точки должны участвовать в ассоциации с исходным объектом, в котором исходный объект играет определенную роль. Роль определяется именем указанного свойства (которое должно быть ссылочным свойством)
     * @param classesOnly указывающее, следует ли возвращать список имен классов, а не фактические экземпляры классов.
     * @param schemaOnly указывающее, применяется ли запрос к схеме, а не к данным.
     * @param requiredAssocQualifier указывает, что возвращаемые конечные точки должны быть связаны с исходным объектом через класс ассоциации, который включает указанный квалификатор.
     * @param requiredQualifier Строка, содержащая имя квалификатора. Если указан, этот параметр указывает, что возвращаемые конечные точки должны включать указанный квалификатор.
     * @param flags Целое число, определяющее дополнительные флаги операции
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredAssocQualifier,
        String requiredQualifier,
        int flags,
        Consumer<WmiObj> client
    );

    public default List<WmiObj> associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredAssocQualifier,
        String requiredQualifier,
        int flags
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredAssocQualifier==null )throw new IllegalArgumentException("requiredAssocQualifier==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        return associatorsOf(
            objectPath,
            Optional.of(assocClass),Optional.of(resultClass),
            Optional.of(resultRole),Optional.of(role),
            Optional.of(classesOnly),Optional.of(schemaOnly),
            Optional.of(requiredAssocQualifier),
            Optional.of(requiredQualifier),
            Optional.of(flags));
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-associatorsof">
     *     Получение ассоциированных объектов
     * </a>
     *
     * <p>The AssociatorsOf method of the SWbemServices object returns a collection of objects (classes or instances)
     * called endpoints that are associated with a specified object.
     *
     * <p>This method performs the same function that the ASSOCIATORS OF WQL query performs.
     *
     * <p>Метод AssociatorsOf объекта SWbemServices возвращает коллекцию объектов (классов или экземпляров),
     * называемых конечными точками, которые связаны с указанным объектом.
     *
     * <p>Этот метод выполняет ту же функцию, что и запрос ASSOCIATORS OF WQL.
     *
     * <p>Error codes
     *
     * <p>After the completion of the AssociatorsOf method, the Err object may contain one of the error codes in the following list.
     *
     * <p><b>Note</b>
     *
     * <p>A returned collection with zero elements is not an error.
     *
     * <ul>
     * <li>wbemErrAccessDenied - 2147749891 (0x80041003)
     *
     *     <br>Current user does not have the permission to view one or more of the classes returned by the call.
     *
     * <li>wbemErrFailed - 2147749889 (0x80041001)
     *
     *     <br>Unspecified error.
     *
     * <li>wbemErrInvalidParameter - 2147749896 (0x80041008)
     *
     *     <br>Invalid parameter was specified.
     *
     * <li>wbemErrOutOfMemory - 2147749894 (0x80041006)
     *
     *     <br>Not enough memory to complete the operation.
     *
     * <li>wbemErrNotFound - 2147749890 (0x80041002)
     *
     *     <br>Requested item was not found.
     * </ul>
     *
     * @param objectPath
     *      Required. String that contains the object path of the source class or instance.
     *      For more information, see Describing the Location of a WMI Object.
     *      <p>Необходимые. Строка, содержащая путь к объекту исходного класса или экземпляра.
     *      Дополнительные сведения см. В разделе «Описание расположения объекта WMI».
     * @param assocClass
     *      String that contains an association class.
     *      If specified, this parameter indicates that the returned endpoints must be associated with the source
     *      through the specified association class or a class that is derived from this association class.
     *      <p>Строка, содержащая класс ассоциации. Если указан, этот параметр указывает,
     *      что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс,
     *      производный от этого класса ассоциации.
     * @param resultClass
     *      String that contains a class name.
     *      If specified, this optional parameter indicates that the returned endpoints must belong to
     *      or be derived from the class specified in this parameter.
     *      <p>Строка, содержащая имя класса. Если указан, этот необязательный параметр указывает,
     *      что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре,
     *      или быть производными от него.
     * @param resultRole
     *      String that contains a property name. If specified, this parameter
     *      indicates that the returned endpoints must play a particular role in their association
     *      with the source object. The role is defined by the name of a specified property
     *      (which must be a reference property) of an association.
     *      <p>Строка, содержащая имя свойства.
     *      Если указан, этот параметр указывает, что возвращаемые конечные точки
     *      должны играть определенную роль в их ассоциации с исходным объектом.
     *      Роль определяется именем указанного свойства (которое должно быть ссылочным свойством) ассоциации.
     * @param role
     *      String that contains a property name. If specified, this parameter indicates that
     *      the returned endpoints must participate in an association with the source
     *      object in which the source object plays a particular role.
     *      The role is defined by the name of a specified property
     *      (which must be a reference property) of an association.
     *      <p>Строка, содержащая имя свойства.
     *      Если указан, этот параметр указывает, что возвращаемые конечные точки
     *      должны участвовать в ассоциации с исходным объектом, в котором исходный
     *      объект играет определенную роль. Роль определяется именем указанного свойства
     *      (которое должно быть ссылочным свойством) ассоциации.
     * @param classesOnly
     *      Boolean value that indicates whether a list of class names should be returned
     *      rather than actual instances of the classes.
     *      These are the classes to which the endpoint instances belong.
     *      The default value for this parameter is FALSE
     *      <p>Логическое значение, указывающее, следует ли возвращать список имен классов,
     *      а не фактические экземпляры классов. Это классы, к которым принадлежат экземпляры конечных точек.
     *      Значение по умолчанию для этого параметра - ЛОЖЬ.
     * @param schemaOnly
     *      Boolean value that indicates whether the query applies to the schema rather than the data.
     *      The default value for this parameter is FALSE. It can only be set to TRUE
     *      if the strObjectPath parameter specifies the object path of a class.
     *      When set to TRUE, the set of returned endpoints represent classes that are
     *      suitably associated with the source class in schema.
     *      <p>Логическое значение, указывающее, применяется ли запрос к схеме, а не к данным.
     *      Значение по умолчанию для этого параметра - ЛОЖЬ. Его можно установить в значение TRUE,
     *      только если параметр strObjectPath указывает путь к объекту класса. Если установлено значение TRUE,
     *      набор возвращенных конечных точек представляет классы, которые соответствующим
     *      образом связаны с исходным классом в схеме.
     * @param requiredAssocQualifier
     *      String that contains a qualifier name. If specified, this parameter indicates
     *      that the returned endpoints must be associated with the source object through
     *      an association class that includes the specified qualifier.
     *      <p>Строка, содержащая имя квалификатора. Если указан, этот параметр указывает,
     *      что возвращаемые конечные точки должны быть связаны с исходным объектом через класс ассоциации,
     *      который включает указанный квалификатор.
     * @param requiredQualifier
     *      String that contains a qualifier name. If specified, this parameter indicates that
     *      the returned endpoints must include the specified qualifier.
     *
     *      <p>Строка, содержащая имя квалификатора.
     *      Если указан, этот параметр указывает, что возвращаемые конечные
     *      точки должны включать указанный квалификатор.
     * @param flags
     *      Integer that specifies additional flags to the operation.
     *      The default value for this parameter is wbemFlagReturnImmediately,
     *      which calls the method in the semisynchronous mode. This parameter can accept the following values.
     *
     *      <p>Целое число, определяющее дополнительные флаги операции.
     *      Значение по умолчанию для этого параметра - wbemFlagReturnImmediately,
     *      который вызывает метод в полусинхронном режиме. Этот параметр может принимать следующие значения.
     *
     *      <ul>
     *      <li>wbemFlagForwardOnly <b>(32 (0x20))</b>
     *      Causes a forward-only enumerator to be returned. Forward-only enumerators are generally much faster and use less memory than conventional enumerators, but they do not allow calls to SWbemObject.Clone_.
     *      <p>Вызывает возвращение перечислителя только для пересылки. Перечислители, работающие только в прямом направлении, обычно намного быстрее и используют меньше памяти, чем обычные перечислители, но они не позволяют вызывать SWbemObject.Clone_.
     *
     *      <li>wbemFlagBidirectional <b>(0 (0x0))</b>
     *      Causes WMI to retain pointers to objects of the enumeration until the client releases the enumerator.
     *      <p>Заставляет WMI сохранять указатели на объекты перечисления до тех пор, пока клиент не освободит перечислитель.
     *
     *      <li>wbemFlagReturnImmediately <b>(16 (0x10))</b>
     *      Causes the call to return immediately.
     *      <p>Вызывает немедленный возврат вызова.
     *
     *      <li>wbemFlagReturnWhenComplete <b>(0 (0x0))</b>
     *      Causes this call to block until the query has completed. This flag calls the method in synchronous mode.
     *      <p>Вызывает блокировку этого вызова до завершения запроса. Этот флаг вызывает метод в синхронном режиме.
     *
     *      <li>wbemFlagUseAmendedQualifiers <b>(131072 (0x20000))</b>
     *      Causes WMI to return class amendment data along with the base class definition
     *      <p>Заставляет WMI возвращать данные об изменении класса вместе с определением базового класса
     *      </ul>
     * @param client Клиентский код
     */
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public void associatorsOf(
        String objectPath,
        Optional<String> assocClass,
        Optional<String> resultClass,
        Optional<String> resultRole,
        Optional<String> role,
        Optional<Boolean> classesOnly,
        Optional<Boolean> schemaOnly,
        Optional<String> requiredAssocQualifier,
        Optional<String> requiredQualifier,
        Optional<Integer> flags,
        Consumer<WmiObj> client
    );

    @SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "OptionalAssignedToNull"})
    public default List<WmiObj> associatorsOf(String objectPath,
                                              Optional<String> assocClass,
                                              Optional<String> resultClass,
                                              Optional<String> resultRole,
                                              Optional<String> role,
                                              Optional<Boolean> classesOnly,
                                              Optional<Boolean> schemaOnly,
                                              Optional<String> requiredAssocQualifier,
                                              Optional<String> requiredQualifier,
                                              Optional<Integer> flags){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( classesOnly==null )throw new IllegalArgumentException("classesOnly==null");
        if( schemaOnly==null )throw new IllegalArgumentException("schemaOnly==null");
        if( requiredAssocQualifier==null )throw new IllegalArgumentException("requiredAssocQualifier==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        if( flags==null )throw new IllegalArgumentException("flags==null");
        ArrayList<WmiObj> list = new ArrayList<>();
        associatorsOf(
            objectPath,
            assocClass,
            resultClass,resultRole,role,
            classesOnly,schemaOnly,requiredAssocQualifier,requiredQualifier,
            flags,
            list::add);
        return list;
    }
    //endregion

    //region instancesOf()
    /**
     * возвращает экземпляры указанного класса в соответствии с заданными пользователем критериями выбора
     * @param clazz Строка, содержащая имя класса, для которого требуются экземпляры
     * @param client клиент
     * @see #instancesOf(String, Optional, Consumer)
     */
    public void instancesOf( String clazz, Consumer<WmiObj> client );

    /**
     * возвращает экземпляры указанного класса в соответствии с заданными пользователем критериями выбора
     * @param clazz Строка, содержащая имя класса, для которого требуются экземпляры
     * @param flags флаги
     * @param client клиент
     * @see #instancesOf(String, Optional, Consumer)
     */
    public void instancesOf( String clazz, int flags, Consumer<WmiObj> client );

    /**
     * The InstancesOf method of the SWbemServices object creates an enumerator
     * that returns the instances of a specified class according to the user-specified selection criteria.
     *
     * <p>Метод InstancesOf объекта SWbemServices создает перечислитель.
     * который возвращает экземпляры указанного класса в соответствии с заданными пользователем критериями выбора.
     *
     * <br>This method implements a simple query. More complex queries may require the use of SWbemServices.ExecQuery.
     * <br>Этот метод реализует простой запрос. Более сложные запросы могут потребовать использования SWbemServices.ExecQuery.
     *
     * <p>Error codes
     *
     * <br>Upon the completion of the InstancesOf method, the Err object may contain one of the error codes in the following list.
     *
     * <br>Note
     *
     * <br>A returned enumerator with zero elements is not an error.
     *
     * <ul>
     * <li>wbemErrAccessDenied - 2147749891 (0x80041003)
     *     <br>Current user does not have the permission to view instances of the specified class.
     *
     * <li>wbemErrFailed - 2147749889 (0x80041001)
     *     <br>Unspecified error occurred.
     *
     * <li>wbemErrInvalidClass - 2147749904 (0x80041010)
     *     <br>Specified class is not valid.
     *
     * <li>wbemErrInvalidParameter - 2147749896 (0x80041008)
     *     <br>A specified parameter is not valid.
     *
     * <li>wbemErrOutOfMemory - 2147749894 (0x80041006)
     *     <br>Not enough memory to complete the operation.
     * </ul>
     *
     * @param clazz
     *      Required. String that contains the name of the class for which instances are desired. This parameter cannot be blank.
     *      <br>Необходимые. Строка, содержащая имя класса, для которого требуются экземпляры. Этот параметр не может быть пустым.
     * @param flags
     *      This parameter determines how detailed the call enumerates and if this call returns immediately. The default value for this parameter is wbemFlagReturnImmediately. This parameter can accept the following values.
     *
     *      <ul>
     *      <li>wbemFlagForwardOnly (32 (0x20))
     *        <br>Causes a forward-only enumerator to be returned. Forward-only enumerators are generally much faster and use less memory than conventional enumerators, but they do not allow calls to SWbemObject.Clone_.
     *        <br>Вызывает возвращение перечислителя только для пересылки. Перечислители, работающие только в прямом направлении, обычно намного быстрее и используют меньше памяти, чем обычные перечислители, но они не позволяют вызывать SWbemObject.Clone_.
     *
     *      <li>wbemFlagBidirectional (0 (0x0))
     *        <br>Causes WMI to retain pointers to objects of the enumeration until the client releases the enumerator.
     *        <br>Заставляет WMI сохранять указатели на объекты перечисления до тех пор, пока клиент не освободит перечислитель.
     *
     *      <li>wbemFlagReturnImmediately (16 (0x10))
     *        <br>Default value for this parameter. This flag causes the call to return immediately.
     *        <br>Значение по умолчанию для этого параметра. Этот флаг вызывает немедленный возврат вызова.
     *
     *      <li>wbemFlagReturnWhenComplete (0 (0x0))
     *        <br>Causes this call to block until the query has completed. This flag calls the method in the synchronous mode.
     *        <br>Вызывает блокировку этого вызова до завершения запроса. Этот флаг вызывает метод в синхронном режиме.
     *
     *      <li>wbemQueryFlagShallow (1 (0x1))
     *        <br>Forces the enumeration to include only immediate subclasses of the specified parent class.
     *        <br>Заставляет перечисление включать только непосредственные подклассы указанного родительского класса.
     *
     *      <li>wbemQueryFlagDeep (0 (0x0))
     *        <br>Default value for this parameter. This value forces the enumeration to include all classes in the hierarchy.
     *        <br>Значение по умолчанию для этого параметра. Это значение заставляет перечисление включать все классы в иерархии.
     *
     *      <li>wbemFlagUseAmendedQualifiers (131072 (0x20000))
     *        <br>Causes WMI to return class amendment data with the base class definition. For more information
     *        <br>Заставляет WMI возвращать данные об изменении класса с определением базового класса. Для дополнительной информации
     *      </ul>
     * @param client
     *      Клиентский код
     */
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public void instancesOf(
        String clazz,
        Optional<Integer> flags,
        Consumer<WmiObj> client
    );
    //endregion
}
