package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_ShareToDirectoryImpl extends WmiObjImpl implements Win32_ShareToDirectory {
  public Win32_ShareToDirectoryImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_ShareToDirectoryImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_ShareToDirectoryImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_ShareToDirectoryImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public java.util.Optional<Win32_Share> getShare(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    
    Variant v = ax.getProperty("Share");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    if( v.getvt()==8 && wmi!=null ){
      String path = v.getString();
      WmiObj obj = wmi.getObject(path);
      Win32_Share impl =  new Win32_ShareImpl(obj.getActiveXComponent(),wmi);
      return java.util.Optional.of(impl);
    }
    
    Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;
    ActiveXComponent a = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;
    java.util.Optional<Win32_Share> r = a!=null ? java.util.Optional.of( new Win32_ShareImpl(a) ) : java.util.Optional.empty();
    return r;
  }
  
  public java.util.Optional<CIM_Directory> getSharedElement(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    
    Variant v = ax.getProperty("SharedElement");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    if( v.getvt()==8 && wmi!=null ){
      String path = v.getString();
      WmiObj obj = wmi.getObject(path);
      CIM_Directory impl =  new CIM_DirectoryImpl(obj.getActiveXComponent(),wmi);
      return java.util.Optional.of(impl);
    }
    
    Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;
    ActiveXComponent a = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;
    java.util.Optional<CIM_Directory> r = a!=null ? java.util.Optional.of( new CIM_DirectoryImpl(a) ) : java.util.Optional.empty();
    return r;
  }
  
}
