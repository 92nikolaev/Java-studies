<%--
  Created by IntelliJ IDEA.
  User: yshuk
  Date: 25-Apr-18
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>

<%-- пока ниработаит --%>
<%-- уже работаит, лол кек чебурек --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%-- в качестве тэга возьмем, к примеру, с --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="salary" scope="session" value="${500*12}"/>
<h3><c:out value="${salary}"/> EUR</h3>

<%--можно всякие выражения делать --%>

<c:if test="${salary>1000}">  <%--или true или false --%>
    я багаты, ептель
</c:if>


<c:choose>
    <c:when test="${salary>1000}">
        RICH BITCH
    </c:when>
    <c:otherwise>
        FFFUUU
    </c:otherwise>
</c:choose>

<h3> FOREACH</h3>
<% java.util.ArrayList array = new java.util.ArrayList();
    array.add("One kid");
    array.add("Two kids");
    array.add("Three kids");
    array.add("Four kids");
    session.setAttribute("array", array);
%>

<h3>List</h3>
<c:forEach items="${array}" var="item">
    <h3>${item}</h3>

</c:forEach>



