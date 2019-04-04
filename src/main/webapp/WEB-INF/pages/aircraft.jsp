<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление самолета</title>
</head>
<body>
    <spring:form method="post" modelAttribute="newAir" action="/logAdmin/aircraft">
        <spring:input path="nameAircraft"/>
        <spring:errors path="nameAircraft"/>
        <spring:button>Add aircraft</spring:button>
        ${errorCurrentCompany}
    </spring:form>
    <a href="/logAdmin/currentCompany">Выбрать компанию</a>
    <a href="/logAdmin">Вернуться</a>
</body>
</html>
