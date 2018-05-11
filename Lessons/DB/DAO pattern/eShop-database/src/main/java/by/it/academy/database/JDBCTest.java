package by.it.academy.database;

import java.sql.*;

public class JDBCTest {

    public static void main(String [] args){
        try {
            //Step0 - load driver

            Class.forName("com.mysql.jdbc.Driver");

            //Step1 - connect to database

            Connection connection =
            DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/eshop_database?useSSL=false",  //database name here
                    "root", "rand47925" ); //login+pass
            System.out.println("Connected: "+connection.getClass().getName());

            //Step2 - Statement&Query

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM user_data ");
            //i.e. we know database name
            //sql syntax

            //Step 3 - Get Data

            while(rs.next()){
                int id = rs.getInt("id");  //id - field from database

                //Step 4 - Print Data

                String passwd = rs.getString("password");
                Date date = rs.getDate("created_date");
                Object object = rs.getObject("user_id");
                System.out.println(id + " | " + passwd+" | "+date+" | "+object);
            }

            //Step 5 - Close

            //in reverse order
            rs.close();
            statement.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("WASTED");
        }


        //DAO TEST
        User user =
                DaoFactory. getInstance().getUserDao().readUser("admin");
        System.out.println(user.getId() + " "+user.getLoginName() + " "+user.getStatus());
        //wow so java
        //doge.jpg

    }
}
