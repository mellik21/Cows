<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Игра бык-корова</title>
    <link href="<c:url value="/res/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script type="text/javascript">
        function showAnswer() {
            $("#answer").show();
        }
    </script>
</head>
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
    <br> <br> <br>
    <form method="post">
        <div class="container">
            <button class="btn btn-lg" type="button" onclick="showAnswer()">Узнать правильный ответ</button>

            <div>
                <label id="answer" style="display: none;">Число: ${game.num}</label>
            </div>

            <h5>Число попыток: ${score}</h5>

            <label for="inputGroupSelect01"></label><select id="inputGroupSelect01" name="select">
            <option selected>Choose...</option>
            <option value="0">O</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
        </select>
            <label for="inputGroupSelect02"></label><select id="inputGroupSelect02" name="select">
            <option selected>Choose...</option>
            <option value="0">O</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
        </select>
            <label for="inputGroupSelect03"></label><select id="inputGroupSelect03" name="select">
            <option selected>Choose...</option>
            <option value="0">O</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
        </select>
            <label for="inputGroupSelect04"></label><select id="inputGroupSelect04" name="select">
            <option selected>Choose...</option>
            <option value="0">O</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
        </select>

            <button class="btn btn-primary" type="submit">Отправить</button>
            <a class="small" href="<c:url value="/new"/> "> Начать новую игру </a>
            <h5>Предыдущие результаты:</h5>
            <c:forEach items="${game.results}" var="result">
                <p>${result}</p>
            </c:forEach>
        </div>
    </form>
</main>

<footer class="footer mt-auto py-3">
    <div class="container">
        <span class="text-muted">Place sticky footer content here.</span>
    </div>
</footer>
</body>
</html>