package com.library.oc.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.AuthorDao;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.library.model.bean.book.Author;
import org.springframework.jdbc.core.RowMapper;


    @Named
    public class AuthorRM implements RowMapper<Author> {


        @Inject
        AuthorDao authorDaoImpl;


        @Inject
        UserDao userDaoImpl;


        @Override
        public Author mapRow(ResultSet pRS, int pRowNum) throws SQLException {

            Author vAuthor = new Author(pRS.getInt("id"));
            vAuthor.setName(pRS.getString("name"));

            return vAuthor;
        }
    }


