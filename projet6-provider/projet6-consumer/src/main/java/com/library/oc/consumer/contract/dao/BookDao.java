package com.library.oc.consumer.contract.dao;
import java.util.List;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.user.User;

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
    List<BookBorrowed> findAllBooksBorrowed(int id);
    int getNbOfCopiesAlreadyBorrowed(Book book);

    /**
     * Retourne le nombre de Book
     * @param pRechercheBook
     * @return Le nombre de Book
     */
    int getCountBook();




}

