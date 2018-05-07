<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="person" class="by.it.academy.Person" />

<jsp:setProperty name="person" property="title" value="Господин Премьер Министр"/>
<jsp:setProperty name="person" property="name" value="Дмитрий Анатольевич Медведев"/>

<ul>
	<li>Обращение:
		<jsp:getProperty name="person" property="title"/>
	</li>
	<li>Имя:
		<jsp:getProperty name="person" property="name"/>
	</li>
</ul>
