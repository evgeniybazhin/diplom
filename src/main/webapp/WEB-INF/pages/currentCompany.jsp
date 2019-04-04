<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текущая компания</title>
</head>
<body>
    <spring:form modelAttribute="currentCompany" method="post" action="/logAdmin/currentCompany">
        <spring:input path="nameCompany"/>
        <spring:button>Pick current company</spring:button>
        <spring:errors path="nameCompany"/>
        ${errorPickCountry}
    </spring:form>
</body>
</html>
