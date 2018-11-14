package com.library.oc.library.model.recherche;

public class RechercheUser {
    /**
     * Classe de critères de recherche de User.
     *
     * @author sga
     */
    // ==================== Attributs ====================
    private Integer userId;
    private String userEmail;
    private String userPass;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public RechercheUser() {

    }


    // ==================== Getters/Setters ====================
    public Integer getUserId() {
        return userId;
    }

    /**
     * Assigne le critère de recherche : id de l'user.
     *
     * @param pUserId -
     * @return {@code this}
     */
    public RechercheUser setUserId(Integer pUserId) {
        userId = pUserId;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Assigne le critère de recherche : email de l'user.
     *
     * @param pUserEmail -
     * @return {@code this}
     */
    public RechercheUser setUserEmail(String pUserEmail) {
        userEmail = pUserEmail;
        return this;
    }

    public String getUserPass() {
        return userPass;
    }

    /**
     * Assigne le critère de recherche : email de l'user.
     *
     * @param pUserPass -
     * @return {@code this}
     */
    public RechercheUser setUserPass(String pUserPass) {
        userPass = pUserPass;
        return this;
    }
}

