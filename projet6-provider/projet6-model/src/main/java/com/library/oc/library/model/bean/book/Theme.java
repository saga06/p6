package com.library.oc.library.model.bean.book;

import javax.validation.constraints.NotNull;

public class Theme {

    // ==================== Attributs ====================
    private Integer id;

    @NotNull
    private String name;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Theme() {
    }

    public Theme(Integer pId) { id = pId;}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
