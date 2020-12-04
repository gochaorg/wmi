package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.util.function.Consumer;

public class SWbemObjectPathImpl implements SWbemObjectPath {
    public SWbemObjectPathImpl(){}

    public SWbemObjectPathImpl(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ax);
    }

    public SWbemObjectPathImpl(GetActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax.getActiveXComponent()));
    }

    private void initProps(ActiveXMethods ax) {
        Variant v = ax.invoke("Path_");
        Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;
        ActiveXComponent ax1 = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;
        ActiveXMethods a = ax1!=null ? ActiveXMethods.of(ax1) : null;
        if( a!=null ){
            configure(obj -> {
                obj.setAuthority(a.invoke("Authority").getString());
                obj.setClazz(a.invoke("Class").getString());
                obj.setDisplayName(a.invoke("DisplayName").getString());
                obj.setClassType(a.invoke("IsClass").getBoolean());
                obj.setSingleton(a.invoke("IsSingleton").getBoolean());
                obj.setLocale(a.invoke("Locale").getString());
                obj.setNamespace(a.invoke("Namespace").getString());
                obj.setParentNamespace(a.invoke("ParentNamespace").getString());
                obj.setPath(a.invoke("Path").getString());
                obj.setRelpath(a.invoke("Relpath").getString());
                obj.setServer(a.invoke("Server").getString());
            });
        }
    }

    //region properties
    //region authority : String
    protected String authority;
    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    //endregion
    //region clazz : String
    protected String clazz;
    @Override
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
    //endregion
    //region displayName : String
    protected String displayName;
    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    //endregion
    //region classType : boolean
    protected boolean IsClass;

    public boolean isClassType() {
        return IsClass;
    }

    public void setClassType(boolean aClass) {
        IsClass = aClass;
    }
    //endregion
    //region singleton : boolean
    protected boolean singleton;
    @Override
    public boolean isSingleton() {
        return singleton;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }
    //endregion
    //region locale : String
    protected String locale;

    @Override
    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
    //endregion
    //region namespace : String
    protected String namespace;

    @Override
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    //endregion
    //region parentNamespace : String
    protected String parentNamespace;

    @Override
    public String getParentNamespace() {
        return parentNamespace;
    }

    public void setParentNamespace(String parentNamespace) {
        this.parentNamespace = parentNamespace;
    }
    //endregion
    //region path : String
    protected String path;

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    //endregion
    //region relpath : String
    protected String relpath;

    @Override
    public String getRelpath() {
        return relpath;
    }

    public void setRelpath(String relpath) {
        this.relpath = relpath;
    }
    //endregion
    //region server : Server
    protected String server;

    @Override
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
    //endregion
    //endregion

    @SuppressWarnings("UnusedReturnValue")
    public SWbemObjectPathImpl configure(Consumer<SWbemObjectPathImpl> conf){
        if( conf==null )throw new IllegalArgumentException("conf==null");
        conf.accept(this);
        return this;
    }
}
