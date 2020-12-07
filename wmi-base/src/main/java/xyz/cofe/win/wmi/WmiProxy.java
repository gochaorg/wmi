package xyz.cofe.win.wmi;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class WmiProxy implements Wmi {
    public final Wmi target;
    public WmiProxy(Wmi target){
        if( target==null )throw new IllegalArgumentException("target==null");
        this.target = target;
    }

    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @param wmiObjectConsumer приемник выборки
     * @see #execQuery(String, Optional, Optional, Consumer)
     */
    @Override
    public void execQuery(String query, Consumer<WmiObj> wmiObjectConsumer) {
        target.execQuery(query, wmiObjectConsumer);
    }

    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @return результат выборки
     * @see #execQuery(String, Optional, Optional, Consumer)
     */
    @Override
    public List<WmiObj> execQuery(String query) {
        return target.execQuery(query);
    }

    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @param flags флаги
     * @param wmiObjectConsumer приемник выборки
     * @see #execQuery(String, Optional, Optional, Consumer)
     */
    @Override
    public void execQuery(String query, int flags, Consumer<WmiObj> wmiObjectConsumer) {
        target.execQuery(query, flags, wmiObjectConsumer);
    }

    /**
     * Выполнение WQL запроса
     * @param query запрос
     * @param flags флаги
     * @return результат выборки
     * @see #execQuery(String, Optional, Optional, Consumer)
     */
    @Override
    public List<WmiObj> execQuery(String query, int flags) {
        return target.execQuery(query, flags);
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
    @Override
    public void execQuery(String query, Optional<String> queryLanguage, Optional<Integer> flags, Consumer<WmiObj> wmiObjectConsumer) {
        target.execQuery(query, queryLanguage, flags, wmiObjectConsumer);
    }

    /**
     * Получение объекта по его WMI "пути"
     * @param path путь
     * @return объект
     */
    @Override
    public WmiObj getObject(String path) {
        return target.getObject(path);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @return классы
     */
    @Override
    public List<WmiObj> subclassesOf() {
        return target.subclassesOf();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param consumer классы
     */
    @Override
    public void subclassesOf(Consumer<WmiObj> consumer) {
        target.subclassesOf(consumer);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param superclass родительский класс
     * @return дочерние классы
     */
    @Override
    public List<WmiObj> subclassesOf(String superclass) {
        return target.subclassesOf(superclass);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param superclass родительский класс
     * @param consumer дочерние классы
     */
    @Override
    public void subclassesOf(String superclass, Consumer<WmiObj> consumer) {
        target.subclassesOf(superclass, consumer);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param superclass дочерние классы
     * @param flags дополнительные флаги
     * @return дочерние классы
     */
    @Override
    public List<WmiObj> subclassesOf(String superclass, int flags) {
        return target.subclassesOf(superclass, flags);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemservices-subclassesof">Получение списка дочерних классов</a>
     * @param superclass дочерние классы
     * @param flags дополнительные флаги
     * @param consumer дочерние классы
     */
    @Override
    public void subclassesOf(String superclass, int flags, Consumer<WmiObj> consumer) {
        target.subclassesOf(superclass, flags, consumer);
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    @Override
    public void associatorsOf(String objectPath, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath) {
        return target.associatorsOf(objectPath);
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    @Override
    public void associatorsOf(String objectPath, String assocClass, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass) {
        return target.associatorsOf(objectPath, assocClass);
    }

    /**
     * Получение ассоциированных объектов.
     * @param objectPath WMI путь
     * @param assocClass указывает, что возвращаемые конечные точки должны быть связаны с источником через указанный класс ассоциации или класс, производный от этого класса ассоциации
     * @param resultClass указывает, что возвращаемые конечные точки должны принадлежать классу, указанному в этом параметре, или быть производными от него
     * @param client Клиентский код
     * @see #associatorsOf(String, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Optional, Consumer)
     */
    @Override
    public void associatorsOf(String objectPath, String assocClass, String resultClass, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass, String resultClass) {
        return target.associatorsOf(objectPath, assocClass, resultClass);
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
    @Override
    public void associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, resultRole, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole) {
        return target.associatorsOf(objectPath, assocClass, resultClass, resultRole);
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
    @Override
    public void associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role) {
        return target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role);
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
    @Override
    public void associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly) {
        return target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly);
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
    @Override
    public void associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, boolean schemaOnly, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, boolean schemaOnly) {
        return target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly);
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
    @Override
    public void associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, boolean schemaOnly, String requiredAssocQualifier, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, requiredAssocQualifier, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, boolean schemaOnly, String requiredAssocQualifier) {
        return target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, requiredAssocQualifier);
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
    @Override
    public void associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, boolean schemaOnly, String requiredAssocQualifier, String requiredQualifier, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, requiredAssocQualifier, requiredQualifier, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, boolean schemaOnly, String requiredAssocQualifier, String requiredQualifier) {
        return target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, requiredAssocQualifier, requiredQualifier);
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
    @Override
    public void associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, boolean schemaOnly, String requiredAssocQualifier, String requiredQualifier, int flags, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, requiredAssocQualifier, requiredQualifier, flags, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, String assocClass, String resultClass, String resultRole, String role, boolean classesOnly, boolean schemaOnly, String requiredAssocQualifier, String requiredQualifier, int flags) {
        return target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, requiredAssocQualifier, requiredQualifier, flags);
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
     *  @param objectPath
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
    @Override
    public void associatorsOf(String objectPath, Optional<String> assocClass, Optional<String> resultClass, Optional<String> resultRole, Optional<String> role, Optional<Boolean> classesOnly, Optional<Boolean> schemaOnly, Optional<String> requiredAssocQualifier, Optional<String> requiredQualifier, Optional<Integer> flags, Consumer<WmiObj> client) {
        target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, requiredAssocQualifier, requiredQualifier, flags, client);
    }

    @Override
    public List<WmiObj> associatorsOf(String objectPath, Optional<String> assocClass, Optional<String> resultClass, Optional<String> resultRole, Optional<String> role, Optional<Boolean> classesOnly, Optional<Boolean> schemaOnly, Optional<String> requiredAssocQualifier, Optional<String> requiredQualifier, Optional<Integer> flags) {
        return target.associatorsOf(objectPath, assocClass, resultClass, resultRole, role, classesOnly, schemaOnly, requiredAssocQualifier, requiredQualifier, flags);
    }

    /**
     * возвращает экземпляры указанного класса в соответствии с заданными пользователем критериями выбора
     * @param clazz Строка, содержащая имя класса, для которого требуются экземпляры
     * @param client клиент
     * @see #instancesOf(String, Optional, Consumer)
     */
    @Override
    public void instancesOf(String clazz, Consumer<WmiObj> client) {
        target.instancesOf(clazz, client);
    }

    /**
     * возвращает экземпляры указанного класса в соответствии с заданными пользователем критериями выбора
     * @param clazz Строка, содержащая имя класса, для которого требуются экземпляры
     * @param flags флаги
     * @param client клиент
     * @see #instancesOf(String, Optional, Consumer)
     */
    @Override
    public void instancesOf(String clazz, int flags, Consumer<WmiObj> client) {
        target.instancesOf(clazz, flags, client);
    }

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
     *  @param clazz
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
     */
    @Override
    public void instancesOf(String clazz, Optional<Integer> flags, Consumer<WmiObj> client) {
        target.instancesOf(clazz, flags, client);
    }

    /**
     * The ReferencesTo method of the SWbemServices object returns a collection
     * of all association classes or instances that refer to a specific source class or instance.
     *
     * This method performs the same function that the REFERENCES OF WQL query performs.
     *  @param objectPath Required. String that contains the object path of the source for this method. For more information
     * @param resultClass String that contains a class name. If specified, this parameter indicates that the returned association objects must belong to or be derived from the class that is specified in this parameter.
     * @param role String that contains a property name. If specified, this parameter indicates that the returned association objects must be limited to those in which the source object plays a specific role. The role is defined by the name of a specified property (which must be a reference property) of an association.
     * @param classesOnly Boolean value that indicates whether or not a list of class names should be returned rather than actual instances of the classes. These are the classes to which the association objects belong. The default value for this parameter is FALSE.
     * @param schemaOnly Boolean value that indicates whether or not the query applies to the schema rather than the data. The default value for this parameter is FALSE. It can only be set to TRUE if the strObjectPath parameter specifies the object path of a class. When set to TRUE, the set of returned endpoints represents classes that are suitably associated with the source class in the schema.
     * @param requiredQualifier String that contains a qualifier name. If specified, this parameter indicates that the returned association objects must include the specified qualifier.
     * @param flags
     *  Integer that specifies additional flags to the operation. The default for this parameter is wbemFlagReturnImmediately, which directs the call to return immediately rather than wait until the query has completed. This parameter can accept the following values.
     *
     *  <ul>
     *  <li>wbemFlagForwardOnly (32 (0x20))
     *  <br>Causes a forward-only enumerator to be returned. Forward-only enumerators are generally much faster and use less memory than conventional enumerators, but they do not allow calls to SWbemObject.Clone_.
     *
     *  <li>wbemFlagBidirectional (0 (0x0))
     *  <br>Causes Windows Management Instrumentation (WMI) to retain pointers to objects of the enumeration until the client releases the enumerator.
     *
     *  <li>wbemFlagReturnImmediately (16 (0x10))
     *  <br>Causes the call to return immediately.
     *
     *  <li>wbemFlagReturnWhenComplete (0 (0x0))
     *  <br>Causes this call to block until the query has completed. This flag calls the method in the synchronous mode.
     *
     *  <li>wbemFlagUseAmendedQualifiers (131072 (0x20000))
     *  <br>Causes WMI to return class amendment data along with the base class definition.
     *  </ul>
     * @param client клиент
     */
    @Override
    public void referencesTo(String objectPath, Optional<String> resultClass, Optional<String> role, Optional<Boolean> classesOnly, Optional<Boolean> schemaOnly, Optional<String> requiredQualifier, Optional<Integer> flags, Consumer<WmiObj> client) {
        target.referencesTo(objectPath, resultClass, role, classesOnly, schemaOnly, requiredQualifier, flags, client);
    }

    @Override
    public List<WmiObj> referencesTo(String objectPath, Optional<String> resultClass, Optional<String> role, Optional<Boolean> classesOnly, Optional<Boolean> schemaOnly, Optional<String> requiredQualifier, Optional<Integer> flags) {
        return target.referencesTo(objectPath, resultClass, role, classesOnly, schemaOnly, requiredQualifier, flags);
    }

    @Override
    public void referencesTo(String objectPath, String resultClass, String role, boolean classesOnly, boolean schemaOnly, String requiredQualifier, int flags, Consumer<WmiObj> client) {
        target.referencesTo(objectPath, resultClass, role, classesOnly, schemaOnly, requiredQualifier, flags, client);
    }

    @Override
    public List<WmiObj> referencesTo(String objectPath, String resultClass, String role, boolean classesOnly, boolean schemaOnly, String requiredQualifier, int flags) {
        return target.referencesTo(objectPath, resultClass, role, classesOnly, schemaOnly, requiredQualifier, flags);
    }

    @Override
    public void referencesTo(String objectPath, String resultClass, String role, boolean classesOnly, boolean schemaOnly, String requiredQualifier, Consumer<WmiObj> client) {
        target.referencesTo(objectPath, resultClass, role, classesOnly, schemaOnly, requiredQualifier, client);
    }

    @Override
    public List<WmiObj> referencesTo(String objectPath, String resultClass, String role, boolean classesOnly, boolean schemaOnly, String requiredQualifier) {
        return target.referencesTo(objectPath, resultClass, role, classesOnly, schemaOnly, requiredQualifier);
    }

    @Override
    public void referencesTo(String objectPath, String resultClass, String role, boolean classesOnly, boolean schemaOnly, Consumer<WmiObj> client) {
        target.referencesTo(objectPath, resultClass, role, classesOnly, schemaOnly, client);
    }

    @Override
    public List<WmiObj> referencesTo(String objectPath, String resultClass, String role, boolean classesOnly, boolean schemaOnly) {
        return target.referencesTo(objectPath, resultClass, role, classesOnly, schemaOnly);
    }

    @Override
    public void referencesTo(String objectPath, String resultClass, String role, boolean classesOnly, Consumer<WmiObj> client) {
        target.referencesTo(objectPath, resultClass, role, classesOnly, client);
    }

    @Override
    public List<WmiObj> referencesTo(String objectPath, String resultClass, String role, boolean classesOnly) {
        return target.referencesTo(objectPath, resultClass, role, classesOnly);
    }

    @Override
    public void referencesTo(String objectPath, String resultClass, String role, Consumer<WmiObj> client) {
        target.referencesTo(objectPath, resultClass, role, client);
    }

    @Override
    public List<WmiObj> referencesTo(String objectPath, String resultClass, String role) {
        return target.referencesTo(objectPath, resultClass, role);
    }

    @Override
    public void referencesTo(String objectPath, String resultClass, Consumer<WmiObj> client) {
        target.referencesTo(objectPath, resultClass, client);
    }

    @Override
    public List<WmiObj> referencesTo(String objectPath, String resultClass) {
        return target.referencesTo(objectPath, resultClass);
    }

    @Override
    public void referencesTo(String objectPath, Consumer<WmiObj> client) {
        target.referencesTo(objectPath, client);
    }

    @Override
    public List<WmiObj> referencesTo(String objectPath) {
        return target.referencesTo(objectPath);
    }

    /**
     * The Delete method of the SWbemServices object deletes the class or instance that is specified in the object path. You can only delete objects in the current namespace.
     * If a dynamic provider supplies the class or instance, you cannot delete this object unless the provider supports class or instance deletion.
     * @param objectPath Required. String that contains the object path to the object that you want to delete
     */
    @Override
    public void delete(String objectPath) {
        target.delete(objectPath);
    }
}
