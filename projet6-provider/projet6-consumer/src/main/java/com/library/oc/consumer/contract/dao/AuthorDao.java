package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;

import java.util.List;

public interface AuthorDao {


    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Author read(int id);
    List<Author> readAll();
    List<Author> readAll(int id);
    List<Author> findAuthorsByBook(Book book);
    List<Author> findAuthorsByBook(BookBorrowed bookBorrowed);


}

