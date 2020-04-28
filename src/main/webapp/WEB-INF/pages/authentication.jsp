<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Авторизация</title>
    <link href="<c:url value="/res/css/authorization.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="login d-flex align-items-center py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-7 col-lg-6 mx-auto">
                <h3 class="login-heading mb-4">Добро пожаловать!</h3>
                <form:form name="user" method="POST">
                    <div class="form-label-group">
                        <label for="login">Логин</label>
                        <input type="text" id="login"  name="login" class="form-control" value="${user.login}" autofocus>
                    </div>

                    <div class="form-label-group">
                        <label for="password">Пароль</label>
                        <input type="password" id="password" name="password" class="form-control" value="${user.password}">
                    </div>
                    <p></p>
                    <button class="btn btn-lg btn-outline-primary btn-block btn-login mb-2" type="submit">Войти</button>
                    <div class="text-center">
                        <a class="small" href="<c:url value="/registration"/>">Регистрация</a></div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>