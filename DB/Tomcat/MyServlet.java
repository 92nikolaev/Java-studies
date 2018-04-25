package by.it.academy;


import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import static java.lang.System.out;


public class MyServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
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

        String fio = request.getParameter("fio");
        String mail = request.getParameter("mail");

        //Print all GET`s

        Enumeration<String> pn = request.getParameterNames();
        while(pn.hasMoreElements()) {
            //out.println("<h1> Hey, " + fio + "</h1>");
            //out.print("<h2> mail: " + mail + "</h2>");
            String s1 = pn.nextElement();
            String s2 = request.getParameter(s1);
            out.print("<h2>"+s1+" " + s2 + "</h2>");
        }


        //COOKIE COOKIE

        Cookie cookie = new Cookie("my_servlet_cookie", "cookie_value");
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);

        HttpSession session = request.getSession();
        List<Map> userList = (List)session.getAttribute(USER_LIST);
        if(userList != null) {
            for (Map map : userList) {
                out.println("<h3> user: " + map.toString() + " </h3>");
            }
        }
        out.println("</body>");
        out.println("</html>");
    }

    private final static String USER_LIST = "USER_LIST";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //SESSION


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
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


        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            out.println("<h1> This is cookie: "+cookie.getName()+" = "+cookie.getValue()+
                    " : "+cookie.getMaxAge()+"</h1>");
        }

        HttpSession session = request.getSession();
        List<Map> userList =  (List)session.getAttribute("USER_LIST");  //OBJECT
        if(userList == null){
            userList = new LinkedList<>();
        }
        Enumeration<String> pn = request.getParameterNames();
        Map<String, String> postParam = null;
        postParam = new HashMap<>();
        while(pn.hasMoreElements()) {
            //out.println("<h1> Hey, " + fio + "</h1>");
            //out.print("<h2> mail: " + mail + "</h2>");

            String s1 = pn.nextElement();
            String s2 = request.getParameter(s1);
            postParam.put(s1,s2);
            out.print("<h2>"+s1+" " + s2 + "</h2>");
        }

        if(postParam.size()>0){
            userList.add(postParam);
        }
        session.setAttribute(USER_LIST, userList);
        out.println("</body>");
        out.println("</html>");
    }
}



