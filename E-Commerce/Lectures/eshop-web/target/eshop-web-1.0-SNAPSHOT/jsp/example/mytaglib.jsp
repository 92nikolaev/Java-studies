<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="by.it.academy.*" %>

<c:set var="salary" scope="session" value="${500*12}"/>
<c:out value="${salary}"/>
<br/>

<c:if test="${salary>1000}">
	Я богатый белорус!
</c:if>
<br/>

<c:choose>
	<c:when test="${salary>1000}">
		I am rich
	</c:when>
	<c:otherwise>
		I am poor
	</c:otherwise>
</c:choose>
<br/>

<h3>Iterating over a range</h3>
<c:forEach var="count" begin="1" end="25">
    ${count},
</c:forEach>
<br/>

<% java.util.ArrayList array = new java.util.ArrayList();
    array.add("One kid");
    array.add("Two kids");
    array.add("Three kids");
    array.add("Four kids");
    session.setAttribute("array", array);
%>
<h3>Iterating over a List of String</h3>
<c:forEach items="${array}" var="item" >
    <h3>${item}</h3>
</c:forEach>
<br/>

<% java.util.ArrayList orders = new java.util.ArrayList();
    orders.add(new Order("BMW x1", 2, 25000.99));
    orders.add(new Order("BMW x3", 1, 50000.99));
    orders.add(new Order("BMW x5", 3, 75000.99));
    orders.add(new Order("BMW x6", 1, 125000.99));
    session.setAttribute("orders", orders);
%>
<h3>Iterating over a List with Orders</h3>
<c:forEach items="${orders}" var="order">
<div class="row">
    <div class="col-sm"><c:out value="${order.productName}"/></div>
    <div class="col-sm"><c:out value="${order.quantity}"/></div>
    <div class="col-sm"><c:out value="${order.price}"/></div>
    <div class="col-sm"><c:out value="${order.total}"/></div>
</div>
</c:forEach>





