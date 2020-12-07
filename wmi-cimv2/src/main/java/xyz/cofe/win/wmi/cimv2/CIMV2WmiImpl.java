package xyz.cofe.win.wmi.cimv2;

import xyz.cofe.win.wmi.Wmi;
import xyz.cofe.win.wmi.WmiProxy;

public class CIMV2WmiImpl extends WmiProxy implements CIMV2Wmi {
    public CIMV2WmiImpl(Wmi target) {
        super(target);
    }
}
