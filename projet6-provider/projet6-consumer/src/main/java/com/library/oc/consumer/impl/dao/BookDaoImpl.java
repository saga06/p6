package com.library.oc.consumer.impl.dao;
import java.sql.Types;
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
                " LEFT JOIN editor ON book.editor_id = editor.id WHERE book.id=" + numero;

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
    public List<BookBorrowed> findAllBooksBorrowed(int id) {
        try {
            String vSQL =
                    "SELECT * FROM book " +
                            "INNER JOIN borrow ON borrow.id_book = book.id \n " +
                            "LEFT JOIN editor ON book.editor_id = editor.id \n " +
                            "WHERE id_borrower = id \n" +
                            "ORDER By book.title";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<BookBorrowed> vListBook = jdbcTemplate.query(vSQL, bookBorrowedRM);
            return vListBook;

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public int getCountBook() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrBook = vJdbcTemplate.queryForObject("SELECT COUNT(*) FROM book", Integer.class);

        return vNbrBook;
    }


    @Override
    public int getNbOfCopiesAlreadyBorrowed(Book book) {
        String sql = "SELECT COUNT(*) FROM borrow WHERE id_book=:book AND is_returned = FALSE";
        getvParams().addValue("book", book.getId(), Types.INTEGER);
        Integer vNbrBook = getvNamedParameterJdbcTemplate().queryForObject(sql, getvParams(), Integer.class);
        return vNbrBook.intValue();
    }

    @Override
    public List<Reservation> findAllActiveReservation() {
        try {
            String vSQL =
                    "SELECT * FROM reservation WHERE is_active = true";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<Reservation> vListReservation = jdbcTemplate.query(vSQL, reservationRM);
            return vListReservation;

        } catch (EmptyResultDataAccessException e) {
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
                "WHERE rs.is_active = TRUE " +
                "AND rs.id_book =" + idBook + " " +
                "ORDER BY rs.date_of_reservation";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<ReservationWithEmail> reservationWithEmail = jdbcTemplate.query(vSQL, reservationWithEmailRM);
        ReservationWithEmail vReservation = reservationWithEmail.get(0);
        return vReservation;
    }

    @Override
    public void updateEmailStatus(int id) {
        String vSQL = "UPDATE reservation " +
                " SET  email_send= TRUE, datetime_email_send = current_timestamp " +
                " WHERE id_reservation = :id;";
        getvParams().addValue("id", id, Types.INTEGER);
        getvNamedParameterJdbcTemplate().update(vSQL, getvParams());
    }

    @Override
    public void updateReservationStatusToFalse(int id) {
        String vSQL = "UPDATE reservation " +
                " SET is_active = FALSE " +
                " WHERE id_reservation = :id";
        getvParams().addValue("id", id, Types.INTEGER);
        getvNamedParameterJdbcTemplate().update(vSQL, getvParams());
    }

    @Override
    public int getNbOfActiveReservationForABook(int id) {
        String sql = "SELECT COUNT(*) FROM reservation WHERE id_book=:id AND is_active = TRUE";
        getvParams().addValue("id", id, Types.INTEGER);
        Integer vNbrResa = getvNamedParameterJdbcTemplate().queryForObject(sql, getvParams(), Integer.class);
        return vNbrResa.intValue();
    }

    @Override
    public ReservationWithEmail getReservationByUserByBook(int idUser, int idBook) {
        String vSQL = "SELECT rs.* ,book.id, book.title, us.email " +
                "FROM reservation AS rs " +
                "LEFT JOIN book AS book " +
                "ON rs.id_book = book.id " +
                "LEFT JOIN users AS us " +
                "ON rs.id_user = us.id " +
                "WHERE rs.is_active = TRUE " +
                "AND rs.id_book =" + idBook + " " +
                "AND rs.id_user =" + idUser;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<ReservationWithEmail> reservationWithEmail = jdbcTemplate.query(vSQL, reservationWithEmailRM);
        if (reservationWithEmail.size() != 0) {
            ReservationWithEmail vReservation = reservationWithEmail.get(0);
            return vReservation;
        }
        return null;
    }

    public BookBorrowed getDateOfReturnOfOldestBorrowOfABook(int idBook) {
        String vSQL = "SELECT * FROM borrow " +
                "INNER JOIN book ON borrow.id_book = book.id \n " +
                "LEFT JOIN editor ON book.editor_id = editor.id \n " +
                "WHERE is_returned = FALSE AND id_book = " + idBook + "  ORDER BY date_end";
        getvParams().addValue("idBook", idBook, Types.INTEGER);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<BookBorrowed> dateOfReturnOfABookList = jdbcTemplate.query(vSQL, bookBorrowedRM);
        if (dateOfReturnOfABookList.size() != 0) {
            BookBorrowed vdateOfReturnOfABook = dateOfReturnOfABookList.get(0);
            return vdateOfReturnOfABook;
        }
        return null;
    }

}