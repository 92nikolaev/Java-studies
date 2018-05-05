package by.it.academy.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    private Connection conn;

    UserDaoImpl(Connection connection) {
        this.conn = connection;
    }


    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User readUser(String userName) {
        User user = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM user us WHERE us.login_name='" + userName+"'");

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));  //id - field from database
                //user.setCreatedDate(rs.getTimestamp("created_date"));  //??
                user.setLoginName(rs.getString("login_name"));
                user.setStatus(rs.getString("status"));


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User readUser(int id) {
        return null;
    }
}
