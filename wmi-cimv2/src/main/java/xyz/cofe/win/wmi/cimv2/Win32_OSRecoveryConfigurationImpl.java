package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_OSRecoveryConfigurationImpl extends WmiObjImpl implements Win32_OSRecoveryConfiguration {
  public Win32_OSRecoveryConfigurationImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_OSRecoveryConfigurationImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_OSRecoveryConfigurationImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_OSRecoveryConfigurationImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public boolean getAutoReboot(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AutoReboot");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AutoReboot");
    return v.getBoolean();
  }
  
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getDebugFilePath(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DebugFilePath");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getDebugInfoType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DebugInfoType");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DebugInfoType");
    return v.getInt();
  }
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getExpandedDebugFilePath(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ExpandedDebugFilePath");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getExpandedMiniDumpDirectory(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ExpandedMiniDumpDirectory");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getKernelDumpOnly(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("KernelDumpOnly");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read KernelDumpOnly");
    return v.getBoolean();
  }
  
  public String getMiniDumpDirectory(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("MiniDumpDirectory");
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
  
  public boolean getOverwriteExistingDebugFile(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("OverwriteExistingDebugFile");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read OverwriteExistingDebugFile");
    return v.getBoolean();
  }
  
  public boolean getSendAdminAlert(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SendAdminAlert");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read SendAdminAlert");
    return v.getBoolean();
  }
  
  public String getSettingID(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SettingID");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getWriteDebugInfo(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("WriteDebugInfo");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read WriteDebugInfo");
    return v.getBoolean();
  }
  
  public boolean getWriteToSystemLog(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("WriteToSystemLog");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read WriteToSystemLog");
    return v.getBoolean();
  }
  
}
