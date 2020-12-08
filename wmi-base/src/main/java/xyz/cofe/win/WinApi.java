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

    /**
     * тоже самое api()
     * @param client клиент
     * @see #api(Consumer)
     */
    public static void run(Consumer<WinApi> client){
        api(client);
    }

    /**
     * тоже самое api()
     * @param client клиент
     * @see #api(Function)
     */
    public static <R> R query(Function<WinApi,R> client){
        return api(client);
    }

    /**
     * Соединение с wmi по умолчанию
     * ,более детально см {@link #wmi(String, String, String, String, String, String, Consumer)}
     * @param wmi клиентский код
     */
    public void wmi( Consumer<Wmi> wmi ){
        wmi0(".", null, null, null, null, null, wmi );
    }

    /**
     * Соединение с wmi по умолчанию,
     * более детально см {@link #wmi(String, String, String, String, String, String, Consumer)}
     * @param host хост
     * @param client клиентский код
     */
    public void wmi( String host, Consumer<Wmi> client ){
        if( host==null )throw new IllegalArgumentException("host==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        wmi0(host,null,null,null,null,null,client);
    }

    /**
     * Соединение с wmi по умолчанию
     * ,более детально см {@link #wmi(String, String, String, String, String, String, Consumer)}
     * @param host хост
     * @param namespace пространство
     * @param client клиентский код
     */
    public void wmi( String host, String namespace, Consumer<Wmi> client ){
        if( host==null )throw new IllegalArgumentException("host==null");
        if( namespace==null )throw new IllegalArgumentException("namespace==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        wmi0(host,namespace,null,null,null,null,client);
    }

    /**
     * Соединение с wmi по умолчанию,
     * более детально см {@link #wmi(String, String, String, String, String, String, Consumer)}
     * @param host хост
     * @param namespace пространство
     * @param user пользователь
     * @param password пароль
     * @param client клиентский код
     */
    public void wmi( String host, String namespace, String user, String password, Consumer<Wmi> client ){
        if( host==null )throw new IllegalArgumentException("host==null");
        if( namespace==null )throw new IllegalArgumentException("namespace==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        wmi0(host,namespace,user,password,null,null,client);
    }

    /**
     * Соединение с wmi по умолчанию,
     * более детально см {@link #wmi(String, String, String, String, String, String, Consumer)}
     * @param host хост
     * @param namespace пространство
     * @param user пользователь
     * @param password пароль
     * @param locale локаль
     * @param client клиентский код
     */
    public void wmi( String host, String namespace, String user, String password, String locale, Consumer<Wmi> client ){
        if( host==null )throw new IllegalArgumentException("host==null");
        if( namespace==null )throw new IllegalArgumentException("namespace==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( locale==null )throw new IllegalArgumentException("locale==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        wmi0(host,namespace,user,password,locale,null,client);
    }

    /**
     * Работа с wmi api.
     *
     * <p>
     * Error codes
     *
     * <p>
     * After the completion of the ConnectServer method, the Err object may contain one of the error codes in the following list.
     *
     * <ul>
     * <li>
     * wbemErrAccessDenied - 2147749891 (0x80041003)
     *
     * <p>
     *     The current or specified user name and password were not valid or authorized to make the connection.
     *
     * <li>
     * wbemErrFailed - 2147749889 (0x80041001)
     *
     * <p>
     *     Unspecified error.
     *
     * <li>
     * wbemErrInvalidNamespace - 2147749902 (0x8004100E)
     *
     * <p>
     *     The specified namespace did not exist on the server.
     *
     * <li>
     * wbemErrInvalidParameter - 2147749896 (0x80041008)
     *
     * <p>
     *     An invalid parameter was specified, or the namespace could not be parsed.
     *
     * <li>
     * wbemErrOutOfMemory - 2147749894 (0x80041006)
     *
     * <p>
     *     Not enough memory to complete the operation.
     *
     * <li>
     * wbemErrTransportFailure - 2147749909
     *
     * <p>
     *     A networking error occurred, preventing normal operation.
     * </ul>
     * @param host хост, '.' - текущий хост.
     *             <p>
     *             Computer name to which you are connecting.
     *             If the remote computer is in a different domain than the user account under which you log in,
     *             then use the fully qualified computer name.
     *             If you do not provide this parameter, the call defaults to the local computer.
     *
     *             <p>
     *             Example: <code>server1.network.fabrikam</code>
     *
     *             <p>
     *             You also can use an IP address in this parameter.
     *             If the IP address is in IPv6 format, the target computer must be running IPv6.
     *             An address in IPv4 looks like 111.222.333.444
     *
     *             <p>
     *             An IP address in IPv6 format looks like 2010:836B:4179::836B:4179
     *
     *             <p>
     *             For more information on DNS and IPv4, see the Remarks section.
     * @param namespace пространство имен wmi:
     * <ul>
     *     <li> 'ROOT\StandardCimv2' см <a href="https://docs.microsoft.com/en-us/previous-versions/windows/desktop/nettcpipprov/msft-nettcpconnection">MSFT_NetTCPConnection</a>
     *     <li> 'root\CIMV2' см <a href="https://docs.microsoft.com/en-us/windows/win32/cimwin32prov/win32-provider">Win32 Provider</a>
     * </ul>
     *
     *                  String that specifies the namespace to which you log on. For example, to log on to the root\default namespace, use root\default. If you do not specify this parameter, it defaults to the namespace that is configured as the default namespace for scripting. For more information, see Creating a WMI Application or Script.
     *             <p>
     *                  Example: "root\CIMV2"
     *
     * @param user  User name to use to connect.
     *
     *             <p>
     *              The string can be in the form of either a user name or a Domain\Username.
     *
     *             <p>
     *              Leave this parameter blank to use the current security context.
     *
     *             <p>
     *              The strUser parameter should only be used with connections to remote WMI servers.
     *
     *             <p>
     *              If you attempt to specify strUser for a local WMI connection,
     *              the connection attempt fails.
     *
     *             <p>
     *              If Kerberos authentication is in use, then the username and password that is specified
     *              in strUser and strPassword cannot be intercepted on a network.
     *
     *             <p>
     *              You can use the UPN format to specify the strUser.
     *
     *             <p>
     *              Example: "DomainName\UserName"
     *
     *             <p>
     *              <b>Note</b>
     *
     *             <p>
     *              If a domain is specified in strAuthority, then the domain must not be specified here.
     *              Specifying the domain in both parameters results in an Invalid Parameter error.
     *
     * @param password
     *              String that specifies the password to use when attempting to connect.
     *              Leave the parameter blank to use the current security context.
     *
     *              The strPassword parameter should only be used with connections to remote WMI servers.
     *
     *              If you attempt to specify strPassword for a local WMI connection, the connection attempt fails.
     *
     *              If Kerberos authentication is in use then the username and password that is specified
     *              in strUser and strPassword cannot be intercepted on the network.
     *
     * @param authority
     *              String that specifies the localization code.
     *
     *             <p>
     *              If you want to use the current locale, leave it blank.
     *
     *
     *             <p>
     *              If not blank, this parameter must be a string that indicates
     *              the desired locale where information must be retrieved.
     *
     *
     *             <p>
     *              For Microsoft locale identifiers, the format of the string is "MS_xxxx",
     *              where xxxx is a string in the hexadecimal form that indicates the LCID.
     *
     *
     *             <p>
     *              For example, American English would appear as "MS_409".
     *
     *             <p>
     *              strAuthority [in, optional]
     *
     *             <p>
     *              ""
     *
     *             <p>
     *              This parameter is optional. However, if it is specified, only Kerberos or NTLMDomain can be used.
     *
     *
     *             <p>
     *              <b>Kerberos:</b>
     *
     *             <p>
     *              If the strAuthority parameter begins with the string "Kerberos:",
     *              then Kerberos authentication is used and this parameter should contain a Kerberos principal name.
     *
     *             <p>
     *              The Kerberos principal name is specified as Kerberos:domain,
     *              such as Kerberos:fabrikam where fabrikam is the server to which you are attempting to connect.
     *
     *             <p>
     *              Example: "Kerberos:DOMAIN"
     *
     *             <p>
     *              <b>NTLMDomain:</b>
     *              To use NT Lan Manager (NTLM) authentication, you must specify it as NTLMDomain:domain,
     *              such as NTLMDomain:fabrikam where fabrikam is the name of the domain.
     *
     *             <p>
     *              Example: "NTLMDomain:DOMAIN"
     *
     *             <p>
     *              If you leave this parameter blank,
     *              the operating system negotiates with COM to determine whether NTLM
     *              or Kerberos authentication is used.
     *
     *             <p>
     *              This parameter should only be used with connections to remote WMI servers.
     *
     *             <p>
     *              If you attempt to set the authority for a local WMI connection, the connection attempt fails.
     *
     *             <p>
     *              <b>Note</b>
     *
     *             <p>
     *              If the domain is specified in strUser, which is the preferred location,
     *              then it must not be specified here.
     *              Specifying the domain in both parameters results
     *              in an Invalid Parameter error.
     * @param client клиентский код
     */
    public void wmi( String host, String namespace, String user, String password, String locale, String authority, Consumer<Wmi> client ){
        if( host==null )throw new IllegalArgumentException("host==null");
        if( namespace==null )throw new IllegalArgumentException("namespace==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( locale==null )throw new IllegalArgumentException("locale==null");
        if( authority==null )throw new IllegalArgumentException("authority==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        wmi0(host,namespace,user,password,locale,authority,client);
    }

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
