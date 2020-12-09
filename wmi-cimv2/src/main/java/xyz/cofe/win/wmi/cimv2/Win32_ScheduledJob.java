package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_ScheduledJob extends WmiObj {
  public String getCaption();
  
  public String getCommand();
  
  public int getDaysOfMonth();
  
  public int getDaysOfWeek();
  
  public String getDescription();
  
  public java.util.Optional<java.time.OffsetDateTime> getElapsedTime();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public boolean getInteractWithDesktop();
  
  public int getJobId();
  
  public String getJobStatus();
  
  public String getName();
  
  public String getNotify();
  
  public String getOwner();
  
  public int getPriority();
  
  public boolean getRunRepeatedly();
  
  public java.util.Optional<java.time.OffsetDateTime> getStartTime();
  
  public String getStatus();
  
  public java.util.Optional<java.time.OffsetDateTime> getTimeSubmitted();
  
  public java.util.Optional<java.time.OffsetDateTime> getUntilTime();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_ScheduledJob> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_ScheduledJob", obj -> client.accept(new Win32_ScheduledJobImpl(obj, wmi)) );
  }
  
  public static List<Win32_ScheduledJob> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_ScheduledJob> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
