package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.book.BookBorrowedWithEmail;
import com.library.oc.library.model.bean.book.BookReserved;
import com.library.oc.library.model.bean.user.User;

import java.util.List;

public interface BookBorrowedDao {

    List<BookBorrowed> findAllBooksBorrowed(int id);
    List<BookReserved> getListBooksReservedByUser(int id);
    public void borrowBook(User user, Book book);
    public void extendBorrow(int id);
    public void cancelReservation(int id);
    int getNbOfCopiesAlreadyBorrowed(BookBorrowed bookBorrowed);
    public void returnBorrow(int id);
    List<BookBorrowedWithEmail> getListBookBorrowedFinishInFiveDays();

}
