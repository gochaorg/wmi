package xyz.cofe.win.wmi.gen;

import org.junit.jupiter.api.Test;
import xyz.cofe.win.WinApi;
import xyz.cofe.win.wmi.WmiObj;

public class GenWin32ProcTest {
    @Test
    public void test01(){
        WinApi.api(winApi -> {
            winApi.wmi( ".", "ROOT\\StandardCimv2", wmi -> {
                WmiObj wobj = wmi.getObject("MSFT_NetTCPConnection");

                System.out.println("-------------------");

                TypeGen tgen = new TypeGen(wobj);
                System.out.println(tgen.generateIterface().getResult());
            });
        });
    }

    @Test
    public void test02(){
        WinApi.api(winApi -> {
            winApi.wmi( ".", "ROOT\\StandardCimv2", wmi -> {
                WmiObj wobj = wmi.getObject("MSFT_NetTCPConnection");

                System.out.println("-------------------");

                TypeGen tgen = new TypeGen(wobj);
                System.out.println(tgen.generateInterfaceImpl().getResult());
            });
        });
    }
}
