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
    <!-- main area -->
    <div class="jumbotron text-center">
        <p class="h4">Ошибка входа</p>
        <p class="lead">Имя пользователя или пароль указаны неверно!</p>
        <hr/>
        <p>Если у вас еще нет имени пользователя и пароля - пройдите регистрацию.</p>
        <a class="btn btn-primary" href="/test/index.html"
                role="button">Регистрация</a>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>