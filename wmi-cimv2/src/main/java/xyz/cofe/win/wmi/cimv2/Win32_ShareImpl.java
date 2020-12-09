package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_ShareImpl extends WmiObjImpl implements Win32_Share {
  public Win32_ShareImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_ShareImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_ShareImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_ShareImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public int getAccessMask(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AccessMask");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AccessMask");
    return v.getInt();
  }
  
  public boolean getAllowMaximum(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AllowMaximum");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AllowMaximum");
    return v.getBoolean();
  }
  
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InstallDate");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public int getMaximumAllowed(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("MaximumAllowed");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read MaximumAllowed");
    return v.getInt();
  }
  
  public String getName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Name");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getPath(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Path");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Status");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Type");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Type");
    return v.getInt();
  }
  
}
