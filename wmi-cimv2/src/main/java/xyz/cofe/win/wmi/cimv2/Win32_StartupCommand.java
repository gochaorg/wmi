package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_StartupCommand extends WmiObj {
  public String getCaption();
  
  public String getCommand();
  
  public String getDescription();
  
  public String getLocation();
  
  public String getName();
  
  public String getSettingID();
  
  public String getUser();
  
  public String getUserSID();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_StartupCommand> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_StartupCommand", obj -> client.accept(new Win32_StartupCommandImpl(obj, wmi)) );
  }
  
  public static List<Win32_StartupCommand> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_StartupCommand> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
