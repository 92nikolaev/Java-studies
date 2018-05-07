<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/jsp/header.jsp"/>

<div class="container">
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="#">Интернен магазин</a>
        <a class="nav-link active" href="/test/index.html">Главная</a>
        <a class="nav-link" href="/test/catalog.html">Каталог</a>
        <a class="nav-link" href="/test/index.html">Заказы</a>
        <a class="nav-link" href="/test/index.html">О компании</a>
        <a class="nav-link" href="/test/index.html">Регистрация</a>
        <a class="nav-link" href="/test/login.html">Войти</a>
    </nav>
    <!-- Main area -->
    <div class="jumbotron text-center">
        <p class="h4">Войти</p>
        <p class="lead">Для того, чтобы войти в наш магазин, введите имя пользователя и пароль.</p>
        <hr/>
        <p>Елси у вас еще нет имени пользователя и пароля - пройдете регистрацию.</p>
        <a class="btn btn-primary" href="/test/index.html" role="button">Регистрация</a>
    </div>
    <form action="/test/login_action" method="post" onclick="">
        <div class="form-group">
            <label>Имя пользователя:</label>
            <input name="login" type="text" class="form-control"
                placeholder="your login" autofocus/>
        </div>
        <div class="form-group">
            <label>Пароль:</label>
            <input name="password" type="password" class="form-control"
                placeholder="your password "/>
        </div>
        <button type="submit" class="btn btn-primary">&nbsp;Войти&nbsp;</button>
    </form>
</div>

<jsp:include page="/jsp/footer.jsp"/>