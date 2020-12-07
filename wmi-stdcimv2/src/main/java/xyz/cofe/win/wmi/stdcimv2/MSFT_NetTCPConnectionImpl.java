package xyz.cofe.win.wmi.stdcimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MSFT_NetTCPConnectionImpl extends WmiObjImpl implements MSFT_NetTCPConnection {
    public MSFT_NetTCPConnectionImpl(ActiveXComponent activeXComponent) {
        super(activeXComponent);
    }

    public MSFT_NetTCPConnectionImpl(ActiveXComponent activeXComponent, Wmi wmi) {
        super(activeXComponent, wmi);
    }

    public MSFT_NetTCPConnectionImpl(GetActiveXComponent activeXComponent) {
        super(activeXComponent.getActiveXComponent());
    }

    public MSFT_NetTCPConnectionImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
        super(activeXComponent.getActiveXComponent(), wmi);
    }

    public short getAggregationBehavior(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("AggregationBehavior");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read AggregationBehavior");
        return v.getShort();
    }

    public byte getAppliedSetting(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("AppliedSetting");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read AppliedSetting");
        return v.getByte();
    }

    public List<Integer> getAvailableRequestedStates(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        ArrayList<Integer> list = new ArrayList<>();
        Variant v = ax.getProperty("AvailableRequestedStates");
        if( v==null || v.isNull() )return list;

        SafeArray arr = v.toSafeArray();
        for( int i=arr.getLBound(); i<=arr.getUBound(); i++ ){
            list.add(arr.getInt(i));
        }

        return list;
    }

    public String getCaption(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Caption");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public short getCommunicationStatus(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("CommunicationStatus");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read CommunicationStatus");
        return v.getShort();
    }

    public java.util.Optional<java.time.OffsetDateTime> getCreationTime(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("CreationTime");
        if( v==null || v.isNull() )return Optional.empty();
        return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
    }

    public String getDescription(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Description");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public short getDetailedStatus(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("DetailedStatus");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read DetailedStatus");
        return v.getShort();
    }

    public short getDirectionality(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Directionality");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read Directionality");
        return v.getShort();
    }

    public String getElementName(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("ElementName");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public short getEnabledDefault(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("EnabledDefault");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read EnabledDefault");
        return v.getShort();
    }

    public short getEnabledState(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("EnabledState");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read EnabledState");
        return v.getShort();
    }

    public short getHealthState(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("HealthState");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read HealthState");
        return v.getShort();
    }

    public java.util.Optional<java.time.OffsetDateTime> getInstallDate(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("InstallDate");
        if( v==null || v.isNull() )return Optional.empty();
        return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
    }

    public String getInstanceID(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("InstanceID");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public String getLocalAddress(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("LocalAddress");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public int getLocalPort(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("LocalPort");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read LocalPort");
        return v.getInt();
    }

    public String getName(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Name");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public byte getOffloadState(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("OffloadState");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read OffloadState");
        return v.getByte();
    }

    public short getOperatingStatus(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("OperatingStatus");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read OperatingStatus");
        return v.getShort();
    }

    public List<Integer> getOperationalStatus(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        ArrayList<Integer> list = new ArrayList<>();
        Variant v = ax.getProperty("OperationalStatus");
        if( v==null || v.isNull() )return list;

        SafeArray arr = v.toSafeArray();
        for( int i=arr.getLBound(); i<=arr.getUBound(); i++ ){
            list.add(arr.getInt(i));
        }

        return list;
    }

    public String getOtherEnabledState(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("OtherEnabledState");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public int getOwningProcess(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("OwningProcess");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read OwningProcess");
        return v.getInt();
    }

    public short getPrimaryStatus(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("PrimaryStatus");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read PrimaryStatus");
        return v.getShort();
    }

    public String getRemoteAddress(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("RemoteAddress");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public int getRemotePort(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("RemotePort");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read RemotePort");
        return v.getInt();
    }

    public short getRequestedState(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("RequestedState");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read RequestedState");
        return v.getShort();
    }

    public byte getState(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("State");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read State");
        return v.getByte();
    }

    public String getStatus(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Status");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public List<String> getStatusDescriptions(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        ArrayList<String> list = new ArrayList<>();
        Variant v = ax.getProperty("StatusDescriptions");
        if( v==null || v.isNull() )return list;

        SafeArray arr = v.toSafeArray();
        for( int i=arr.getLBound(); i<=arr.getUBound(); i++ ){
            list.add(arr.getString(i));
        }

        return list;
    }

    public java.util.Optional<java.time.OffsetDateTime> getTimeOfLastStateChange(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("TimeOfLastStateChange");
        if( v==null || v.isNull() )return Optional.empty();
        return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
    }

    public short getTransitioningToState(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("TransitioningToState");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read TransitioningToState");
        return v.getShort();
    }

}

