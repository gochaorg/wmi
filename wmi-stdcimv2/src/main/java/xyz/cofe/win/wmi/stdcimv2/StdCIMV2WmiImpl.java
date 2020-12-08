package xyz.cofe.win.wmi.stdcimv2;

import xyz.cofe.win.wmi.Wmi;
import xyz.cofe.win.wmi.WmiProxy;

public class StdCIMV2WmiImpl extends WmiProxy implements StdCIMV2Wmi {
    public StdCIMV2WmiImpl(Wmi target) {
        super(target);
    }
}
