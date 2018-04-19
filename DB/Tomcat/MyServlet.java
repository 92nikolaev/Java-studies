package by.it.academy;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class MyServlet extends HttpServlet {
        //just some example from Tomcat
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ho-Ho-Ho!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Ho-Ho-Ho!</h1>");
        out.println("</body>");
        out.println("</html>");
    }


}
