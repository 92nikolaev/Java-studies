<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <title>Войти</title>
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
        <a class="nav-link" href="/project/catalog.html">Каталог</a>
        <a class="nav-link" href="/project/index.html">Заказы</a>
        <a class="nav-link" href="/project/index.html">О компании</a>
        <a class="nav-link" href="/project/index.html">Регистрация</a>
        <a class="nav-link" href="/project/login.html">Войти</a>
    </nav>
    <div class="jumbotron text-center">
        <p class="h4">Войти</p>
        <p class="lead">Для того, чтобы войти в наш магазин, введите имя пользователя и пароль.</p>
        <hr/>
        <p>Если у вас еще нет имени пользователя и пароля - пройдете регистрацию.</p>
        <a class="btn btn-primary" href="/project/index.html" role="button">Регистрация</a>
    </div>

    <form action="/project/login_action" method="post" onclick="">
        <div class="form-group">
            <label>Имя пользователя:</label>
            <input name="login" type="text" class="form-control" placeholder="логин" autofocus/>
            <small id="loginHelp" class="form-text text-muted">Ваши данные не будут переданы третьим лицам.</small>
        </div>

        <div class="form-group">
            <label>Пароль:</label>
            <input name="password" type="password" class="form-control" placeholder="пароль"/>
        </div>
        <button type="submit" class="btn btn-primary">&nbsp;Войти&nbsp;</button>
    </form>

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