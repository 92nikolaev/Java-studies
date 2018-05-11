package com.gmail.slshukevitch.project.WEB;

import com.gmail.slshukevitch.project.DAO.Model.UserData;
import com.gmail.slshukevitch.project.DAO.Database.DaoFactory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginActionServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        System.out.println("login "+login);
        System.out.println("password "+password);

        //Connection to DB


       UserData userData = DaoFactory.getInstance().getUseDataDao().readUserData(login);

        if (login == null || !password.equals(userData.getPassword())) {

            resp.sendRedirect(getServletContext().getContextPath()
                    + "/login_error.html");
        }
        else {
            req.getSession().setAttribute("userData", userData);
            getServletContext().getRequestDispatcher(
                    "/login_ok.html").forward(req, resp);
        }
    }

}
