package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_ScheduledJobImpl extends WmiObjImpl implements Win32_ScheduledJob {
  public Win32_ScheduledJobImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_ScheduledJobImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_ScheduledJobImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_ScheduledJobImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getCommand(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Command");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getDaysOfMonth(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaysOfMonth");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaysOfMonth");
    return v.getInt();
  }
  
  public int getDaysOfWeek(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaysOfWeek");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaysOfWeek");
    return v.getInt();
  }
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getElapsedTime(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ElapsedTime");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InstallDate");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public boolean getInteractWithDesktop(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InteractWithDesktop");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read InteractWithDesktop");
    return v.getBoolean();
  }
  
  public int getJobId(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("JobId");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read JobId");
    return v.getInt();
  }
  
  public String getJobStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("JobStatus");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Name");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getNotify(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Notify");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getOwner(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Owner");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getPriority(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Priority");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Priority");
    return v.getInt();
  }
  
  public boolean getRunRepeatedly(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("RunRepeatedly");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read RunRepeatedly");
    return v.getBoolean();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getStartTime(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StartTime");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public String getStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Status");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getTimeSubmitted(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("TimeSubmitted");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getUntilTime(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("UntilTime");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
}
