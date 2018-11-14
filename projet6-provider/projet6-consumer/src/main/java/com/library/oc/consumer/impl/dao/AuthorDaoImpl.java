package com.library.oc.consumer.impl.dao;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.AuthorDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.impl.rowmapper.AuthorRM;
import com.library.oc.consumer.impl.rowmapper.BookRM;
import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.user.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@Named
public class AuthorDaoImpl  extends AbstractDao implements AuthorDao {

    //----- INJECTION DES DEPENDANCES -----

    @Inject
    BookRM bookRM;
    @Inject
    AuthorRM authorRM;

    @Override
    public Author read(int id) {
        String vSQL = "SELECT name FROM author WHERE id="+id;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Author> listAuthor = jdbcTemplate.query(vSQL, authorRM);
        Author vAuthor = listAuthor.get(0);

        return vAuthor;
    }


    @Override
    public List<Author> readAll() {
        String vSQL = "SELECT * FROM author";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Author> listAuthor = jdbcTemplate.query(vSQL, authorRM);

        return listAuthor;
    }

    @Override
    public List<Author> findAuthorsByBook(Book book){
        try
        {
            String vSQL =
                    "SELECT author.name, author.id  FROM author \n" +
                    "INNER JOIN book_author ON book_author.author_id = author.id \n" +
                    "INNER JOIN book ON book.id = book_author.book_id \n" +
                    "WHERE book.id ="+book.getId();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<Author> listAuthor = jdbcTemplate.query(vSQL, authorRM);
            return listAuthor;

        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Author> findAuthorsByBook(BookBorrowed bookBorrowed) {
        try
        {
            String vSQL =
                    "SELECT author.name, author.id  FROM author \n" +
                            "INNER JOIN book_author ON book_author.author_id = author.id \n" +
                            "INNER JOIN book ON book.id = book_author.book_id \n" +
                            "WHERE book.id ="+bookBorrowed.getId();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<Author> listAuthor = jdbcTemplate.query(vSQL, authorRM);
            return listAuthor;

        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }


    @Override
    public List<Author> readAll(int id) {
        return null;
    }

}
