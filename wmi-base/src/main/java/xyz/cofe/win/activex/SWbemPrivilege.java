package xyz.cofe.win.activex;

/**
 * The
 * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemprivilege">
 * SWbemPrivilege
 * </a>
 * object represents a single privilege. This object cannot be created by the VBScript CreateObject call.
 */
public interface SWbemPrivilege {
    /**
     * Display name of this privilege.
     * @return display name
     */
    String getDisplayName();

    /**
     * Integer that represents the privilege that is being set or retrieved.
     * @return id
     */
    int getIdentifier();

    /**
     * Boolean value that indicates if this privilege is enabled.
     * @return enabled
     */
    boolean isEnabled();

    /**
     * Name of this privilege.
     * @return name
     */
    String getName();
}
