<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация админа</title>
</head>
<body>

    <spring:form method="post" action="/reg/admin" modelAttribute="newAdmin">
        <spring:input  path="login"/>
        <spring:errors path="login"/>
        ${messageErrorAdmin}
        <p>Пароль</p>
        <spring:input path="password"/>
        <spring:errors path="password"/>
        <spring:button>Add admin</spring:button>
    </spring:form>

</body>

</html>
