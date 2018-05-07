package by.it.academy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MyServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");

        // Adding header from another servlet (HeaderServlet)
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/header");
        rd.include(req, resp);
        /*out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");*/

        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        Enumeration<String> en = getServletContext().getInitParameterNames();
        while (en.hasMoreElements()) {
            String paramName = en.nextElement();
            String paramValue =
                    getServletContext().getInitParameter(paramName);
            out.println("<h2>" + paramName + "=" + paramValue  +"</h2>");
        }
        out.println("<h2>DEBUG_LEVEL=" +
        getServletConfig().getInitParameter("DEBUG_LEVEL") + "</h2>");

        //Print parameters from GET URL
        Enumeration<String> pn = req.getParameterNames();
        while (pn.hasMoreElements()) {
            String s1 = pn.nextElement();
            String s2 = req.getParameter(s1);
            out.println("<h1>" + s1 + "=" + s2 +"</h1>");
        }

        //Add cookie to browser
        Cookie cookie =
                new Cookie("my_servlet_cookie", "cookie_value");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

        // Reading attributes from session
        HttpSession session = req.getSession();
        List<Map> userList = (List)session.getAttribute(USER_LIST);
        if (userList != null) {
            for (Map map : userList) {
                out.println("<h3> user: " + map.toString() + "</h3>");
            }
        }
        out.println("</body>");
        out.println("</html>");
    }

    private final static String USER_LIST = "USER_LIST";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");

        // Adding header from another servlet (HeaderServlet)
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/header");
        rd.include(req, resp);
        /*out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");*/
        HttpSession session = req.getSession();
        out.println(session.getAttribute("person") == null
                ? "empty" : ((Person)session.getAttribute("person")).getName());
        out.println("<body>");

        // Setting attributes to session
        List<Map> userList = (List)session.getAttribute(USER_LIST);
        if (userList == null) {
            userList = new LinkedList<>();
        }
        Enumeration<String> pn = req.getParameterNames();
        Map<String, String> postParam = new HashMap<>();
        while (pn.hasMoreElements()) {
            String s1 = pn.nextElement();
            String s2 = req.getParameter(s1);
            postParam.put(s1, s2);
            out.println("<h1>" + s1 + "=" + s2 +"</h1>");
        }
        if (postParam.size() > 0) userList.add(postParam);
        session.setAttribute(USER_LIST, userList);

        // Reading cookie from browser
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies) {
            out.println("<h1>" + cookie.getName()
                    + "=" + cookie.getValue() +"; " + cookie.getMaxAge() + "</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
