<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="by.it.academy.Person"%>

<%! int x = 2 * 2; %>
<%= x %>

<%= new Date()%><br>
Host name: <%= request.getRemoteHost()%><br>
Параметер: <%= request.getParameter("title")%><br>

<%! private int accessCount = 0; %>
<%= ++accessCount %><br>
<!-- My comments -->
<%
System.out.println("accessCount=" + accessCount);
Person person = new Person();
person.setName(request.getParameter("name"));
person.setTitle(request.getParameter("title"));

if (request.getParameter("name") != null &&
  !"".equals(request.getParameter("name")))
session.setAttribute("person", person);
%>
Hello, <%= session.getAttribute("person") == null
? "Unknown" : ((Person)session.getAttribute("person")).getName()%>
