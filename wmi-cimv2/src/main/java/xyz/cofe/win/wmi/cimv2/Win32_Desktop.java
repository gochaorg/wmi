package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_Desktop extends WmiObj {
  public int getBorderWidth();
  
  public String getCaption();
  
  public boolean getCoolSwitch();
  
  public int getCursorBlinkRate();
  
  public String getDescription();
  
  public boolean getDragFullWindows();
  
  public int getGridGranularity();
  
  public int getIconSpacing();
  
  public String getIconTitleFaceName();
  
  public int getIconTitleSize();
  
  public boolean getIconTitleWrap();
  
  public String getName();
  
  public String getPattern();
  
  public boolean getScreenSaverActive();
  
  public String getScreenSaverExecutable();
  
  public boolean getScreenSaverSecure();
  
  public int getScreenSaverTimeout();
  
  public String getSettingID();
  
  public String getWallpaper();
  
  public boolean getWallpaperStretched();
  
  public boolean getWallpaperTiled();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_Desktop> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_Desktop", obj -> client.accept(new Win32_DesktopImpl(obj, wmi)) );
  }
  
  public static List<Win32_Desktop> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_Desktop> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
