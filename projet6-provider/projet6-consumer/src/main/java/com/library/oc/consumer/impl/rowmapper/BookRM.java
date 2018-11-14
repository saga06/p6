package com.library.oc.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.contract.dao.AuthorDao;

import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.bean.book.Book;


import org.springframework.jdbc.core.RowMapper;

    @Named
    public class BookRM implements RowMapper<Book> {

        @Inject
        AuthorDao authorDaoImpl;

        @Inject
        UserDao userDaoImpl;

        @Override
        public Book mapRow(ResultSet pRS, int pRowNum) throws SQLException {

            Book book = new Book(pRS.getInt("id"));
            book.setNumberOfCopies(pRS.getInt("number_of_copies"));
            book.setTitle(pRS.getString("title"));
            book.setEditorId(pRS.getInt("editor_id"));
            book.setEditorName(pRS.getString("name"));
            book.setIsbn(pRS.getString("isbn"));
            book.setResume(pRS.getString("resume"));

            return book;

        }

    }

