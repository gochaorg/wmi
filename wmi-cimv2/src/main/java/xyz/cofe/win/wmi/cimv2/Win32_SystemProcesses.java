package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_SystemProcesses extends WmiObj {
  public java.util.Optional<Win32_ComputerSystem> getGroupComponent();
  
  public java.util.Optional<Win32_Process> getPartComponent();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_SystemProcesses> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_SystemProcesses", obj -> client.accept(new Win32_SystemProcessesImpl(obj, wmi)) );
  }
  
  public static List<Win32_SystemProcesses> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_SystemProcesses> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
