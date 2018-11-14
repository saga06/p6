
package com.library.oc.library.business.contract.manager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour book complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="book"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="authors" type="{http://manager.contract.business.library.oc.library.com/}author" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="editorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nbOfCopiesAlreadyBorrowed" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nbOfCopiesAvailable" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="numberOfCopies" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="resume" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="themes" type="{http://manager.contract.business.library.oc.library.com/}theme" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "authors",
    "editorName",
    "id",
    "isbn",
    "nbOfCopiesAlreadyBorrowed",
    "nbOfCopiesAvailable",
    "numberOfCopies",
    "resume",
    "themes",
    "title"
})
public class Book {

    @XmlElement(nillable = true)
    protected List<Author> authors;
    protected String editorName;
    protected Integer id;
    protected String isbn;
    protected Integer nbOfCopiesAlreadyBorrowed;
    protected Integer nbOfCopiesAvailable;
    protected Integer numberOfCopies;
    protected String resume;
    @XmlElement(nillable = true)
    protected List<Theme> themes;
    protected String title;

    /**
     * Gets the value of the authors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Author }
     * 
     * 
     */
    public List<Author> getAuthors() {
        if (authors == null) {
            authors = new ArrayList<Author>();
        }
        return this.authors;
    }

    /**
     * Obtient la valeur de la propriété editorName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditorName() {
        return editorName;
    }

    /**
     * Définit la valeur de la propriété editorName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditorName(String value) {
        this.editorName = value;
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
     * Obtient la valeur de la propriété isbn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Définit la valeur de la propriété isbn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbn(String value) {
        this.isbn = value;
    }

    /**
     * Obtient la valeur de la propriété nbOfCopiesAlreadyBorrowed.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbOfCopiesAlreadyBorrowed() {
        return nbOfCopiesAlreadyBorrowed;
    }

    /**
     * Définit la valeur de la propriété nbOfCopiesAlreadyBorrowed.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbOfCopiesAlreadyBorrowed(Integer value) {
        this.nbOfCopiesAlreadyBorrowed = value;
    }

    /**
     * Obtient la valeur de la propriété nbOfCopiesAvailable.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbOfCopiesAvailable() {
        return nbOfCopiesAvailable;
    }

    /**
     * Définit la valeur de la propriété nbOfCopiesAvailable.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbOfCopiesAvailable(Integer value) {
        this.nbOfCopiesAvailable = value;
    }

    /**
     * Obtient la valeur de la propriété numberOfCopies.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * Définit la valeur de la propriété numberOfCopies.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfCopies(Integer value) {
        this.numberOfCopies = value;
    }

    /**
     * Obtient la valeur de la propriété resume.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResume() {
        return resume;
    }

    /**
     * Définit la valeur de la propriété resume.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResume(String value) {
        this.resume = value;
    }

    /**
     * Gets the value of the themes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the themes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThemes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Theme }
     * 
     * 
     */
    public List<Theme> getThemes() {
        if (themes == null) {
            themes = new ArrayList<Theme>();
        }
        return this.themes;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
