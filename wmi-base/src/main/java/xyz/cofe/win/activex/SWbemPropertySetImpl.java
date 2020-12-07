package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import xyz.cofe.win.wmi.Wmi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SWbemPropertySetImpl implements SWbemPropertySet {
    protected List<SWbemProperty> propertyList;

    public SWbemPropertySetImpl(){
        propertyList = new ArrayList<>();
    }
    public SWbemPropertySetImpl(SWbemPropertySetImpl sample){
        if( sample==null )throw new IllegalArgumentException("sample==null");
        propertyList = new ArrayList<>();
        propertyList.addAll(sample.propertyList);
    }

    public SWbemPropertySetImpl(ActiveXMethods ax, Wmi wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ax, wmi);
    }

    public SWbemPropertySetImpl(ActiveXMethods ax){
        this(ax,null);
    }

    public SWbemPropertySetImpl(GetActiveXComponent ax, Wmi wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax.getActiveXComponent()), wmi);
    }

    public SWbemPropertySetImpl(GetActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax.getActiveXComponent()), null);
    }

    public SWbemPropertySetImpl(Iterable<? extends SWbemProperty> props){
        if( props==null )throw new IllegalArgumentException("props==null");
        propertyList = new ArrayList<>();
        props.forEach(propertyList::add);
    }

    private void initProps(ActiveXMethods ax, Wmi wmi) {
        propertyList = new ArrayList<>();
        EnumVariant en = new EnumVariant(ax.invoke("Properties_").toDispatch());
        while( en.hasMoreElements() ){
            Variant v = en.nextElement();
            if( v==null || v.isNull() ){
                continue;
            }
            propertyList.add(
                new SWbemPropertyImpl(
                    ActiveXMethods.of(
                        new ActiveXComponent(v.toDispatch())
                    ),
                    wmi
                )
            );
        }
    }

    @Override
    public Iterator<SWbemProperty> iterator() {
        return propertyList.iterator();
    }

    @Override
    public int getSize() {
        return propertyList.size();
    }

    @Override
    public SWbemProperty get(int idx) {
        return propertyList.get(idx);
    }

    @Override
    public SWbemPropertySet clear() {
        return new SWbemPropertySetImpl();
    }

    @Override
    public SWbemPropertySet append(Iterable<? extends SWbemProperty> items) {
        if( items==null )throw new IllegalArgumentException("items==null");
        SWbemPropertySetImpl clone = new SWbemPropertySetImpl(this);
        items.forEach(clone.propertyList::add);
        return clone;
    }
}
