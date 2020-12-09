package xyz.cofe.win.wmi.cimv2;

import org.junit.jupiter.api.Test;
import xyz.cofe.win.WinApi;

public class Win32_LoggedOnUser_Test {
    @Test
    public void test01(){
        WinApi.api(winApi -> {
           CIMV2Wmi.wmi(winApi, wmi -> {
               Win32_LoggedOnUser.query(wmi, lUsr -> {
                   System.out.println("logged");
                   lUsr.getAntecedent().ifPresent(usr->{
                       System.out.println("  user:");
                       System.out.println("    domain="+usr.getDomain());
                       System.out.println("    name="+usr.getName());
                       System.out.println("    caption="+usr.getCaption());
                       System.out.println("    SID="+usr.getSID());
                       System.out.println("    status="+usr.getStatus());
                       System.out.println("    localAccount="+usr.getLocalAccount());
                   });
                   lUsr.getDependent().ifPresent(ses->{
                       System.out.println("  session:");
                       System.out.println("    logonId="+ses.getLogonId());
                       System.out.println("    authenticationPackage="+ses.getAuthenticationPackage());
                       System.out.println("    caption="+ses.getCaption());
                       System.out.println("    description="+ses.getDescription());
                       System.out.println("    name="+ses.getName());
                       System.out.println("    status="+ses.getStatus());
                       System.out.println("    logonType="+ses.getLogonType());
                       ses.getStartTime().ifPresent(t -> System.out.println("    startTime="+t));
                   });
               });
           });
        });
    }
}
