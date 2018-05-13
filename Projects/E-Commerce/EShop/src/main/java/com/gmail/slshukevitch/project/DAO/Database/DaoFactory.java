package com.gmail.slshukevitch.project.DAO.Database;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {

    public static final String DATABASE_URL = "DATABASE_URL";
    public static final String DATABASE_USER = "DATABASE_USER";
    public static final String DATABASE_PASSWORD = "DATABASE_PASSWORD";

    private Properties properties;

    private DaoFactory(Properties properties) {
        this.properties = properties;
        this.init();
    }

    public static DaoFactory getInstance() {
        Properties properties = new Properties();
        InputStream is = Thread.currentThread().
                getContextClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getInstance(properties);
    }

    public static DaoFactory getInstance(Properties properties) {
        if (daoFactory == null) {
            daoFactory = new DaoFactory(properties);
        }
        return daoFactory;
    }


    private static DaoFactory daoFactory;
            //new DaoFactory();

    private MysqlConnectionPoolDataSource mysqlConnectionPoolDataSource;

    private DaoFactory() {
        this.init();
    }


    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        //Replaced with connection pool
        String databaseURL = properties.getProperty(DATABASE_URL);
        String databaseUser = properties.getProperty(DATABASE_USER);
        String databasePassword = properties.getProperty(DATABASE_PASSWORD);

        if (mysqlConnectionPoolDataSource == null) {
            mysqlConnectionPoolDataSource = new MysqlConnectionPoolDataSource();
            mysqlConnectionPoolDataSource.setURL(databaseURL);
            mysqlConnectionPoolDataSource.setUser(databaseUser);
            mysqlConnectionPoolDataSource.setPassword(databasePassword);
        }
        return mysqlConnectionPoolDataSource.getConnection();
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
        if (userDataDao == null) {
            System.out.println("UserDataDao is not initialised");
        }
        return userDataDao;
    }

    public ProductDao getProductDao() {

        ProductDao productDao = null;
        try {
            productDao = new ProductDaoImpl(getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (productDao == null) {
            System.out.println("productDao is not initialised");
        }
        return productDao;
    }


}
