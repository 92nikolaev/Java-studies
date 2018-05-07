<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="salary" scope="session" value="${40*8*20}"/>
<h3><c:out value="${salary}"/> EUR</h3>

<c:choose>
	<c:when test="${salary>1000}">
		I am rich
	</c:when>
	<c:otherwise>
		I am poor
	</c:otherwise>
</c:choose>

<h3>Iterating over a range</h3>
<c:forEach var="count" begin="1" end="25">
    ${count},
</c:forEach>

<!--
<% ArrayList array = new ArrayList();
    array.add("One kid");
    array.add("Two kids");
    array.add("Three kids");
    array.add("Four kids");
    pageContext.setAttribute("array", array);
%>
<h3>Iterating over a List</h3>
<c:forEach items="${array}" var="item" >
    <h3>${item}</h3>
</c:forEach>
-->
