package xyz.cofe.win;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;
import xyz.cofe.jacob.JacobDll;
import xyz.cofe.win.activex.Apartment;
import xyz.cofe.win.wmi.Wmi;
import xyz.cofe.win.wmi.WmiBase;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Windows api
 */
public class WinApi {
    static {
        // Инициализация jacob dll
        JacobDll.init();
    }

    private static final WinApi winApi = new WinApi();

    /**
     * Выполнение кода в контексте wmi
     * @param client код
     */
    public static void api(Consumer<WinApi> client ){
        if( client==null )throw new IllegalArgumentException("client == null");
        try{
            Apartment.inApartment(() -> {
                client.accept(winApi);
                return null;
            });
        } catch( Throwable err ){
            System.out.println("catched err "+err);
            err.printStackTrace();
        }
    }

    /**
     * Выполнение кода в контексте wmi
     * @param client код
     */
    @SuppressWarnings("unchecked")
    public static <R> R api(Function<WinApi,R> client ){
        if( client==null )throw new IllegalArgumentException("client == null");
        return (R)Apartment.inApartment( ()-> {
            return client.apply(winApi);
        });
    }

    public void wmi( Consumer<Wmi> wmi ){
        wmi0(".", null, null, null, null, null, wmi );
    }

    /**
     * Работа с wmi api
     * @param host хост, '.' - текущий хост
     * @param namespace пространство имен wmi:
     * <ul>
     *     <li> 'ROOT\StandardCimv2' см <a href="https://docs.microsoft.com/en-us/previous-versions/windows/desktop/nettcpipprov/msft-nettcpconnection">MSFT_NetTCPConnection</a>
     *     <li> 'root\CIMV2' см <a href="https://docs.microsoft.com/en-us/windows/win32/cimwin32prov/win32-provider">Win32 Provider</a>
     * </ul>
     * @param client клиентский код
     */
    protected void wmi0( String host, String namespace, String user, String password, String locale, String authority, Consumer<Wmi> client ){
        if( client==null )throw new IllegalArgumentException("client==null");

        ActiveXComponent locator = new ActiveXComponent("WbemScripting.SWbemLocator");
        ActiveXComponent services = null;
        if( host!=null && namespace!=null && user!=null && password!=null && locale!=null && authority!=null ){
//            services = locator.ConnectServer(host, namespace, user, password, locale, authority);
            Variant vSer = locator.invoke("ConnectServer",
                new Variant(host),
                new Variant(namespace),
                new Variant(user),
                new Variant(password),
                new Variant(locale),
                new Variant(authority)
            );
            if( vSer!=null && !vSer.isNull() ){
                services = new ActiveXComponent(vSer.toDispatch());
            }
        }else if( host!=null && namespace!=null && user!=null && password!=null && locale!=null ){
//            services = locator.ConnectServer(host, namespace, user, password, locale);
            Variant vSer = locator.invoke("ConnectServer",
                new Variant(host),
                new Variant(namespace),
                new Variant(user),
                new Variant(password),
                new Variant(locale)
            );
            if( vSer!=null && !vSer.isNull() ){
                services = new ActiveXComponent(vSer.toDispatch());
            }
        }else if( host!=null && namespace!=null && user!=null && password!=null ){
//            services = locator.ConnectServer(host, namespace, user, password);
            Variant vSer = locator.invoke("ConnectServer",
                new Variant(host),
                new Variant(namespace),
                new Variant(user),
                new Variant(password)
            );
            if( vSer!=null && !vSer.isNull() ){
                services = new ActiveXComponent(vSer.toDispatch());
            }
        }else if( host!=null && namespace!=null && user!=null ){
//            services = locator.ConnectServer(host, namespace, user);
            Variant vSer = locator.invoke("ConnectServer",
                new Variant(host),
                new Variant(namespace),
                new Variant(user)
            );
            if( vSer!=null && !vSer.isNull() ){
                services = new ActiveXComponent(vSer.toDispatch());
            }
        }else if( host!=null && namespace!=null ){
//            services = locator.ConnectServer(host, namespace);
            Variant vSer = locator.invoke("ConnectServer",
                new Variant(host),
                new Variant(namespace)
            );
            if( vSer!=null && !vSer.isNull() ){
                services = new ActiveXComponent(vSer.toDispatch());
            }
        }else if( host!=null ){
//            services = locator.ConnectServer(host);
            Variant vSer = locator.invoke("ConnectServer",
                new Variant(host)
            );
            if( vSer!=null && !vSer.isNull() ){
                services = new ActiveXComponent(vSer.toDispatch());
            }
        }else{
//            services = locator.ConnectServer();
            Variant vSer = locator.invoke("ConnectServer");
            if( vSer!=null && !vSer.isNull() ){
                services = new ActiveXComponent(vSer.toDispatch());
            }
        }

        if( services!=null ){
            WmiBase wmiImpl = new WmiBase(services);
            client.accept(wmiImpl);
        }
    }
}
