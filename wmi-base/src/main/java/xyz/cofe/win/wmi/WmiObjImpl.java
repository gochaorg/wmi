package xyz.cofe.win.wmi;

import com.jacob.activeX.ActiveXComponent;
import xyz.cofe.win.activex.*;

public class WmiObjImpl implements WmiObj {
    protected ActiveXComponent activeXComponent;
    protected Wmi wmi;

    public WmiObjImpl(ActiveXComponent activeXComponent){
        if( activeXComponent==null )throw new IllegalArgumentException("activeXComponent==null");
        this.activeXComponent = activeXComponent;
    }

    public WmiObjImpl(ActiveXComponent activeXComponent, Wmi wmi){
        if( activeXComponent==null )throw new IllegalArgumentException("activeXComponent==null");
        this.activeXComponent = activeXComponent;
        this.wmi = wmi;
    }

    @Override
    public ActiveXComponent getActiveXComponent() {
        return activeXComponent;
    }

    @Override
    public SWbemPropertySet getWmiProperties() {
        return new SWbemPropertySetImpl(this,wmi);
    }

    @Override
    public SWbemMethodSet getWmiMethods() {
        return new SWbemMethodSetImpl(this,wmi);
    }
}
