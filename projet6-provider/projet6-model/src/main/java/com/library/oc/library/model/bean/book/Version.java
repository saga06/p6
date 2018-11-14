package com.library.oc.library.model.bean.book;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Objet métier représentant une Version de Book
 *
 * @author sga
 */
public class Version {

    // ==================== Attributs ====================
    @NotNull
    private Book book;

    @NotNull
    @Size(min = 1, max = 30)
    private String numero;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Version() {
    }


    // ==================== Getters/Setters ====================
    public Book getBook() {
        return book;
    }
    public void setBook(Book pBook) {
        book = pBook;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String pNumero) {
        numero = pNumero;
    }


    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("ouvrage=").append(book)
                .append(vSEP).append("numero=\"").append(numero).append('"')
                .append("}");
        return vStB.toString();
    }
}
