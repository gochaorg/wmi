package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_UserAccount extends WmiObj {
  public int getAccountType();
  
  public String getCaption();
  
  public String getDescription();
  
  public boolean getDisabled();
  
  public String getDomain();
  
  public String getFullName();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public boolean getLocalAccount();
  
  public boolean getLockout();
  
  public String getName();
  
  public boolean getPasswordChangeable();
  
  public boolean getPasswordExpires();
  
  public boolean getPasswordRequired();
  
  public String getSID();
  
  public byte getSIDType();
  
  public String getStatus();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_UserAccount> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_UserAccount", obj -> client.accept(new Win32_UserAccountImpl(obj, wmi)) );
  }
  
  public static List<Win32_UserAccount> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_UserAccount> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
