package by.it.academy;


import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

import static java.lang.System.out;


public class MyServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ho-Ho-Ho!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Ho-Ho-Ho!</h1>");

        Enumeration<String> en = getServletContext().getInitParameterNames();
        //писать надо именно тут, чтобы h2 прописался именно в <body> а не куда-то еще
        while (en.hasMoreElements()) {
            String paramName = en.nextElement();
            String paramValue = getServletContext().getInitParameter(paramName);
            out.println("<h2>" + paramName + " = " + paramValue + "</h2>");
        }
        out.println("<h2>DEBUG LEVEL =  "
                + getServletConfig().getInitParameter("DEBUG_LEVEL"));

        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ho-Ho-Ho!</title>");
        out.println("</head>");
        out.println("<body>");
        String fio = request.getParameter("fio");
        String mail = request.getParameter("mail");
        out.println("<h1> Hey, " + fio + "</h1>");
        out.print("<h2> mail: " + mail + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}



