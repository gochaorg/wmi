package xyz.cofe.win.activex;

import com.jacob.com.Variant;
import xyz.cofe.win.wmi.Wmi;
import xyz.cofe.win.wmi.WmiObj;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class SWbemPropertyImpl implements SWbemProperty {
    public SWbemPropertyImpl(){
    }

    public SWbemPropertyImpl(ActiveXMethods ax, Wmi wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        configure(p -> {
            p.setName(ax.invoke("Name").getString());
            p.setLocal(ax.invoke("IsLocal").getBoolean());
            p.setArray(ax.invoke("IsArray").getBoolean());

            int iType = ax.invoke("CIMType").getInt();
            AtomicReference<WbemCIMType> ctype = new AtomicReference<>(null);
            Arrays.stream(WbemCIMType.values()).filter(v->v.code==iType).findFirst().ifPresent(ctype::set);
            p.setCIMType(ctype.get());

            p.setOrigin(ax.invoke("Origin").getString());

            Variant value = ax.invoke("Value");
            p.setVariant(value);
            p.wmi = wmi;
        });
    }

    public SWbemPropertyImpl(ActiveXMethods ax){
        this(ax,null);
    }

    public SWbemPropertyImpl configure(Consumer<SWbemPropertyImpl> conf){
        if( conf==null )throw new IllegalArgumentException("conf==null");
        conf.accept(this);
        return this;
    }

    //region name
    protected String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
    //region local
    protected boolean local;

    @Override
    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }
    //endregion
    //region array
    protected boolean array;

    @Override
    public boolean isArray() {
        return array;
    }

    public void setArray(boolean array) {
        this.array = array;
    }
    //endregion
    //region CIMType
    protected WbemCIMType cimtype;

    @Override
    public WbemCIMType getCIMType() {
        return cimtype;
    }

    public void setCIMType(WbemCIMType type){
        cimtype = type;
    }
    //endregion
    //region origin
    protected String origin;

    @Override
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    //endregion

    protected Variant variant;

    @Override
    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    protected Wmi wmi;

    public Optional<WmiObj> getReference(){
        Wmi wmi1 = wmi;
        Variant v1 = variant;
        if( wmi1!=null && v1!=null && !v1.isNull() ){
            return Optional.of(wmi1.getObject(v1.toString()));
        }
        return Optional.empty();
    }
}
