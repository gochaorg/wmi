package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_LogonSession extends WmiObj {
  public String getAuthenticationPackage();
  
  public String getCaption();
  
  public String getDescription();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public String getLogonId();
  
  public int getLogonType();
  
  public String getName();
  
  public java.util.Optional<java.time.OffsetDateTime> getStartTime();
  
  public String getStatus();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_LogonSession> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_LogonSession", obj -> client.accept(new Win32_LogonSessionImpl(obj, wmi)) );
  }
  
  public static List<Win32_LogonSession> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_LogonSession> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
