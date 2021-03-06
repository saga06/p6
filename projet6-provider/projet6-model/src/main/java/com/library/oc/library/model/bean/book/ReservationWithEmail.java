package com.library.oc.library.model.bean.book;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReservationWithEmail {
    // ==================== Attributs ====================

    private Integer idReservation;
    private Integer idBook;
    private Integer idUser;
    private Calendar dateOfReservation;
    private Boolean active;
    private Boolean emailSend;
    private Calendar dateOfEmail;
    private String email;
    private String bookTitle;

    private List <ReservationWithEmail> reservationWithEmails = new ArrayList<ReservationWithEmail>();

    @NotNull
    private Integer id;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public ReservationWithEmail() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public ReservationWithEmail(Integer pId) {
        id = pId;
    }

    // ==================== Getters/Setters ====================


    public Integer getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Integer getIdBook() {
        return idBook;
    }
    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Calendar getDateOfReservation() { return dateOfReservation; }
    public void setDateOfReservation(Calendar dateOfReservation) { this.dateOfReservation = dateOfReservation; }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getEmailSend() { return emailSend; }
    public void setEmailSend(Boolean emailSend) { this.emailSend = emailSend; }

    public Calendar getDateOfEmail() { return dateOfEmail; }
    public void setDateOfEmail(Calendar dateOfEmail) { this.dateOfEmail = dateOfEmail; }

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

    public List<ReservationWithEmail> getReservationWithEmails() { return reservationWithEmails; }
    public void setReservationWithEmails(List<ReservationWithEmail> reservationWithEmails) { this.reservationWithEmails = reservationWithEmails; }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
