package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface CIM_Directory extends WmiObj {
  public int getAccessMask();
  
  public boolean getArchive();
  
  public String getCaption();
  
  public boolean getCompressed();
  
  public String getCompressionMethod();
  
  public String getCreationClassName();
  
  public java.util.Optional<java.time.OffsetDateTime> getCreationDate();
  
  public String getCSCreationClassName();
  
  public String getCSName();
  
  public String getDescription();
  
  public String getDrive();
  
  public String getEightDotThreeFileName();
  
  public boolean getEncrypted();
  
  public String getEncryptionMethod();
  
  public String getExtension();
  
  public String getFileName();
  
  public long getFileSize();
  
  public String getFileType();
  
  public String getFSCreationClassName();
  
  public String getFSName();
  
  public boolean getHidden();
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate();
  
  public long getInUseCount();
  
  public java.util.Optional<java.time.OffsetDateTime> getLastAccessed();
  
  public java.util.Optional<java.time.OffsetDateTime> getLastModified();
  
  public String getName();
  
  public String getPath();
  
  public boolean getReadable();
  
  public String getStatus();
  
  public boolean getSystem();
  
  public boolean getWriteable();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<CIM_Directory> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("CIM_Directory", obj -> client.accept(new CIM_DirectoryImpl(obj, wmi)) );
  }
  
  public static List<CIM_Directory> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<CIM_Directory> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
