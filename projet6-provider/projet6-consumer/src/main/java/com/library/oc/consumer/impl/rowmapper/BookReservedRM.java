package com.library.oc.consumer.impl.rowmapper;

        import com.library.oc.library.model.bean.book.BookReserved;
        import org.springframework.jdbc.core.RowMapper;

        import javax.inject.Inject;
        import javax.inject.Named;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Timestamp;
        import java.util.Calendar;

@Named
public class BookReservedRM implements RowMapper<BookReserved> {




    @Override
    public BookReserved mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        BookReserved BookReservedRM = new BookReserved(pRS.getInt("id"));
        BookReservedRM.setId(pRS.getInt("id"));
        BookReservedRM.setIdBook(pRS.getInt("id_book"));

        String title = (pRS.getString("title"));
        if (title != null) {
            BookReservedRM.setTitle(title); }


        int idReservation =(pRS.getInt("id_reservation"));
        BookReservedRM.setIdReservation(idReservation);

        BookReservedRM.setIdUser(pRS.getInt("id_user"));
        BookReservedRM.setActive(pRS.getBoolean("is_active"));
        BookReservedRM.setEmailSend(pRS.getBoolean("email_send"));
        Timestamp dateOfReservation = pRS.getTimestamp("date_of_reservation");
        Timestamp dateEmailSend = pRS.getTimestamp("datetime_email_send");
        Calendar calendarDateOfReservation = Calendar.getInstance();
        Calendar calendarDateEmailSend = Calendar.getInstance();
        calendarDateOfReservation.setTimeInMillis(dateOfReservation.getTime());
        if (dateEmailSend != null) {
            calendarDateEmailSend.setTimeInMillis(dateEmailSend.getTime());
            BookReservedRM.setDateOfEmail(calendarDateEmailSend);
        }
        BookReservedRM.setDateOfReservation(calendarDateOfReservation);

        return BookReservedRM;

    }

}

