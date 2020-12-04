package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.SafeArray;
import com.jacob.com.Variant;
import xyz.cofe.win.wmi.Wmi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Описывает элемент иерархии наследования
 */
public interface WmiDerivation {
    /**
     * Имя родительского класса
     * @return Имя родительского класса
     */
    String getClazz();

    /**
     * Получает список родительских классов, от ближайшего предка к корню
     * @param ax компонент WMI
     * @param wmi не обязательный параметр
     * @return список родительских классов
     */
    public static List<WmiDerivation> of(ActiveXMethods ax, Wmi wmi){
        Variant vDer = ax.getProperty("Derivation_");
        if( vDer.isNull() )return Collections.emptyList();

        SafeArray saDer = vDer.toSafeArray();
        int saDerFrom = saDer.getLBound();
        int saDerToInc = saDer.getUBound();

        List<WmiDerivation> lDer = new ArrayList<>();
        for( int i=Math.min(saDerFrom,saDerToInc); i<=Math.max(saDerFrom,saDerToInc); i++ ){
            String s = saDer.getString(i);
            WmiDerivation d = new WmiDerivation() {
                @Override
                public String getClazz() {
                    return s;
                }
            };
            lDer.add(d);
        }

        return Collections.unmodifiableList(lDer);
    }

    public static List<WmiDerivation> of(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        return of(ax,null);
    }

    public static List<WmiDerivation> of(ActiveXComponent ax, Wmi wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        return of(ActiveXMethods.of(ax), wmi);
    }

    public static List<WmiDerivation> of(ActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        return of(ActiveXMethods.of(ax), null);
    }

    public static List<WmiDerivation> of(GetActiveXComponent ax, Wmi wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        return of(ax.getActiveXComponent(),wmi);
    }

    public static List<WmiDerivation> of(GetActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        return of(ax.getActiveXComponent(),null);
    }
}
