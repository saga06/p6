
package com.library.oc.library.business.contract.manager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour bookBorrowedWithEmail complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="bookBorrowedWithEmail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="alreadyExtended" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="bookTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="borrowsWithEmails" type="{http://manager.contract.business.library.oc.library.com/}bookBorrowedWithEmail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dateEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dateStart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idBook" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idBorrow" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idBorrower" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idUser" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="returned" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="returnedOnTime" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookBorrowedWithEmail", propOrder = {
    "alreadyExtended",
    "bookTitle",
    "borrowsWithEmails",
    "dateEnd",
    "dateStart",
    "email",
    "id",
    "idBook",
    "idBorrow",
    "idBorrower",
    "idUser",
    "lastname",
    "returned",
    "returnedOnTime",
    "surname"
})
public class BookBorrowedWithEmail {

    protected boolean alreadyExtended;
    protected String bookTitle;
    @XmlElement(nillable = true)
    protected List<BookBorrowedWithEmail> borrowsWithEmails;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateEnd;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateStart;
    protected String email;
    protected Integer id;
    protected Integer idBook;
    protected Integer idBorrow;
    protected Integer idBorrower;
    protected Integer idUser;
    protected String lastname;
    protected boolean returned;
    protected boolean returnedOnTime;
    protected String surname;

    /**
     * Obtient la valeur de la propriété alreadyExtended.
     * 
     */
    public boolean isAlreadyExtended() {
        return alreadyExtended;
    }

    /**
     * Définit la valeur de la propriété alreadyExtended.
     * 
     */
    public void setAlreadyExtended(boolean value) {
        this.alreadyExtended = value;
    }

    /**
     * Obtient la valeur de la propriété bookTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Définit la valeur de la propriété bookTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookTitle(String value) {
        this.bookTitle = value;
    }

    /**
     * Gets the value of the borrowsWithEmails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the borrowsWithEmails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBorrowsWithEmails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BookBorrowedWithEmail }
     * 
     * 
     */
    public List<BookBorrowedWithEmail> getBorrowsWithEmails() {
        if (borrowsWithEmails == null) {
            borrowsWithEmails = new ArrayList<BookBorrowedWithEmail>();
        }
        return this.borrowsWithEmails;
    }

    /**
     * Obtient la valeur de la propriété dateEnd.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEnd() {
        return dateEnd;
    }

    /**
     * Définit la valeur de la propriété dateEnd.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEnd(XMLGregorianCalendar value) {
        this.dateEnd = value;
    }

    /**
     * Obtient la valeur de la propriété dateStart.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateStart() {
        return dateStart;
    }

    /**
     * Définit la valeur de la propriété dateStart.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateStart(XMLGregorianCalendar value) {
        this.dateStart = value;
    }

    /**
     * Obtient la valeur de la propriété email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit la valeur de la propriété email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété idBook.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdBook() {
        return idBook;
    }

    /**
     * Définit la valeur de la propriété idBook.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdBook(Integer value) {
        this.idBook = value;
    }

    /**
     * Obtient la valeur de la propriété idBorrow.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdBorrow() {
        return idBorrow;
    }

    /**
     * Définit la valeur de la propriété idBorrow.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdBorrow(Integer value) {
        this.idBorrow = value;
    }

    /**
     * Obtient la valeur de la propriété idBorrower.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdBorrower() {
        return idBorrower;
    }

    /**
     * Définit la valeur de la propriété idBorrower.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdBorrower(Integer value) {
        this.idBorrower = value;
    }

    /**
     * Obtient la valeur de la propriété idUser.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * Définit la valeur de la propriété idUser.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUser(Integer value) {
        this.idUser = value;
    }

    /**
     * Obtient la valeur de la propriété lastname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Définit la valeur de la propriété lastname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Obtient la valeur de la propriété returned.
     * 
     */
    public boolean isReturned() {
        return returned;
    }

    /**
     * Définit la valeur de la propriété returned.
     * 
     */
    public void setReturned(boolean value) {
        this.returned = value;
    }

    /**
     * Obtient la valeur de la propriété returnedOnTime.
     * 
     */
    public boolean isReturnedOnTime() {
        return returnedOnTime;
    }

    /**
     * Définit la valeur de la propriété returnedOnTime.
     * 
     */
    public void setReturnedOnTime(boolean value) {
        this.returnedOnTime = value;
    }

    /**
     * Obtient la valeur de la propriété surname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Définit la valeur de la propriété surname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

}
