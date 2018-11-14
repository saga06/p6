package com.library.oc.library.model.bean.book;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Objet métier représentant un emprunt
 *
 * @author sga
 */
public class BookBorrowed {

    // ==================== Attributs ====================
    private Integer idBorrow;

    private Date dateStart;

    private Date dateEnd;

    private boolean alreadyExtended;

    private Integer idBorrower;

    private Integer idBook;

    private boolean returned;

    private boolean returnedOnTime;


    private List<BookBorrowed> books = new ArrayList<BookBorrowed>();

    @NotNull
    private Integer id;

    @NotNull
    private Integer numberOfCopies;

    @NotNull
    private Integer nbOfCopiesAlreadyBorrowed;

    @NotNull
    private Integer nbOfCopiesAvailable;

    @NotNull
    private String title;

    @NotNull
    private String editorName;

    @NotNull
    private String isbn;

    private String resume;

    public Integer getEditorId() { return editorId; }

    public void setEditorId(Integer editorId) { this.editorId = editorId; }

    @NotNull
    private Integer editorId;

    private List<Author> authors = new ArrayList<Author>();

    private List<Theme> themes = new ArrayList<Theme>();


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public BookBorrowed() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public BookBorrowed(Integer pId) {
        id = pId;
    }

    // ==================== Getters/Setters ====================


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isAlreadyExtended() { return alreadyExtended; }
    public void setAlreadyExtended(boolean alreadyExtended) {
        this.alreadyExtended = alreadyExtended;
    }

    public Integer getIdBorrower() {
        return idBorrower;
    }
    public void setIdBorrower(Integer idBorrower) {
        this.idBorrower = idBorrower;
    }

    public Integer getIdBook() {
        return idBook;
    }
    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public boolean isReturned() { return returned; }
    public void setReturned(boolean returned) { this.returned = returned; }


    public boolean isReturnedOnTime() { return returnedOnTime; }
    public void setReturnedOnTime(boolean returnedOnTime) { this.returnedOnTime = returnedOnTime; }

    public Integer getIdBorrow() { return idBorrow; }
    public void setIdBorrow(Integer idBorrow) {
        this.idBorrow = idBorrow;
    }

    public List<BookBorrowed> getBooks() { return books; }
    public void setBooks(List<BookBorrowed> books) { this.books = books; }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }
    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Integer getNbOfCopiesAlreadyBorrowed() { return nbOfCopiesAlreadyBorrowed; }
    public void setNbOfCopiesAlreadyBorrowed(Integer nbOfCopiesAlreadyBorrowed) { this.nbOfCopiesAlreadyBorrowed = nbOfCopiesAlreadyBorrowed; }

    public Integer getNbOfCopiesAvailable() { return nbOfCopiesAvailable; }
    public void setNbOfCopiesAvailable(Integer nbOfCopiesAvailable) { this.nbOfCopiesAvailable = nbOfCopiesAvailable; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditorName() {
        return editorName;
    }
    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getResume() {
        return resume;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Theme> getThemes() {
        return themes;
    }
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }



}
