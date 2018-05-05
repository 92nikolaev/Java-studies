package by.it.academy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    //initialise DAO`s
    //singletone pattern

    private static DaoFactory daoFactory;

    static {
        try {
            daoFactory = new DaoFactory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DaoFactory() throws SQLException {
        this.init();
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }

    private UserDao userDao;

    public UserDao getUserDao() {
        if(userDao==null){
            System.out.println("Not initialized");
        }
        return userDao;

    }

    private void init() throws SQLException {
        //initialise JDBC connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection
                            ("jdbc:mysql://localhost:3306/eshop_database?useSSL=false",  //database name here
                                    "root", "rand47925"); //login+pass
            userDao = new UserDaoImpl(connection);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
