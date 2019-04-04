<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Добавление полета</title>
</head>
<body>
    <form method="post" action="/logAdmin/flight">
        <p>Дата полета</p>
        <input type="date" name="date">
        <p>Откуда</p>
        <input name="cityFrom">
        <p>Куда</p>
        <input name="cityTo">
        <button type="submit">Add flight</button>
    </form>

    <a href="/logAdmin">Вернуться</a>
</body>
</html>
