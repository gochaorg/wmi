package xyz.cofe.win.activex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SWbemPrivilegeSetImpl implements SWbemPrivilegeSet {
    protected List<SWbemPrivilege> list = new ArrayList<>();

    public SWbemPrivilegeSetImpl(){
    }

    public SWbemPrivilegeSetImpl(SWbemPrivilegeSetImpl sample){
        if( sample==null )throw new IllegalArgumentException("sample==null");
        list.addAll(sample.list);
    }

    public SWbemPrivilegeSetImpl(Iterable<? extends SWbemPrivilege> privs){
        if( privs==null )throw new IllegalArgumentException("privs==null");
        privs.forEach(list::add);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public SWbemPrivilege get(int idx) {
        return list.get(idx);
    }

    @Override
    public Iterator<SWbemPrivilege> iterator() {
        return list.iterator();
    }

    @Override
    public SWbemPrivilegeSet clear() {
        return new SWbemPrivilegeSetImpl();
    }

    @Override
    public SWbemPrivilegeSet append(Iterable<? extends SWbemPrivilege> items) {
        if( items==null )throw new IllegalArgumentException("items==null");
        SWbemPrivilegeSetImpl clone = new SWbemPrivilegeSetImpl(this);
        items.forEach(i->clone.list.add(i));
        return clone;
    }
}
