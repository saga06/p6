package com.library.oc.library.model.bean.book;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BookReserved {

    /**
     * Objet métier représentant une réservation
     *
     * @author sga
     */

        // ==================== Attributs ====================
        private Integer id;

        private Timestamp dateOfReservation;

        private Integer idUser;

        private Integer idBook;

        private boolean active;

        private boolean emailSend;

        private Timestamp dateOfEmail;

/*
        private List<BookReserved> books = new ArrayList<BookReserved>();
*/



        // ==================== Constructeurs ====================
        /**
         * Constructeur par défaut.
         */
        public BookReserved() {
        }

        /**
         * Constructeur.
         *
         * @param pId -
         */
        public BookReserved(Integer pId) {
            id = pId;
        }

        // ==================== Getters/Setters ====================


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDateOfReservation() {
        return dateOfReservation;
    }
    public void setDateOfReservation(Timestamp dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdBook() {
        return idBook;
    }
    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public boolean isEmailSend() { return emailSend; }
    public void setEmailSend(boolean emailSend) { this.emailSend = emailSend; }

    public Timestamp getDateOfEmail() { return dateOfEmail; }
    public void setDateOfEmail(Timestamp dateOfEmail) { this.dateOfEmail = dateOfEmail; }
}

