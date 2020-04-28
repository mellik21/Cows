<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript">
    function checkPasswordMatch() {
        var password = $("#pass1").val();
        var confirmPassword = $("#pass2").val();

        if (password !== confirmPassword)
            $("#divCheckPasswordMatch").html("Passwords do not match!");
        else
            $("#divCheckPasswordMatch").html("Passwords match.");
    }
    </script>
</head>
<body>

<div class="login d-flex align-items-center py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-7 col-lg-6 mx-auto">
                <h3 class="login-heading mb-4">Регистрация</h3>
                <form:form name="user" method="post">
                    <div class="form-label-group">
                        <label for="login">Логин</label>
                        <input type="text" id="login" name="login" class="form-control" value="${user.login}" autofocus>
                    </div>

                    <div class="form-label-group">
                        <label for="password">Пароль</label>
                        <input type="password" id="password" name="password" class="form-control" value="${user.password}">
                    </div>

                    <div class="form-label-group">
                        <label for="inputPassword1">Повторите пароль</label>
                        <input type="password" id="inputPassword1" class="form-control" required>
                    </div>
                    <p></p>

                    <button class="btn btn-lg btn-outline-primary btn-block btn-login mb-2" type="submit">Зарегистрироваться</button>

                    <div class="text-center">
                        <a class="small" href="<c:url value="/"/>">Уже есть аккаунт? Войти</a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
