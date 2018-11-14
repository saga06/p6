package com.library.oc.library.model.bean.user;

public class User {

    // ==================== Attributs ====================
    private Integer id;
    private String surname;
    private String lastname;
    private String email;
    private String password;


   /* // ==================== Constructeurs ====================
    *//**
     * Constructeur.
     *//*
    public User() {
    }*/


    /**
     * Constructeur.
     *
     * @param pId -
     */
/*    public User(Integer pId) {
        id = pId;
    }*/


    // ==================== Getters/Setters ====================
    public Integer getId() { return id; }
    public void setId(Integer pId) {
        id = pId;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

/*// ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("id=").append(id)
            .append(vSEP).append("nom=\"").append(nom).append('"')
            .append(vSEP).append("prenom=\"").append(prenom).append('"')
            .append("}");
        return vStB.toString();
    }*/
}
