package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_SystemAccount extends WmiObj {
  public String getCaption();
  
  public String getDescription();
  
  public String getDomain();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public boolean getLocalAccount();
  
  public String getName();
  
  public String getSID();
  
  public byte getSIDType();
  
  public String getStatus();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_SystemAccount> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_SystemAccount", obj -> client.accept(new Win32_SystemAccountImpl(obj, wmi)) );
  }
  
  public static List<Win32_SystemAccount> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_SystemAccount> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
