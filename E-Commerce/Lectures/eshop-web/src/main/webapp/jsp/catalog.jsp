<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/jsp/header.jsp"/>
<jsp:include page="/get_catalog"/>
<div class="container">
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="#">Интернет магазин</a>
        <a class="nav-link active" href="/test/index.html">Главная</a>
        <a class="nav-link" href="/test/index.html">Каталог</a>
        <a class="nav-link" href="/test/index.html">Заказы</a>
        <a class="nav-link" href="/test/index.html">О компании</a>
        <a class="nav-link" href="/test/index.html">Регистрация</a>
        <a class="nav-link" href="/test/login.html">Войти</a>
    </nav>
    <!-- main area -->
    <div class="jumbotron text-center">
        <p class="h4">Каталог</p>
        <p class="lead">В нашем каталоге вы можете найти лучшие предложения новых моделей автомобилей BMW</p>
        <hr/>
        <p>Выбирайте интересующую вас модель из списка ниже.</p>
    </div>
    <table class="table table-striped">
        <tbody>
        <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.description}"/></td>
            <fmt:formatNumber value="${product.price}" maxFractionDigits="2" var="price"/>
            <td><c:out value="${price}"/>EUR</div>
            <td><c:out value="${product.createdDate.time.year+1900}"/></td>
            <td><a class="btn btn-secondary btn-sm"
    href="/test/product.html?product_id=${product.id}" role="button">Подробнее</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- end of main area -->
</div>
<jsp:include page="/jsp/footer.jsp"/>