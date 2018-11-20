package com.library.oc.consumer.contract;

import com.library.oc.consumer.contract.dao.*;
import com.library.oc.consumer.impl.rowmapper.BookBorrowedRM;


public interface DaoFactory {

    //----- UTILISATEUR -----
    UserDao getUserDao();
    void setUserDao(UserDao pUserDao);

    //----- BOOK -----
    BookDao getBookDao();
    void setBookDao(BookDao pBookDao);

    //----- BOOK Borrowed -----
    BookBorrowedDao getBookBorrowedDao();
    void setBookBorrowedDao(BookBorrowedDao pBookBorrowedDao);

    //----- BOOK Reserved -----
    BookReservedDao getBookReservedDao();
    void setBookReservedDao(BookReservedDao pBookReservedDao);

    //------Author ------
    AuthorDao getAuthorDao();
    void setAuthorDao(AuthorDao pAuthorDao);

    //------Theme -----
    ThemeDao getThemeDao();
    void setThemeDao (ThemeDao pThemeDao);

}
