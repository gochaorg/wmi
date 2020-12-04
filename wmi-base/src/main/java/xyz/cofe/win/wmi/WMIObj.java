package xyz.cofe.win.wmi;

import xyz.cofe.win.activex.*;

/**
 * https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemobject
 */
public interface WMIObj extends GetActiveXComponent {
    public default SWbemPropertySet getWmiProperties(){
        return new SWbemPropertySetImpl(this);
    }
    public default SWbemObjectPath getWmiPath(){
        return new SWbemObjectPathImpl(this);
    }
    public default SWbemMethodSet getWmiMethods(){
        return new SWbemMethodSetImpl(this);
    }
}
