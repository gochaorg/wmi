package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_OperatingSystemQFEImpl extends WmiObjImpl implements Win32_OperatingSystemQFE {
  public Win32_OperatingSystemQFEImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_OperatingSystemQFEImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_OperatingSystemQFEImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_OperatingSystemQFEImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public java.util.Optional<Win32_OperatingSystem> getAntecedent(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    
    Variant v = ax.getProperty("Antecedent");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    if( v.getvt()==8 && wmi!=null ){
      String path = v.getString();
      WmiObj obj = wmi.getObject(path);
      Win32_OperatingSystem impl =  new Win32_OperatingSystemImpl(obj.getActiveXComponent(),wmi);
      return java.util.Optional.of(impl);
    }
    
    Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;
    ActiveXComponent a = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;
    java.util.Optional<Win32_OperatingSystem> r = a!=null ? java.util.Optional.of( new Win32_OperatingSystemImpl(a) ) : java.util.Optional.empty();
    return r;
  }
  
  public java.util.Optional<Win32_QuickFixEngineering> getDependent(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    
    Variant v = ax.getProperty("Dependent");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    if( v.getvt()==8 && wmi!=null ){
      String path = v.getString();
      WmiObj obj = wmi.getObject(path);
      Win32_QuickFixEngineering impl =  new Win32_QuickFixEngineeringImpl(obj.getActiveXComponent(),wmi);
      return java.util.Optional.of(impl);
    }
    
    Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;
    ActiveXComponent a = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;
    java.util.Optional<Win32_QuickFixEngineering> r = a!=null ? java.util.Optional.of( new Win32_QuickFixEngineeringImpl(a) ) : java.util.Optional.empty();
    return r;
  }
  
}
