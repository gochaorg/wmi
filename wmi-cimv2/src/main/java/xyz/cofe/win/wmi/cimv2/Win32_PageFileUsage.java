package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_PageFileUsage extends WmiObj {
  public int getAllocatedBaseSize();
  
  public String getCaption();
  
  public int getCurrentUsage();
  
  public String getDescription();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public String getName();
  
  public int getPeakUsage();
  
  public String getStatus();
  
  public boolean getTempPageFile();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_PageFileUsage> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_PageFileUsage", obj -> client.accept(new Win32_PageFileUsageImpl(obj, wmi)) );
  }
  
  public static List<Win32_PageFileUsage> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_PageFileUsage> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
