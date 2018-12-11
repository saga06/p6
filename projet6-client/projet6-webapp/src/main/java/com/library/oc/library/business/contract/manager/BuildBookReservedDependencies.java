
package com.library.oc.library.business.contract.manager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour buildBookReservedDependencies complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="buildBookReservedDependencies"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reservedBook" type="{http://manager.contract.business.library.oc.library.com/}bookReserved" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buildBookReservedDependencies", propOrder = {
    "reservedBook"
})
public class BuildBookReservedDependencies {

    protected BookReserved reservedBook;

    /**
     * Obtient la valeur de la propriété reservedBook.
     * 
     * @return
     *     possible object is
     *     {@link BookReserved }
     *     
     */
    public BookReserved getReservedBook() {
        return reservedBook;
    }

    /**
     * Définit la valeur de la propriété reservedBook.
     * 
     * @param value
     *     allowed object is
     *     {@link BookReserved }
     *     
     */
    public void setReservedBook(BookReserved value) {
        this.reservedBook = value;
    }

}
