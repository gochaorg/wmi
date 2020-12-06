package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;

import java.util.function.Consumer;

public class SWbemPrivilegeImpl implements SWbemPrivilege {
    public SWbemPrivilegeImpl(){}
    public SWbemPrivilegeImpl configure(Consumer<SWbemPrivilegeImpl> conf){
        if( conf==null )throw new IllegalArgumentException("conf==null");
        conf.accept(this);
        return this;
    }
    public SWbemPrivilegeImpl(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        init(ax);
    }
    public SWbemPrivilegeImpl(ActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        init(ActiveXMethods.of(ax));
    }
    public SWbemPrivilegeImpl(GetActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        init(ActiveXMethods.of(ax.getActiveXComponent()));
    }
    protected void init(ActiveXMethods ax){
        displayName = ax.getProperty("DisplayName").getString();
        identifier = ax.getProperty("Identifier").getInt();
        enabled = ax.getProperty("IsEnabled").getBoolean();
        name = ax.getProperty("Name").getString();
    }

    //region displayName
    protected String displayName;

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    //endregion
    //region identifier
    protected int identifier;
    @Override
    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
    //endregion
    //region enabled
    protected boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    //endregion
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
}
