package xyz.cofe.win.activex;

/**
 * The <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemsecurity">
 *     SWbemSecurity
 *     </a>
 *     object gets or sets security settings, such as privileges,
 * COM impersonations, and authentication levels assigned to an object.
 *
 * <p>
 * The SWbemLocator, SWbemServices, SWbemObject, SWbemObjectSet, SWbemObjectPath, SWbemLastError, and SWbemEventSource
 * objects have a Security_ property, which is the SWbemSecurity object.
 *
 * <p>
 * When you retrieve an instance or view the WMI security log, you might need to set the properties of the Security_ object.
 *
 * <p>
 * The VBScript CreateObject call cannot create the Security object.
 *
 * <p>
 * The security settings in this object do not identify the authentication, impersonation,
 * or privilege settings on a connection to WMI,
 * or the security in effect for the proxy when an object is delivered to a sink in an asynchronous call.
 *
 * <h2>
 *     <a href="https://docs.microsoft.com/en-us/windows/win32/secbp/running-with-special-privileges">
 *     Running with Special Privileges
 *     </a>
 * </h2>
 *
 * Some functions require special privileges to run correctly.
 * In some cases, the function can only be run by certain users or by members of certain groups.
 * The most common requirement is that the user be a local administrator.
 * Other functions require the user's account to have specific privileges enabled.
 *
 * <p>
 * To reduce the possibility of unauthorized code being able to get control,
 * the system should run with the least privilege necessary.
 * Applications that need to call functions that require special
 * privileges can leave the system open to attack by hackers.
 * Such applications should be designed to run for short periods of time and should inform
 * the user of the security implications involved.
 *
 * <p>
 * For information about how to run as different users and how to
 * enable privileges in your application, see the following topics:
 *
 * <ul>
 *   <li>
 *       <a href="https://docs.microsoft.com/en-us/windows/win32/secbp/running-with-administrator-privileges">
 *       Running with Administrator Privileges
 *       </a>
 *   <li>
 *       <a href="https://docs.microsoft.com/en-us/windows/win32/secbp/asking-the-user-for-credentials">
 *       Asking the User for Credentials
 *       </a>
 *   <li>
 *       <a href="https://docs.microsoft.com/en-us/windows/win32/secbp/changing-privileges-in-a-token">
 *       Changing Privileges in a Token
 *       </a>
 *   <li>
 *       <a href="https://docs.microsoft.com/en-us/windows/win32/secbp/assigning-privileges-to-an-account">
 *       Assigning Privileges to an Account
 *       </a>
 * </ul>
 */
public interface SWbemSecurity {
    /**
     * Numeric value that defines the COM Authentication level that is assigned to this object. This setting determines how you protect information sent from WMI.
     *
     * <ul>
     *   <li><b>WbemAuthenticationLevelDefault 0 &amp;H0</b>
     *       <br>WMI uses the default Windows Authentication setting.
     *   <li><b>WbemAuthenticationLevelNone 1 &amp;H1</b>
     *       <br>Uses no authentication.
     *   <li><b>WbemAuthenticationLevelConnect 2 &amp;H2</b>
     *       <br>Authenticates the credentials of the client only when the client establishes a relationship with the server.
     *   <li><b>WbemAuthenticationLevelCall 3 &amp;H3</b>
     *       <br>Authenticates only at the beginning of each call when the server receives the request.
     *   <li><b>WbemAuthenticationLevelPkt 4 &amp;H4</b>
     *       <br>Authenticates that all data received is from the expected client.
     *   <li><b>WbemAuthenticationLevelPktIntegrity 5 &amp;H5</b>
     *       <br>Authenticates and verifies that none of the data transferred between client and server has been modified.
     *   <li><b>WbemAuthenticationLevelPktPrivacy 6 &amp;H6</b>
     *       <br>Authenticates all previous impersonation levels and encrypts the argument value of each remote procedure call.
     * </ul>
     *
     * <pre>
     * strComputer = "RemoteComputer"
     * Set objWMIServices = GetObject("WINMGMTS:" _
     *     & "{authenticationLevel=pktPrivacy}!\\" _
     *     & strComputer & "\ROOT\CIMV2")
     * </pre>
     * @return authentication level
     */
    int getAuthenticationLevel();

    /**
     * Numeric value that defines the COM Impersonation level
     * that is assigned to this object.
     *
     * This setting determines if processes owned by WMI can detect
     * or use your security credentials when making calls to other processes.
     *
     * <ul>
     *     <li>01 - Anonymous
     *     <li>02 - Identify
     *     <li>03 - Impersonate
     *     <li>04 - Delegate
     * </ul>
     * @return impersonation level
     */
    int getImpersonationLevel();

    /**
     * object that defines privileges for this object.
     * @return privileges
     */
    SWbemPrivilegeSet getPrivileges();
}
