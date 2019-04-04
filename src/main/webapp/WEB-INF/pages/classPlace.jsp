<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Добавление класса на место</title>
</head>
<body>
    <spring:form modelAttribute="classPlace" method="post" action="/logAdmin/classPlace">
        <spring:input path="name"/>
        <spring:errors path="name"/>
        <spring:button>Add Class Place</spring:button>
    </spring:form>

    <a href="/logAdmin">Вернуться</a>
</body>
</html>
