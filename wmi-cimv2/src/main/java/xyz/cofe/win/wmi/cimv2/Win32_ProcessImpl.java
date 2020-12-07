package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.DateUtilities;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import xyz.cofe.win.activex.GetActiveXComponent;
import xyz.cofe.win.wmi.Wmi;
import xyz.cofe.win.wmi.WmiObj;
import xyz.cofe.win.wmi.WmiObjImpl;

import java.util.Optional;

public class Win32_ProcessImpl extends WmiObjImpl implements Win32_Process {
    public Win32_ProcessImpl(ActiveXComponent activeXComponent) {
        super(activeXComponent);
    }

    public Win32_ProcessImpl(ActiveXComponent activeXComponent, Wmi wmi) {
        super(activeXComponent, wmi);
    }

    public Win32_ProcessImpl(GetActiveXComponent activeXComponent) {
        super(activeXComponent.getActiveXComponent());
    }

    public Win32_ProcessImpl(GetActiveXComponent activeXComponent, Wmi wmi) {
        super(activeXComponent.getActiveXComponent(), wmi);
    }

    //region auto generated
    public String getCaption(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Caption");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public String getCommandLine(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("CommandLine");
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
        if( v==null || v.isNull() )return Optional.empty();
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

    public String getExecutablePath(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("ExecutablePath");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public short getExecutionState(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("ExecutionState");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read ExecutionState");
        return v.getShort();
    }

    public String getHandle(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Handle");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public int getHandleCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("HandleCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read HandleCount");
        return v.getInt();
    }

    public java.util.Optional<java.time.OffsetDateTime> getInstallDate(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("InstallDate");
        if( v==null || v.isNull() )return Optional.empty();
        return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
    }

    public long getKernelModeTime(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("KernelModeTime");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read KernelModeTime");
        return v.getLong();
    }

    public int getMaximumWorkingSetSize(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("MaximumWorkingSetSize");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read MaximumWorkingSetSize");
        return v.getInt();
    }

    public int getMinimumWorkingSetSize(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("MinimumWorkingSetSize");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read MinimumWorkingSetSize");
        return v.getInt();
    }

    public String getName(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Name");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public String getOSCreationClassName(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("OSCreationClassName");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public String getOSName(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("OSName");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public long getOtherOperationCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("OtherOperationCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read OtherOperationCount");
        return v.getLong();
    }

    public long getOtherTransferCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("OtherTransferCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read OtherTransferCount");
        return v.getLong();
    }

    public int getPageFaults(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("PageFaults");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read PageFaults");
        return v.getInt();
    }

    public int getPageFileUsage(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("PageFileUsage");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read PageFileUsage");
        return v.getInt();
    }

    public int getParentProcessId(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("ParentProcessId");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read ParentProcessId");
        return v.getInt();
    }

    public int getPeakPageFileUsage(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("PeakPageFileUsage");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read PeakPageFileUsage");
        return v.getInt();
    }

    public long getPeakVirtualSize(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("PeakVirtualSize");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read PeakVirtualSize");
        return v.getLong();
    }

    public int getPeakWorkingSetSize(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("PeakWorkingSetSize");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read PeakWorkingSetSize");
        return v.getInt();
    }

    public int getPriority(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Priority");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read Priority");
        return v.getInt();
    }

    public long getPrivatePageCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("PrivatePageCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read PrivatePageCount");
        return v.getLong();
    }

    public int getProcessId(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("ProcessId");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read ProcessId");
        return v.getInt();
    }

    public int getQuotaNonPagedPoolUsage(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("QuotaNonPagedPoolUsage");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read QuotaNonPagedPoolUsage");
        return v.getInt();
    }

    public int getQuotaPagedPoolUsage(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("QuotaPagedPoolUsage");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read QuotaPagedPoolUsage");
        return v.getInt();
    }

    public int getQuotaPeakNonPagedPoolUsage(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("QuotaPeakNonPagedPoolUsage");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read QuotaPeakNonPagedPoolUsage");
        return v.getInt();
    }

    public int getQuotaPeakPagedPoolUsage(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("QuotaPeakPagedPoolUsage");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read QuotaPeakPagedPoolUsage");
        return v.getInt();
    }

    public long getReadOperationCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("ReadOperationCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read ReadOperationCount");
        return v.getLong();
    }

    public long getReadTransferCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("ReadTransferCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read ReadTransferCount");
        return v.getLong();
    }

    public int getSessionId(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("SessionId");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read SessionId");
        return v.getInt();
    }

    public String getStatus(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("Status");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public java.util.Optional<java.time.OffsetDateTime> getTerminationDate(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("TerminationDate");
        if( v==null || v.isNull() )return Optional.empty();
        return xyz.cofe.win.wmi.time.ParseTime.parse(v.getString());
    }
    public int getThreadCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("ThreadCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read ThreadCount");
        return v.getInt();
    }

    public long getUserModeTime(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("UserModeTime");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read UserModeTime");
        return v.getLong();
    }

    public long getVirtualSize(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("VirtualSize");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read VirtualSize");
        return v.getLong();
    }

    public String getWindowsVersion(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("WindowsVersion");
        if( v==null || v.isNull() )return null;
        return v.getString();
    }

    public long getWorkingSetSize(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("WorkingSetSize");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read WorkingSetSize");
        return v.getLong();
    }

    public long getWriteOperationCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("WriteOperationCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read WriteOperationCount");
        return v.getLong();
    }

    public long getWriteTransferCount(){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");
        Variant v = ax.getProperty("WriteTransferCount");
        if( v==null || v.isNull() )throw new IllegalStateException("can't read WriteTransferCount");
        return v.getLong();
    }
    //endregion

    public int terminate(int exitCode){
        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        Variant v = ax.invoke("Terminate", new Variant(exitCode));
        return v.getInt();
    }

    public static class CreateResult {
        public CreateResult(int result, int processId) {
            this.result = result;
            this.processId = processId;
        }
        public final int result;
        public int getResult() {
            return result;
        }

        public final int processId;
        public int getProcessId() {
            return processId;
        }
    }

    @SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "OptionalAssignedToNull"})
    public CreateResult create(String commandLine, Optional<String> workDir){
        if( commandLine==null )throw new IllegalArgumentException("commandLine==null");
        if( workDir==null )throw new IllegalArgumentException("workDir==null");

        ActiveXComponent ax = getActiveXComponent();
        if( ax==null )throw new IllegalStateException("activeXComponent is null");

        Variant procId = new Variant(0, true);
        Variant res = ax.invoke("Create",
            new Variant(commandLine),
            workDir.map(Variant::new).orElse(Variant.VT_MISSING),
            Variant.VT_MISSING,
            procId
        );

        return new CreateResult(res.getInt(), procId.getIntRef());
    }

    public static Win32_ProcessImpl clazz( Wmi wmi ){
        if( wmi==null )throw new IllegalArgumentException("wmi==null");
        return new Win32_ProcessImpl(wmi.getObject("Win32_Process"));
    }

    public static Win32_ProcessImpl get( Wmi wmi, int pid ){
        if( wmi==null )throw new IllegalArgumentException("wmi==null");
        WmiObj obj = wmi.getObject("Win32_Process.Handle=\""+pid+"\"");
        return new Win32_ProcessImpl(obj, wmi);
    }
}
