package xyz.cofe.win.wmi;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import xyz.cofe.win.activex.*;

public class WMIObjImpl implements WMIObj {
    protected ActiveXComponent activeXComponent;
    protected WMI wmi;

    public WMIObjImpl(ActiveXComponent activeXComponent){
        if( activeXComponent==null )throw new IllegalArgumentException("activeXComponent==null");
        this.activeXComponent = activeXComponent;
    }

    public WMIObjImpl(ActiveXComponent activeXComponent, WMI wmi){
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
