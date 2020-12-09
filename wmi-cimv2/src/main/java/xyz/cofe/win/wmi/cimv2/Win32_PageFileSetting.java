package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_PageFileSetting extends WmiObj {
  public String getCaption();
  
  public String getDescription();
  
  public int getInitialSize();
  
  public int getMaximumSize();
  
  public String getName();
  
  public String getSettingID();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_PageFileSetting> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_PageFileSetting", obj -> client.accept(new Win32_PageFileSettingImpl(obj, wmi)) );
  }
  
  public static List<Win32_PageFileSetting> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_PageFileSetting> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
