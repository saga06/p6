package com.library.oc.consumer.impl.rowmapper;

import com.library.oc.library.model.bean.book.BookBorrowedWithEmail;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

@Named
public class BookBorrowedWithEmailRM implements RowMapper<BookBorrowedWithEmail> {

    @Override
    public BookBorrowedWithEmail mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        BookBorrowedWithEmail bookBorrowedWithEmailRM = new BookBorrowedWithEmail(pRS.getInt("id_borrow"));

        bookBorrowedWithEmailRM.setIdBorrow(pRS.getInt("id_borrow"));
        bookBorrowedWithEmailRM.setIdBook(pRS.getInt("id_book"));
        bookBorrowedWithEmailRM.setIdUser(pRS.getInt("id_borrower"));
        bookBorrowedWithEmailRM.setSurname(pRS.getString("lastname"));
        bookBorrowedWithEmailRM.setLastname(pRS.getString("surname"));

        Timestamp dateStart = pRS.getTimestamp("date_start");
        Timestamp dateEnd = pRS.getTimestamp("date_end");
        Calendar calendarDateStart = Calendar.getInstance();
        Calendar calendarDateEnd = Calendar.getInstance();
        calendarDateStart.setTimeInMillis(dateStart.getTime());
        calendarDateEnd.setTimeInMillis(dateEnd.getTime());
        bookBorrowedWithEmailRM.setDateEnd(calendarDateEnd);
        bookBorrowedWithEmailRM.setDateStart(calendarDateStart);

        bookBorrowedWithEmailRM.setIdBorrower(pRS.getInt("id_borrower"));
        bookBorrowedWithEmailRM.setReturned(pRS.getBoolean("is_returned"));
        bookBorrowedWithEmailRM.setEmail(pRS.getString("email"));
        bookBorrowedWithEmailRM.setBookTitle(pRS.getString("title"));

        return bookBorrowedWithEmailRM;
    }
}
