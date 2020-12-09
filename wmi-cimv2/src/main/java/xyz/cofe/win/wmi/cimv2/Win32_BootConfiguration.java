package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_BootConfiguration extends WmiObj {
  public String getBootDirectory();
  
  public String getCaption();
  
  public String getConfigurationPath();
  
  public String getDescription();
  
  public String getLastDrive();
  
  public String getName();
  
  public String getScratchDirectory();
  
  public String getSettingID();
  
  public String getTempDirectory();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_BootConfiguration> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_BootConfiguration", obj -> client.accept(new Win32_BootConfigurationImpl(obj, wmi)) );
  }
  
  public static List<Win32_BootConfiguration> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_BootConfiguration> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
