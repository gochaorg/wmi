package xyz.cofe.win.wmi;

import xyz.cofe.win.activex.*;

import java.util.List;

/**
 * https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemobject
 */
public interface WmiObj extends GetActiveXComponent, GetWmiQualifiers {
    public default SWbemPropertySet getWmiProperties(){
        return new SWbemPropertySetImpl(this);
    }
    public default SWbemObjectPath getWmiPath(){
        return new SWbemObjectPathImpl(this);
    }
    public default SWbemMethodSet getWmiMethods(){
        return new SWbemMethodSetImpl(this);
    }
    public default List<WmiDerivation> getWmiDerivation(){ return WmiDerivation.of(this); }
    public default SWbemQualifierSet getWmiQualifiers(){ return new SWbemQualifierSetImpl(this); }
    public default SWbemSecurity getWmiSecurity(){
        return SWbemSecurityImpl.fromOwner(this);
    }
}
