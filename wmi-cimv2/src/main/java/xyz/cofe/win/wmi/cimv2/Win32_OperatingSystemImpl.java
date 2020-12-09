package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class Win32_OperatingSystemImpl extends WmiObjImpl implements Win32_OperatingSystem {
  public Win32_OperatingSystemImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public Win32_OperatingSystemImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public Win32_OperatingSystemImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public Win32_OperatingSystemImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public String getBootDevice(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("BootDevice");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getBuildNumber(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("BuildNumber");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getBuildType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("BuildType");
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
  
  public String getCodeSet(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CodeSet");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getCountryCode(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CountryCode");
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
  
  public String getCSCreationClassName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CSCreationClassName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getCSDVersion(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CSDVersion");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getCSName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CSName");
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
  
  public boolean getDataExecutionPrevention_32BitApplications(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DataExecutionPrevention_32BitApplications");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DataExecutionPrevention_32BitApplications");
    return v.getBoolean();
  }
  
  public boolean getDataExecutionPrevention_Available(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DataExecutionPrevention_Available");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DataExecutionPrevention_Available");
    return v.getBoolean();
  }
  
  public boolean getDataExecutionPrevention_Drivers(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DataExecutionPrevention_Drivers");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DataExecutionPrevention_Drivers");
    return v.getBoolean();
  }
  
  public byte getDataExecutionPrevention_SupportPolicy(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("DataExecutionPrevention_SupportPolicy");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read DataExecutionPrevention_SupportPolicy");
    return v.getByte();
  }
  
  public boolean getDebug(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Debug");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Debug");
    return v.getBoolean();
  }
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getDistributed(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Distributed");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Distributed");
    return v.getBoolean();
  }
  
  public int getEncryptionLevel(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("EncryptionLevel");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read EncryptionLevel");
    return v.getInt();
  }
  
  public byte getForegroundApplicationBoost(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ForegroundApplicationBoost");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ForegroundApplicationBoost");
    return v.getByte();
  }
  
  public long getFreePhysicalMemory(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FreePhysicalMemory");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read FreePhysicalMemory");
    return v.getLong();
  }
  
  public long getFreeSpaceInPagingFiles(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FreeSpaceInPagingFiles");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read FreeSpaceInPagingFiles");
    return v.getLong();
  }
  
  public long getFreeVirtualMemory(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FreeVirtualMemory");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read FreeVirtualMemory");
    return v.getLong();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InstallDate");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public int getLargeSystemCache(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("LargeSystemCache");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read LargeSystemCache");
    return v.getInt();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getLastBootUpTime(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("LastBootUpTime");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getLocalDateTime(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("LocalDateTime");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public String getLocale(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Locale");
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
  
  public int getMaxNumberOfProcesses(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("MaxNumberOfProcesses");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read MaxNumberOfProcesses");
    return v.getInt();
  }
  
  public long getMaxProcessMemorySize(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("MaxProcessMemorySize");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read MaxProcessMemorySize");
    return v.getLong();
  }
  
  /* property MUILanguages : array - not supported */
  
  public String getName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Name");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getNumberOfLicensedUsers(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("NumberOfLicensedUsers");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read NumberOfLicensedUsers");
    return v.getInt();
  }
  
  public int getNumberOfProcesses(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("NumberOfProcesses");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read NumberOfProcesses");
    return v.getInt();
  }
  
  public int getNumberOfUsers(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("NumberOfUsers");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read NumberOfUsers");
    return v.getInt();
  }
  
  public int getOperatingSystemSKU(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("OperatingSystemSKU");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read OperatingSystemSKU");
    return v.getInt();
  }
  
  public String getOrganization(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Organization");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getOSArchitecture(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("OSArchitecture");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getOSLanguage(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("OSLanguage");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read OSLanguage");
    return v.getInt();
  }
  
  public int getOSProductSuite(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("OSProductSuite");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read OSProductSuite");
    return v.getInt();
  }
  
  public int getOSType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("OSType");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read OSType");
    return v.getInt();
  }
  
  public String getOtherTypeDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("OtherTypeDescription");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getPAEEnabled(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PAEEnabled");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PAEEnabled");
    return v.getBoolean();
  }
  
  public String getPlusProductID(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PlusProductID");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getPlusVersionNumber(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PlusVersionNumber");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getPortableOperatingSystem(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("PortableOperatingSystem");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read PortableOperatingSystem");
    return v.getBoolean();
  }
  
  public boolean getPrimary(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Primary");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Primary");
    return v.getBoolean();
  }
  
  public int getProductType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ProductType");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ProductType");
    return v.getInt();
  }
  
  public String getRegisteredUser(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("RegisteredUser");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getSerialNumber(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SerialNumber");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getServicePackMajorVersion(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ServicePackMajorVersion");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ServicePackMajorVersion");
    return v.getInt();
  }
  
  public int getServicePackMinorVersion(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("ServicePackMinorVersion");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read ServicePackMinorVersion");
    return v.getInt();
  }
  
  public long getSizeStoredInPagingFiles(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SizeStoredInPagingFiles");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read SizeStoredInPagingFiles");
    return v.getLong();
  }
  
  public String getStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Status");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public int getSuiteMask(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SuiteMask");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read SuiteMask");
    return v.getInt();
  }
  
  public String getSystemDevice(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemDevice");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getSystemDirectory(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemDirectory");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getSystemDrive(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("SystemDrive");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public long getTotalSwapSpaceSize(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("TotalSwapSpaceSize");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read TotalSwapSpaceSize");
    return v.getLong();
  }
  
  public long getTotalVirtualMemorySize(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("TotalVirtualMemorySize");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read TotalVirtualMemorySize");
    return v.getLong();
  }
  
  public long getTotalVisibleMemorySize(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("TotalVisibleMemorySize");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read TotalVisibleMemorySize");
    return v.getLong();
  }
  
  public String getVersion(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Version");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getWindowsDirectory(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("WindowsDirectory");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
}
