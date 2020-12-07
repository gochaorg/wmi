package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.WmiObj;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface Win32_Process extends WmiObj {
    //region auto generated
    public String getCaption();

    public String getCommandLine();

    public String getCreationClassName();

    public java.util.Optional<java.time.OffsetDateTime> getCreationDate();

    public String getCSCreationClassName();

    public String getCSName();

    public String getDescription();

    public String getExecutablePath();

    public short getExecutionState();

    public String getHandle();

    public int getHandleCount();

    public java.util.Optional<java.time.OffsetDateTime> getInstallDate();

    public long getKernelModeTime();

    public int getMaximumWorkingSetSize();

    public int getMinimumWorkingSetSize();

    public String getName();

    public String getOSCreationClassName();

    public String getOSName();

    public long getOtherOperationCount();

    public long getOtherTransferCount();

    public int getPageFaults();

    public int getPageFileUsage();

    public int getParentProcessId();

    public int getPeakPageFileUsage();

    public long getPeakVirtualSize();

    public int getPeakWorkingSetSize();

    public int getPriority();

    public long getPrivatePageCount();

    public int getProcessId();

    public int getQuotaNonPagedPoolUsage();

    public int getQuotaPagedPoolUsage();

    public int getQuotaPeakNonPagedPoolUsage();

    public int getQuotaPeakPagedPoolUsage();

    public long getReadOperationCount();

    public long getReadTransferCount();

    public int getSessionId();

    public String getStatus();

    public java.util.Optional<java.time.OffsetDateTime> getTerminationDate();

    public int getThreadCount();

    public long getUserModeTime();

    public long getVirtualSize();

    public String getWindowsVersion();

    public long getWorkingSetSize();

    public long getWriteOperationCount();

    public long getWriteTransferCount();
    //endregion

    public static Win32_Process get(CIMV2Wmi wmi, int pid){
        if( wmi==null )throw new IllegalArgumentException("wmi==null");
        return Win32_ProcessImpl.get(wmi, pid);
    }

    public int terminate(int exitCode);

    public static void query(CIMV2Wmi wmi, Consumer<Win32_Process> client){
        if( wmi==null )throw new IllegalArgumentException("wmi==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        wmi.subclassesOf("Win32_Process", obj -> client.accept(new Win32_ProcessImpl(obj)) );
    }

    public static List<Win32_Process> query(CIMV2Wmi wmi){
        if( wmi==null )throw new IllegalArgumentException("wmi==null");
        ArrayList<Win32_Process> list = new ArrayList<>();
        query(wmi,list::add);
        return list;
    }
}
