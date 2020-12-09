package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_SystemTimeZoneImpl extends WmiObjImpl implements Win32_SystemTimeZone {
  public Win32_SystemTimeZoneImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_SystemTimeZoneImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_SystemTimeZoneImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_SystemTimeZoneImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public java.util.Optional<Win32_ComputerSystem> getElement(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    
    Variant v = ax.getProperty("Element");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    if( v.getvt()==8 && wmi!=null ){
      String path = v.getString();
      WmiObj obj = wmi.getObject(path);
      Win32_ComputerSystem impl =  new Win32_ComputerSystemImpl(obj.getActiveXComponent(),wmi);
      return java.util.Optional.of(impl);
    }
    
    Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;
    ActiveXComponent a = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;
    java.util.Optional<Win32_ComputerSystem> r = a!=null ? java.util.Optional.of( new Win32_ComputerSystemImpl(a) ) : java.util.Optional.empty();
    return r;
  }
  
  public java.util.Optional<Win32_TimeZone> getSetting(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    
    Variant v = ax.getProperty("Setting");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    if( v.getvt()==8 && wmi!=null ){
      String path = v.getString();
      WmiObj obj = wmi.getObject(path);
      Win32_TimeZone impl =  new Win32_TimeZoneImpl(obj.getActiveXComponent(),wmi);
      return java.util.Optional.of(impl);
    }
    
    Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;
    ActiveXComponent a = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;
    java.util.Optional<Win32_TimeZone> r = a!=null ? java.util.Optional.of( new Win32_TimeZoneImpl(a) ) : java.util.Optional.empty();
    return r;
  }
  
}
