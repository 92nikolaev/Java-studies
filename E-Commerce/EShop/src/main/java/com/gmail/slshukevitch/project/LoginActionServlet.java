package com.gmail.slshukevitch.project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginActionServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("test/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password"); //somewhere in database

        if (login == null || "".equals(login)) {
            //TODO: call database;
            //любой путь мб, поэтому получаем, без хардкода
            resp.sendRedirect(getServletContext().getContextPath() + "/login_error.html");
        }
        //This is Bean
        else {

            //some random values just for debugging

            UserData userData = new UserData();
            userData.setFirstName("Ivan");
            userData.setSecondName("Ivanov");
            userData.setLogin("vanya14");

            req.getSession().setAttribute("userData", userData);
            getServletContext().getRequestDispatcher("/login_ok.html").forward(req, resp);

        }

    }

}
