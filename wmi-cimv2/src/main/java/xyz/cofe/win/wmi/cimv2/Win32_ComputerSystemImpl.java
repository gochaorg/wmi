package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_ComputerSystemImpl extends WmiObjImpl implements Win32_ComputerSystem {
  public Win32_ComputerSystemImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_ComputerSystemImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_ComputerSystemImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_ComputerSystemImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public int getAdminPasswordStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AdminPasswordStatus");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AdminPasswordStatus");
    return v.getInt();
  }
  
  public boolean getAutomaticManagedPagefile(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AutomaticManagedPagefile");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AutomaticManagedPagefile");
    return v.getBoolean();
  }
  
  public boolean getAutomaticResetBootOption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AutomaticResetBootOption");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AutomaticResetBootOption");
    return v.getBoolean();
  }
  
  public boolean getAutomaticResetCapability(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AutomaticResetCapability");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AutomaticResetCapability");
    return v.getBoolean();
  }
  
  public int getBootOptionOnLimit(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("BootOptionOnLimit");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read BootOptionOnLimit");
    return v.getInt();
  }
  
  public int getBootOptionOnWatchDog(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("BootOptionOnWatchDog");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read BootOptionOnWatchDog");
    return v.getInt();
  }
  
  public boolean getBootROMSupported(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("BootROMSupported");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read BootROMSupported");
    return v.getBoolean();
  }
  
  /* property BootStatus : array - not supported */
  
  public String getBootupState(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("BootupState");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getChassisBootupState(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ChassisBootupState");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ChassisBootupState");
    return v.getInt();
  }
  
  public String getChassisSKUNumber(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ChassisSKUNumber");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getCreationClassName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CreationClassName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public short getCurrentTimeZone(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CurrentTimeZone");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read CurrentTimeZone");
    return v.getShort();
  }
  
  public boolean getDaylightInEffect(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DaylightInEffect");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DaylightInEffect");
    return v.getBoolean();
  }
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getDNSHostName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DNSHostName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getDomain(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Domain");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getDomainRole(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DomainRole");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DomainRole");
    return v.getInt();
  }
  
  public boolean getEnableDaylightSavingsTime(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("EnableDaylightSavingsTime");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read EnableDaylightSavingsTime");
    return v.getBoolean();
  }
  
  public int getFrontPanelResetStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FrontPanelResetStatus");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read FrontPanelResetStatus");
    return v.getInt();
  }
  
  public boolean getHypervisorPresent(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("HypervisorPresent");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read HypervisorPresent");
    return v.getBoolean();
  }
  
  public boolean getInfraredSupported(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InfraredSupported");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read InfraredSupported");
    return v.getBoolean();
  }
  
  /* property InitialLoadInfo : array - not supported */
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InstallDate");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public int getKeyboardPasswordStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("KeyboardPasswordStatus");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read KeyboardPasswordStatus");
    return v.getInt();
  }
  
  public String getLastLoadInfo(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("LastLoadInfo");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getManufacturer(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Manufacturer");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getModel(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Model");
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
  
  public String getNameFormat(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("NameFormat");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getNetworkServerModeEnabled(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("NetworkServerModeEnabled");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read NetworkServerModeEnabled");
    return v.getBoolean();
  }
  
  public int getNumberOfLogicalProcessors(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("NumberOfLogicalProcessors");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read NumberOfLogicalProcessors");
    return v.getInt();
  }
  
  public int getNumberOfProcessors(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("NumberOfProcessors");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read NumberOfProcessors");
    return v.getInt();
  }
  
  /* property OEMLogoBitmap : array - not supported */
  
  /* property OEMStringArray : array - not supported */
  
  public boolean getPartOfDomain(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PartOfDomain");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PartOfDomain");
    return v.getBoolean();
  }
  
  public long getPauseAfterReset(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PauseAfterReset");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PauseAfterReset");
    return v.getLong();
  }
  
  public int getPCSystemType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PCSystemType");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PCSystemType");
    return v.getInt();
  }
  
  public int getPCSystemTypeEx(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PCSystemTypeEx");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PCSystemTypeEx");
    return v.getInt();
  }
  
  /* property PowerManagementCapabilities : array - not supported */
  
  public boolean getPowerManagementSupported(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PowerManagementSupported");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PowerManagementSupported");
    return v.getBoolean();
  }
  
  public int getPowerOnPasswordStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PowerOnPasswordStatus");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PowerOnPasswordStatus");
    return v.getInt();
  }
  
  public int getPowerState(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PowerState");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PowerState");
    return v.getInt();
  }
  
  public int getPowerSupplyState(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PowerSupplyState");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PowerSupplyState");
    return v.getInt();
  }
  
  public String getPrimaryOwnerContact(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PrimaryOwnerContact");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getPrimaryOwnerName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PrimaryOwnerName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getResetCapability(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ResetCapability");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ResetCapability");
    return v.getInt();
  }
  
  public short getResetCount(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ResetCount");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ResetCount");
    return v.getShort();
  }
  
  public short getResetLimit(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ResetLimit");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ResetLimit");
    return v.getShort();
  }
  
  /* property Roles : array - not supported */
  
  public String getStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Status");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  /* property SupportContactDescription : array - not supported */
  
  public String getSystemFamily(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemFamily");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getSystemSKUNumber(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemSKUNumber");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getSystemStartupDelay(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemStartupDelay");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read SystemStartupDelay");
    return v.getInt();
  }
  
  /* property SystemStartupOptions : array - not supported */
  
  public byte getSystemStartupSetting(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemStartupSetting");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read SystemStartupSetting");
    return v.getByte();
  }
  
  public String getSystemType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemType");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getThermalState(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ThermalState");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ThermalState");
    return v.getInt();
  }
  
  public long getTotalPhysicalMemory(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("TotalPhysicalMemory");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read TotalPhysicalMemory");
    return v.getLong();
  }
  
  public String getUserName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("UserName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getWakeUpType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("WakeUpType");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read WakeUpType");
    return v.getInt();
  }
  
  public String getWorkgroup(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Workgroup");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
}
