package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_QuickFixEngineeringImpl extends WmiObjImpl implements Win32_QuickFixEngineering {
  public Win32_QuickFixEngineeringImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_QuickFixEngineeringImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_QuickFixEngineeringImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_QuickFixEngineeringImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getCSName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CSName");
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
  
  public String getFixComments(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FixComments");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getHotFixID(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("HotFixID");
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
  
  public String getInstalledBy(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InstalledBy");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getInstalledOn(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InstalledOn");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Name");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getServicePackInEffect(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ServicePackInEffect");
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
  
}
