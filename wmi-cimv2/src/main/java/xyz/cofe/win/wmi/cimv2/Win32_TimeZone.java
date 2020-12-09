package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_TimeZone extends WmiObj {
  public int getBias();
  
  public String getCaption();
  
  public int getDaylightBias();
  
  public int getDaylightDay();
  
  public byte getDaylightDayOfWeek();
  
  public int getDaylightHour();
  
  public int getDaylightMillisecond();
  
  public int getDaylightMinute();
  
  public int getDaylightMonth();
  
  public String getDaylightName();
  
  public int getDaylightSecond();
  
  public int getDaylightYear();
  
  public String getDescription();
  
  public String getSettingID();
  
  public int getStandardBias();
  
  public int getStandardDay();
  
  public byte getStandardDayOfWeek();
  
  public int getStandardHour();
  
  public int getStandardMillisecond();
  
  public int getStandardMinute();
  
  public int getStandardMonth();
  
  public String getStandardName();
  
  public int getStandardSecond();
  
  public int getStandardYear();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_TimeZone> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_TimeZone", obj -> client.accept(new Win32_TimeZoneImpl(obj, wmi)) );
  }
  
  public static List<Win32_TimeZone> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_TimeZone> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
