package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.User;


import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserDaoImpl implements UserDao {

    private Connection conn;

    UserDaoImpl(Connection connection) {
        this.conn = connection;
    }

    @Override
    public User createUser(User user) {
        String insertUser = "insert into eshop_database.user (created_date, last_login_date, login_name, status)"
                + "values (now(), null, ?, ?);";

        try (PreparedStatement preparedStatement =
                     conn.prepareStatement(insertUser)){

            preparedStatement.setString(1, user.getLoginName());
            preparedStatement.setString(2, user.getStatus());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readUser(user.getLoginName());
    }

    @Override
    public User readUser(String userName) {
        User user = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(
                    "select * from eshop_database.user us where us.login_name='"
                            + userName +"'");
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                Calendar calendar = new GregorianCalendar();
                calendar.setTimeInMillis(rs.getTimestamp("created_date").getTime());
                user.setCreatedDate(calendar);
                user.setLoginName(rs.getString("login_name"));
                user.setStatus(rs.getString("status"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User readUser(int id) {
        return null;
    }
}
