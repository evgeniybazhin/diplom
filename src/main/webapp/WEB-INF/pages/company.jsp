<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Добавление компании</title>
</head>
<body>
    <spring:form method="post" modelAttribute="newCompany" action="/logAdmin/company">
        <spring:input path="nameCompany"/>
        <spring:errors path="nameCompany"/>
        ${error}
        <spring:button>Add company</spring:button>
    </spring:form>
    <a href="/logAdmin">Вернуться</a>
</body>
</html>
