package com.library.oc.consumer.impl.dao;

import com.library.oc.consumer.contract.dao.BookReservedDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.impl.rowmapper.BookRM;
import com.library.oc.consumer.impl.rowmapper.BookReservedRM;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.user.User;

import javax.inject.Inject;
import java.sql.Types;

public class BookReservedDaoImpl extends AbstractDao implements BookReservedDao {

    //----- INJECTION DES DEPENDANCES -----

    @Inject
    UserDao userDaoImpl;
    @Inject
    BookRM bookRM;
    @Inject
    BookReservedRM bookReservedRM;


    @Override
    public void reserveBook(User user, Book book) {
        String vSQL = "INSERT INTO reservation(id_book, id_user, date_of_reservation) " +
                " VALUES ( :book_id, :user_id, current_timestamp)";
        getvParams().addValue("user_id", user.getId(), Types.INTEGER);
        getvParams().addValue("book_id", book.getId(), Types.INTEGER);
        getvNamedParameterJdbcTemplate().update(vSQL, getvParams());
    }
}
