package com.gmail.slshukevitch.project.DAO.Database;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

    private static DaoFactory daoFactory =
            new DaoFactory();

    private MysqlConnectionPoolDataSource mysqlConnectionPoolDataSource;

    private DaoFactory() {
        this.init();
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        //Replace with connection pool
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysql?useSSL=false&connectTimeout=5000",
                "root", "rand47925");
    }


    public UserDao getUserDao() {
        UserDao userDao = null;
        try {
            userDao = new UserDaoImpl(getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userDao == null) System.out.println("Use Dao has not been initialized");
        return userDao;
    }

    public UserDataDao getUseDataDao() {

        UserDataDao userDataDao = null;
        try {
            userDataDao = new UserDataDaoImpl(getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userDataDao==null){
            System.out.println("UserDataDao is not initialised");
        }
        return userDataDao;
    }

}
