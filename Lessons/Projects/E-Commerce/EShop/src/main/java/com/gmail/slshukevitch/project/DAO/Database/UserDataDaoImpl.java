package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.ObjectFactory;
import com.gmail.slshukevitch.project.DAO.Model.User;
import com.gmail.slshukevitch.project.DAO.Model.UserData;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class UserDataDaoImpl implements  UserDataDao {
    private Connection conn;


    public UserDataDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public UserData createUserData(UserData userData) {
        return null;
    }

    @Override
    public UserData readUserData(String loginName) {
        User user = DaoFactory.getInstance().getUserDao().readUser(loginName);
        if(user==null){
            System.out.println("Cannot find user with loginName: "+loginName);
            return null;
        }
        UserData userData=null;
        try (Statement statement = conn.createStatement();) {

            ResultSet rs = statement.executeQuery(
                    "select max(id) max_id, ud.* from eshop_database.user_data ud where ud.user_id="+user.getId());
            while (rs.next()) {
                ObjectFactory objectFactory = new ObjectFactory();
                //!!!!
                userData=objectFactory.createUserData();
                userData.setId(rs.getInt("id"));
                Calendar calendar = new GregorianCalendar();
                calendar.setTimeInMillis(rs.getTimestamp("created_date").getTime());
                userData.setCreatedDate(calendar);
                userData.setStatus(rs.getString("status"));
                userData.setPassword(rs.getString("password"));
                userData.setFirstName(rs.getString("first_name"));
                userData.setSecondName(rs.getString("second_name"));
                userData.setMobilePhone(rs.getString("mobile_phone"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


            return userData;

    }

    @Override
    public UserData readUserData(int id) {
        return null;
    }

    @Override
    public List<UserData> readAllUserData() {
        return null;
    }
}
