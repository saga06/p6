package com.library.oc.library.model.bean.book;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Reservation extends ReservationWithEmail {
    // ==================== Attributs ====================

    private Integer idReservation;
    private Integer idBook;
    private Integer idUser;
    private Timestamp dateOfReservation;
    private Boolean active;
    private Boolean emailSend;
    private Timestamp dateOfEmail;
/*
    private String email;
*/
    private String bookTitle;

    private List<Reservation> reservations = new ArrayList<Reservation>();

    @NotNull
    private Integer id;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Reservation() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Reservation(Integer pId) {
        id = pId;
    }

    // ==================== Getters/Setters ====================

    public Integer getIdReservation() { return idReservation; }
    public void setIdReservation(Integer idReservation) { this.idReservation = idReservation; }

    public Integer getIdBook() { return idBook; }
    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Timestamp getDateOfReservation() {
        return dateOfReservation;
    }
    public void setDateOfReservation(Timestamp dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getEmailSend() {
        return emailSend;
    }
    public void setEmailSend(Boolean emailSend) {
        this.emailSend = emailSend;
    }

    public Timestamp getDateOfEmail() {
        return dateOfEmail;
    }
    public void setDateOfEmail(Timestamp dateOfEmail) {
        this.dateOfEmail = dateOfEmail;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

/*    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }*/

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
}
