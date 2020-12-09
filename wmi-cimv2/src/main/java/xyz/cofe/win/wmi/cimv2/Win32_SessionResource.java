package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_SessionResource extends WmiObj {
  public java.util.Optional<Win32_LogicalElement> getAntecedent();
  
  public java.util.Optional<Win32_Session> getDependent();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_SessionResource> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_SessionResource", obj -> client.accept(new Win32_SessionResourceImpl(obj, wmi)) );
  }
  
  public static List<Win32_SessionResource> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_SessionResource> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
