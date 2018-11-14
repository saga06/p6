package com.library.oc.library.webapp.action;


import com.library.oc.library.business.contract.manager.*;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;


public class GestionBookAction extends ActionSupport {

    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;
    private Integer idEditor;
    private Integer idUser;

    // ----- Eléments en sortie
    private List<Book> listBook;
    private Book book;
    private User user;
    private List<User> listUser;
    private List<Book> listEditor;
    private List<Author> authors;
    private List<Theme> themes;


    private BookService bookService = new BookService();
    private BookClient bookClient = bookService.getBookPort();

    private UserService userService = new UserService();
    private UserClient userClient = userService.getUserPort();

    // ==================== Getters/Setters ====================
    public Integer getId() { return id; }
    public void setId(Integer pId) { id = pId; }

    public Integer getIdEditor() { return idEditor; }
    public void setIdEditor(Integer idEditor) { this.idEditor = idEditor; }

    public List<Book> getListBook() { return listBook; }
    public void setListBook(List<Book> listBook) { this.listBook = listBook; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    public void setListUser(List<User> listUser) { this.listUser = listUser; }
    public List<User> getListUser() { return listUser; }

    public List<Book> getListEditor() { return listEditor; }
    public void setListEditor(List<Book> listEditor) { this.listEditor = listEditor; }

    public List<Author> getAuthors() { return authors; }
    public void setAuthors(List<Author> authors) { this.authors = authors; }

    public List<Theme> getThemes() {
        return themes;
    }
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

/*    public Editor getEditor() {return editor;}
    public void setEditor(Editor pEditor) {editor=pEditor;}*/

    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Book}
     * @return success
     */


    public String doList() {
/*
        listBook = managerFactory.getBookManager().displayAllBooks();
*/

        listBook = bookClient.displayAllBooks();

        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Book}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.book.missing.id"));
        } else {
            book = bookClient.getBook(id);
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant d'effectuer un emprunt de {@link Book}
     * @return input / success / erreur
     *
     */
    public String doBorrow() {

        //Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (id == null) {
            this.addActionError("livre non renseigné");
        } else {
            if (idUser == null) {
                this.addActionError("identifiant utilisateur non renseigné");
            }
            else {
                try {
                    book = bookClient.getBook(id);
                    user = userClient.getUser(idUser);
                    bookClient.borrowBook(user,book);
                } catch ( NotFoundException_Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant de prolonger un prêt d'un {@link Book}
     * @return input / success / erreur
     *
     */
    public String doExtend() {

        //Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (id == null) {
            this.addActionError("livre non renseigné");
        } else {
            bookClient.extendBorrow(id);
        }
            return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

}
