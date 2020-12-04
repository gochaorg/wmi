package xyz.cofe.win.activex;

/**
 * https://github.com/groovy/Scriptom/blob/master/scriptom-wbem/src/main/java/org/codehaus/groovy/scriptom/tlb/wbemscripting/WbemCimtypeEnum.java
 */
public enum WbemCIMType
{
    SINT8(16),
    UNIT8(17),
    SINT16(2),
    UNIT16(18),
    SINT32(3),
    UNIT32(19),
    SINT64(20),
    UNIT64(21),

    REAL32(4),
    REAL64(5),

    BOOLEAN(11),
    STRING(8),
    DATETIME(101),
    REFERENCE(102),

    CHAR16(103),
    OBJECT(13);
    public final int code;
    WbemCIMType(int code){
        this.code = code;
    }
}