package com.library.oc.library.webapp.action;



import com.library.oc.library.business.contract.manager.Author;
import com.library.oc.library.business.contract.manager.AuthorClient;
import com.library.oc.library.business.contract.manager.AuthorService;
import com.library.oc.library.business.contract.manager.NotFoundException_Exception;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;


public class GestionAuthorAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Author> listAuthor;
    private Author author;

    private AuthorService authorService = new AuthorService();
    private AuthorClient authorClient = authorService.getAuthorPort();




    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }

    public List<Author> getListAuthor() {
        return listAuthor;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author pAuthor) {
        author = pAuthor;
    }



    // ==================== Méthodes ====================

    /**
     * Action listant les {@link Author}
     *
     * @return success
     */


    public String doList() {
        listAuthor = getListAuthor();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Author}
     *
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.book.missing.id"));
        } else {
            try {

                author = authorClient.getAuthor(id);

            } catch (NotFoundException_Exception e) {
                e.printStackTrace();
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
