<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="order" class="by.it.academy.Order">
    <jsp:setProperty name="order" property="productName" value="iPhone X"/>
    <jsp:setProperty name="order" property="price" value="999.99"/>
    <jsp:setProperty name="order" property="quantity" value="3"/>
</jsp:useBean>

<ul>
	<li>Название товара:
    	<jsp:getProperty name="order" property="productName"/>
    </li>
	<li>Количество предметов:
		<jsp:getProperty name="order" property="quantity"/>
	</li>
	<li>Цена за штуку:
		<jsp:getProperty name="order" property="price"/>
	</li>
    <li>Итого:
        <jsp:getProperty name="order" property="total"/>
    </li>
</ul>