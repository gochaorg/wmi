package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_Environment extends WmiObj {
  public String getCaption();
  
  public String getDescription();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public String getName();
  
  public String getStatus();
  
  public boolean getSystemVariable();
  
  public String getUserName();
  
  public String getVariableValue();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_Environment> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_Environment", obj -> client.accept(new Win32_EnvironmentImpl(obj, wmi)) );
  }
  
  public static List<Win32_Environment> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_Environment> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
