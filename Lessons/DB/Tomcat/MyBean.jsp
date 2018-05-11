<%--
  Created by IntelliJ IDEA.
  User: yshuk
  Date: 27-Apr-18
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<jsp:useBean id="order" class="by.it.academy.Order">
    <jsp:setProperty name="order" property="productName" value="iPhone X"/>
    <jsp:setProperty name="order" property="price" value="999.9"/>
    <jsp:setProperty name="order" property="quantity" value="3"/>
</jsp:useBean>


<ul>
    <li> Количество элементов
        <jsp:getProperty name="order" property="quantity"/>
    </li>
    <li>Название товара
        <jsp:getProperty name="order" property="productName"/>
    </li>
    <li>Цена
        <jsp:getProperty name="order" property="price"/>
    </li>
    <li>Итого
        <jsp:getProperty name="order" property="total"/>
    </li>
</ul>
<%@include file="footer.jsp"%>