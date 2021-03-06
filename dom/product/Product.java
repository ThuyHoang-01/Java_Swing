//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.20 at 07:23:39 PM ICT 
//


package sesion11.dom.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}manufacture"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}suplier"/>
 *         &lt;element ref="{}unitbaseprice"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "manufacture",
    "description",
    "suplier",
    "unitbaseprice"
})
@XmlRootElement(name = "product")
public class Product {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String manufacture;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected Suplier suplier;
    protected double unitbaseprice;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the manufacture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacture() {
        return manufacture;
    }

    /**
     * Sets the value of the manufacture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacture(String value) {
        this.manufacture = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the suplier property.
     * 
     * @return
     *     possible object is
     *     {@link Suplier }
     *     
     */
    public Suplier getSuplier() {
        return suplier;
    }

    /**
     * Sets the value of the suplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Suplier }
     *     
     */
    public void setSuplier(Suplier value) {
        this.suplier = value;
    }

    /**
     * Gets the value of the unitbaseprice property.
     * 
     */
    public double getUnitbaseprice() {
        return unitbaseprice;
    }

    /**
     * Sets the value of the unitbaseprice property.
     * 
     */
    public void setUnitbaseprice(double value) {
        this.unitbaseprice = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
