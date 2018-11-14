
package com.library.oc.library.business.contract.manager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getNbOfCopiesAvailableForABookBorrowed complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getNbOfCopiesAvailableForABookBorrowed"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookBorrowed" type="{http://manager.contract.business.library.oc.library.com/}bookBorrowed" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNbOfCopiesAvailableForABookBorrowed", propOrder = {
    "bookBorrowed"
})
public class GetNbOfCopiesAvailableForABookBorrowed {

    protected BookBorrowed bookBorrowed;

    /**
     * Obtient la valeur de la propriété bookBorrowed.
     * 
     * @return
     *     possible object is
     *     {@link BookBorrowed }
     *     
     */
    public BookBorrowed getBookBorrowed() {
        return bookBorrowed;
    }

    /**
     * Définit la valeur de la propriété bookBorrowed.
     * 
     * @param value
     *     allowed object is
     *     {@link BookBorrowed }
     *     
     */
    public void setBookBorrowed(BookBorrowed value) {
        this.bookBorrowed = value;
    }

}
