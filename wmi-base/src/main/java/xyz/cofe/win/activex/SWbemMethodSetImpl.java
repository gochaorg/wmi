package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import xyz.cofe.win.wmi.WMI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SWbemMethodSetImpl implements SWbemMethodSet {
    protected List<SWbemMethod> methods;
    public SWbemMethodSetImpl(Iterable<? extends SWbemMethod> methods){
        if( methods==null )throw new IllegalArgumentException("methods==null");
        this.methods = new ArrayList<>();
    }

    public SWbemMethodSetImpl(ActiveXMethods ax, WMI wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initMethods(ax,wmi);
    }

    public SWbemMethodSetImpl(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initMethods(ax,null);
    }

    public SWbemMethodSetImpl(GetActiveXComponent ax, WMI wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initMethods(ActiveXMethods.of(ax.getActiveXComponent()),wmi);
    }

    public SWbemMethodSetImpl(GetActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initMethods(ActiveXMethods.of(ax.getActiveXComponent()),null);
    }

    private void initMethods(ActiveXMethods ax, WMI wmi) {
        methods = new ArrayList<>();
        Variant vMethods = ax.invoke("Methods_");
        Dispatch dMethods = vMethods!=null && !vMethods.isNull() ? vMethods.toDispatch() : null;
        EnumVariant enMethods = dMethods!=null && dMethods.m_pDispatch!=0 ? new EnumVariant(dMethods) : null;
        while( enMethods!=null && enMethods.hasMoreElements() ){
            Variant vMethod = enMethods.nextElement();
            Dispatch dMethod = vMethod!=null && !vMethod.isNull() ? vMethod.toDispatch() : null;
            ActiveXComponent axMethod = dMethod!=null && dMethod.m_pDispatch!=0 ?
                new ActiveXComponent(dMethod) : null;
            if( axMethod!=null ){

                SWbemMethodImpl meth = new SWbemMethodImpl(axMethod, wmi);
                methods.add(meth);
            }
        }
    }

    @Override
    public int getSize() {
        return methods.size();
    }

    @Override
    public SWbemMethod get(int idx) {
        return methods.get(idx);
    }

    @Override
    public Iterator<SWbemMethod> iterator() {
        return methods.iterator();
    }

    public static SWbemMethodSetImpl of( ActiveXMethods ax ){
        if( ax==null )throw new IllegalArgumentException("ax==null");

        List<SWbemMethod> methods = new ArrayList<>();
        Variant vMethods = ax.invoke("Methods_");
        Dispatch dMethods = vMethods!=null && !vMethods.isNull() ? vMethods.toDispatch() : null;
        EnumVariant enMethods = dMethods!=null && dMethods.m_pDispatch!=0 ? new EnumVariant(dMethods) : null;
        while( enMethods!=null && enMethods.hasMoreElements() ){
            Variant vMethod = enMethods.nextElement();
            Dispatch dMethod = vMethod!=null && !vMethod.isNull() ? vMethod.toDispatch() : null;
            ActiveXComponent axMethod = dMethod!=null && dMethod.m_pDispatch!=0 ?
                new ActiveXComponent(dMethod) : null;

        }

        SWbemMethodSetImpl methodSet = new SWbemMethodSetImpl(methods);
        return methodSet;
    }
}
