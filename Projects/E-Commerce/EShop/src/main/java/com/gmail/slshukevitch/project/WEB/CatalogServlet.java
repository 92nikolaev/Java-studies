package com.gmail.slshukevitch.project.WEB;

import com.gmail.slshukevitch.project.DAO.Database.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CatalogServlet extends HttpServlet {

    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    public void doPost( HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("products", DaoFactory.getInstance().getProductDao().readAllProduct());
    }

}
