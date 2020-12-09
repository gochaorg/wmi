package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_BaseService extends WmiObj {
  public boolean getAcceptPause();
  
  public boolean getAcceptStop();
  
  public String getCaption();
  
  public String getCreationClassName();
  
  public String getDescription();
  
  public boolean getDesktopInteract();
  
  public String getDisplayName();
  
  public String getErrorControl();
  
  public int getExitCode();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public String getName();
  
  public String getPathName();
  
  public int getServiceSpecificExitCode();
  
  public String getServiceType();
  
  public boolean getStarted();
  
  public String getStartMode();
  
  public String getStartName();
  
  public String getState();
  
  public String getStatus();
  
  public String getSystemCreationClassName();
  
  public String getSystemName();
  
  public int getTagId();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_BaseService> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_BaseService", obj -> client.accept(new Win32_BaseServiceImpl(obj, wmi)) );
  }
  
  public static List<Win32_BaseService> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_BaseService> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
