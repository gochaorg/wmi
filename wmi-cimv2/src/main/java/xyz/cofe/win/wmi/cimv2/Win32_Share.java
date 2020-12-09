package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_Share extends WmiObj {
  public int getAccessMask();
  
  public boolean getAllowMaximum();
  
  public String getCaption();
  
  public String getDescription();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public int getMaximumAllowed();
  
  public String getName();
  
  public String getPath();
  
  public String getStatus();
  
  public int getType();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_Share> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_Share", obj -> client.accept(new Win32_ShareImpl(obj, wmi)) );
  }
  
  public static List<Win32_Share> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_Share> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
