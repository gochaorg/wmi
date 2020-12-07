package xyz.cofe.win.activex;

import java.util.List;
import java.util.Optional;

/**
 * <a href="https://docs.microsoft.com/en-us/windows/win32/wmisdk/swbempropertyset">Перечень свойств объекта</a>.
 *
 * <p>
 * An SWbemPropertySet object is a collection of SWbemProperty objects.
 * You can add items to the collection using the Add method, retrieve items from the collection using the Item method,
 * and remove items from the collection using the Remove method. For more information, see Accessing a Collection.
 *
 * <p>
 * This object cannot be created by the VBScript CreateObject call.
 *
 * <p>
 * The SWbemProperty objects that make up an SWbemPropertySet collection are used to describe the properties of a single WMI class or instance.
 *
 * <p>
 * Объект SWbemPropertySet - это набор объектов SWbemProperty.
 * Вы можете добавлять элементы в коллекцию с помощью метода Add, извлекать элементы из коллекции
 * с помощью метода Item и удалять элементы из коллекции с помощью метода Remove.
 *
 * <p>
 * Для получения дополнительной информации см. Доступ к коллекции.
 * Этот объект не может быть создан с помощью вызова VBScript CreateObject.
 *
 * <p>
 * Объекты SWbemProperty, составляющие коллекцию SWbemPropertySet,
 * используются для описания свойств одного класса или экземпляра WMI.
 */
public interface SWbemPropertySet extends ArrayView<SWbemProperty,SWbemPropertySet> {
}
