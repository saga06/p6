package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.book.BookReserved;
import com.library.oc.library.model.bean.user.User;

import java.util.List;

public interface BookReservedDao {

    public void reserveBook(User user, Book book);

}