package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SWbemQualifierSetImpl implements SWbemQualifierSet {
    protected List<SWbemQualifier> qualifierList = new ArrayList<>();

    public SWbemQualifierSetImpl(){
    }

    public SWbemQualifierSetImpl(SWbemQualifierSetImpl sample){
        if( sample==null )throw new IllegalArgumentException("sample==null");
        qualifierList.addAll(sample.qualifierList);
    }

    public SWbemQualifierSetImpl(Iterable<? extends SWbemQualifier> qualifiers){
        if( qualifiers==null )throw new IllegalArgumentException("qualifiers==null");
        qualifiers.forEach(qualifierList::add);
    }

    public SWbemQualifierSetImpl(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        init(ax);
    }

    public SWbemQualifierSetImpl(ActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        init(ActiveXMethods.of(ax));
    }

    public SWbemQualifierSetImpl(GetActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        init(ActiveXMethods.of(ax.getActiveXComponent()));
    }

    protected void init(ActiveXMethods ax){
        Variant vQualifiers = ax.getProperty("Qualifiers_");
        Dispatch dQualifiers = vQualifiers!=null && !vQualifiers.isNull() ?
            vQualifiers.toDispatch() : null;
        EnumVariant enQualifiers = dQualifiers!=null && dQualifiers.m_pDispatch!=0 ?
            new EnumVariant(dQualifiers) : null;
        while( enQualifiers!=null && enQualifiers.hasMoreElements() ){
            Variant vQual = enQualifiers.nextElement();
            Dispatch dQual = vQual!=null && !vQual.isNull() ?
                vQual.toDispatch() : null;
            ActiveXComponent axQual = dQual!=null && dQual.m_pDispatch!=0 ?
                new ActiveXComponent(dQual) : null;
            if( axQual!=null ){
                qualifierList.add(new SWbemQualifierImpl(axQual));
            }
        }
    }

    @Override
    public SWbemQualifierSet clear() {
        return new SWbemQualifierSetImpl();
    }

    @Override
    public SWbemQualifierSet append(Iterable<? extends SWbemQualifier> item) {
        SWbemQualifierSetImpl clone = new SWbemQualifierSetImpl(this);
        item.forEach(i->clone.qualifierList.add(i));
        return clone;
    }

    @Override
    public int getSize() {
        return qualifierList.size();
    }

    @Override
    public SWbemQualifier get(int idx) {
        return qualifierList.get(idx);
    }

    @Override
    public Iterator<SWbemQualifier> iterator() {
        return qualifierList.iterator();
    }
}
