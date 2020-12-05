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

        Dispatch dRes = vRes!=null && !vRes.isNull() ?
            vRes.toDispatch() : null;
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
}
