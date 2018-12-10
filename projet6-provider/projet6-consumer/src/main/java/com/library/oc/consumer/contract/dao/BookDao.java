package com.library.oc.consumer.contract.dao;
import java.util.List;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.book.Reservation;
import com.library.oc.library.model.bean.book.ReservationWithEmail;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Book" / La table "book"
 * @author sga
 *
 */

public interface BookDao {

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Book read(int id);
    List<Book> findAllBooks();
    List<Reservation> findAllActiveReservation();
    ReservationWithEmail getOldestUserReservationForABook(int id);
    List<BookBorrowed> findAllBooksBorrowed(int id);
    int getNbOfCopiesAlreadyBorrowed(Book book);
    void updateEmailStatus(int id);
    void updateReservationStatusToFalse(int id);
    int getNbOfActiveReservationForABook(int id);
    ReservationWithEmail getReservationByUserByBook(int idUser, int idBook);

    /**
     * Retourne le nombre de Book
     * @param
     * @return Le nombre de Book
     */
    int getCountBook();




}

