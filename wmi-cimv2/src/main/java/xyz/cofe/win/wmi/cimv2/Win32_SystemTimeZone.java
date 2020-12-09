package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_SystemTimeZone extends WmiObj {
  public java.util.Optional<Win32_ComputerSystem> getElement();
  
  public java.util.Optional<Win32_TimeZone> getSetting();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_SystemTimeZone> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_SystemTimeZone", obj -> client.accept(new Win32_SystemTimeZoneImpl(obj, wmi)) );
  }
  
  public static List<Win32_SystemTimeZone> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_SystemTimeZone> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
