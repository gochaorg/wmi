package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_ShareToDirectory extends WmiObj {
  public java.util.Optional<Win32_Share> getShare();
  
  public java.util.Optional<CIM_Directory> getSharedElement();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_ShareToDirectory> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_ShareToDirectory", obj -> client.accept(new Win32_ShareToDirectoryImpl(obj, wmi)) );
  }
  
  public static List<Win32_ShareToDirectory> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_ShareToDirectory> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
