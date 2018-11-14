package com.library.oc.consumer.impl.dao;
import java.sql.Types;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.BookDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.consumer.impl.rowmapper.BookRM;
import com.library.oc.consumer.impl.rowmapper.BookBorrowedRM;
import com.library.oc.library.model.bean.book.BookBorrowed;
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
        String sql = "SELECT COUNT(*) FROM borrow WHERE id_book=:book";
        getvParams().addValue("book", book.getId(), Types.INTEGER);
        Integer vNbrBook = getvNamedParameterJdbcTemplate().queryForObject(sql,getvParams(), Integer.class);
        return vNbrBook.intValue();
    }
}