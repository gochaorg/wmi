package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_ServiceImpl extends WmiObjImpl implements Win32_Service {
  public Win32_ServiceImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_ServiceImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_ServiceImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_ServiceImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public boolean getAcceptPause(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AcceptPause");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AcceptPause");
    return v.getBoolean();
  }
  
  public boolean getAcceptStop(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AcceptStop");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AcceptStop");
    return v.getBoolean();
  }
  
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getCheckPoint(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CheckPoint");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read CheckPoint");
    return v.getInt();
  }
  
  public String getCreationClassName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CreationClassName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getDelayedAutoStart(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DelayedAutoStart");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DelayedAutoStart");
    return v.getBoolean();
  }
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getDesktopInteract(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DesktopInteract");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DesktopInteract");
    return v.getBoolean();
  }
  
  public String getDisplayName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DisplayName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getErrorControl(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ErrorControl");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getExitCode(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ExitCode");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ExitCode");
    return v.getInt();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InstallDate");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public String getName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Name");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getPathName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PathName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getProcessId(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ProcessId");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ProcessId");
    return v.getInt();
  }
  
  public int getServiceSpecificExitCode(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ServiceSpecificExitCode");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ServiceSpecificExitCode");
    return v.getInt();
  }
  
  public String getServiceType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ServiceType");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getStarted(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Started");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Started");
    return v.getBoolean();
  }
  
  public String getStartMode(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StartMode");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getStartName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StartName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getState(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("State");
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
  
  public String getSystemCreationClassName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemCreationClassName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getSystemName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getTagId(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("TagId");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read TagId");
    return v.getInt();
  }
  
  public int getWaitHint(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("WaitHint");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read WaitHint");
    return v.getInt();
  }
  
}
