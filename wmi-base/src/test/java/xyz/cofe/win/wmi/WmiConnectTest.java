package xyz.cofe.win.wmi;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.SafeArray;
import com.jacob.com.Variant;
import org.junit.jupiter.api.Test;
import xyz.cofe.win.WinApi;
import xyz.cofe.win.activex.ActiveXMethods;
import xyz.cofe.win.activex.SWbemProperty;
import xyz.cofe.win.activex.SWbemPropertyImpl;
import xyz.cofe.win.activex.WmiDerivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WmiConnectTest {
    @Test
    public void test01(){
        WinApi.api(winApi -> {
            winApi.wmi( wmi -> {
                System.out.println("connected");
                AtomicInteger cnt = new AtomicInteger(0);
//                wmi.execQuery("SELECT * FROM Win32_SystemDesktop", obj -> {
                wmi.execQuery("SELECT * FROM Win32_Process", obj -> {
                    int c = cnt.incrementAndGet();
                    if( c>2 )return;


                    System.out.println("path:");
                    System.out.println("  "+obj.getWmiPath().getPath());
                    System.out.println("  "+obj.getWmiPath().getClazz());
                    System.out.println("  "+obj.getWmiPath().getNamespace());

                    System.out.println("properties:");
                    obj.getWmiProperties().forEach( prop ->{
                        System.out.println("  "+prop.getName()+" "+prop.getCIMType()+" "+prop.getVariant());
                    });

                    System.out.println("methods:");
                    obj.getWmiMethods().forEach( meth->{
                        System.out.print("  ");
                        System.out.println(meth.getName());
                        if( meth.getInParameters().size()>0 ){
                            System.out.print("  ");
                            System.out.println("input:");
                            meth.getInParameters().forEach( p -> {
                                System.out.print("    ");
                                System.out.println(
                                    p.getName()+":"+p.getCIMType()+
                                        " array="+p.isArray()+
                                        (
                                        p.getReference().map(
                                            m->" ref="+m.getWmiPath().getClazz()
                                        ).orElse("")
                                    )
                                );
                            });
                        }
                        if( meth.getOutParameters().size()>0 ){
                            System.out.print("  ");
                            System.out.println("output:");
                            meth.getOutParameters().forEach( p -> {
                                System.out.print("    ");
                                System.out.println(
                                    p.getName()+":"+p.getCIMType()+
                                        " array="+p.isArray()+
                                        (
                                        p.getReference().map(
                                            m-> " ref="+ m.getWmiPath().getClazz()
                                        ).orElse("")
                                    )
                                );
                            });
                        }
                    });
                });
            });
        });
    }

    @Test
    public void test02(){
        WinApi.api(winApi -> {
            winApi.wmi( wmi -> {
                AtomicInteger cnt = new AtomicInteger(0);
                wmi.execQuery( "SELECT * FROM meta_class WHERE __CLASS = 'Win32_Process'", obj -> {
                    if( cnt.incrementAndGet()<2 ){
                        System.out.println(".......");
                        ActiveXComponent ax = obj.getActiveXComponent();

                        obj.getWmiDerivation()
                            .stream().map(WmiDerivation::getClazz)
                            .forEach(System.out::println);

                        System.out.println("methods:");
                        EnumVariant enMethods = new EnumVariant(ax.invoke("Methods_").toDispatch());

                        while( enMethods.hasMoreElements() ){
                            Dispatch dispMeth = enMethods.nextElement().toDispatch();
                            //System.out.println("meth disp "+dispMeth.m_pDispatch);

                            ActiveXComponent aMeth = new ActiveXComponent(dispMeth);
                            System.out.println("method "+aMeth.getProperty("Name").getString());

                            Variant vInParams = aMeth.getProperty("InParameters");
                            //System.out.println(vInParams);

                            Dispatch dispInParams = vInParams.toDispatch();
                            //System.out.println("dispInParams "+dispInParams.m_pDispatch);
                            if( dispInParams.m_pDispatch!=0 ){
                                System.out.println("  InParameters");
                                ActiveXComponent aInParams = new ActiveXComponent(dispInParams);
                                Variant vParamsProps = aInParams.getProperty("Properties_");
                                //System.out.println(vParamsProps);

                                Dispatch dispParamsProps = vParamsProps.toDispatch();
                                if( dispParamsProps.m_pDispatch!=0 ){
                                    EnumVariant enParam = new EnumVariant(dispParamsProps);
                                    while( enParam.hasMoreElements() ){
                                        Dispatch dispParam = enParam.nextElement().toDispatch();
                                        if( dispParam.m_pDispatch!=0 ){
                                            ActiveXComponent aParam = new ActiveXComponent(dispParam);
                                            SWbemProperty prop = new SWbemPropertyImpl(ActiveXMethods.of(aParam));
                                            System.out.println("    "+prop.getName()+":"+prop.getCIMType());
                                        }
                                    }
                                }
                            }

                            Variant vOutParams = aMeth.getProperty("OutParameters");
                            Dispatch dOutParams = vOutParams.toDispatch();
                            if( dOutParams.m_pDispatch!=0 ){
                                System.out.println("  OutParameters");
                                ActiveXComponent aOutParams = new ActiveXComponent(dOutParams);

                                Variant vOutParamsProps = aOutParams.getProperty("Properties_");
                                Dispatch dOutParamsProps = vOutParamsProps.toDispatch();
                                if( dOutParamsProps.m_pDispatch!=0 ){
                                    EnumVariant enOutParam = new EnumVariant(dOutParamsProps);
                                    while( enOutParam.hasMoreElements() ){
                                        Dispatch dOutParam = enOutParam.nextElement().toDispatch();
                                        if( dOutParam.m_pDispatch!=0 ){
                                            ActiveXComponent aOutParam = new ActiveXComponent(dOutParam);
                                            SWbemProperty prop = new SWbemPropertyImpl(ActiveXMethods.of(aOutParam));
                                            System.out.println("    "+prop.getName()+":"+prop.getCIMType());
                                        }
                                    }
                                }else{
                                    System.out.println("    #none");
                                }
                            }
                        }
                    }
                });
            });
        });
    }
}
