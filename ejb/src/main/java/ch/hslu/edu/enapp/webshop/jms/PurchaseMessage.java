
package ch.hslu.edu.enapp.webshop.jms;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="payId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="purchaseId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="student" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customer">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dynNavCustNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="postCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="shopLoginname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lines">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="line" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="msDynNAVItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="totalLinePrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "payId",
        "purchaseId",
        "student",
        "totalPrice",
        "date",
        "customer",
        "lines"
})
@XmlRootElement(name = "purchaseMessage")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class PurchaseMessage {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String payId;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String purchaseId;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String student;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String totalPrice;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String date;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected PurchaseMessage.Customer customer;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected PurchaseMessage.Lines lines;

    /**
     * Ruft den Wert der payId-Eigenschaft ab.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getPayId() {
        return payId;
    }

    /**
     * Legt den Wert der payId-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPayId(String value) {
        this.payId = value;
    }

    /**
     * Ruft den Wert der purchaseId-Eigenschaft ab.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getPurchaseId() {
        return purchaseId;
    }

    /**
     * Legt den Wert der purchaseId-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setPurchaseId(String value) {
        this.purchaseId = value;
    }

    /**
     * Ruft den Wert der student-Eigenschaft ab.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getStudent() {
        return student;
    }

    /**
     * Legt den Wert der student-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setStudent(String value) {
        this.student = value;
    }

    /**
     * Ruft den Wert der totalPrice-Eigenschaft ab.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     * Legt den Wert der totalPrice-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTotalPrice(String value) {
        this.totalPrice = value;
    }

    /**
     * Ruft den Wert der date-Eigenschaft ab.
     *
     * @return possible object is
     * {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getDate() {
        return date;
    }

    /**
     * Legt den Wert der date-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Ruft den Wert der customer-Eigenschaft ab.
     *
     * @return possible object is
     * {@link PurchaseMessage.Customer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public PurchaseMessage.Customer getCustomer() {
        return customer;
    }

    /**
     * Legt den Wert der customer-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link PurchaseMessage.Customer }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setCustomer(PurchaseMessage.Customer value) {
        this.customer = value;
    }

    /**
     * Ruft den Wert der lines-Eigenschaft ab.
     *
     * @return possible object is
     * {@link PurchaseMessage.Lines }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public PurchaseMessage.Lines getLines() {
        return lines;
    }

    /**
     * Legt den Wert der lines-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link PurchaseMessage.Lines }
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLines(PurchaseMessage.Lines value) {
        this.lines = value;
    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     *
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="dynNavCustNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="postCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="shopLoginname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "dynNavCustNo",
            "name",
            "address",
            "postCode",
            "city",
            "shopLoginname"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class Customer {

        @XmlElement(required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String dynNavCustNo;
        @XmlElement(required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String name;
        @XmlElement(required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String address;
        @XmlElement(required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String postCode;
        @XmlElement(required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String city;
        @XmlElement(required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String shopLoginname;

        /**
         * Ruft den Wert der dynNavCustNo-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getDynNavCustNo() {
            return dynNavCustNo;
        }

        /**
         * Legt den Wert der dynNavCustNo-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setDynNavCustNo(String value) {
            this.dynNavCustNo = value;
        }

        /**
         * Ruft den Wert der name-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getName() {
            return name;
        }

        /**
         * Legt den Wert der name-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Ruft den Wert der address-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getAddress() {
            return address;
        }

        /**
         * Legt den Wert der address-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setAddress(String value) {
            this.address = value;
        }

        /**
         * Ruft den Wert der postCode-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getPostCode() {
            return postCode;
        }

        /**
         * Legt den Wert der postCode-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setPostCode(String value) {
            this.postCode = value;
        }

        /**
         * Ruft den Wert der city-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getCity() {
            return city;
        }

        /**
         * Legt den Wert der city-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setCity(String value) {
            this.city = value;
        }

        /**
         * Ruft den Wert der shopLoginname-Eigenschaft ab.
         *
         * @return possible object is
         * {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getShopLoginname() {
            return shopLoginname;
        }

        /**
         * Legt den Wert der shopLoginname-Eigenschaft fest.
         *
         * @param value allowed object is
         *              {@link String }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setShopLoginname(String value) {
            this.shopLoginname = value;
        }

    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     *
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="line" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="msDynNAVItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="totalLinePrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "line"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class Lines {

        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected List<PurchaseMessage.Lines.Line> line;

        /**
         * Gets the value of the line property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the line property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLine().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PurchaseMessage.Lines.Line }
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public List<PurchaseMessage.Lines.Line> getLine() {
            if (line == null) {
                line = new ArrayList<PurchaseMessage.Lines.Line>();
            }
            return this.line;
        }

        public void setLine(List<PurchaseMessage.Lines.Line> lines) {
            this.line = lines;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         *
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="msDynNAVItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="totalLinePrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "msDynNAVItemNo",
                "description",
                "quantity",
                "totalLinePrice"
        })
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public static class Line {

            @XmlElement(required = true)
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected String msDynNAVItemNo;
            @XmlElement(required = true)
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected String description;
            @XmlElement(required = true)
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected String quantity;
            @XmlElement(required = true)
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected String totalLinePrice;

            /**
             * Ruft den Wert der msDynNAVItemNo-Eigenschaft ab.
             *
             * @return possible object is
             * {@link String }
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public String getMsDynNAVItemNo() {
                return msDynNAVItemNo;
            }

            /**
             * Legt den Wert der msDynNAVItemNo-Eigenschaft fest.
             *
             * @param value allowed object is
             *              {@link String }
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public void setMsDynNAVItemNo(String value) {
                this.msDynNAVItemNo = value;
            }

            /**
             * Ruft den Wert der description-Eigenschaft ab.
             *
             * @return possible object is
             * {@link String }
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public String getDescription() {
                return description;
            }

            /**
             * Legt den Wert der description-Eigenschaft fest.
             *
             * @param value allowed object is
             *              {@link String }
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public void setDescription(String value) {
                this.description = value;
            }

            /**
             * Ruft den Wert der quantity-Eigenschaft ab.
             *
             * @return possible object is
             * {@link String }
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public String getQuantity() {
                return quantity;
            }

            /**
             * Legt den Wert der quantity-Eigenschaft fest.
             *
             * @param value allowed object is
             *              {@link String }
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public void setQuantity(String value) {
                this.quantity = value;
            }

            /**
             * Ruft den Wert der totalLinePrice-Eigenschaft ab.
             *
             * @return possible object is
             * {@link String }
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public String getTotalLinePrice() {
                return totalLinePrice;
            }

            /**
             * Legt den Wert der totalLinePrice-Eigenschaft fest.
             *
             * @param value allowed object is
             *              {@link String }
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2018-12-03T08:39:42+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public void setTotalLinePrice(String value) {
                this.totalLinePrice = value;
            }

        }

    }

}
