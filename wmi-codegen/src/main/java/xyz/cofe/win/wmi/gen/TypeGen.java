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

    protected void log(String message){
        System.out.println(message);
    }

    //region package
    private final List<String> packaje = new ArrayList<>();
    public String getPackage(){
        if( packaje.size()>0 ){
            if( packaje.size()>1 ){
                return packaje.stream().reduce((a,b)->a+"."+b).get();
            }else{
                return packaje.get(0);
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
    //endregion

    public String getInterfaceFullName(){
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
    public String getInterfaceName(){
        return wmiObj.getWmiPath().getClazz();
    }

    //region implSuff
    protected String implSuff = "Impl";
    public String getImplSuff() { return implSuff; }
    public void setImplSuff(String implSuff) {
        if( implSuff==null )throw new IllegalArgumentException("implSuff==null");
        this.implSuff = implSuff;
    }
    //endregion

    public String getInterfaceImplFullName(){
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
    public String getInterfaceImplName(){
        return wmiObj.getWmiPath().getClazz()+getImplSuff();
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
    public File getInterfaceImplFile(File root){
        if( root==null )throw new IllegalArgumentException("root==null");
        File trgt = root;
        for( String name : packaje ){
            trgt = trgt.resolve(name);
        }
        trgt = trgt.resolve(wmiObj.getWmiPath().getClazz()+getImplSuff()+".java");
        return trgt;
    }

    public Optional<String> getWmiRefType(SWbemProperty prop){
        if( prop==null )throw new IllegalArgumentException("prop==null");
        if( WbemCIMType.REFERENCE!=prop.getCIMType() )return Optional.empty();

        Optional<String> refOpt = prop.getWmiQualifiers()
            .filter(p->p.getName().equalsIgnoreCase("CIMTYPE"))
            .first(p->p.getVariant().getString());
        if( !refOpt.isPresent() )return Optional.empty();

        String ref = refOpt.get();
        if( ref.startsWith("ref:") && ref.length()>4 ){
            return Optional.of(ref.substring(4));
        }

        return Optional.empty();
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

        Optional<String> refOpt = getWmiRefType(prop);
        if( refOpt.isPresent() ){
            StringBuilder sb = new StringBuilder();
            sb.append("public java.util.Optional<"+refOpt.get()+"> get"+prop.getName()+"();\n");
            return Result.ok(sb.toString());
        }

        String message = "property"+
            " name="+prop.getName()+
            " type="+prop.getCIMType()+
            (prop.getReference().map(r->" ref="+r.getWmiPath().getClazz()).orElse(""))+
            " -  not supported";

        log(message);
        return Result.fail("/* "+message+" */\n");
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

        Optional<String> refOpt = getWmiRefType(prop);
        if( refOpt.isPresent() ){
            StringWriter sw = new StringWriter();
            Output out = new Output(sw);
            out.setLinePrefix("");
            out.println("public java.util.Optional<"+refOpt.get()+"> get"+prop.getName()+"(){");

            out.setLinePrefix("  ");

            out.println("ActiveXComponent ax = getActiveXComponent();");
            out.println("if( ax==null )throw new IllegalStateException(\"activeXComponent is null\");");

            out.println();
            out.println("Variant v = ax.getProperty(\""+prop.getName()+"\");");
            out.println("if( v==null || v.isNull() )return java.util.Optional.empty();");
            out.println(
                "if( v.getvt()==8 && wmi!=null ){\n" +
                "  String path = v.getString();\n" +
                "  WmiObj obj = wmi.getObject(path);\n" +
                "  "+refOpt.get()+" impl =  new "+refOpt.get()+getImplSuff()+"(obj.getActiveXComponent(),wmi);\n" +
                "  return java.util.Optional.of(impl);\n" +
                "}");

            out.println();
            out.println("Dispatch d = v!=null && !v.isNull() ? v.toDispatch() : null;");
            out.println("ActiveXComponent a = d!=null && d.m_pDispatch!=0 ? new ActiveXComponent(d) : null;");
            out.println("java.util.Optional<"+refOpt.get()+"> r = a!=null ? " +
                "java.util.Optional.of( new "+refOpt.get()+getImplSuff()+"(a) )" +
                " : java.util.Optional.empty();");

            out.println("return r;");

            out.setLinePrefix("");
            out.println("}");
            return Result.ok(sw.toString());
        }

        return Result.fail("/* property"+
            " name="+prop.getName()+
            " type="+prop.getCIMType()+
            (prop.getReference().map(r->" ref="+r.getWmiPath().getClazz()).orElse(""))+
            " -  not supported */\n");
    }

    protected String nameSpaceItf = null;
    public String getNameSpaceItf() { return nameSpaceItf; }
    public void setNameSpaceItf(String nameSpaceItf) { this.nameSpaceItf = nameSpaceItf; }

    public Result<String> generateInterface(){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);

        out.setLinePrefix("");

        if( isPackageDefined() ){
            out.println("package "+getPackage()+";");
            out.println();
        }

        out.println("import xyz.cofe.win.wmi.WmiObj;");
        out.println("import java.util.ArrayList;");
        out.println("import java.util.List;");
        out.println("import java.util.function.Consumer;");
        out.println();

        out.println("public interface "+ getInterfaceName()+" extends WmiObj {");
        wmiObj.getWmiProperties().forEach( wprop -> {
            out.setLinePrefix("  ");
            out.println(generatePropDecl(wprop).getResult());
        });

        if( nameSpaceItf!=null ){
            out.println();
            out.println(
                "public static void query("+nameSpaceItf+" wmi, Consumer<"+getInterfaceName()+"> client){\n" +
                "  if( wmi==null )throw new IllegalArgumentException(\"wmi==null\");\n" +
                "  if( client==null )throw new IllegalArgumentException(\"client==null\");\n" +
                "  wmi.instancesOf(\""+wmiObj.getWmiPath().getClazz()+"\", obj -> client.accept(new "+getInterfaceImplName()+"(obj, wmi)) );\n" +
                "}");

            out.println();
            out.println(
                "public static List<"+getInterfaceName()+"> query("+nameSpaceItf+" wmi){\n" +
                "  if( wmi==null )throw new IllegalArgumentException(\"wmi==null\");\n" +
                "  ArrayList<"+getInterfaceName()+"> list = new ArrayList<>();\n" +
                "  query(wmi,list::add);\n" +
                "  return list;\n" +
                "}");
        }

        out.setLinePrefix("");
        out.println("}");

        return Result.ok(sw.toString());
    }
    public Result<String> generateInterfaceImpl(){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);

        out.setLinePrefix("");

        if( isPackageDefined() ){
            out.println("package "+getPackage()+";");
            out.println();
        }

        out.println("import com.jacob.activeX.ActiveXComponent;");
        out.println("import com.jacob.com.*;");
        out.println("import xyz.cofe.win.activex.GetActiveXComponent;");
        out.println("import xyz.cofe.win.wmi.*;");
        out.println();

        out.println("public class "+ getInterfaceImplName()+" extends WmiObjImpl implements "+ getInterfaceName()+" {");

        out.setLinePrefix("  ");
        out.println(
            "public "+ getInterfaceImplName()+"(ActiveXComponent activeXComponent) {\n" +
            "  super(activeXComponent);\n" +
            "}");
        out.println(
            "public "+ getInterfaceImplName()+"(ActiveXComponent activeXComponent, Wmi wmi) {\n" +
            "  super(activeXComponent, wmi);\n" +
            "}");
        out.println(
            "public "+ getInterfaceImplName()+"(GetActiveXComponent activeXComponent) {\n" +
            "  super(activeXComponent.getActiveXComponent());\n" +
            "}");
        out.println(
            "public "+ getInterfaceImplName()+"(GetActiveXComponent activeXComponent, Wmi wmi) {\n" +
            "  super(activeXComponent.getActiveXComponent(), wmi);\n" +
            "}"
        );

        wmiObj.getWmiProperties().forEach( wprop -> {
            out.setLinePrefix("  ");
            out.println(generatePropImpl(wprop).getResult());
        });

        out.setLinePrefix("");
        out.println("}");

        return Result.ok(sw.toString());
    }

    public void generateFiles(String root){
        if( root==null )throw new IllegalArgumentException("root==null");
        generateFiles(new File(root));
    }
    public void generateFiles(File root){
        if( root==null )throw new IllegalArgumentException("root==null");
        log("generateFiles into "+root);

        log("generate interface of "+wmiObj.getWmiPath().getClazz());

        File itfFile = getInterfaceFile(root);
        log("  into "+itfFile);

        String itfContent = generateInterface().getResult();
        File itfDir = itfFile.getParent();
        if( !itfDir.exists() )itfDir.createDirectories();
        itfFile.writeText(itfContent,"utf-8");

        log("generate implementation of "+wmiObj.getWmiPath().getClazz());

        File implFile = getInterfaceImplFile(root);
        log("  into "+implFile);

        String implContent = generateInterfaceImpl().getResult();
        File implDir = implFile.getParent();
        if( !implDir.exists() )implDir.createDirectories();
        implFile.writeText(implContent,"utf-8");
    }
}
