package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_LoggedOnUser extends WmiObj {
  public java.util.Optional<Win32_Account> getAntecedent();
  
  public java.util.Optional<Win32_LogonSession> getDependent();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_LoggedOnUser> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_LoggedOnUser", obj -> client.accept(new Win32_LoggedOnUserImpl(obj, wmi)) );
  }
  
  public static List<Win32_LoggedOnUser> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_LoggedOnUser> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
