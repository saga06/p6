package com.library.oc.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Named;

import com.library.oc.library.model.bean.book.Theme;
import org.springframework.jdbc.core.RowMapper;


@Named
public class ThemeRM implements RowMapper<Theme> {

    @Override
    public Theme mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Theme vTheme = new Theme(pRS.getInt("id"));
        vTheme.setName(pRS.getString("name"));

        return vTheme;
    }
}


