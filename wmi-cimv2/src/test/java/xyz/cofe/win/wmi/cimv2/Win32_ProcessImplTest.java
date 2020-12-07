package xyz.cofe.win.wmi.cimv2;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.junit.jupiter.api.Test;
import xyz.cofe.win.WinApi;
import xyz.cofe.win.wmi.WmiObj;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Win32_ProcessImplTest {
    @Test
    public void test01(){
        WinApi.api(api->{
            api.wmi(wmi -> {
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSSSSSZZZ");
                wmi.instancesOf("Win32_Process", wproc -> {
                    Win32_ProcessImpl proc = new Win32_ProcessImpl(wproc);
                    System.out.println(
                        "pid="+proc.getProcessId()+
                        " caption="+proc.getCaption()+
                        " created="+proc.getCreationDate()+
                        " ns="+proc.getWmiPath().getNamespace()
                    );
                    System.out.println("  path="+proc.getWmiPath().getPath());
                });
            });
        });
    }

    @Test
    public void create01(){
        WinApi.api(api->{
            api.wmi(wmi->{
                System.out.println("try create notepad.exe");
                Win32_ProcessImpl.CreateResult cr =
                Win32_ProcessImpl.clazz(wmi).create("notepad.exe", Optional.empty());

                System.out.println("create result:");
                System.out.println("  code="+cr.getResult());
                System.out.println("  pid="+cr.getProcessId());

                if(cr.getResult()==0){
                    System.out.println("created");
                    Win32_ProcessImpl prc = Win32_ProcessImpl.get(wmi, cr.getProcessId());
                    System.out.println(prc.getCommandLine());

                    System.out.println("terminate");
                    prc.terminate(1);
                }
            });
        });
    }

    @Test
    public void create02(){
        WinApi.api(api->{
            api.wmi(wmi->{
                System.out.println("try create notepad.exe");
                Win32_ProcessImpl wclz = Win32_ProcessImpl.clazz(wmi);
                Win32_ProcessImpl.CreateResult cr =
                wclz.create("notepad111233.exe", Optional.empty());

                System.out.println("create result:");
                System.out.println("  code="+cr.getResult());
                System.out.println("  pid="+cr.getProcessId());

                if(cr.getResult()==0){
                    System.out.println("created");
                    Win32_ProcessImpl prc = Win32_ProcessImpl.get(wmi, cr.getProcessId());
                    System.out.println(prc.getCommandLine());

                    System.out.println("terminate");
                    prc.terminate(1);
                }else{
                    Variant v = Dispatch.call(wclz.getActiveXComponent(),"GetLastErrorMsg");
                    System.out.println(v);
                }
            });
        });
    }

    @Test
    public void create03(){
        WinApi.api(api->{
            api.wmi(wmi->{
                System.out.println("try create notepad.exe");
                Win32_ProcessImpl.CreateResult cr =
                Win32_ProcessImpl.clazz(wmi).create("cmd /c dir", Optional.of("C:\\"));

                System.out.println("create result:");
                System.out.println("  code="+cr.getResult());
                System.out.println("  pid="+cr.getProcessId());

                try{
                    Thread.sleep(1000L*5L);
                } catch( InterruptedException e ) {
                    e.printStackTrace();
                }

                if(cr.getResult()==0){
                    System.out.println("created");
                    Win32_ProcessImpl prc = Win32_ProcessImpl.get(wmi, cr.getProcessId());
                    System.out.println(prc.getCommandLine());

                    System.out.println("terminate");
                    prc.terminate(1);
                }
            });
        });
    }
}
