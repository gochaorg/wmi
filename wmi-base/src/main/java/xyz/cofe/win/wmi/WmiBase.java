package xyz.cofe.win.wmi;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class WmiBase implements Wmi {
    protected ActiveXComponent activeXComponent;

    public WmiBase(ActiveXComponent activeXComponent){
        if( activeXComponent==null )throw new IllegalArgumentException("activeXComponent==null");
        this.activeXComponent = activeXComponent;
    }

    //region execQuery()
    @Override
    public void execQuery(String query, Consumer<WmiObj> wmiObjectConsumer) {
        if( query==null )throw new IllegalArgumentException("query==null");
        if( wmiObjectConsumer==null )throw new IllegalArgumentException("wmiObjectConsumer==null");

        ActiveXComponent ax1 = activeXComponent;
        if( ax1==null )throw new IllegalStateException("activeXComponent is null");

        // SWbemObjectSet
        Variant rset = ax1.invoke("ExecQuery",new Variant(query));
        each(rset,wmiObjectConsumer);
    }

    public void execQuery(
        String query,
        int flags,
        Consumer<WmiObj> wmiObjectConsumer
    ) {
        execQuery(query,Optional.empty(),Optional.of(flags),wmiObjectConsumer);
    }

    @SuppressWarnings({"OptionalAssignedToNull"})
    public void execQuery(
        String query,
        Optional<String> queryLanguage,
        Optional<Integer> flags,
        Consumer<WmiObj> wmiObjectConsumer
    ) {
        if( query==null )throw new IllegalArgumentException("query==null");
        if( queryLanguage==null )throw new IllegalArgumentException("queryLanguage==null");
        if( flags==null )throw new IllegalArgumentException("flags==null");
        if( wmiObjectConsumer==null )throw new IllegalArgumentException("wmiObjectConsumer==null");

        ActiveXComponent ax1 = activeXComponent;
        if( ax1==null )throw new IllegalStateException("activeXComponent is null");

        // SWbemObjectSet
        Variant rset = ax1.invoke(
            "ExecQuery",
            new Variant(query),
            queryLanguage.map(Variant::new).orElse(Variant.DEFAULT),
            flags.map(Variant::new).orElse(Variant.DEFAULT)
        );
        each(rset,wmiObjectConsumer);
    }
    //endregion

    @Override
    public WmiObj getObject(String path) {
        if( path==null )throw new IllegalArgumentException("path==null");

        ActiveXComponent ax1 = activeXComponent;
        if( ax1==null )throw new IllegalStateException("activeXComponent is null");

        Variant v = ax1.invoke("Get", new Variant(path));
        if( v==null || v.isNull() )return null;

        ActiveXComponent ax = new ActiveXComponent(v.toDispatch());

        return new WmiObjImpl(ax,this);
    }

    //region subclassesOf()
    @Override
    public List<WmiObj> subclassesOf() {
        ArrayList<WmiObj> list = new ArrayList<>();
        subclassesOf(
            Optional.empty(),
            Optional.empty(),
            list::add
        );
        return list;
    }

    @Override
    public void subclassesOf(Consumer<WmiObj> consumer) {
        if( consumer==null )throw new IllegalArgumentException("consumer==null");
        subclassesOf(Optional.empty(),Optional.empty(),consumer);
    }

    @Override
    public List<WmiObj> subclassesOf(String superclass) {
        if( superclass==null )throw new IllegalArgumentException("superclass==null");
        ArrayList<WmiObj> list = new ArrayList<>();
        subclassesOf(
            Optional.of(superclass),
            Optional.empty(),
            list::add
        );
        return list;
    }

    @Override
    public void subclassesOf(String superclass, Consumer<WmiObj> consumer) {
        if( superclass==null )throw new IllegalArgumentException("superclass==null");
        if( consumer==null )throw new IllegalArgumentException("consumer==null");
        subclassesOf(Optional.of(superclass),Optional.empty(),consumer);
    }

    @Override
    public List<WmiObj> subclassesOf(String superclass, int flags) {
        if( superclass==null )throw new IllegalArgumentException("superclass==null");
        ArrayList<WmiObj> list = new ArrayList<>();
        subclassesOf(
            Optional.of(superclass),
            Optional.of(flags),
            list::add
        );
        return list;
    }

    @Override
    public void subclassesOf(String superclass, int flags, Consumer<WmiObj> consumer) {
        if( superclass==null )throw new IllegalArgumentException("superclass==null");
        if( consumer==null )throw new IllegalArgumentException("consumer==null");
        subclassesOf(Optional.of(superclass),Optional.of(flags),consumer);
    }

    @SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "OptionalAssignedToNull"})
    protected void subclassesOf(Optional<String> superclass, Optional<Integer> flags, Consumer<WmiObj> consumer) {
        if( superclass==null )throw new IllegalArgumentException("superclass==null");
        if( consumer==null )throw new IllegalArgumentException("consumer==null");
        if( flags==null )throw new IllegalArgumentException("flags==null");

        ActiveXComponent ax = activeXComponent;
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        Variant vRes = null;

        if( flags.isPresent() && superclass.isPresent() ){
            vRes = ax.invoke("SubclassesOf",
                new Variant(superclass.get()), new Variant(flags.get().intValue()));
        }else if( superclass.isPresent() ){
            vRes = ax.invoke("SubclassesOf",
                new Variant(superclass.get()));
        }else{
            vRes = ax.invoke("SubclassesOf");
        }

        each(vRes, consumer);
    }
    //endregion

    private void each(Variant wmiCollection, Consumer<WmiObj> consumer) {
        Dispatch dRes = wmiCollection !=null && !wmiCollection.isNull() ?
            wmiCollection.toDispatch() : null;
        EnumVariant enRes = dRes!=null && dRes.m_pDispatch!=0 ?
            new EnumVariant(dRes) : null;
        while( enRes!=null && enRes.hasMoreElements() ){
            Variant veRes = enRes.nextElement();
            Dispatch deRes = veRes!=null && !veRes.isNull() ?
                veRes.toDispatch() : null;
            ActiveXComponent axRes = deRes!=null && deRes.m_pDispatch!=0 ?
                new ActiveXComponent(deRes) : null;
            WmiObjImpl wObj = axRes!=null ?
                new WmiObjImpl(axRes) : null;
            if( wObj!=null ){
                consumer.accept(wObj);
            }
        }
    }

    //region associatorsOf()
    public void associatorsOf(
        String objectPath,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , client
        );
    }

    public void associatorsOf(
        String objectPath,
        String assocClass,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , client
        );
    }

    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.of(resultClass)
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , client
        );
    }

    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.of(resultClass)
            , Optional.of(resultRole)
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , client
        );
    }

    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.of(resultClass)
            , Optional.of(resultRole)
            , Optional.of(role)
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , client
        );
    }

    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.of(resultClass)
            , Optional.of(resultRole)
            , Optional.of(role)
            , Optional.of(classesOnly)
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , client
        );
    }

    public void associatorsOf(
        String objectPath,
        String assocClass,
        String resultClass,
        String resultRole,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.of(resultClass)
            , Optional.of(resultRole)
            , Optional.of(role)
            , Optional.of(classesOnly)
            , Optional.of(schemaOnly)
            , Optional.empty()
            , Optional.empty()
            , Optional.empty()
            , client
        );
    }

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
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredAssocQualifier==null )throw new IllegalArgumentException("requiredAssocQualifier==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.of(resultClass)
            , Optional.of(resultRole)
            , Optional.of(role)
            , Optional.of(classesOnly)
            , Optional.of(schemaOnly)
            , Optional.of(requiredAssocQualifier)
            , Optional.empty()
            , Optional.empty(),
            client
        );
    }

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
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredAssocQualifier==null )throw new IllegalArgumentException("requiredAssocQualifier==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.of(resultClass)
            , Optional.of(resultRole)
            , Optional.of(role)
            , Optional.of(classesOnly)
            , Optional.of(schemaOnly)
            , Optional.of(requiredAssocQualifier)
            , Optional.of(requiredQualifier)
            , Optional.empty(),
            client
        );
    }

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
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( assocClass==null )throw new IllegalArgumentException("assocClass==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( resultRole==null )throw new IllegalArgumentException("resultRole==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredAssocQualifier==null )throw new IllegalArgumentException("requiredAssocQualifier==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        associatorsOf(
            objectPath
            , Optional.of(assocClass)
            , Optional.of(resultClass)
            , Optional.of(resultRole)
            , Optional.of(role)
            , Optional.of(classesOnly)
            , Optional.of(schemaOnly)
            , Optional.of(requiredAssocQualifier)
            , Optional.of(requiredQualifier)
            , Optional.of(flags),
            client
        );
    }

    @SuppressWarnings("OptionalAssignedToNull")
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
    ){
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
        if( client==null )throw new IllegalArgumentException("client==null");

        ActiveXComponent ax = activeXComponent;
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        Variant v = ax.invoke("AssociatorsOf",
            new Variant(objectPath),
            assocClass.map(Variant::new).orElse(Variant.DEFAULT),
            resultClass.map(Variant::new).orElse(Variant.DEFAULT),
            resultRole.map(Variant::new).orElse(Variant.DEFAULT),
            role.map(Variant::new).orElse(Variant.DEFAULT),
            classesOnly.map(Variant::new).orElse(Variant.DEFAULT),
            schemaOnly.map(Variant::new).orElse(Variant.DEFAULT),
            requiredAssocQualifier.map(Variant::new).orElse(Variant.DEFAULT),
            requiredQualifier.map(Variant::new).orElse(Variant.DEFAULT),
            flags.map(Variant::new).orElse(Variant.DEFAULT)
        );
        each(v,client);
    }
    //endregion

    //region instanceOf()
    /**
     * возвращает экземпляры указанного класса в соответствии с заданными пользователем критериями выбора
     * @param clazz Строка, содержащая имя класса, для которого требуются экземпляры
     * @param client клиент
     */
    public void instancesOf( String clazz, Consumer<WmiObj> client ){
        if( clazz==null )throw new IllegalArgumentException("clazz==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        instancesOf(clazz, Optional.empty(), client);
    }

    /**
     * возвращает экземпляры указанного класса в соответствии с заданными пользователем критериями выбора
     * @param clazz Строка, содержащая имя класса, для которого требуются экземпляры
     * @param flags флаги
     * @param client клиент
     */
    public void instancesOf( String clazz, int flags, Consumer<WmiObj> client ){
        if( clazz==null )throw new IllegalArgumentException("clazz==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        instancesOf(clazz, Optional.of(flags), client);
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
    @SuppressWarnings({"OptionalAssignedToNull"})
    public void instancesOf(
        String clazz,
        Optional<Integer> flags,
        Consumer<WmiObj> client
    ){
        if( clazz==null )throw new IllegalArgumentException("clazz==null");
        if( flags==null )throw new IllegalArgumentException("flags==null");
        if( client==null )throw new IllegalArgumentException("client==null");

        ActiveXComponent ax = activeXComponent;
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        Variant v = ax.invoke("InstancesOf",
            new Variant(clazz),
            flags.map(Variant::new).orElse(Variant.DEFAULT)
        );
        each(v,client);
    }
    //endregion

    //region referencesTo()
    /**
     * The ReferencesTo method of the SWbemServices object returns a collection
     * of all association classes or instances that refer to a specific source class or instance.
     *
     * This method performs the same function that the REFERENCES OF WQL query performs.
     *
     * @param objectPath Required. String that contains the object path of the source for this method. For more information
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
    @SuppressWarnings({"OptionalAssignedToNull"})
    public void referencesTo(
        String objectPath,
        Optional<String> resultClass,
        Optional<String> role,
        Optional<Boolean> classesOnly,
        Optional<Boolean> schemaOnly,
        Optional<String> requiredQualifier,
        Optional<Integer> flags,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( classesOnly==null )throw new IllegalArgumentException("classesOnly==null");
        if( schemaOnly==null )throw new IllegalArgumentException("schemaOnly==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        if( flags==null )throw new IllegalArgumentException("flags==null");
        if( client==null )throw new IllegalArgumentException("client==null");

        ActiveXComponent ax = activeXComponent;
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        Variant v = ax.invoke("ReferencesTo",
            new Variant(objectPath),
            resultClass.map(Variant::new).orElse(Variant.DEFAULT),
            role.map(Variant::new).orElse(Variant.DEFAULT),
            classesOnly.map(Variant::new).orElse(Variant.DEFAULT),
            schemaOnly.map(Variant::new).orElse(Variant.DEFAULT),
            requiredQualifier.map(Variant::new).orElse(Variant.DEFAULT),
            flags.map(Variant::new).orElse(Variant.DEFAULT)
        );
        each(v,client);
    }

    /**
     * Метод ReferencesTo объекта SWbemServices возвращает коллекцию
     * всех классов или экземпляров ассоциации, которые относятся к конкретному исходному классу или экземпляру.
     *
     * @param objectPath wmi путь
     * @param resultClass
     *      Строка, содержащая имя класса. Если указан, этот параметр указывает, что возвращаемые объекты ассоциации должны принадлежать или быть производными от класса, указанного в этом параметре.
     * @param role
     *      Строка, содержащая имя свойства. Если указан, этот параметр указывает, что возвращаемые объекты ассоциации должны быть ограничены теми, в которых исходный объект играет определенную роль. Роль определяется именем указанного свойства (которое должно быть ссылочным свойством) ассоциации.
     * @param classesOnly
     *      Логическое значение, указывающее, следует ли возвращать список имен классов, а не фактические экземпляры классов. Это классы, к которым принадлежат объекты ассоциации. Значение по умолчанию для этого параметра - ЛОЖЬ.
     * @param schemaOnly
     *      Логическое значение, указывающее, применяется ли запрос к схеме, а не к данным. Значение по умолчанию для этого параметра - ЛОЖЬ. Его можно установить в значение TRUE, только если параметр strObjectPath указывает путь к объекту класса. Если установлено значение TRUE, набор возвращаемых конечных точек представляет классы, которые соответствующим образом связаны с исходным классом в схеме.
     * @param requiredQualifier
     *      Строка, содержащая имя квалификатора. Если указан, этот параметр указывает, что возвращаемые объекты ассоциации должны включать указанный квалификатор.
     * @param flags
     *      Целое число, определяющее дополнительные флаги операции. Значение по умолчанию для этого параметра - wbemFlagReturnImmediately, который указывает вызову на немедленный возврат, а не на ожидание завершения запроса. Этот параметр может принимать следующие значения.
     * @return выборка
     */
    @SuppressWarnings({"OptionalAssignedToNull"})
    public List<WmiObj> referencesTo(
        String objectPath,
        Optional<String> resultClass,
        Optional<String> role,
        Optional<Boolean> classesOnly,
        Optional<Boolean> schemaOnly,
        Optional<String> requiredQualifier,
        Optional<Integer> flags
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( classesOnly==null )throw new IllegalArgumentException("classesOnly==null");
        if( schemaOnly==null )throw new IllegalArgumentException("schemaOnly==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        if( flags==null )throw new IllegalArgumentException("flags==null");

        ArrayList<WmiObj> list = new ArrayList<>();
        referencesTo(objectPath,resultClass,role,classesOnly,schemaOnly,requiredQualifier,flags,list::add);
        return list;
    }

    public void referencesTo(
        String objectPath,
        String resultClass,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredQualifier,
        int flags,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.of(classesOnly),
            Optional.of(schemaOnly),
            Optional.of(requiredQualifier),
            Optional.of(flags),
            client
        );
    }

    public List<WmiObj> referencesTo(
        String objectPath,
        String resultClass,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredQualifier,
        int flags
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        return referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.of(classesOnly),
            Optional.of(schemaOnly),
            Optional.of(requiredQualifier),
            Optional.of(flags)
        );
    }

    public void referencesTo(
        String objectPath,
        String resultClass,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredQualifier,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.of(classesOnly),
            Optional.of(schemaOnly),
            Optional.of(requiredQualifier),
            Optional.empty(),
            client
        );
    }

    public List<WmiObj> referencesTo(
        String objectPath,
        String resultClass,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        String requiredQualifier
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( requiredQualifier==null )throw new IllegalArgumentException("requiredQualifier==null");
        return referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.of(classesOnly),
            Optional.of(schemaOnly),
            Optional.of(requiredQualifier),
            Optional.empty()
        );
    }

    public void referencesTo(
        String objectPath,
        String resultClass,
        String role,
        boolean classesOnly,
        boolean schemaOnly,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.of(classesOnly),
            Optional.of(schemaOnly),
            Optional.empty(),
            Optional.empty(),
            client
        );
    }

    public List<WmiObj> referencesTo(
        String objectPath,
        String resultClass,
        String role,
        boolean classesOnly,
        boolean schemaOnly
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        return referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.of(classesOnly),
            Optional.of(schemaOnly),
            Optional.empty(),
            Optional.empty()
        );
    }

    public void referencesTo(
        String objectPath,
        String resultClass,
        String role,
        boolean classesOnly,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.of(classesOnly),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            client
        );
    }

    public List<WmiObj> referencesTo(
        String objectPath,
        String resultClass,
        String role,
        boolean classesOnly
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        return referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.of(classesOnly),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
        );
    }

    public void referencesTo(
        String objectPath,
        String resultClass,
        String role,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            client
        );
    }

    public List<WmiObj> referencesTo(
        String objectPath,
        String resultClass,
        String role
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( role==null )throw new IllegalArgumentException("role==null");
        return referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.of(role),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
        );
    }

    public void referencesTo(
        String objectPath,
        String resultClass,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            client
        );
    }

    public List<WmiObj> referencesTo(
        String objectPath,
        String resultClass
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( resultClass==null )throw new IllegalArgumentException("resultClass==null");
        return referencesTo(
            objectPath,
            Optional.of(resultClass),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
        );
    }

    public void referencesTo(
        String objectPath,
        Consumer<WmiObj> client
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        referencesTo(
            objectPath,
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            client
        );
    }

    public List<WmiObj> referencesTo(
        String objectPath
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");
        return referencesTo(
            objectPath,
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
        );
    }
    //endregion

    public void delete(
        String objectPath
    ){
        if( objectPath==null )throw new IllegalArgumentException("objectPath==null");

        ActiveXComponent ax = activeXComponent;
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        ax.invoke("Delete",
            new Variant(objectPath)
        );
    }
}
