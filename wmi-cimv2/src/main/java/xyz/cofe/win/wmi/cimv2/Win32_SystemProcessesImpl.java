package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_SystemProcessesImpl extends WmiObjImpl implements Win32_SystemProcesses {
  public Win32_SystemProcessesImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_SystemProcessesImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_SystemProcessesImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_SystemProcessesImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public java.util.Optional<Win32_ComputerSystem> getGroupComponent(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    
    Variant v = ax.getProperty("GroupComponent");
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
  
  public java.util.Optional<Win32_Process> getPartComponent(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    
    Variant v = ax.getProperty("PartComponent");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    if( v.getvt()==8 && wmi!=null ){
      String path = v.getString();
      WmiObj obj = wmi.getObject(path);
      Win32_Process impl =  new Win32_ProcessImpl(obj.getActiveXComponent(),wmi);
      return java.util.Optional.of(impl);
    }
    
    Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;
    ActiveXComponent a = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;
    java.util.Optional<Win32_Process> r = a!=null ? java.util.Optional.of( new Win32_ProcessImpl(a) ) : java.util.Optional.empty();
    return r;
  }
  
}
