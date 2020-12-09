package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_GroupUser extends WmiObj {
  public java.util.Optional<Win32_Group> getGroupComponent();
  
  public java.util.Optional<Win32_Account> getPartComponent();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_GroupUser> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_GroupUser", obj -> client.accept(new Win32_GroupUserImpl(obj, wmi)) );
  }
  
  public static List<Win32_GroupUser> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_GroupUser> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
