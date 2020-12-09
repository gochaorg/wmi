package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_UserDesktop extends WmiObj {
  public java.util.Optional<Win32_UserAccount> getElement();
  
  public java.util.Optional<Win32_Desktop> getSetting();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_UserDesktop> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_UserDesktop", obj -> client.accept(new Win32_UserDesktopImpl(obj, wmi)) );
  }
  
  public static List<Win32_UserDesktop> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_UserDesktop> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
