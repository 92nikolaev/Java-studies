package by.it.academy;

import by.it.academy.model.ObjectFactory;
import by.it.academy.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CatalogServlet extends HttpServlet {

    static List<Product> products;

    static {
        products = new ArrayList<>(10);
        ObjectFactory objectFactory = new ObjectFactory();
        for (int i = 0; i < 10; i++) {
            Product product = objectFactory.createProduct();
            product.setCreatedDate(Calendar.getInstance());
            product.setDescription("BMW Description " + i);
            product.setId(i);
            product.setName("BMW X" + i);
            product.setPrice(10000 + 10000 * Math.random());
            products.add(product);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //TODO: replace with DaoFactory.getInstance().getProductDao().readProducts();
        req.getSession().setAttribute("products", products);
    }
}