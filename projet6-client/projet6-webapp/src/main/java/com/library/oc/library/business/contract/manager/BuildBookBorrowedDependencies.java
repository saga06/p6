
package com.library.oc.library.business.contract.manager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour buildBookBorrowedDependencies complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="buildBookBorrowedDependencies"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="borrowedBook" type="{http://manager.contract.business.library.oc.library.com/}bookBorrowed" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buildBookBorrowedDependencies", propOrder = {
    "borrowedBook"
})
public class BuildBookBorrowedDependencies {

    protected BookBorrowed borrowedBook;

    /**
     * Obtient la valeur de la propriété borrowedBook.
     * 
     * @return
     *     possible object is
     *     {@link BookBorrowed }
     *     
     */
    public BookBorrowed getBorrowedBook() {
        return borrowedBook;
    }

    /**
     * Définit la valeur de la propriété borrowedBook.
     * 
     * @param value
     *     allowed object is
     *     {@link BookBorrowed }
     *     
     */
    public void setBorrowedBook(BookBorrowed value) {
        this.borrowedBook = value;
    }

}
