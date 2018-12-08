package com.library.oc.consumer.impl.rowmapper;


import com.library.oc.library.model.bean.book.ReservationWithEmail;
import org.springframework.jdbc.core.RowMapper;


import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class ReservationWithEmailRM implements RowMapper<ReservationWithEmail> {

    @Override
    public ReservationWithEmail mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        ReservationWithEmail reservationWithEmailRM = new ReservationWithEmail(pRS.getInt("id"));
        reservationWithEmailRM.setId(pRS.getInt("id"));
        reservationWithEmailRM.setIdBook(pRS.getInt("id_book"));
        reservationWithEmailRM.setIdUser(pRS.getInt("id_user"));
        reservationWithEmailRM.setDateOfReservation(pRS.getTimestamp("date_of_reservation"));
        reservationWithEmailRM.setActive(pRS.getBoolean("is_active"));
        reservationWithEmailRM.setEmailSend(pRS.getBoolean("email_send"));
        reservationWithEmailRM.setDateOfEmail(pRS.getTimestamp("datetime_email_send"));
        reservationWithEmailRM.setEmail(pRS.getString("email"));
        reservationWithEmailRM.setBookTitle(pRS.getString("title"));

        return reservationWithEmailRM;
    }
}
