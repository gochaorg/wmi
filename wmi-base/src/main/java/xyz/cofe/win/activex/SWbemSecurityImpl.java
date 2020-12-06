package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SWbemSecurityImpl implements SWbemSecurity {
    public SWbemSecurityImpl(){
    }
    public SWbemSecurityImpl(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        init(ax);
    }
    protected void init(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        authenticationLevel = ax.getProperty("AuthenticationLevel").getInt();
        impersonationLevel = ax.getProperty("ImpersonationLevel").getInt();
        Variant vPrivileges = ax.getProperty("Privileges");
        Dispatch dPrivileges = vPrivileges!=null && !vPrivileges.isNull() ?
            vPrivileges.toDispatch() : null;
        EnumVariant enPrivileges = dPrivileges!=null && dPrivileges.m_pDispatch!=0 ?
            new EnumVariant(dPrivileges) : null;

        List<SWbemPrivilege> privs = new ArrayList<>();
        while( enPrivileges!=null && enPrivileges.hasMoreElements() ){
            Variant evPrivilege = enPrivileges.nextElement();
            //noinspection ConstantConditions
            Dispatch edPrivileges = enPrivileges!=null && !evPrivilege.isNull() ?
                evPrivilege.toDispatch() : null;
            ActiveXComponent axPrivilege = edPrivileges!=null && edPrivileges.m_pDispatch!=0 ?
                new ActiveXComponent(edPrivileges) : null;
            if( axPrivilege!=null ){
                SWbemPrivilegeImpl priv = new SWbemPrivilegeImpl(axPrivilege);
                privs.add(priv);
            }
        }

        privileges = new SWbemPrivilegeSetImpl(privs);
    }
    public static SWbemSecurityImpl fromOwner(ActiveXComponent axOwner){
        if( axOwner==null )throw new IllegalArgumentException("axOwner==null");
        return fromOwner(ActiveXMethods.of(axOwner));
    }
    public static SWbemSecurityImpl fromOwner(GetActiveXComponent axOwner){
        if( axOwner==null )throw new IllegalArgumentException("axOwner==null");
        return fromOwner(ActiveXMethods.of(axOwner.getActiveXComponent()));
    }
    public static SWbemSecurityImpl fromOwner(ActiveXMethods axOwner){
        if( axOwner==null )throw new IllegalArgumentException("axOwner==null");

        Variant vSecur = axOwner.getProperty("Security_");
        Dispatch dSecur = vSecur!=null && !vSecur.isNull() ?
            vSecur.toDispatch() : null;
        ActiveXComponent ax = dSecur!=null && dSecur.m_pDispatch!=0 ?
            new ActiveXComponent(dSecur) : null;
        ActiveXMethods am = ax!=null ?
            ActiveXMethods.of(ax) : null;
        if( am==null ){
            throw new RuntimeException("can't create SWbemSecurityImpl");
        }
        SWbemSecurityImpl inst = new SWbemSecurityImpl();
        inst.init(am);
        return inst;
    }
    //region configure()
    public SWbemSecurityImpl configure(Consumer<SWbemSecurityImpl> conf){
        if( conf==null )throw new IllegalArgumentException("conf==null");
        conf.accept(this);
        return this;
    }
    //endregion
    //region authenticationLevel
    protected int authenticationLevel;

    public int getAuthenticationLevel() {
        return authenticationLevel;
    }

    public void setAuthenticationLevel(int authenticationLevel) {
        this.authenticationLevel = authenticationLevel;
    }
    //endregion
    //region impersonationLevel
    protected int impersonationLevel;

    public int getImpersonationLevel() {
        return impersonationLevel;
    }

    public void setImpersonationLevel(int impersonationLevel) {
        this.impersonationLevel = impersonationLevel;
    }
    //endregion
    //region privileges
    protected SWbemPrivilegeSet privileges;

    public SWbemPrivilegeSet getPrivileges() {
        return privileges;
    }

    public void setPrivileges(SWbemPrivilegeSet privileges) {
        this.privileges = privileges;
    }
    //endregion
}
