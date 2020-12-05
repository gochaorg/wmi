package xyz.cofe.win.activex;

import com.jacob.com.Variant;

/**
 * https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemnamedvalue
 */
public interface SWbemNamedValue {
    String getName();
    Variant getVariant();
}
