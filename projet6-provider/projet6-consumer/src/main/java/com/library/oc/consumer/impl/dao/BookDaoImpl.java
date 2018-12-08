package com.library.oc.consumer.impl.dao;
import java.sql.Types;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.BookDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.impl.rowmapper.*;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.consumer.impl.rowmapper.BookBorrowedRM;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.book.Reservation;
import com.library.oc.library.model.bean.book.ReservationWithEmail;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Classe d'implémentation de {@link BookDao}.
 */
@Named
public class BookDaoImpl extends AbstractDao implements BookDao {

    //----- INJECTION DES DEPENDANCES -----

    @Inject
    UserDao userDaoImpl;
    @Inject
    BookRM bookRM;
    @Inject
    BookBorrowedRM bookBorrowedRM;
    @Inject
    ReservationWithEmailRM reservationWithEmailRM;
    @Inject
    ReservationRM reservationRM;

    //----- IMPLEMENTATION DES METHODES -----


    @Override
    public Book read(int numero) {
        String vSQL = "SELECT * FROM book " +
                " LEFT JOIN editor ON book.editor_id = editor.id WHERE book.id="+numero;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> listBook = jdbcTemplate.query(vSQL, bookRM);
        Book vBook = listBook.get(0);

        return vBook;
    }



    @Override
    public List<Book> findAllBooks() {
        String vSQL = "SELECT * FROM book " +
                "LEFT JOIN editor ON book.editor_id = editor.id ORDER By book.title";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Book> vListBook = vJdbcTemplate.query(vSQL, bookRM);

        return vListBook;
    }

    @Override
    public  List<BookBorrowed> findAllBooksBorrowed(int id) {
        try
        {
            String vSQL =
                    "SELECT * FROM book " +
                    "INNER JOIN borrow ON borrow.id_book = book.id \n " +
                    "LEFT JOIN editor ON book.editor_id = editor.id \n " +
                    "WHERE id_borrower = id \n" +
                    "ORDER By book.title" ;

            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<BookBorrowed> vListBook = jdbcTemplate.query(vSQL, bookBorrowedRM);
            return vListBook;

        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public int getCountBook() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrBook = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM book", Integer.class);

        return vNbrBook;
    }


    @Override
    public int getNbOfCopiesAlreadyBorrowed(Book book) {
        String sql = "SELECT COUNT(*) FROM borrow WHERE id_book=:book AND is_returned = FALSE";
        getvParams().addValue("book", book.getId(), Types.INTEGER);
        Integer vNbrBook = getvNamedParameterJdbcTemplate().queryForObject(sql,getvParams(), Integer.class);
        return vNbrBook.intValue();
    }

    @Override
    public  List<Reservation> findAllActiveReservation() {
        try
        {
            String vSQL =
                    "SELECT * FROM reservation WHERE is_active = true";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<Reservation> vListReservation = jdbcTemplate.query(vSQL, reservationRM);
            return vListReservation;

        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public ReservationWithEmail getOldestUserReservationForABook(int idBook) {
        String vSQL = "SELECT rs.* ,book.id, book.title, us.email " +
        "FROM reservation AS rs " +
                "LEFT JOIN book AS book " +
                "ON rs.id_book = book.id " +
                "LEFT JOIN users AS us " +
                "ON rs.id_user = us.id " +
                "WHERE rs.date_of_reservation =" +
                " (SELECT min(rs2.date_of_reservation)" +
                "  FROM reservation AS rs2" +
                "  WHERE rs2.id_book = rs.id_book " +
                "  GROUP BY rs2.id_book) " +
                "AND rs.is_active = TRUE "+
                "AND rs.id_book ="+ idBook ;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<ReservationWithEmail> reservationWithEmail = jdbcTemplate.query(vSQL, reservationWithEmailRM);
        ReservationWithEmail vReservation = reservationWithEmail.get(0);
        return vReservation;
    }
}