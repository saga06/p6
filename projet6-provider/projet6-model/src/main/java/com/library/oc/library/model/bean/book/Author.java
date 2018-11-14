package com.library.oc.library.model.bean.book;

import javax.validation.constraints.NotNull;

public class Author {

    // ==================== Attributs ====================
    private Integer id;

    @NotNull
    private String name;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Author() {
    }

    public Author(Integer pId) { id = pId;}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void setName(Author vAuthor) {
    }
}
