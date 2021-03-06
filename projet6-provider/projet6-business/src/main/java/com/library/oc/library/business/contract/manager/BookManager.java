package com.library.oc.library.business.contract.manager;

import com.library.oc.library.model.bean.book.*;
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
    List<BookBorrowedWithEmail> getListBookBorrowedFinishInFiveDays();
    List<BookReserved> getListBookReservedByUser(@WebParam(name = "id") Integer pid);
    List<Reservation> getListReservationByBookOrderByDate(@WebParam(name = "idBook") int ibBook);
    void buildBookDependencies(@WebParam(name = "book") Book book);
    void buildBookBorrowedDependencies(@WebParam(name = "borrowedBook") BookBorrowed bookBorrowed);
    void buildBookReservedDependencies(@WebParam(name = "reservedBook") BookReserved bookReserved);
    void borrowBook(@WebParam(name = "user") User user,
                    @WebParam(name = "book") Book book);
    void reserveBook(@WebParam(name = "user") User user,
                    @WebParam(name = "book") Book book);
    void extendBorrow(@WebParam(name = "id") Integer id);
    void cancelReservation(@WebParam(name = "id") Integer id);
    void updateEmailStatus(@WebParam(name = "id") Integer id);
    void updateReservationStatusToFalse(@WebParam(name = "id") Integer id);
    int getNbOfCopiesAvailableForABookBorrowed(@WebParam(name = "bookBorrowed") BookBorrowed bookBorrowed);
    int getNbOfCopiesAvailableForABook(@WebParam(name = "book") Book book);
    ReservationWithEmail getOldestUserReservationForABook(@WebParam(name = "id") Integer id);
    List<ReservationWithEmail> getListReservationWithEmailAndBook();
    List<Book> getListBookReservedByUserAndReadyToBorrow(@WebParam(name = "idUser") int idUser);
    ReservationWithEmail getReservationByUserByBook(@WebParam(name = "idUser") int idUser,
                                                    @WebParam(name = "idBook") int idBook);
    int getNbOfActiveReservationForABook(@WebParam(name = "id") Integer id);
    BookBorrowed getDateOfReturnOfOldestBorrowOfABook(@WebParam(name = "idBook") int idBook);


}

