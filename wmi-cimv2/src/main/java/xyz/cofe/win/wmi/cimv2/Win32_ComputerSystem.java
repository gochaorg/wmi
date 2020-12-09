package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_ComputerSystem extends WmiObj {
  public int getAdminPasswordStatus();
  
  public boolean getAutomaticManagedPagefile();
  
  public boolean getAutomaticResetBootOption();
  
  public boolean getAutomaticResetCapability();
  
  public int getBootOptionOnLimit();
  
  public int getBootOptionOnWatchDog();
  
  public boolean getBootROMSupported();
  
  /* property BootStatus : array - not supported */
  
  public String getBootupState();
  
  public String getCaption();
  
  public int getChassisBootupState();
  
  public String getChassisSKUNumber();
  
  public String getCreationClassName();
  
  public short getCurrentTimeZone();
  
  public boolean getDaylightInEffect();
  
  public String getDescription();
  
  public String getDNSHostName();
  
  public String getDomain();
  
  public int getDomainRole();
  
  public boolean getEnableDaylightSavingsTime();
  
  public int getFrontPanelResetStatus();
  
  public boolean getHypervisorPresent();
  
  public boolean getInfraredSupported();
  
  /* property InitialLoadInfo : array - not supported */
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public int getKeyboardPasswordStatus();
  
  public String getLastLoadInfo();
  
  public String getManufacturer();
  
  public String getModel();
  
  public String getName();
  
  public String getNameFormat();
  
  public boolean getNetworkServerModeEnabled();
  
  public int getNumberOfLogicalProcessors();
  
  public int getNumberOfProcessors();
  
  /* property OEMLogoBitmap : array - not supported */
  
  /* property OEMStringArray : array - not supported */
  
  public boolean getPartOfDomain();
  
  public long getPauseAfterReset();
  
  public int getPCSystemType();
  
  public int getPCSystemTypeEx();
  
  /* property PowerManagementCapabilities : array - not supported */
  
  public boolean getPowerManagementSupported();
  
  public int getPowerOnPasswordStatus();
  
  public int getPowerState();
  
  public int getPowerSupplyState();
  
  public String getPrimaryOwnerContact();
  
  public String getPrimaryOwnerName();
  
  public int getResetCapability();
  
  public short getResetCount();
  
  public short getResetLimit();
  
  /* property Roles : array - not supported */
  
  public String getStatus();
  
  /* property SupportContactDescription : array - not supported */
  
  public String getSystemFamily();
  
  public String getSystemSKUNumber();
  
  public int getSystemStartupDelay();
  
  /* property SystemStartupOptions : array - not supported */
  
  public byte getSystemStartupSetting();
  
  public String getSystemType();
  
  public int getThermalState();
  
  public long getTotalPhysicalMemory();
  
  public String getUserName();
  
  public int getWakeUpType();
  
  public String getWorkgroup();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_ComputerSystem> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_ComputerSystem", obj -> client.accept(new Win32_ComputerSystemImpl(obj, wmi)) );
  }
  
  public static List<Win32_ComputerSystem> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_ComputerSystem> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
