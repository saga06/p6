package com.library.oc.consumer.impl.dao;

import java.sql.Types;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.impl.rowmapper.UserRM;
import com.library.oc.library.model.bean.user.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@Named
public class UserDaoImpl extends AbstractDao implements UserDao {


    @Inject
    UserRM userRM;


    @Override
    public User read(int id) {
        String vSQL = "SELECT * FROM users WHERE id="+id;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<User> listUser = jdbcTemplate.query(vSQL, userRM);
        User user = listUser.get(0);

        return user;
    }


    @Override
    public User read(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> readAll() {
        String vSQL = "SELECT * FROM users";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<User> listUser = jdbcTemplate.query(vSQL, userRM);

        return listUser;
    }

    @Override
    public User findByEmail(String email) {
        try {
            String vSQL = "SELECT * FROM users WHERE email='" + email + "'";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
            List<User> listUser = jdbcTemplate.query(vSQL, userRM);
            if (!listUser.isEmpty()){
            User user = listUser.get(0);
            return user;}
            else {
                return null;
            }
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<User> readAll(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getNbUser() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrUser = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM users", Integer.class);
        return vNbrUser;
    }

    @Override
    public List<User> getListUserLateReturn() {
        String vSQL = "SELECT borrow.date_end, borrow.id_borrower, borrow.id_book, borrow.is_returned, borrow.is_returned_on_time, users.email, users.lastname, " +
                "users.password, users.id, users.surname\n" +
                "FROM borrow\n" +
                "INNER JOIN users ON borrow.id_borrower = users.id\n" +
                "WHERE date_end < current_date\n" +
                "AND borrow.is_returned = false ";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<User> listUser = jdbcTemplate.query(vSQL, userRM);

        return listUser;
    }

    // Method used by an User to change his "reminder_active" to false (it's to not receive the email 5 days and less before the end of the borrow)
    @Override
    public void updateStatusReminderToFalse(Integer idUser) {
        String vSQL ="UPDATE users " +
                " SET reminder_active = FALSE " +
                " WHERE users.id=" +idUser;
        getvParams().addValue("idUser", idUser, Types.INTEGER);
        getvNamedParameterJdbcTemplate().update(vSQL, getvParams());
    }

    // Method used by an User to change his "reminder_active" to true (it's to receive the email 5 days and less before the end of the borrow)
    @Override
    public void updateStatusReminderToTrue(Integer idUser) {
        String vSQL ="UPDATE users " +
                " SET reminder_active = TRUE " +
                " WHERE users.id=" +idUser;
        getvParams().addValue("idUser", idUser, Types.INTEGER);
        getvNamedParameterJdbcTemplate().update(vSQL, getvParams());
    }






}
