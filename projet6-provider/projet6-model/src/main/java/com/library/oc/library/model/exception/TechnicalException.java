package com.library.oc.library.model.exception;

/**
 * Classe d'exception levée quand une erreur technique est survenue
 *
 * @author sga
 */
public class TechnicalException extends Exception {

    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public TechnicalException(String pMessage) {
        super(pMessage);
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public TechnicalException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}
