package com.gmail.slshukevitch.project.DAO.Database;



import com.gmail.slshukevitch.project.DAO.Model.ObjectFactory;
import com.gmail.slshukevitch.project.DAO.Model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection conn;

    public ProductDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Product readProduct(int id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> readAllProduct() {
        List<Product> productList = new LinkedList<>();
        try (Statement statement = conn.createStatement()) {

            ObjectFactory objectFactory = new ObjectFactory();
            ResultSet rs = statement.executeQuery("select * from eshop_database.product");

            while (rs.next()) {
                Product p = objectFactory.createProduct();
                p.setId(rs.getInt("id"));
                Calendar calendar = new GregorianCalendar();
                calendar.setTimeInMillis(rs.getTimestamp("created_date").getTime());
                p.setCreatedDate(calendar);
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setStatus(rs.getString("status"));
                productList.add(p);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


        return productList;
    }
}
