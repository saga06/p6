package com.library.oc.library.webapp.action;


import com.library.oc.library.business.contract.manager.*;
import com.opensymphony.xwork2.ActionSupport;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * Action de gestion des {@link User}
 */
public class GestionUserAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;
    private Integer idUser;

    // ----- Eléments en sortie
    private User user;
    // ----- Eléments en sortie
    private List<Book> listBook;
    private Book book;
    private List<User> listUser;
    private List<Book> listEditor;
    private List<Author> authors;
    private List<Theme> themes;
    private String statusUser;

    /*Get current date in Date Format*/
    Date dateToday = new Date();
    /*Get current Date in XmlGregorianFormat*/
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
    XMLGregorianCalendar currentDate = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);

    private List<BookBorrowed> listBookBorrowedByUser;
    private List<BookReserved> listBookReservedByUser;

    private BookService bookService = new BookService();
    private BookClient bookClient = bookService.getBookPort();
    private UserService userService = new UserService();
    private UserClient userClient = userService.getUserPort();

    public GestionUserAction() throws DatatypeConfigurationException {
    }


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }

    public List<Book> getListBook() {
        return listBook;
    }
    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public List<User> getListUser() {
        return listUser;
    }
    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public List<Book> getListEditor() {
        return listEditor;
    }
    public void setListEditor(List<Book> listEditor) {
        this.listEditor = listEditor;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Theme> getThemes() {
        return themes;
    }
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public Date getDateToday() { return dateToday; }
    public void setDateToday(Date dateToday) { this.dateToday = dateToday; }

    public XMLGregorianCalendar getCurrentDate() { return currentDate; }
    public void setCurrentDate(XMLGregorianCalendar currentDate) { this.currentDate = currentDate; }

    public List<BookBorrowed> getListBookBorrowedByUser() { return listBookBorrowedByUser; }
    public void setListBookBorrowedByUser(List<BookBorrowed> listBookBorrowedByUser) { this.listBookBorrowedByUser = listBookBorrowedByUser; }

    public List<BookReserved> getListBookReservedByUser() { return listBookReservedByUser; }
    public void setListBookReservedByUser(List<BookReserved> listBookReservedByUser) { this.listBookReservedByUser = listBookReservedByUser; }

    public String getStatusUser() {
        return statusUser;
    }
    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }

// ==================== Méthodes ====================

    /**
     * Action affichant les ouvrages emprunté par un {@Link User}
     *
     * @return success / erreur
     */
    public String doListBookBorrowedByUser() throws NotFoundException_Exception {
        if (id == null) {
            this.addActionError("No id user");
        } else {
            listBookBorrowedByUser = bookClient.getListBookBorrowedByUser(id);
            listBookReservedByUser = bookClient.getListBookReservedByUser(id);
            statusUser = String.valueOf(userClient.read(id));
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant désavtiver le rappel de fin de prêt d'un {@link Book}
     * @return input / success / erreur
     *
     */
    public String doChangeToFalse() {

        //Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (idUser == null) {
            this.addActionError("User non renseigné");
        } else {
            userClient.updateStatusReminderToFalse(idUser);
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant d'activer le rappel de fin de prêt d'un {@link Book}
     * @return input / success / erreur
     *
     */
    public String doChangeToTrue() {

        //Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (idUser == null) {
            this.addActionError("User non renseigné");
        } else {
            userClient.updateStatusReminderToTrue(idUser);
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

}

