package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.WinApi;
import xyz.cofe.win.wmi.Wmi;

import java.util.function.Consumer;

/**
 * root\cimv2
 */
public interface CIMV2Wmi extends Wmi {
    public static final String NAMESPACE="root\\cimv2";

    public static void wmi(WinApi winApi, Consumer<CIMV2Wmi> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( w -> {
            client.accept(new CIMV2WmiImpl(w));
        });
    }
    public static void wmi(WinApi winApi, String host, Consumer<CIMV2Wmi> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( host==null )throw new IllegalArgumentException("host==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( host, w -> {
            client.accept(new CIMV2WmiImpl(w));
        });
    }
    public static void wmi(WinApi winApi, String host, String user, String password, Consumer<CIMV2Wmi> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( host==null )throw new IllegalArgumentException("host==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( host, NAMESPACE, user, password, w -> {
            client.accept(new CIMV2WmiImpl(w));
        });
    }
    public static void wmi(WinApi winApi, String host, String user, String password, String locale, Consumer<CIMV2Wmi> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( host==null )throw new IllegalArgumentException("host==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( locale==null )throw new IllegalArgumentException("locale==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( host, NAMESPACE, user, password, locale, w -> {
            client.accept(new CIMV2WmiImpl(w));
        });
    }
    public static void wmi(WinApi winApi, String host, String user, String password, String locale, String authority, Consumer<CIMV2Wmi> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( host==null )throw new IllegalArgumentException("host==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( locale==null )throw new IllegalArgumentException("locale==null");
        if( authority==null )throw new IllegalArgumentException("authority==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( host, NAMESPACE, user, password, locale, authority, w -> {
            client.accept(new CIMV2WmiImpl(w));
        });
    }
}
