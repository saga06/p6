
package com.library.oc.library.business.contract.manager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getListReservationByBookOrderByDate complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getListReservationByBookOrderByDate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBook" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListReservationByBookOrderByDate", propOrder = {
    "idBook"
})
public class GetListReservationByBookOrderByDate {

    protected int idBook;

    /**
     * Obtient la valeur de la propriété idBook.
     * 
     */
    public int getIdBook() {
        return idBook;
    }

    /**
     * Définit la valeur de la propriété idBook.
     * 
     */
    public void setIdBook(int value) {
        this.idBook = value;
    }

}
