package by.it.academy.database;

import by.it.academy.model.ObjectFactory;
import by.it.academy.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;

public class JdbcTest {

    public static void main(String[] args) {
        // JDBC example
        try {
            //Step 1
            Class.forName("com.mysql.jdbc.Driver");
            //Step 2
            // Change user and password value
            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/mysql?useSSL=false&connectTimeout=5000",
                            "root", "rand47925");
            System.out.println(connection.getClass().getName());
            //Step 3
            Statement statement = connection.createStatement();
            //Step 4
            ResultSet rs = statement.executeQuery(
                    "select * from eshop_database.user_data");
            //Step 5
            while (rs.next()) {
                int id = rs.getInt("id");
                String passwd = rs.getString("password");
                Date date = rs.getDate("created_date");
                Object object = rs.getObject("user_id");
                System.out.println(id + "|" + passwd + "|" + date + "|" + object);
            }
            //Step 6
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished");
        }

        // DAO and DTD example
        User user =
                DaoFactory.getInstance().getUserDao().readUser("admin");
        System.out.println(user.getId() + "|" + user.getLoginName()
                + "|" + user.getStatus() + "|"
                + new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(user.getCreatedDate().getTime()));


        User user2 = DaoFactory.getInstance().getUserDao().readUser("test_user");
        if (user2 == null) {
            user2 = new ObjectFactory().createUser();
            user2.setLoginName("test_user");
            user2.setStatus("ACTIVE");
            user2 = DaoFactory.getInstance().getUserDao().createUser(user2);
        }
        System.out.println(user2.getId() + "|" + user2.getLoginName()
                + "|" + user2.getStatus() + "|"
                + new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(user2.getCreatedDate().getTime()));


    }
}
