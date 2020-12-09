package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_DesktopImpl extends WmiObjImpl implements Win32_Desktop {
  public Win32_DesktopImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_DesktopImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_DesktopImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_DesktopImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public int getBorderWidth(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("BorderWidth");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read BorderWidth");
    return v.getInt();
  }
  
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getCoolSwitch(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CoolSwitch");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read CoolSwitch");
    return v.getBoolean();
  }
  
  public int getCursorBlinkRate(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CursorBlinkRate");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read CursorBlinkRate");
    return v.getInt();
  }
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getDragFullWindows(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DragFullWindows");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DragFullWindows");
    return v.getBoolean();
  }
  
  public int getGridGranularity(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("GridGranularity");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read GridGranularity");
    return v.getInt();
  }
  
  public int getIconSpacing(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("IconSpacing");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read IconSpacing");
    return v.getInt();
  }
  
  public String getIconTitleFaceName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("IconTitleFaceName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getIconTitleSize(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("IconTitleSize");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read IconTitleSize");
    return v.getInt();
  }
  
  public boolean getIconTitleWrap(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("IconTitleWrap");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read IconTitleWrap");
    return v.getBoolean();
  }
  
  public String getName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Name");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getPattern(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Pattern");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getScreenSaverActive(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ScreenSaverActive");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ScreenSaverActive");
    return v.getBoolean();
  }
  
  public String getScreenSaverExecutable(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ScreenSaverExecutable");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getScreenSaverSecure(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ScreenSaverSecure");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ScreenSaverSecure");
    return v.getBoolean();
  }
  
  public int getScreenSaverTimeout(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ScreenSaverTimeout");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ScreenSaverTimeout");
    return v.getInt();
  }
  
  public String getSettingID(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SettingID");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getWallpaper(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Wallpaper");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getWallpaperStretched(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("WallpaperStretched");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read WallpaperStretched");
    return v.getBoolean();
  }
  
  public boolean getWallpaperTiled(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("WallpaperTiled");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read WallpaperTiled");
    return v.getBoolean();
  }
  
}
