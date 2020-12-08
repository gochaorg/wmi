package xyz.cofe.win.wmi.gen;

import org.junit.jupiter.api.Test;
import xyz.cofe.win.WinApi;
import xyz.cofe.win.wmi.WmiObj;

public class GenerateTest {
    @Test
    public void wmi1(){
        WinApi.api(winApi -> { winApi.wmi( wmi -> {
            String[] wmiClasses = new String[]{
                "Win32_LogonSession",
                "Win32_Account",
                "Win32_LoggedOnUser"
            };
            for( String wmiCls : wmiClasses ){
                WmiObj wobj = wmi.getObject(wmiCls);
                TypeGen tg = new TypeGen(wobj);
                tg.setPackage("xyz.cofe.win.wmi.cimv2");
                tg.generateFiles("target\\wmi-codegen");
            }
        });});
    }
}
