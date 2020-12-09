package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_Account extends WmiObj {
  public String getCaption();
  
  public String getDescription();
  
  public String getDomain();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public boolean getLocalAccount();
  
  public String getName();
  
  public String getSID();
  
  public byte getSIDType();
  
  public String getStatus();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_Account> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_Account", obj -> client.accept(new Win32_AccountImpl(obj, wmi)) );
  }
  
  public static List<Win32_Account> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_Account> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
