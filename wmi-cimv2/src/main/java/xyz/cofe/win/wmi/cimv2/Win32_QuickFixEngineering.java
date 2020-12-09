package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_QuickFixEngineering extends WmiObj {
  public String getCaption();
  
  public String getCSName();
  
  public String getDescription();
  
  public String getFixComments();
  
  public String getHotFixID();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public String getInstalledBy();
  
  public String getInstalledOn();
  
  public String getName();
  
  public String getServicePackInEffect();
  
  public String getStatus();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_QuickFixEngineering> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_QuickFixEngineering", obj -> client.accept(new Win32_QuickFixEngineeringImpl(obj, wmi)) );
  }
  
  public static List<Win32_QuickFixEngineering> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_QuickFixEngineering> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
