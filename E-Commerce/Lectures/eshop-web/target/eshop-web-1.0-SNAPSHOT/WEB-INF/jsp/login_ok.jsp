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
        <p class="h4">Добро пожаловать!</p>
        <p class="lead">Уважаемый ${userData.firstName} ${userData.secondName}, мы снова рады видеть Вас!</p>
        <hr/>
        <p>Широкий выбор автомобилей в нашем каталоге.</p>
        <a class="btn btn-primary" href="/test/catalog.html"
                role="button">Перейти в каталог</a>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>