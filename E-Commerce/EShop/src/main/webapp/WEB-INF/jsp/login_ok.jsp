<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <title>Login page</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="#">Интернет-магазин</a>
        <a class="nav-link active" href="/project/index.html">Главная</a>
        <a class="nav-link" href="/project/index.html">Каталог</a>
        <a class="nav-link" href="/project/index.html">Заказы</a>
        <a class="nav-link" href="/project/index.html">О компании</a>
        <a class="nav-link" href="/project/index.html">Регистрация</a>
        <a class="nav-link" href="/project/login.html">Войти</a>
    </nav>


    <div class="jumbotron text-center">
        <p class="h4">Добро пожаловать!</p>
        <p class="lead">Уважаемый
            <c:out value="${userData.firstName}"/>
            <c:out value="${userData.secondName}"/>
            , добро пожаловать!
        </p>
        <hr/>
        <p>Широкий выбор автомобилей в нашем каталоге.</p>
        <a class="btn btn-primary" href="/project/catalog.html"
           role="button">Перейти в каталог</a>
    </div>



</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>