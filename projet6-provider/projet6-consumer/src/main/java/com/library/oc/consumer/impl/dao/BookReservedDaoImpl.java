package com.library.oc.consumer.impl.dao;

import com.library.oc.consumer.contract.dao.BookReservedDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.impl.rowmapper.BookRM;
import com.library.oc.consumer.impl.rowmapper.BookReservedRM;
import com.library.oc.consumer.impl.rowmapper.ReservationRM;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.Reservation;
import com.library.oc.library.model.bean.user.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Classe d'implémentation de {@link BookReservedDaoImpl}.
 */
@Named
public class BookReservedDaoImpl extends AbstractDao implements BookReservedDao {

    //----- INJECTION OF DEPENDENCIES -----

    @Inject
    UserDao userDaoImpl;
    @Inject
    BookRM bookRM;
    @Inject
    BookReservedRM bookReservedRM;
    @Inject
    ReservationRM reservationRM;

    //----- Implementation methods -----

    // Method used to be on the reservation list of a book unavailable.... :)
    @Override
    public void reserveBook(User user, Book book) {
        String vSQL = "INSERT INTO reservation(id_book, id_user, date_of_reservation, is_active, email_send, datetime_email_send ) " +
                " VALUES ( :book_id, :user_id, current_timestamp, true, false, null)";
        getvParams().addValue("user_id", user.getId(), Types.INTEGER);
        getvParams().addValue("book_id", book.getId(), Types.INTEGER);
        getvNamedParameterJdbcTemplate().update(vSQL, getvParams());
    }


    // Method used to know if there is a reservation for a book (book id) -> get the list of active reservation, and check if one is for this book
    @Override
    public int getNbOfExistenceOfReservationForABook(int id) {
        String sql = "SELECT COUNT(*) FROM reservation WHERE is_active = TRUE AND id_book = :id_book";
        getvParams().addValue("id_book", id, Types.INTEGER);
        Integer vNbrRs = getvNamedParameterJdbcTemplate().queryForObject(sql,getvParams(), Integer.class);
        return vNbrRs.intValue();
    }

    public List<Reservation> getListReservationByBookOrderByDate(int idBook){
        try {
            String sql = "SELECT * FROM reservation WHERE reservation.id_book = " + idBook + " AND is_active = TRUE ORDER BY date_of_reservation";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<Reservation> vListBook = jdbcTemplate.query(sql, reservationRM);
            return vListBook;

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
