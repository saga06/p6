package com.library.oc.consumer.impl.rowmapper;


import com.library.oc.library.model.bean.book.Reservation;
import org.springframework.jdbc.core.RowMapper;


import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

@Named
public class ReservationRM implements RowMapper<Reservation> {

    @Override
    public Reservation mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Reservation reservationRM = new Reservation(pRS.getInt("id_reservation"));
        reservationRM.setIdReservation(pRS.getInt("id_reservation"));
        reservationRM.setIdBook(pRS.getInt("id_book"));
        reservationRM.setIdUser(pRS.getInt("id_user"));
        reservationRM.setActive(pRS.getBoolean("is_active"));
        reservationRM.setEmailSend(pRS.getBoolean("email_send"));

        Timestamp dateOfReservation = pRS.getTimestamp("date_of_reservation");
        Timestamp dateEmailSend = pRS.getTimestamp("datetime_email_send");
        Calendar calendarDateOfReservation = Calendar.getInstance();
        Calendar calendarDateEmailSend = Calendar.getInstance();
        System.out.println(dateOfReservation.getTime());
        calendarDateOfReservation.setTimeInMillis(dateOfReservation.getTime());
        System.out.println(calendarDateOfReservation);
        if (dateEmailSend != null) {
            calendarDateEmailSend.setTimeInMillis(dateEmailSend.getTime());
            reservationRM.setDateOfEmail(calendarDateEmailSend);
        }
        reservationRM.setDateOfReservation(calendarDateOfReservation);

        return reservationRM;
    }
}
