package com.library.oc.consumer.impl.rowmapper;


import com.library.oc.library.model.bean.book.Reservation;
import org.springframework.jdbc.core.RowMapper;


import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class ReservationRM implements RowMapper<Reservation> {

    @Override
    public Reservation mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Reservation reservationRM = new Reservation(pRS.getInt("id"));
        reservationRM.setIdReservation(pRS.getInt("id"));
        reservationRM.setIdBook(pRS.getInt("id_book"));
        reservationRM.setIdUser(pRS.getInt("id_user"));
        reservationRM.setDateOfReservation(pRS.getTimestamp("date_of_reservation"));
        reservationRM.setActive(pRS.getBoolean("is_active"));
        reservationRM.setEmailSend(pRS.getBoolean("email_send"));
        reservationRM.setDateOfEmail(pRS.getTimestamp("datetime_email_send"));

        return reservationRM;
    }
}
