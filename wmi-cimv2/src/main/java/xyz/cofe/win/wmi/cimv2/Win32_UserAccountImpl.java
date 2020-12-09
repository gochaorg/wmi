package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_UserAccountImpl extends WmiObjImpl implements Win32_UserAccount {
  public Win32_UserAccountImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_UserAccountImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_UserAccountImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_UserAccountImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public int getAccountType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AccountType");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AccountType");
    return v.getInt();
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
  
  public boolean getDisabled(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Disabled");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Disabled");
    return v.getBoolean();
  }
  
  public String getDomain(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Domain");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getFullName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FullName");
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
  
  public boolean getLocalAccount(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("LocalAccount");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read LocalAccount");
    return v.getBoolean();
  }
  
  public boolean getLockout(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Lockout");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Lockout");
    return v.getBoolean();
  }
  
  public String getName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Name");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getPasswordChangeable(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PasswordChangeable");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PasswordChangeable");
    return v.getBoolean();
  }
  
  public boolean getPasswordExpires(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PasswordExpires");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PasswordExpires");
    return v.getBoolean();
  }
  
  public boolean getPasswordRequired(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PasswordRequired");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PasswordRequired");
    return v.getBoolean();
  }
  
  public String getSID(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SID");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public byte getSIDType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SIDType");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read SIDType");
    return v.getByte();
  }
  
  public String getStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Status");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
}
