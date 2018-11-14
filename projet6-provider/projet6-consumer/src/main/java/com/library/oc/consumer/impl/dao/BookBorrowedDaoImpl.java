package com.library.oc.consumer.impl.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.util.List;
import java.util.Properties;
import javax.inject.Inject;
import javax.inject.Named;
import com.library.oc.consumer.contract.dao.BookBorrowedDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.consumer.impl.rowmapper.BookRM;
import com.library.oc.consumer.impl.rowmapper.BookBorrowedRM;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.user.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Classe d'implémentation de {@link BookBorrowedDao}.
 */
@Named
public class BookBorrowedDaoImpl extends AbstractDao implements BookBorrowedDao {

    //----- INJECTION DES DEPENDANCES -----

    @Inject
    UserDao userDaoImpl;
    @Inject
    BookRM bookRM;
    @Inject
    BookBorrowedRM bookBorrowedRM;

    private static final String FICHIER_PROPERTIES = "config.properties";
    private static final String PROPERTY_BORROWDURATION = "borrow.Duration";
    private static final String PROPERTY_BORROWDURATIONUNIT = "borrow.Duration.Unit";
    private static final String PROPERTY_BORROWEXTENSION = "borrow.Extension";
    private static final String PROPERTY_BORROWEXTENSIONUNIT = "borrow.Extension.Unit";


    Properties properties = new Properties();
    String borrowDuration = null;
    String borrowDurationUnit = null;
    String borrowExtension = null;
    String borrowExtensionUnit = null;
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);


    //----- IMPLEMENTATION DES METHODES -----

    @Override
    public List<BookBorrowed> findAllBooksBorrowed(int id) {
        try {
            String vSQL =
                    "SELECT * FROM book " +
                            "INNER JOIN borrow ON borrow.id_book = book.id \n " +
                            "LEFT JOIN editor ON book.editor_id = editor.id \n " +
                            "WHERE id_borrower = " + id;

            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<BookBorrowed> vListBook = jdbcTemplate.query(vSQL, bookBorrowedRM);
            return vListBook;

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void borrowBook(User user, Book book) {
        try {
            properties.load(fichierProperties);
            borrowDuration = properties.getProperty(PROPERTY_BORROWDURATION);
            borrowDurationUnit = properties.getProperty(PROPERTY_BORROWDURATIONUNIT);
            String vSQL = "INSERT INTO borrow(date_start, date_end, already_extended, id_borrower, id_book) " +
                    "VALUES ( current_date, current_date + interval '" + borrowDuration + " " + borrowDurationUnit + "', false, :user_id, :book_id)";
            getvParams().addValue("user_id", user.getId(), Types.INTEGER);
            getvParams().addValue("book_id", book.getId(), Types.INTEGER);
            getvNamedParameterJdbcTemplate().update(vSQL, getvParams());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void extendBorrow(int id) {
        try {
            properties.load(fichierProperties);
            borrowExtension = properties.getProperty(PROPERTY_BORROWEXTENSION);
            borrowExtensionUnit = properties.getProperty(PROPERTY_BORROWEXTENSIONUNIT);
            String vSQL = "UPDATE borrow SET date_end= date_end + interval '" + borrowExtension + " " + borrowExtensionUnit + "', already_extended=true WHERE id_borrow= :borrow_id";
            getvParams().addValue("borrow_id", id, Types.INTEGER);
            getvNamedParameterJdbcTemplate().update(vSQL, getvParams());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getNbOfCopiesAlreadyBorrowed(BookBorrowed bookBorrowed) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Integer vNbrBook = vJdbcTemplate.queryForObject(
                "SELECT COUNT(id_book) FROM borrow WHERE id_book =?", Integer.class, bookBorrowed.getId());
        return vNbrBook;
    }


}
