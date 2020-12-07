package xyz.cofe.win.activex;

/**
 * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemprivilegeset">
 *     SWbemPrivilegeSet
 * </a>
 *
 * An SWbemPrivilegeSet object is a collection of SWbemPrivilege objects in an SWbemSecurity object that requests specific privileges for a Windows Management Instrumentation (WMI) object. See the list of privileges in Privilege Constants. Items are added to the collection using the Add and AddAsString methods. Items are retrieved from the collection using the Item method, and removed using the Remove method. This object cannot be created by the VBScript CreateObject method call. For more information, see Accessing a Collection.
 *
 * An SWbemPrivilegeSet object is a set of privilege override requests for a specific object. When an API call is made using this object, the privilege override requests are attempted. The SWbemPrivilegeSet object does not define the privileges available to the current user or process. In other words, obtaining the privileges for any WMI object does not identify the privilege settings that are made on the connection to WMI, or the privileges in effect when an object is delivered to a sink.
 */
public interface SWbemPrivilegeSet extends ArrayView<SWbemPrivilege,SWbemPrivilegeSet> {
}
