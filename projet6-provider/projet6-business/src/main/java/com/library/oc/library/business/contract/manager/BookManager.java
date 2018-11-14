package com.library.oc.library.business.contract.manager;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.user.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;


/**
 * Manager du package « book »
 */
@WebService(name="BookClient", serviceName="BookService",portName = "BookPort")
public interface BookManager {

    /**
     * Renvoie le book demandé
     *
     * @param pId l'identifiant du book
     * @return Le {@link Book}
     */
    Book getBook(@WebParam(name = "id") Integer pId);

    /**
     * Renvoie la liste des {@link Book}
     * @return List
     */

    List<Book> displayAllBooks();
    List<BookBorrowed> getListBookBorrowedByUser(@WebParam(name = "id") Integer pid);
    void buildBookDependencies(@WebParam(name = "book") Book book);
    void buildBookBorrowedDependencies(@WebParam(name = "borrowedBook") BookBorrowed bookBorrowed);
    void borrowBook(@WebParam(name = "user") User user,
                    @WebParam(name = "book") Book book);
    void extendBorrow(@WebParam(name = "id") Integer id);
    int getNbOfCopiesAvailableForABookBorrowed(@WebParam(name = "bookBorrowed") BookBorrowed bookBorrowed);
    int getNbOfCopiesAvailableForABook(@WebParam(name = "book") Book book);

}
