package by.it.academy.database;

import by.it.academy.model.Product;

import java.util.List;

public interface ProductDao {

    Product readProduct(int id);
    Product createProduct(Product product);
    List<Product> readAllProduct();
}
