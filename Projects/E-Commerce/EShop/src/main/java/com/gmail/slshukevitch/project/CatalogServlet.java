package com.gmail.slshukevitch.project;

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
    static{

        products = new ArrayList<>(10);
        for(int i=0; i<10; i++){
            Product product = new Product();
            product.setCreatedDate(Calendar.getInstance());
            product.setDescription("Ford Model "+i);
            product.setId(i);
            product.setName("Ford "+i);
            product.setPrice(1000+1000+Math.random());
            products.add(product);
        }
    }

    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    public void doPost( HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("products", products);
    }

}
