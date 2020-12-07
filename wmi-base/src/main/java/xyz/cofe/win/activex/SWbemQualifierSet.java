package xyz.cofe.win.activex;

import com.jacob.com.SafeArray;
import com.jacob.com.Variant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public interface SWbemQualifierSet extends ArrayView<SWbemQualifier,SWbemQualifierSet> {
    public default Optional<String> createBy(){
        return filter(q->q.getName().equals("CreateBy")).first(q->q.getVariant().toString());
    }
    public default Optional<String> deleteBy(){
        return filter(q->q.getName().equals("DeleteBy")).first(q->q.getVariant().toString());
    }
    public default Optional<Boolean> optional(){
        return filter(q->q.getName().equalsIgnoreCase("Optional")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> dynamic(){
        return filter(q->q.getName().equals("dynamic")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> supportsCreate(){
        return filter(q->q.getName().equals("SupportsCreate")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> supportsDelete(){
        return filter(q->q.getName().equals("SupportsDelete")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> constructor(){
        return filter(q->q.getName().equals("Constructor")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> destructor(){
        return filter(q->q.getName().equals("Destructor")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> implemented(){
        return filter(q->q.getName().equals("Implemented")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> In(){
        return filter(q->q.getName().equals("In")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> Static(){
        return filter(q->q.getName().equals("Static")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> OUT(){
        return filter(q->q.getName().equals("Out")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Boolean> out(){
        return filter(q->q.getName().equals("out")).first(q->q.getVariant().toString().equals("true"));
    }
    public default Optional<Long> ID(){
        return filter(q->q.getName().equals("ID")).first(q->Long.parseLong(q.getVariant().toString()));
    }
    public default Optional<List<String>> privileges(){
        return filter(q->q.getName().equals("Privileges")).first(q->{
            Variant v = q.getVariant();
            List<String> res = new ArrayList<>();
            if( v!=null && !v.isNull() ){
                SafeArray arr = v.toSafeArray();
                int lo = arr.getLBound();
                int hi = arr.getUBound();
                for( int i=lo; i<=hi; i++ ){
                    String s = arr.getString(i);
                    if( s!=null ){
                        res.add(s);
                    }
                }
            }
            return res;
        });
    }
}
