package com.library.oc.library.model.bean.book;

import javax.validation.constraints.NotNull;

/**
 * Objet métier représentant un Editor
 *
 * @author sga
 */

public class Editor {

    // ==================== Attributs ====================
    private Integer id;

    @NotNull
    private String name;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Editor() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Editor(Integer pId) { id = pId;}

    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
