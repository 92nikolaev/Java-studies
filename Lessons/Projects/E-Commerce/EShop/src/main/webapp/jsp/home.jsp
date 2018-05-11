<%--
  Created by IntelliJ IDEA.
  User: yshuk
  Date: 25-Apr-18
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%@page import="java.util.Date" %>
<%@page import="by.it.academy.Person" %>
> <!-- Import class -->

<%@include file="header.jsp"%>
<% x = 2*2;%>
<%=x%>


<%=new Date()%></br>
Host Name: <%=request.getRemoteHost()%></br>
Параметр: <%=request.getParameter("title")%></br>
<%!private int accessCount = 0;%>
<%=++accessCount%></br>

<%--Some Java code in <% %> --%>
<%

    System.out.println("This is another counter: " + accessCount);
    //will display in Tomcat`s window

    Person vasya = new Person();
    vasya.setName(request.getParameter("name"));
    vasya.setTitle(request.getParameter("title"));
    if (!"".equals(request.getParameter("name"))  //empty string
            && request.getParameter("name") != null) {
        session.setAttribute("person", vasya);
    }

%>
 Hey, <%=session.getAttribute("person")==null ? "void":
        ((Person)session.getAttribute("person")).getName()%>


<%@include file="footer.jsp"%>


