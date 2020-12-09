package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

public class CIM_DirectoryImpl extends WmiObjImpl implements CIM_Directory {
  public CIM_DirectoryImpl(ActiveXComponent activeXComponent) {
    super(activeXComponent);
  }
  public CIM_DirectoryImpl(ActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent, wmi);
  }
  public CIM_DirectoryImpl(GetActiveXComponent activeXComponent) {
    super(activeXComponent.getActiveXComponent());
  }
  public CIM_DirectoryImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
    super(activeXComponent.getActiveXComponent(), wmi);
  }
  public int getAccessMask(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("AccessMask");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read AccessMask");
    return v.getInt();
  }
  
  public boolean getArchive(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Archive");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Archive");
    return v.getBoolean();
  }
  
  public String getCaption(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Caption");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getCompressed(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Compressed");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Compressed");
    return v.getBoolean();
  }
  
  public String getCompressionMethod(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CompressionMethod");
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
  
  public java.util.Optional<java.time.OffsetDateTime> getCreationDate(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CreationDate");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public String getCSCreationClassName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("CSCreationClassName");
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
  
  public String getDescription(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Description");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getDrive(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Drive");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getEightDotThreeFileName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("EightDotThreeFileName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getEncrypted(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Encrypted");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Encrypted");
    return v.getBoolean();
  }
  
  public String getEncryptionMethod(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("EncryptionMethod");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getExtension(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Extension");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getFileName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FileName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public long getFileSize(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FileSize");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read FileSize");
    return v.getLong();
  }
  
  public String getFileType(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FileType");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getFSCreationClassName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FSCreationClassName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getFSName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("FSName");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getHidden(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Hidden");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Hidden");
    return v.getBoolean();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getInstallDate(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InstallDate");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public long getInUseCount(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("InUseCount");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read InUseCount");
    return v.getLong();
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getLastAccessed(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("LastAccessed");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public java.util.Optional<java.time.OffsetDateTime> getLastModified(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("LastModified");
    if( v==null || v.isNull() )return java.util.Optional.empty();
    return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
  }
  
  public String getName(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Name");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public String getPath(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Path");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getReadable(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Readable");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Readable");
    return v.getBoolean();
  }
  
  public String getStatus(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Status");
    if( v==null || v.isNull() )return null;
    return v.getString();
  }
  
  public boolean getSystem(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("System");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read System");
    return v.getBoolean();
  }
  
  public boolean getWriteable(){
    ActiveXComponent ax = getActiveXComponent();
    if( ax==null )throw new IllegalStateException("activeXComponent is null");
    Variant v = ax.getProperty("Writeable");
    if( v==null || v.isNull() )throw new IllegalStateException("can't read Writeable");
    return v.getBoolean();
  }
  
}
