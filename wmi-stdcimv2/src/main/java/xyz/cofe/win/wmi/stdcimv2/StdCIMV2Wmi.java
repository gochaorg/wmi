package xyz.cofe.win.wmi.stdcimv2;

import xyz.cofe.win.WinApi;
import xyz.cofe.win.wmi.Wmi;

import java.util.function.Consumer;

public interface StdCIMV2Wmi extends Wmi {
    public static final String NAMESPACE="ROOT\\StandardCimv2";

    public static void wmi(WinApi winApi, Consumer<StdCIMV2WmiImpl> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( ".", NAMESPACE, w -> {
            client.accept(new StdCIMV2WmiImpl(w));
        });
    }
    public static void wmi(WinApi winApi, String host, Consumer<StdCIMV2WmiImpl> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( host==null )throw new IllegalArgumentException("host==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( host, NAMESPACE, w -> {
            client.accept(new StdCIMV2WmiImpl(w));
        });
    }
    public static void wmi(WinApi winApi, String host, String user, String password,
                           Consumer<StdCIMV2WmiImpl> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( host==null )throw new IllegalArgumentException("host==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( host, NAMESPACE, user, password, w -> {
            client.accept(new StdCIMV2WmiImpl(w));
        });
    }
    public static void wmi(WinApi winApi, String host, String user, String password,
                           String locale, Consumer<StdCIMV2WmiImpl> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( host==null )throw new IllegalArgumentException("host==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( locale==null )throw new IllegalArgumentException("locale==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( host, NAMESPACE, user, password, locale, w -> {
            client.accept(new StdCIMV2WmiImpl(w));
        });
    }
    public static void wmi(WinApi winApi, String host, String user, String password,
                           String locale, String authority, Consumer<StdCIMV2WmiImpl> client){
        if( winApi==null )throw new IllegalArgumentException("winApi==null");
        if( host==null )throw new IllegalArgumentException("host==null");
        if( user==null )throw new IllegalArgumentException("user==null");
        if( password==null )throw new IllegalArgumentException("password==null");
        if( locale==null )throw new IllegalArgumentException("locale==null");
        if( authority==null )throw new IllegalArgumentException("authority==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        winApi.wmi( host, NAMESPACE, user, password, locale, authority, w -> {
            client.accept(new StdCIMV2WmiImpl(w));
        });
    }
}
