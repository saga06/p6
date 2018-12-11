
package com.library.oc.library.business.contract.manager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getDateOfReturnOfOldestBorrowOfABookResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getDateOfReturnOfOldestBorrowOfABookResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://manager.contract.business.library.oc.library.com/}bookBorrowed" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDateOfReturnOfOldestBorrowOfABookResponse", propOrder = {
    "_return"
})
public class GetDateOfReturnOfOldestBorrowOfABookResponse {

    @XmlElement(name = "return")
    protected BookBorrowed _return;

    /**
     * Obtient la valeur de la propriété return.
     * 
     * @return
     *     possible object is
     *     {@link BookBorrowed }
     *     
     */
    public BookBorrowed getReturn() {
        return _return;
    }

    /**
     * Définit la valeur de la propriété return.
     * 
     * @param value
     *     allowed object is
     *     {@link BookBorrowed }
     *     
     */
    public void setReturn(BookBorrowed value) {
        this._return = value;
    }

}
