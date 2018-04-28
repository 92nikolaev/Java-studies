<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/get_catalog"></jsp:include>  <!-- !!!!!! -->

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
        <a class="nav-link active" href="/test/index.html">Главная</a>
        <a class="nav-link" href="/test/catalog.html">Каталог</a>
        <a class="nav-link" href="/test/index.html">Заказы</a>
        <a class="nav-link" href="/test/index.html">О компании</a>
        <a class="nav-link" href="/test/index.html">Регистрация</a>
        <a class="nav-link" href="/test/login.html">Войти</a>
    </nav>


    <div class="jumbotron text-center">
        <p class="h4">Каталог</p>
        <p class="lead">В нашем каталоге вы найдете все предложения новых моделей</p>
        <hr/>
        <p>Выберите интересующую модель: </p>

    </div>

    <c:forEach items="${products}" var="product">

    <div class="row">
        <div class="col-sm"><c:out value="${product.name}"/></div>
        <div class="col-sm"><c:out value="${product.description}"/></div>
        <div class="col-sm"><c:out value="${product.price}"/></div>
        <div class="col-sm"><c:out value="${product.createdDate.time.year+1900}"/></div>
        <div class="col-sm">
            <a class="btn btn-secondary btn-sm"
               href="/test/product.html?product_id=${product.id}" role="button">Подробнее</a></div>
    </div>

    </c:forEach>


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