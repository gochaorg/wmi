package xyz.cofe.win.wmi;

import org.junit.jupiter.api.Test;
import xyz.cofe.text.out.Output;
import xyz.cofe.win.WinApi;
import xyz.cofe.win.activex.*;

import java.util.List;

public class IntrospectTest {
    private static String indent(int level){
        StringBuilder sb = new StringBuilder();
        if( level>0 ){
            for( int i=0; i<level; i++ ){
                sb.append("  ");
            }
        }
        return sb.toString();
    }

    @Test
    public void introspect01() {
        Output out = new Output();

        out.println("introspect01");
        out.println("======================================");

        WinApi.api(winApi -> {
            winApi.wmi(wmi -> {
                WmiObj wobj = wmi.getObject("Win32_Process");
                out.setLinePrefix("");
                out.println("path:");

                out.setLinePrefix("  ");
                out.println("path: "+wobj.getWmiPath().getPath());
                out.println("relpath: "+wobj.getWmiPath().getRelpath() );
                out.println("class: "+wobj.getWmiPath().getClazz() );
                out.println("classType: "+wobj.getWmiPath().isClassType() );
                out.println("singleton: "+wobj.getWmiPath().isSingleton() );
                out.println("namespace: "+wobj.getWmiPath().getNamespace() );
                out.println("parentNamespace: "+wobj.getWmiPath().getParentNamespace() );
                out.println("auth: "+wobj.getWmiPath().getAuthority() );
                out.println("displayName: "+wobj.getWmiPath().getDisplayName() );
                out.println("server: "+wobj.getWmiPath().getServer() );
                out.println("locale: "+wobj.getWmiPath().getLocale() );

                out.setLinePrefix(indent(0));
                List<WmiDerivation> derivation = wobj.getWmiDerivation();
                out.println("derivation("+derivation.size()+")"+(!derivation.isEmpty()?":":""));
                wobj.getWmiDerivation().forEach( der -> {
                    out.setLinePrefix(indent(1));
                    out.println(der.getClazz());
                });

                inspectSecurity(out, 0, wobj.getWmiSecurity());
                inspectQualifiers(out,0, wobj.getWmiQualifiers());
                inspectProps(out, 0, wobj.getWmiProperties());

                out.setLinePrefix(indent(0));
                SWbemMethodSet methods = wobj.getWmiMethods();
                out.println("methods("+methods.size()+")"+(methods.size()>0?":":""));
                methods.forEach(meth->{
                    out.setLinePrefix(indent(1));
                    out.println(meth.getName()+":");

                    out.setLinePrefix(indent(2));
                    out.println("name: "+meth.getName());
                    out.println("origin: "+meth.getOrigin());
                    inspectQualifiers(out,2,meth.getWmiQualifiers());

                    out.setLinePrefix(indent(2));
                    SWbemPropertySet inProps = meth.getInParameters();
                    inspectProps(out,2,"input",inProps);

                    SWbemPropertySet outProps = meth.getOutParameters();
                    inspectProps(out,2,"output",outProps);
                });
            });
        });
    }

    private void inspectProps(Output out, int level, SWbemPropertySet props) {
        inspectProps(out,level,"properties:", props);
    }

    private void inspectProps(Output out, int level, String name, SWbemPropertySet props) {
        out.setLinePrefix(indent(level));
        out.println(name+"("+props.size()+")"+(props.size()>0?":":""));
        props.forEach(prop -> {
            out.setLinePrefix(indent(level+1));
            out.println(prop.getName()+":");

            out.setLinePrefix(indent(level+2));
            out.println("name: "+prop.getName());
            out.println("cimType: "+prop.getCIMType());
            out.print(prop.getReference().map(r->"class: "+r.getWmiPath().getClazz()+"\n").orElse(""));
            out.println("array: "+prop.isArray());
            out.println("local: "+prop.isLocal());
            out.println("origin: "+prop.getOrigin());

            SWbemQualifierSet qualifiers = prop.getWmiQualifiers();
            inspectQualifiers(out, level+2, qualifiers);
        });
    }

    private void inspectQualifiers(Output out, int level, SWbemQualifierSet qualifiers) {
        if( qualifiers.size()>0){
            out.setLinePrefix(indent(level));
            out.println("qualifiers("+qualifiers.size()+")"+(qualifiers.size()>0?":":""));
            qualifiers.forEach(qual->{
                out.setLinePrefix(indent(level +1));
                out.println(qual.getName()+":");

                out.setLinePrefix(indent(level +2));
                out.println("name: "+qual.getName());
                out.println("amended: "+qual.isAmended());
                out.println("local: "+qual.isLocal());
                out.println("overridable: "+qual.isOverridable());
                out.println("propagatesToInstance: "+qual.isPropagatesToInstance());
                out.println("propagatesToSubClass: "+qual.isPropagatesToSubClass());
                out.println("variant: "+qual.getVariant());
            });
        }
    }

    private void inspectSecurity(Output out, int level, SWbemSecurity sec) {
        out.setLinePrefix(indent(level));
        out.println("security:");

        out.setLinePrefix(indent(level+1));
        out.println("authenticationLevel: "+ sec.getAuthenticationLevel());
        out.println("impersonationLevel: "+ sec.getImpersonationLevel());

        SWbemPrivilegeSet privs = sec.getPrivileges();
        out.println("privileges("+privs.size()+")"+(privs.size()>0 ? ":" : ""));
        privs.forEach(priv -> {
            out.setLinePrefix(indent(level+2));
            out.println("name: "+priv.getName());
            out.println("enabled: "+priv.isEnabled());
            out.println("displayName: "+priv.getDisplayName());
            out.println("identifier: "+priv.getIdentifier());
        });
    }
}
