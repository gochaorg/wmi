package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_DependentService extends WmiObj {
  public java.util.Optional<Win32_BaseService> getAntecedent();
  
  public java.util.Optional<Win32_BaseService> getDependent();
  
  public int getTypeOfDependency();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_DependentService> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_DependentService", obj -> client.accept(new Win32_DependentServiceImpl(obj, wmi)) );
  }
  
  public static List<Win32_DependentService> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_DependentService> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
