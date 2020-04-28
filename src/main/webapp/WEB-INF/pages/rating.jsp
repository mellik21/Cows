<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
    <link href="<c:url value="/res/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
</head>
<style>
    div.container6 {
        width: 500px; /* Ширина элемента в пикселах */
        padding: 10px; /* Поля вокруг текста */
        margin: auto; /* Выравниваем по центру */
    }

</style>
<body class="d-flex flex-column h-100" style="background-color: #F5F5F5">
<header>
    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <a class="navbar-brand" href="#" style="color:#761c19;">Быки и коровы</a>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">

                <a class="nav-link" href="<c:url value="/rating"/>" style="color: #000000">Посмотреть рейтинг</a>
            </ul>
            <ul class="navbar-nav mr-auto">
                <a class="nav-link" style="color: #000000">${username}</a>
            </ul>
        </div>
    </nav>
</header>

<main role="main" class="flex-shrink-0">
<% int i = 1;%>

<div class="container6">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">№</th>
            <th scope="col">Имя пользователя</th>
            <th scope="col">Среднее число попыток</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <th scope="row"><%=i%>
                </th>
                <td>${user.login}</td>
                <td> ${user.score}</td>
            </tr>
            <% i++; %>
        </c:forEach>
        </tbody>
    </table>

    <a href="<c:url value="/game"/>" class="btn btn-primary">Начать игру</a>
</div>

</main>
</body>
</html>