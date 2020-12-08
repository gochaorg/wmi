package xyz.cofe.win.wmi.gen;

import xyz.cofe.text.out.Output;
import xyz.cofe.win.activex.WbemCIMType;

import java.io.StringWriter;
import java.util.function.Function;

public interface BaseType {
    public String codeReadPropImpl(String propName);
    public String codeReadPropDecl(String propName);
    public WbemCIMType[] cimTypes();

    public static String implNullable(String propName, String propType, Function<String,String> readValue){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);
        out.setLinePrefix("");
        out.println("public "+propType+" get"+propName+"(){");

        out.setLinePrefix("  ");
        out.println("ActiveXComponent ax = getActiveXComponent();");
        out.println("if( ax==null )throw new IllegalStateException(\"activeXComponent is null\");");
        out.println("Variant v = ax.getProperty(\""+propName+"\");");
        out.println("if( v==null || v.isNull() )return null;");
        out.println("return "+readValue.apply("v")+";");

        out.setLinePrefix("");
        out.println("}");
        return sw.toString();
    }
    public static String implNotNull(String propName, String propType, Function<String,String> readValue){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);
        out.setLinePrefix("");
        out.println("public "+propType+" get"+propName+"(){");

        out.setLinePrefix("  ");
        out.println("ActiveXComponent ax = getActiveXComponent();");
        out.println("if( ax==null )throw new IllegalStateException(\"activeXComponent is null\");");
        out.println("Variant v = ax.getProperty(\""+propName+"\");");
        out.println("if( v==null || v.isNull() )throw new IllegalStateException(\"can't read "+propName+"\");");
        out.println("return "+readValue.apply("v")+";");

        out.setLinePrefix("");
        out.println("}");
        return sw.toString();
    }
    public static String decl(String propName,String propType){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);
        out.println("public "+propType+" get"+propName+"();");
        return sw.toString();
    }

    public static String implOptional(String propName, String propType, Function<String,String> readValue){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);
        out.setLinePrefix("");
        out.println("public java.util.Optional<"+propType+"> get"+propName+"(){");

        out.setLinePrefix("  ");
        out.println("ActiveXComponent ax = getActiveXComponent();");
        out.println("if( ax==null )throw new IllegalStateException(\"activeXComponent is null\");");
        out.println("Variant v = ax.getProperty(\""+propName+"\");");
        out.println("if( v==null || v.isNull() )return java.util.Optional.empty();");
        out.println("return java.util.Optional.of("+readValue.apply("v")+");");

        out.setLinePrefix("");
        out.println("}");
        return sw.toString();
    }
    public static String declOptional(String propName,String propType){
        StringWriter sw = new StringWriter();
        Output out = new Output(sw);
        out.println("public java.util.Optional<"+propType+"> get"+propName+"();");
        return sw.toString();
    }

    public static BaseType baseType(String baseType, boolean nullable, Function<String,String> readValue, WbemCIMType ... cimTypes){
        return new BaseType() {
            @Override
            public String codeReadPropImpl(String propName) {
                return
                    nullable
                        ? implNullable(propName,baseType, readValue)
                        : implNotNull(propName,baseType, readValue);
            }

            @Override
            public String codeReadPropDecl(String propName) {
                return decl(propName, baseType);
            }

            @Override
            public WbemCIMType[] cimTypes() {
                return cimTypes;
            }
        };
    }
    public static BaseType optionalType(String baseType, Function<String,String> readValue, WbemCIMType ... cimTypes){
        return new BaseType() {
            @Override
            public String codeReadPropImpl(String propName) {
                return implOptional(propName,baseType,readValue);
            }

            @Override
            public String codeReadPropDecl(String propName) {
                return declOptional(propName,baseType);
            }

            @Override
            public WbemCIMType[] cimTypes() {
                return cimTypes;
            }
        };
    }

    //region basic numeric types
    public static final BaseType BYTE = baseType(
        "byte", false, varName -> varName+".getByte()",
        WbemCIMType.UNIT8, WbemCIMType.SINT8
    );
    public static final BaseType SHORT = baseType(
        "short", false, varName -> varName+".getShort()",
        WbemCIMType.SINT16
    );
    public static final BaseType INT = baseType(
        "int", false, varName -> varName+".getInt()",
        WbemCIMType.UNIT16, WbemCIMType.UNIT32, WbemCIMType.SINT32
    );
    public static final BaseType LONG = baseType(
        "long", false, varName -> varName+".getLong()",
        WbemCIMType.UNIT64, WbemCIMType.SINT64
    );
    public static final BaseType FLOAT = baseType(
        "float", false, varName -> varName+".getFloat()",
        WbemCIMType.REAL32
    );
    public static final BaseType DOUBLE = baseType(
        "double", false, varName -> varName+".getDouble()",
        WbemCIMType.REAL64
    );
    //endregion
    //region boolean
    public static final BaseType BOOLEAN = baseType(
        "boolean", false, varName -> varName+".getBoolean()",
        WbemCIMType.BOOLEAN
    );
    //endregion
    //region string
    public static final BaseType STRING = baseType(
        "String", true, varName -> varName+".getString()",
        WbemCIMType.STRING
    );
    //endregion
    //region date
    public static final BaseType DATE = optionalType(
        "java.time.OffsetDateTime",
            varName -> "xyz.cofe.win.wmi.time.ParseTime.parse("+varName+".getString())",
        WbemCIMType.DATETIME
    );
    //endregion

    public static final BaseType[] baseTypes = new BaseType[]{
        BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, DATE
    };

    public static BaseType of(WbemCIMType cimType){
        if( cimType==null )throw new IllegalArgumentException("cimType==null");
        for( BaseType bt : baseTypes ){
            boolean match = false;
            for( WbemCIMType ct : bt.cimTypes() ){
                if( !match ){
                    match = ct==cimType;
                }
            }
            if( match ){
                return bt;
            }
        }
        return null;
    }
}
