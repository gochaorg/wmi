package xyz.cofe.win.wmi.gen;

import xyz.cofe.io.fs.File;
import xyz.cofe.text.out.Output;
import xyz.cofe.win.activex.SWbemProperty;
import xyz.cofe.win.activex.WbemCIMType;
import xyz.cofe.win.wmi.WmiObj;

import java.io.StringWriter;
import java.util.*;

public class TypeGen {
    public final WmiObj wmiObj;
    public TypeGen(WmiObj wmiObj){
        if( wmiObj==null )throw new IllegalArgumentException("wmiObj==null");
        this.wmiObj = wmiObj;
    }

    private List<String> packaje = new ArrayList<>();
    public String getPackage(){
        if( packaje.size()>0 ){
            if( packaje.size()>1 ){
                return packaje.stream().reduce((a,b)->a+"."+b).get();
            }else{
                packaje.get(0);
            }
        }
        return "";
    }
    public void setPackage(String pkg){
        if( pkg==null )throw new IllegalArgumentException("pkg==null");
        packaje.clear();
        packaje.addAll(Arrays.asList(pkg.split("\\.")));
    }
    public boolean isPackageDefined(){ return !packaje.isEmpty(); }

    public String getInterfaceName(){
        ArrayList<String> name = new ArrayList<>(packaje);
        name.add(wmiObj.getWmiPath().getClazz());
        if( name.size()>1 ){
            return name.stream().reduce((a,b)->a+"."+b).get();
        }else if( name.size()==1 ){
            return name.get(0);
        }else {
            return "??";
        }
    }

    protected String implSuff = "Impl";
    public String getImplSuff() { return implSuff; }
    public void setImplSuff(String implSuff) { this.implSuff = implSuff; }

    public String getInterfaceImplName(){
        ArrayList<String> name = new ArrayList<>(packaje);
        name.add(wmiObj.getWmiPath().getClazz()+implSuff);
        if( name.size()>1 ){
            return name.stream().reduce((a,b)->a+"."+b).get();
        }else if( name.size()==1 ){
            return name.get(0);
        }else {
            return "??";
        }
    }

    public File getInterfaceFile(File root){
        if( root==null )throw new IllegalArgumentException("root==null");
        File trgt = root;
        for( String name : packaje ){
            trgt = trgt.resolve(name);
        }
        trgt = trgt.resolve(wmiObj.getWmiPath().getClazz()+".java");
        return trgt;
    }

    public Result<String> generatePropImpl(SWbemProperty prop){
        if( prop==null )throw new IllegalArgumentException("prop==null");
        if( prop.isArray() ){
            return Result.fail("/* property "+prop.getName()+" : array - not supported */\n");
        }

        BaseType bt = BaseType.of(prop.getCIMType());
        if( bt!=null ){
            return Result.ok(bt.codeReadPropImpl(prop.getName()));
        }

        return Result.fail("/* property"+
            " name="+prop.getName()+
            " type="+prop.getCIMType()+
            (prop.getReference().map(r->" ref="+r.getWmiPath().getClazz()).orElse(""))+
            " -  not supported */\n");
    }
    public Result<String> generatePropDecl(SWbemProperty prop){
        if( prop==null )throw new IllegalArgumentException("prop==null");
        if( prop.isArray() ){
            return Result.fail("/* property "+prop.getName()+" : array - not supported */\n");
        }
        BaseType bt = BaseType.of(prop.getCIMType());
        if( bt!=null ){
            return Result.ok(bt.codeReadPropDecl(prop.getName()));
        }

        return Result.fail("/* property"+
            " name="+prop.getName()+
            " type="+prop.getCIMType()+
            (prop.getReference().map(r->" ref="+r.getWmiPath().getClazz()).orElse(""))+
            " -  not supported */\n");
    }

    public Result<String> generateIterface(){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);

        out.setLinePrefix("");

        if( isPackageDefined() ){
            out.println("packge "+getPackage()+";");
            out.println();
        }

        out.println("import xyz.cofe.win.wmi.WmiObj;");
        out.println("import java.util.ArrayList;");
        out.println("import java.util.List;");
        out.println("import java.util.function.Consumer;");
        out.println();

        out.println("public interface "+getInterfaceName()+" extends WmiObj {");
        wmiObj.getWmiProperties().forEach( wprop -> {
            out.setLinePrefix("  ");
            out.println(generatePropDecl(wprop).getResult());
        });

        out.setLinePrefix("");
        out.println("}");

        return Result.ok(sw.toString());
    }

    public Result<String> generateInterfaceImpl(){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);

        out.setLinePrefix("");

        if( isPackageDefined() ){
            out.println("packge "+getPackage()+";");
            out.println();
        }

        out.println("import com.jacob.activeX.ActiveXComponent;");
        out.println("import com.jacob.com.*;");
        out.println("import xyz.cofe.win.activex.GetActiveXComponent;");
        out.println("import xyz.cofe.win.wmi.*;");
        out.println();

        out.println("public class "+getInterfaceImplName()+" extends WmiObjImpl implements "+getInterfaceName()+" {");
        wmiObj.getWmiProperties().forEach( wprop -> {
            out.setLinePrefix("  ");
            out.println(generatePropImpl(wprop).getResult());
        });

        out.setLinePrefix("");
        out.println("}");

        return Result.ok(sw.toString());
    }
}
