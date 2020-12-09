package xyz.cofe.win.wmi.gen;

import org.junit.jupiter.api.Test;
import xyz.cofe.win.WinApi;
import xyz.cofe.win.wmi.WmiObj;

public class GenerateTest {
    @Test
    public void wmi1(){
        WinApi.api(winApi -> { winApi.wmi( wmi -> {
            String[] wmiClasses = new String[]{
//                "Win32_LogonSession",
//                "Win32_Account",
//                "Win32_LoggedOnUser"
//                "Win32_Desktop",
//                "Win32_BootConfiguration",
//                "Win32_BaseService",
//                "Win32_ComputerSystem",
//                "Win32_ComputerSystemProduct",
//                "Win32_Environment",
//                "Win32_Group",
//                "Win32_GroupUser",
//                "Win32_OperatingSystem",
//                "Win32_OSRecoveryConfiguration",
//                "Win32_PageFileUsage",
//                "Win32_PageFileSetting",
//                "Win32_ScheduledJob",
//                "Win32_Service",
//                "Win32_Session",
//                "Win32_SessionProcess",
//                "Win32_SessionResource",
//                "Win32_LogicalElement",
//                "Win32_OperatingSystemQFE",
//                "Win32_QuickFixEngineering",
//                "Win32_Share",
//                "Win32_ShareToDirectory",
//                "CIM_Directory",
//                "Win32_StartupCommand",
//                "Win32_SystemAccount",
//                "Win32_SystemProcesses",
//                "Win32_SystemTimeZone",
//                "Win32_TimeZone",
//                "Win32_UserDesktop",
//                "Win32_DependentService"
                "Win32_UserAccount"
            };
            for( String wmiCls : wmiClasses ){
                WmiObj wobj = wmi.getObject(wmiCls);

                TypeGen tg = new TypeGen(wobj);
                tg.setPackage("xyz.cofe.win.wmi.cimv2");
                tg.setNameSpaceItf("CIMV2Wmi");
                tg.generateFiles("target\\wmi-codegen");
            }
        });});
    }
}
