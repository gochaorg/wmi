package xyz.cofe.win.activex;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.JacobObject;
import com.jacob.com.Variant;

public interface ActiveXMethods {
    Dispatch getObject();
    Variant getProperty(String propertyName);
    ActiveXComponent getPropertyAsComponent(String propertyName);
    boolean getPropertyAsBoolean(String propertyName);
    byte getPropertyAsByte(String propertyName);
    String getPropertyAsString(String propertyName);
    int getPropertyAsInt(String propertyName);
    void setProperty(String propertyName, Variant arg);
    void setProperty(String propertyName, Dispatch arg);
    void setProperty(String propertyName, String propertyValue);
    void setProperty(String propertyName, boolean propValue);
    void setProperty(String propertyName, byte propValue);
    void setProperty(String propertyName, int propValue);
    void logCallbackEvent(String description, Variant[] args);
    ActiveXComponent invokeGetComponent(String callAction);
    ActiveXComponent invokeGetComponent(String callAction, Variant... parameters);
    Variant invoke(String actionCommand, String parameter);
    Variant invoke(String actionCommand, boolean parameter);
    Variant invoke(String actionCommand, int parameter);
    Variant invoke(String actionCommand, String parameter1, int parameter2);
    Variant invoke(String actionCommand, int parameter1, int parameter2);
    Variant invoke(String callAction);
    Variant invoke(String name, Variant... args);
    Dispatch QueryInterface(String iid);
    String getProgramId();
    void safeRelease();

    static ActiveXMethods of( ActiveXComponent c ){
        if( c==null )throw new IllegalArgumentException("c==null");
        return new ActiveXMethods() {
            @Override
            public Dispatch getObject() {
                return c.getObject();
            }

            @Override
            public Variant getProperty(String propertyName) {
                return c.getProperty(propertyName);
            }

            @Override
            public ActiveXComponent getPropertyAsComponent(String propertyName) {
                return c.getPropertyAsComponent(propertyName);
            }

            @Override
            public boolean getPropertyAsBoolean(String propertyName) {
                return c.getPropertyAsBoolean(propertyName);
            }

            @Override
            public byte getPropertyAsByte(String propertyName) {
                return c.getPropertyAsByte(propertyName);
            }

            @Override
            public String getPropertyAsString(String propertyName) {
                return c.getPropertyAsString(propertyName);
            }

            @Override
            public int getPropertyAsInt(String propertyName) {
                return c.getPropertyAsInt(propertyName);
            }

            @Override
            public void setProperty(String propertyName, Variant arg) {
                c.setProperty(propertyName,arg);
            }

            @Override
            public void setProperty(String propertyName, Dispatch arg) {
                c.setProperty(propertyName,arg);
            }

            @Override
            public void setProperty(String propertyName, String propertyValue) {
                c.setProperty(propertyName,propertyValue);
            }

            @Override
            public void setProperty(String propertyName, boolean propValue) {
                c.setProperty(propertyName,propValue);
            }

            @Override
            public void setProperty(String propertyName, byte propValue) {
                c.setProperty(propertyName,propValue);
            }

            @Override
            public void setProperty(String propertyName, int propValue) {
                c.setProperty(propertyName,propValue);
            }

            @Override
            public void logCallbackEvent(String description, Variant[] args) {
                c.logCallbackEvent(description,args);
            }

            @Override
            public ActiveXComponent invokeGetComponent(String callAction) {
                return c.invokeGetComponent(callAction);
            }

            @Override
            public ActiveXComponent invokeGetComponent(String callAction, Variant... parameters) {
                return c.invokeGetComponent(callAction,parameters);
            }

            @Override
            public Variant invoke(String actionCommand, String parameter) {
                return c.invoke(actionCommand,parameter);
            }

            @Override
            public Variant invoke(String actionCommand, boolean parameter) {
                return c.invoke(actionCommand,parameter);
            }

            @Override
            public Variant invoke(String actionCommand, int parameter) {
                return c.invoke(actionCommand,parameter);
            }

            @Override
            public Variant invoke(String actionCommand, String parameter1, int parameter2) {
                return c.invoke(actionCommand,parameter1,parameter2);
            }

            @Override
            public Variant invoke(String actionCommand, int parameter1, int parameter2) {
                return c.invoke(actionCommand,parameter1,parameter2);
            }

            @Override
            public Variant invoke(String callAction) {
                return c.invoke(callAction);
            }

            @Override
            public Variant invoke(String name, Variant... args) {
                return c.invoke(name,args);
            }

            @Override
            public Dispatch QueryInterface(String iid) {
                return c.QueryInterface(iid);
            }

            @Override
            public String getProgramId() {
                return c.getProgramId();
            }

            @Override
            public void safeRelease() {
                c.safeRelease();
            }
        };
    }
}
