package com.library.oc.consumer.impl.rowmapper;

import com.library.oc.consumer.contract.dao.AuthorDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.library.model.bean.book.BookBorrowed;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
import com.library.oc.consumer.contract.dao.BookStatutDao;
*/

@Named
public class BookBorrowedRM implements RowMapper<BookBorrowed> {


    @Inject
    AuthorDao authorDaoImpl;


    @Inject
    UserDao userDaoImpl;



    @Override
    public BookBorrowed mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        BookBorrowed bookBorrowedRM = new BookBorrowed(pRS.getInt("id_borrow"));
        bookBorrowedRM.setIdBorrow(pRS.getInt("id_borrow"));
        bookBorrowedRM.setId(pRS.getInt("id"));
        bookBorrowedRM.setDateStart(pRS.getDate("date_start"));
        bookBorrowedRM.setDateEnd(pRS.getDate("date_end"));
        bookBorrowedRM.setAlreadyExtended(pRS.getBoolean("already_extended"));
        bookBorrowedRM.setIdBorrower(pRS.getInt("id_borrower"));
        bookBorrowedRM.setIdBook(pRS.getInt("id_book"));
        bookBorrowedRM.setReturned(pRS.getBoolean("is_returned"));
        bookBorrowedRM.setReturnedOnTime(pRS.getBoolean("is_returned_on_time"));
        bookBorrowedRM.setNumberOfCopies(pRS.getInt("number_of_copies"));
        bookBorrowedRM.setTitle(pRS.getString("title"));
        bookBorrowedRM.setEditorId(pRS.getInt("editor_id"));
        bookBorrowedRM.setEditorName(pRS.getString("name"));
        bookBorrowedRM.setIsbn(pRS.getString("isbn"));
        bookBorrowedRM.setResume(pRS.getString("resume"));

        return bookBorrowedRM;

    }

}

