package xyz.cofe.win.activex;

import com.jacob.com.Variant;
import xyz.cofe.win.wmi.WmiObj;

import java.util.Optional;

/**
 * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbemproperty">Описание свойства</a>
 *
 * <p>
 * The SWbemProperty object represents a single WMI property of a managed object.
 * This object cannot be created by the VBScript CreateObject call.
 *
 * <p>
 * Объект SWbemProperty представляет отдельное свойство WMI управляемого объекта.
 * Этот объект не может быть создан с помощью вызова VBScript CreateObject.
 */
public interface SWbemProperty extends GetWmiQualifiers {
    /**
     * <pre>
     * SWbemProperty.Name property
     * SWbemProperty.Name As String
     * This property is read-only.
     *
     * Requirements
     *
     * Minimum supported client - Windows Vista
     * Minimum supported server - Windows Server 2008
     * Header - Wbemdisp.h
     * Type library - Wbemdisp.tlb
     * DLL - Wbemdisp.dll
     *
     * CLSID - CLSID_SWbemProperty
     * IID - IID_ISWbemProperty
     *
     * </pre>
     * @return name of property
     */
    String getName();

    /**
     * <pre>
     * The IsLocal property of the SWbemProperty object is a Boolean
     * value that can be used to determine if this property is local.
     *
     * A value of FALSE indicates that this property has been inherited from another class.
     *
     * This property is read-only.
     * </pre>
     * @return A value of FALSE indicates that this property has been inherited from another class.
     */
    boolean isLocal();

    /**
     * The IsArray property of the SWbemProperty object is a Boolean value that can be used to determine
     * if this property has an array type.

     * <p>
     * This property is read-only.
     *
     * @return if this property has an array type.
     */
    boolean isArray();

    /**
     * The CIMType property of the SWbemProperty object is an integer that can be used to determine the CIM type of this property.
     *
     * <p>
     * This property is read-only.
     *
     * <p>
     * Свойство CIMType объекта SWbemProperty является целым числом, которое можно использовать для определения типа CIM этого свойства.
     *
     * @return CIMType
     */
    WbemCIMType getCIMType();

    /**
     * The Origin property of the SWbemProperty object retrieves the name of the WMI class in which this
     * property was introduced. For classes with deep inheritance hierarchies,
     *
     * it is often desirable to know which properties were declared in which classes.
     *
     * <p>
     * If the property is local (see SWbemQualifier.IsLocal), this value is the same as the owning class.
     *
     * <p>
     * This property is read-only.
     *
     * <p>
     * Свойство Origin объекта SWbemProperty извлекает имя класса WMI, в котором это свойство было введено.
     * Для классов с глубокой иерархией наследования часто бывает желательно знать,
     * какие свойства были объявлены в каких классах.
     *
     * <p>
     *     Если свойство является локальным (см. SWbemQualifier.IsLocal), это значение совпадает с классом-владельцем.
     * @return Origin property
     */
    String getOrigin();

    /**
     * Значение свойства
     * @return свойство
     */
    Variant getVariant();

    /**
     * Ссылка на объект, актуально для тех свойств, чей тип (getCIMType) {@link WbemCIMType#REFERENCE}
     * @return объект
     */
    Optional<WmiObj> getReference();
}
