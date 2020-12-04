package xyz.cofe.win.activex;

import com.jacob.com.Variant;

/**
 * <a href="https://docs.microsoft.com/ru-ru/windows/win32/wmisdk/swbemqualifier">Квалификатор WMI</a>
 */
public interface SWbemQualifier {
    /**
     * Variant value of this qualifier. This is the default property of this object.
     *
     * <p>
     *     Значение варианта этого классификатора. Это свойство данного объекта по умолчанию.
     * @return default property
     */
    Variant getVariant();

    /**
     * Boolean value that indicates if this qualifier can be propagated to a subclass.
     * @return can be propagated to a subclass
     */
    boolean isPropagatesToSubClass();

    /**
     * Boolean value that indicates if this qualifier can be propagated to an instance.
     * @return can be propagated to an instance
     */
    boolean isPropagatesToInstance();

    /**
     * Name of this qualifier.
     *
     * <p>
     * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/standard-wmi-qualifiers">Standard WMI Qualifiers</a>
     *
     * <ul>
     * <li><b>Amendment</b> 
     *   : <b style="color: blue">boolean</b>
     *   , applies to: classes
     *   <br>Indicates that a class contains amended qualifiers that are localized. The default is TRUE.
     *   <br>The associated class can be translated. To access the translated version, use the locale identifier to construct a namespace name.
     *
     * <li><b>Bypass_GetObject</b> 
     *   : <b style="color: blue">boolean</b>
     *   , applies to: methods
     *    <br>Indicates that the method call should pass directly to the ExecMethodAsync
     *    call of the provider rather than the provider first making a call to
     *    GetObject to validate the object path. The default is FALSE.
     *
     *    <br>Using Bypass_GetObject can significantly improve performance.
     *     <br>a) Before using Bypass_GetObject, ensure that neither of the following actions are taken:
     *     <br>b) Derive a class from your class.
     *    <br>Override the method that has the Bypass_GetObject qualifier.
     *
     *    <br>Failure to follow these precautions can result in invoking
     *        the method implementation of the parent class instead of the child class.
     *        For more information, see Using the Bypass_GetObject Qualifier.
     *
     * <li><b>CIM_Key</b> 
     *   : <b style="color: blue">CIM_BOOLEAN</b>
     *   , applies to: properties
     *   <br> Indicates that the associated property is a key property in CIM but not in WMI.
     *
     * <li><b>CIMType</b> 
     *   : <b style="color: blue">VT_BSTR</b>
     *   , applies to: properties, methods, parameters
     *   <br> Contains text describing the type of a property.
     *
     * <li><b>ClassContext</b>
     *     : <b style="color: blue">VT_BSTR</b>
     *     , applies to: classes
     *     <br>Indicates that a class has instances associated with more information dynamically supplied by a provider.
     *
     * <li><b>Deprecated</b>
     *     : <b style="color: blue">CIM_BOOLEAN</b>
     *     , applies to: properties, classes
     *     <br>Indicates the property has been superseded by another property.
     *
     * <li><b>Display</b>
     *     , applies to: classes, properties
     *     <br>The UUID of the associated class.
     *
     * <li><b>Dynamic</b>
     *     : <b style="color: blue">boolean</b>
     *     , applies to: classes, properties
     *     <br>Indicates a class whose instances are created dynamically. The value of this qualifier must be set to TRUE.
     *
     * <li><b>DynProps</b>
     *     : <b style="color: blue">boolean</b>
     *     , applies to: classes, instances
     *     <br>Indicates that an instance contains values provided by dynamic property providers. The default is TRUE.
     *     <br>You must specify this qualifier on such an instance. Only the value TRUE is allowed.
     * 
     * <li><b>Fixed</b>
     *     : <b style="color: blue">CIM_BOOLEAN</b>
     *     , applies to: instances
     *     <br>Indicates that the value of this property cannot change during the lifetime of the instance.
     *
     * <li><b>ID</b>
     *     : <b style="color: blue">VT_I4</b>
     *     , applies to: properties, parameters
     *     <br>Uniquely identifies and sequences a property or method parameter when MOF statements are generated automatically.
     *     <br>This qualifier is required for method parameters only. When creating parameters for a method, class designers should begin with Id(0) for the first parameter and use each successive integer for each successive parameter. If the ID qualifiers are unintentionally omitted, the MOF compiler generates ID qualifiers automatically.
     *
     * <li><b>Implemented</b>
     *     : <b style="color: blue">boolean</b>
     *     , applies to: methods
     *     <br>Indicates that a method has an implementation supplied by a provider.
     *
     * <li><b>InstanceContext</b>
     *     : <b style="color: blue">VT_BSTR</b>
     *     , applies to: instances
     *     <br>Indicates that an instance contains values provided by a dynamic property provider.
     *     <br>The value is passed to the property provider as an argument to the IWbemPropertyProvider::GetProperty method.
     *
     * <li><b>Locale</b>
     *     : <b style="color: blue">VT_BSTR</b>
     *     , applies to: classes or instances
     *     <br>Specifies the language of origin for a class or instance. For more information about locale values, see Locale Codes.
     *
     * <li><b>NamespaceSecuritySDDL</b>
     *     : <b style="color: blue">string array</b>
     *     , applies to: namespace instances
     *     <br>Specifies a security descriptor for the namespace in SDDL format. For more information, see Setting Namespace Security When the Namespace is Created. The SDDL string is processed by WMI to establish the namespace security but not stored as a string. If no security descriptor is specified, the default security is used. For more information, see Setting Namepace Security Descriptors.
     *
     * <li><b>Optional</b>
     *     : <b style="color: blue">boolean</b>
     *     , applies to: parameters
     *     <br>Indicates that a parameter is not required, and that it has a well-behaved default value.
     *
     * <li><b>Privileges</b>
     *     : <b style="color: blue">string array</b>
     *     , applies to: properties, methods
     *     <br>Set of values used to inform the client which privileges are required to create instances, fill in properties, or perform methods. The default is FALSE.
     *
     * <li><b>PropertyContext</b>
     *     : <b style="color: blue">VT_BSTR</b>
     *     , applies to: properties
     *     <br>Indicates that an instance property contains values provided by dynamic property providers.
     *     <br>You must specify this qualifier on such a property. The value is passed to the property provider as an argument to IWbemPropertyProvider::GetProperty.
     *
     * <li><b>Provider</b>
     *     : <b style="color: blue">VT_BSTR</b>
     *     , applies to: classes
     *     <br>The value of this qualifier is the name of the dynamic provider that provides class instances and refreshes instance data. This name must be registered with WMI by creating an instance of the __Win32Provider class with the Name property containing this name. When this qualifier is specified on a class whose instances are provided dynamically, the Dynamic qualifier must also be specified.
     *
     * <li><b>RequiresEncryption</b>
     *     : <b style="color: blue">boolean</b>
     *     , applies to: namespace instances
     *     <br>If set to TRUE, RequiresEncryption marks a namespace so that client applications and scripts must connect with encrypted authentication. The authentication level must be set to RPC_C_AUTHN_LEVEL_PKT_PRIVACY in C++. In scripting or Visual Basic, authentication level must be set to WbemAuthenticationLevelPktPrivacy. For more information, see Setting Namepace Security Descriptors. The qualifier is used in MOF with the pragma namespace preprocessor command.
     *     <br>For more information, see Setting the Default Process Security Level Using C++ or Setting the Default Process Security Level Using VBScript. Scripting authentication levels are defined in WbemAuthenticationLevelEnum.
     *
     * <li><b>Singleton</b>
     *     : <b style="color: blue">boolean</b>
     *     , applies to: classes
     *     <br>Designates a class that can only have one instance and that does not contain key properties.
     *     <br>Only the value TRUE (default) is allowed.
     *
     * <li><b>Static</b>
     *     : <b style="color: blue">boolean</b>
     *     , applies to: methods
     *     <br>Indicates whether a method can called by using the class definition or its instances.
     *     <br>The method cannot be invoked from an instance.
     *
     * <li><b>SubType</b>
     *     : <b style="color: blue">VT_BSTR</b>
     *     , applies to: properties
     *     <br>Indicates that a property of type CIM_DATETIME represents a time interval rather than a specific time.
     *     <br>To identify the property as an interval, the value of this qualifier must be "interval". All other values for this qualifier are reserved for future use.
     *
     * <li><b>UUID</b>
     *     : <b style="color: blue">string</b>
     *     , applies to: classes
     *     <br>Universally unique identifier applied to the class.
     *
     * <li><b>ClassVersion</b>
     *     : <b style="color: blue">string</b>
     *     , applies to: classes
     *     <br>The version number of the class object. The default is NULL. The version number is incremented when changes are made to the class.
     *
     * <li><b>WritePrivileges</b>
     *     : <b style="color: blue">string array</b>
     *     , applies to: properties
     *     <br>Set of values indicating which system privileges must be available and enabled for a successful write operation.
     * </ul>
     * @return Name of this qualifier.
     */
    String getName();

    /**
     * Boolean value that indicates if this qualifier can be overridden when propagated.
     * @return can be overridden
     */
    boolean isOverridable();

    /**
     * Boolean value that indicates if this qualifier is local.
     * @return qualifier is local
     */
    boolean isLocal();

    /**
     * Boolean value that indicates if this qualifier has been localized using a merge operation.
     * @return has been localized using a merge operation
     */
    boolean isAmended();
}
