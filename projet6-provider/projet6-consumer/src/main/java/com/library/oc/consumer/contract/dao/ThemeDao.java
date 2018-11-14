package com.library.oc.consumer.contract.dao;

import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.book.Theme;

import java.util.List;

public interface ThemeDao {

    List<Theme> findThemesByBook(Book book);
    List<Theme> findThemesByBook(BookBorrowed bookBorrowed);



}
