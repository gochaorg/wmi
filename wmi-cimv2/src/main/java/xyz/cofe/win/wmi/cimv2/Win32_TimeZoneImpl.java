package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_TimeZoneImpl extends WmiObjImpl implements Win32_TimeZone {
  public Win32_TimeZoneImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_TimeZoneImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_TimeZoneImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_TimeZoneImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public int getBias(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Bias");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Bias");
    return v.getInt();
  }
  
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getDaylightBias(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightBias");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightBias");
    return v.getInt();
  }
  
  public int getDaylightDay(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightDay");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightDay");
    return v.getInt();
  }
  
  public byte getDaylightDayOfWeek(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightDayOfWeek");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightDayOfWeek");
    return v.getByte();
  }
  
  public int getDaylightHour(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightHour");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightHour");
    return v.getInt();
  }
  
  public int getDaylightMillisecond(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightMillisecond");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightMillisecond");
    return v.getInt();
  }
  
  public int getDaylightMinute(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightMinute");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightMinute");
    return v.getInt();
  }
  
  public int getDaylightMonth(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightMonth");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightMonth");
    return v.getInt();
  }
  
  public String getDaylightName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getDaylightSecond(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightSecond");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightSecond");
    return v.getInt();
  }
  
  public int getDaylightYear(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightYear");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightYear");
    return v.getInt();
  }
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getSettingID(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SettingID");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getStandardBias(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardBias");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardBias");
    return v.getInt();
  }
  
  public int getStandardDay(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardDay");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardDay");
    return v.getInt();
  }
  
  public byte getStandardDayOfWeek(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardDayOfWeek");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardDayOfWeek");
    return v.getByte();
  }
  
  public int getStandardHour(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardHour");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardHour");
    return v.getInt();
  }
  
  public int getStandardMillisecond(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardMillisecond");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardMillisecond");
    return v.getInt();
  }
  
  public int getStandardMinute(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardMinute");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardMinute");
    return v.getInt();
  }
  
  public int getStandardMonth(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardMonth");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardMonth");
    return v.getInt();
  }
  
  public String getStandardName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getStandardSecond(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardSecond");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardSecond");
    return v.getInt();
  }
  
  public int getStandardYear(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("StandardYear");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read StandardYear");
    return v.getInt();
  }
  
}
