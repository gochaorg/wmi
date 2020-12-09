package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_SessionProcess extends WmiObj {
  public java.util.Optional<Win32_LogonSession> getAntecedent();
  
  public java.util.Optional<Win32_Process> getDependent();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_SessionProcess> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_SessionProcess", obj -> client.accept(new Win32_SessionProcessImpl(obj, wmi)) );
  }
  
  public static List<Win32_SessionProcess> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_SessionProcess> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
