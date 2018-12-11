package com.library.oc.library.model.bean.book;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookBorrowedWithEmail {
    // ==================== Attributs ====================

    private Integer idBorrow;
    private Integer idBook;
    private Integer idUser;
    private Calendar dateStart;
    private Calendar dateEnd;
    private boolean alreadyExtended;
    private Integer idBorrower;
    private boolean returned;
    private boolean returnedOnTime;
    private String email;
    private String bookTitle;

    private List <BookBorrowedWithEmail> borrowsWithEmails = new ArrayList<BookBorrowedWithEmail>();

    @NotNull
    private Integer id;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public BookBorrowedWithEmail() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public BookBorrowedWithEmail(Integer pId) {
        id = pId;
    }

    // ==================== Getters/Setters ====================


    public Integer getIdBorrow() {

        return idBorrow;
    }

    public void setIdBorrow(Integer idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Calendar getDateStart() {
        return dateStart;
    }

    public void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
    }

    public Calendar getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Calendar dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isAlreadyExtended() {
        return alreadyExtended;
    }

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

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public boolean isReturnedOnTime() {
        return returnedOnTime;
    }

    public void setReturnedOnTime(boolean returnedOnTime) {
        this.returnedOnTime = returnedOnTime;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public List<BookBorrowedWithEmail> getBorrowsWithEmails() {
        return borrowsWithEmails;
    }

    public void setBorrowsWithEmails(List<BookBorrowedWithEmail> borrowsWithEmails) {
        this.borrowsWithEmails = borrowsWithEmails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
