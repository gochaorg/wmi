package xyz.cofe.win.wmi;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import xyz.cofe.win.wmi.WMI;

import java.util.function.Consumer;

public class WMIBase implements WMI {
    protected volatile ActiveXComponent activeXComponent;

    public WMIBase(ActiveXComponent activeXComponent){
        if( activeXComponent==null )throw new IllegalArgumentException("activeXComponent==null");
        this.activeXComponent = activeXComponent;
    }

    @Override
    public void execQuery(String query, Consumer<WMIObj> wmiObjectConsumer) {
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
                wmiObjectConsumer.accept(new WMIObjImpl(xvIt,this));
            }
        }
    }

    @Override
    public WMIObj getObject(String path) {
        if( path==null )throw new IllegalArgumentException("path==null");

        ActiveXComponent ax1 = activeXComponent;
        if( ax1==null )throw new IllegalStateException("activeXComponent is null");

        Variant v = ax1.invoke("Get", new Variant(path));
        if( v==null || v.isNull() )return null;

        ActiveXComponent ax = new ActiveXComponent(v.toDispatch());

        return new WMIObjImpl(ax,this);
    }
}
