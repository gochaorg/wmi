package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_OSRecoveryConfiguration extends WmiObj {
  public boolean getAutoReboot();
  
  public String getCaption();
  
  public String getDebugFilePath();
  
  public int getDebugInfoType();
  
  public String getDescription();
  
  public String getExpandedDebugFilePath();
  
  public String getExpandedMiniDumpDirectory();
  
  public boolean getKernelDumpOnly();
  
  public String getMiniDumpDirectory();
  
  public String getName();
  
  public boolean getOverwriteExistingDebugFile();
  
  public boolean getSendAdminAlert();
  
  public String getSettingID();
  
  public boolean getWriteDebugInfo();
  
  public boolean getWriteToSystemLog();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_OSRecoveryConfiguration> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_OSRecoveryConfiguration", obj -> client.accept(new Win32_OSRecoveryConfigurationImpl(obj, wmi)) );
  }
  
  public static List<Win32_OSRecoveryConfiguration> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_OSRecoveryConfiguration> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
