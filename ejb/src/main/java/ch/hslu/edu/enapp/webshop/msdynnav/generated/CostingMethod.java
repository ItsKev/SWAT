
package ch.hslu.edu.enapp.webshop.msdynnav.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r Costing_Method.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="Costing_Method">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FIFO"/>
 *     &lt;enumeration value="LIFO"/>
 *     &lt;enumeration value="Specific"/>
 *     &lt;enumeration value="Average"/>
 *     &lt;enumeration value="Standard"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Costing_Method")
@XmlEnum
public enum CostingMethod {

    FIFO("FIFO"),
    LIFO("LIFO"),
    @XmlEnumValue("Specific")
    SPECIFIC("Specific"),
    @XmlEnumValue("Average")
    AVERAGE("Average"),
    @XmlEnumValue("Standard")
    STANDARD("Standard");
    private final String value;

    CostingMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CostingMethod fromValue(String v) {
        for (CostingMethod c: CostingMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
