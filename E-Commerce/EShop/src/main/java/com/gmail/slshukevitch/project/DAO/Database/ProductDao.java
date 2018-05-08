package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.Product;

import java.util.List;

public interface ProductDao {

    Product readProduct(int id);
    Product createProduct(Product product);
    List<Product> readAllProduct();
}
