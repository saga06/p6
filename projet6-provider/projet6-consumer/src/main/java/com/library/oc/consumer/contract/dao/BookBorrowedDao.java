package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.user.User;

import java.util.List;

public interface BookBorrowedDao {

    List<BookBorrowed> findAllBooksBorrowed(int id);
    public void borrowBook(User user, Book book);
    public void extendBorrow(int id);
    int getNbOfCopiesAlreadyBorrowed(BookBorrowed bookBorrowed);

}
