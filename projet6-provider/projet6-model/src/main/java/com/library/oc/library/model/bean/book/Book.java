package com.library.oc.library.model.bean.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.library.oc.library.model.bean.user.User;


/**
 * Objet métier représentant un Book
 *
 * @author sga
 */
public class Book {

    // ==================== Attributs ====================
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

    public void setEditorId(Integer editorId) { this.editorId = editorId; }

    @NotNull
    private Integer editorId;

    private List<Author> authors = new ArrayList<Author>();

    private List<Theme> themes = new ArrayList<Theme>();


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Book() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Book(Integer pId) {
        id = pId;
    }

    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }

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

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getEditorName() { return editorName; }
    public void setEditorName(String editorName) { this.editorName = editorName; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getResume() { return resume; }

    public void setResume(String resume) { this.resume = resume; }

    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) { this.authors = authors; }

    public List<Theme> getThemes() {
        return themes;
    }
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
    

}
