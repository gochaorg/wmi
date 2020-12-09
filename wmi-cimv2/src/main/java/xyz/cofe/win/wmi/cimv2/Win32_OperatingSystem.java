package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_OperatingSystem extends WmiObj {
  public String getBootDevice();
  
  public String getBuildNumber();
  
  public String getBuildType();
  
  public String getCaption();
  
  public String getCodeSet();
  
  public String getCountryCode();
  
  public String getCreationClassName();
  
  public String getCSCreationClassName();
  
  public String getCSDVersion();
  
  public String getCSName();
  
  public short getCurrentTimeZone();
  
  public boolean getDataExecutionPrevention_32BitApplications();
  
  public boolean getDataExecutionPrevention_Available();
  
  public boolean getDataExecutionPrevention_Drivers();
  
  public byte getDataExecutionPrevention_SupportPolicy();
  
  public boolean getDebug();
  
  public String getDescription();
  
  public boolean getDistributed();
  
  public int getEncryptionLevel();
  
  public byte getForegroundApplicationBoost();
  
  public long getFreePhysicalMemory();
  
  public long getFreeSpaceInPagingFiles();
  
  public long getFreeVirtualMemory();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public int getLargeSystemCache();
  
  public java.util.Optional<java.time.OffsetDateTime> getLastBootUpTime();
  
  public java.util.Optional<java.time.OffsetDateTime> getLocalDateTime();
  
  public String getLocale();
  
  public String getManufacturer();
  
  public int getMaxNumberOfProcesses();
  
  public long getMaxProcessMemorySize();
  
  /* property MUILanguages : array - not supported */
  
  public String getName();
  
  public int getNumberOfLicensedUsers();
  
  public int getNumberOfProcesses();
  
  public int getNumberOfUsers();
  
  public int getOperatingSystemSKU();
  
  public String getOrganization();
  
  public String getOSArchitecture();
  
  public int getOSLanguage();
  
  public int getOSProductSuite();
  
  public int getOSType();
  
  public String getOtherTypeDescription();
  
  public boolean getPAEEnabled();
  
  public String getPlusProductID();
  
  public String getPlusVersionNumber();
  
  public boolean getPortableOperatingSystem();
  
  public boolean getPrimary();
  
  public int getProductType();
  
  public String getRegisteredUser();
  
  public String getSerialNumber();
  
  public int getServicePackMajorVersion();
  
  public int getServicePackMinorVersion();
  
  public long getSizeStoredInPagingFiles();
  
  public String getStatus();
  
  public int getSuiteMask();
  
  public String getSystemDevice();
  
  public String getSystemDirectory();
  
  public String getSystemDrive();
  
  public long getTotalSwapSpaceSize();
  
  public long getTotalVirtualMemorySize();
  
  public long getTotalVisibleMemorySize();
  
  public String getVersion();
  
  public String getWindowsDirectory();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_OperatingSystem> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_OperatingSystem", obj -> client.accept(new Win32_OperatingSystemImpl(obj, wmi)) );
  }
  
  public static List<Win32_OperatingSystem> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_OperatingSystem> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
