package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_OperatingSystemQFE extends WmiObj {
  public java.util.Optional<Win32_OperatingSystem> getAntecedent();
  
  public java.util.Optional<Win32_QuickFixEngineering> getDependent();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_OperatingSystemQFE> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_OperatingSystemQFE", obj -> client.accept(new Win32_OperatingSystemQFEImpl(obj, wmi)) );
  }
  
  public static List<Win32_OperatingSystemQFE> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_OperatingSystemQFE> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
