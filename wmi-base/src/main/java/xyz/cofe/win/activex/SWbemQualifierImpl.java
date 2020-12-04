package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

import java.util.function.Consumer;

public class SWbemQualifierImpl implements SWbemQualifier {
    public SWbemQualifierImpl(){}
    public SWbemQualifierImpl(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ax);
    }
    public SWbemQualifierImpl(ActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax));
    }
    public SWbemQualifierImpl(GetActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax.getActiveXComponent()));
    }

    protected void initProps(ActiveXMethods ax){
        variant = ax.getProperty("Value");
        propagatesToSubClass = ax.getProperty("PropagatesToSubClass").getBoolean();
        propagatesToInstance = ax.getProperty("PropagatesToInstance").getBoolean();
        name = ax.getProperty("Name").getString();
        overridable = ax.getProperty("IsOverridable").getBoolean();
        local = ax.getProperty("IsLocal").getBoolean();
        amended = ax.getProperty("IsAmended").getBoolean();
    }

    public SWbemQualifierImpl configure(Consumer<SWbemQualifierImpl> conf){
        if( conf==null )throw new IllegalArgumentException("conf==null");
        conf.accept(this);
        return this;
    }

    //region variant
    protected Variant variant;
    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }
    //endregion
    //region propagatesToSubClass
    protected boolean propagatesToSubClass;
    public boolean isPropagatesToSubClass() {
        return propagatesToSubClass;
    }

    public void setPropagatesToSubClass(boolean propagatesToSubClass) {
        this.propagatesToSubClass = propagatesToSubClass;
    }
    //endregion
    //region propagatesToInstance
    protected boolean propagatesToInstance;
    public boolean isPropagatesToInstance() {
        return propagatesToInstance;
    }

    public void setPropagatesToInstance(boolean propagatesToInstance) {
        this.propagatesToInstance = propagatesToInstance;
    }
    //endregion
    //region name
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
    //region overridable
    protected boolean overridable;

    public boolean isOverridable() {
        return overridable;
    }

    public void setOverridable(boolean overridable) {
        this.overridable = overridable;
    }
    //endregion
    //region local
    protected boolean local;

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }
    //endregion
    //region amended
    protected boolean amended;

    public boolean isAmended() {
        return amended;
    }

    public void setAmended(boolean amended) {
        this.amended = amended;
    }
    //endregion
}
