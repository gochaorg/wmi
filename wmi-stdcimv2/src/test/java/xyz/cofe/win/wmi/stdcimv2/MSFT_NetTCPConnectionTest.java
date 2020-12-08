package xyz.cofe.win.wmi.stdcimv2;

import org.junit.jupiter.api.Test;
import xyz.cofe.win.WinApi;

import java.time.format.DateTimeFormatter;

public class MSFT_NetTCPConnectionTest {
    @Test
    public void test01(){
        WinApi.api(api->{
            StdCIMV2Wmi.wmi(api,wmi->{
                System.out.println("MSFT_NetTCPConnection");
                wmi.instancesOf("MSFT_NetTCPConnection", wobj -> {
                    MSFT_NetTCPConnectionImpl conn = new MSFT_NetTCPConnectionImpl(wobj);
                    System.out.println(
                        conn.getLocalAddress()+":"+conn.getLocalPort()+" -> "+
                        conn.getRemoteAddress()+":"+conn.getRemotePort()+" "+
                        "pid="+conn.getOwningProcess()+
                        " "+conn.getState()+
                        " "+conn.getStatusDescriptions()+
                        " "+conn.getOperationalStatus()+
                        " "+conn.getAvailableRequestedStates()
                    );
                });
            });
        });
    }

    @Test
    public void test02(){
        WinApi.api(api->{
            StdCIMV2Wmi.wmi(api,wmi->{
                MSFT_NetTCPConnection.query(wmi, conn->{
                    System.out.println(
                        conn.getLocalAddress()+":"+conn.getLocalPort()+" -> "+
                            conn.getRemoteAddress()+":"+conn.getRemotePort()+" "+
                            "pid="+conn.getOwningProcess()+
                            " "+conn.getState()
                    );
                });
            });
        });
    }
}
