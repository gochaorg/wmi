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

    @Override
    public void execQuery(String query, Consumer<WmiObj> wmiObjectConsumer) {
        if( query==null )throw new IllegalArgumentException("query==null");
        if( wmiObjectConsumer==null )throw new IllegalArgumentException("wmiObjectConsumer==null");

        ActiveXComponent ax1 = activeXComponent;
        if( ax1==null )throw new IllegalStateException("activeXComponent is null");

        // SWbemObjectSet
        Variant rset = ax1.invoke("ExecQuery",new Variant(query));

        EnumVariant enumVariant = new EnumVariant(rset.toDispatch());
        while( enumVariant.hasMoreElements() ){
            Variant vIt = enumVariant.nextElement();
            if( vIt==null || vIt.isNull() ){
                wmiObjectConsumer.accept(null);
            }else{
                ActiveXComponent xvIt = new ActiveXComponent(vIt.toDispatch());
                wmiObjectConsumer.accept(new WmiObjImpl(xvIt,this));
            }
        }
    }

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

    public void instancesOf(
        Consumer<WmiObj> client
    ){

    }
}
