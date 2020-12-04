package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import xyz.cofe.win.wmi.WMI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SWbemMethodImpl implements SWbemMethod {
    public SWbemMethodImpl(){
    }

    public SWbemMethodImpl(ActiveXMethods ax, WMI wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ax, wmi);
    }

    public SWbemMethodImpl(ActiveXMethods ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ax, null);
    }

    public SWbemMethodImpl(ActiveXComponent ax, WMI wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax), wmi);
    }

    public SWbemMethodImpl(ActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax), null);
    }

    public SWbemMethodImpl(GetActiveXComponent ax, WMI wmi){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax.getActiveXComponent()), wmi);
    }

    public SWbemMethodImpl(GetActiveXComponent ax){
        if( ax==null )throw new IllegalArgumentException("ax==null");
        initProps(ActiveXMethods.of(ax.getActiveXComponent()), null);
    }

    private void initProps(ActiveXMethods ax, WMI wmi) {
        name = ax.getProperty("Name").getString();
        origin = ax.getProperty("Origin").getString();

        inParameters = new SWbemPropertySetImpl(paramsOf(ax,"InParameters", wmi));
        outParameters = new SWbemPropertySetImpl(paramsOf(ax,"OutParameters", wmi));
    }

    private static List<SWbemProperty> paramsOf(ActiveXMethods axMethod, String paramsPropertyName, WMI wmi) {
        Variant vParameters = axMethod.getProperty(paramsPropertyName);
        Dispatch dInParameters = vParameters!=null && !vParameters.isNull() ?
            vParameters.toDispatch() : null;

        ActiveXComponent axParameters = dInParameters!=null && dInParameters.m_pDispatch!=0 ?
            new ActiveXComponent(dInParameters) : null;

        Variant vParametersProps = axParameters!=null ?
            axParameters.getProperty("Properties_") : null;

        Dispatch dParametersProps = vParametersProps!=null && !vParametersProps.isNull() ?
            vParametersProps.toDispatch() : null;

        EnumVariant enParametersProps = dParametersProps!=null && dParametersProps.m_pDispatch!=0 ?
            new EnumVariant(dParametersProps) : null;

        List<SWbemProperty> lParamProps = new ArrayList<>();

        while( enParametersProps!=null && enParametersProps.hasMoreElements() ){
            Variant vInParametersProp = enParametersProps.nextElement();

            Dispatch dParametersProp = vInParametersProp!=null && !vInParametersProp.isNull() ?
                vInParametersProp.toDispatch() : null;

            ActiveXComponent axParametersProp = dParametersProp!=null && dParametersProp.m_pDispatch!=0 ?
                new ActiveXComponent(dParametersProp) : null;

            if( axParametersProp!=null ){
                SWbemProperty prop = new SWbemPropertyImpl(
                    ActiveXMethods.of(axParametersProp), wmi
                );
                lParamProps.add(prop);
            }
        }

        return lParamProps;
    }

    //region properties
    //region name:String
    protected String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
    //region origin:String
    protected String origin;
    @Override
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    //endregion
    //region inParameters:SWbemPropertySet
    protected SWbemPropertySet inParameters;

    @Override
    public SWbemPropertySet getInParameters() {
        return inParameters;
    }

    public void setInParameters(SWbemPropertySet inParameters) {
        this.inParameters = inParameters;
    }
    //endregion
    //region outParameters:SWbemPropertySet
    protected SWbemPropertySet outParameters;

    @Override
    public SWbemPropertySet getOutParameters() {
        return outParameters;
    }

    public void setOutParameters(SWbemPropertySet outParameters) {
        this.outParameters = outParameters;
    }
    //endregion
    //endregion

    public SWbemMethodImpl configure(Consumer<SWbemMethodImpl> conf){
        if( conf==null )throw new IllegalArgumentException("conf==null");
        conf.accept(this);
        return this;
    }
}
