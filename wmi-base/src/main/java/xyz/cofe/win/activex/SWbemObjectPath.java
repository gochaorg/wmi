package xyz.cofe.win.activex;

public interface SWbemObjectPath {
    /**
     * The Authority property of the SWbemObjectPath object contains a string that defines the Authority component of the object path. For more information, see the strAuthority parameter of the SWbemLocator.ConnectServer method and Setting the Security on IWbemServices and Other Proxies.
     *
     * For an explanation of this syntax, see Document Conventions for the Scripting API.
     *
     * This property is read/write.
     * @return Authority
     */
    String getAuthority();

    /**
     * The Class property of the SWbemObjectPath object is the name of the class that is part of the object path.
     *
     * For an explanation of this syntax, see Document Conventions for the Scripting API.
     *
     * This property is read/write.
     * @return name of the class that is part of the object path
     */
    String getClazz();

    /**
     * The DisplayName property of the SWbemObjectPath object is a string that contains the path in a form that can be used as a moniker display name.
     *
     * For an explanation of this syntax, see Document Conventions for the Scripting API.
     *
     * This property is read/write.
     * @return display name
     */
    String getDisplayName();

    /**
     * The IsClass property of the SWbemObjectPath object is a Boolean value
     * that indicates if this path represents a class. This property is read-only.
     *
     * For an explanation of this syntax, see Document Conventions for the Scripting API.
     *
     * This property is read-only.
     * @return path represents a class
     */
    boolean isClassType();

    /**
     * The IsSingleton property of the SWbemObjectPath object is a Boolean value
     * that indicates if this path represents a singleton instance.
     *
     * A singleton instance is an instance of a class that can never have more than one instance. This property is read-only.
     *
     * For an explanation of this syntax, see Document Conventions for the Scripting API.
     *
     * This property is read-only.
     * @return path represents a singleton instance
     */
    boolean isSingleton();

    /**
     * The Locale property of the SWbemObjectPath object contains the locale of object path.
     *
     * When the SWbemObjectPath.Locale property is part of a standalone SWbemObjectPath object,
     * it is read/write and can be used to set the locale component of the moniker.
     *
     * When the SWbemObjectPath.Locale property is accessed as part of a
     * SWbemObject.Path_ property, it is read-only and reports the value of the locale used in binding to the namespace from which the object was obtained.
     *
     * For Microsoft locale identifiers, the format of the string is "MS_xxxx", where xxxx is a string in hexadecimal form that indicates the LCID. For example, the American English locale identifier is "MS_409".
     *
     * For an explanation of this syntax, see Document Conventions for the Scripting API.
     *
     * This property is read/write.
     * @return the locale of object path
     */
    String getLocale();

    /**
     * The Namespace property of the SWbemObjectPath object contains
     * the name of the namespace that is part of the object path. For example,
     * the following path shows the namespace property that returns root\cimv2:
     *
     * \\computer\root\cimv2:win32_logicaldisk="a:"
     *
     * @return namespace
     */
    String getNamespace();

    String getParentNamespace();

    String getPath();

    String getRelpath();

    String getServer();

    //Object getSecurity();

    //Object getKeys();
}
