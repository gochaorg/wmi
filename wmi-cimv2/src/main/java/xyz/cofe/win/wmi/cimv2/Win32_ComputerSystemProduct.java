package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_ComputerSystemProduct extends WmiObj {
  public String getCaption();
  
  public String getDescription();
  
  public String getElementName();
  
  public String getIdentifyingNumber();
  
  public String getInstanceID();
  
  public String getName();
  
  public String getSKUNumber();
  
  public String getUUID();
  
  public String getVendor();
  
  public String getVersion();
  
  public int getWarrantyDuration();
  
  public java.util.Optional<java.time.OffsetDateTime> getWarrantyStartDate();
  
  
  public static void query(CIMV2Wmi wmi, Consumer<Win32_ComputerSystemProduct> client){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    if( client==null )throw new IllegalArgumentException("client==null");
    wmi.instancesOf("Win32_ComputerSystemProduct", obj -> client.accept(new Win32_ComputerSystemProductImpl(obj, wmi)) );
  }
  
  public static List<Win32_ComputerSystemProduct> query(CIMV2Wmi wmi){
    if( wmi==null )throw new IllegalArgumentException("wmi==null");
    ArrayList<Win32_ComputerSystemProduct> list = new ArrayList<>();
    query(wmi,list::add);
    return list;
  }
}
