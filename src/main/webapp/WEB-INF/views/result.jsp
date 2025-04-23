<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Result</title>
</head>
<body>
<h1>Submitted Details</h1>
<c:forEach var="user" items="${users}">
    <form method="post" action="form" name="more">
        <p>Name: ${user.name}</p>
        <input type="hidden" name="name" value="${user.name}">
        <input type="hidden" name="email" value="${user.email}">
        <input type="hidden" name="country" value="${user.country}">
        <input type="hidden" name="action" value="more">
        <button type="submit">See more infos</button>
    </form>
    <c:if test="${showDetails and selectedUser.name eq user.name}">
        <p>Email: ${user.email}</p>
        <p>Country: ${user.country}</p>
    </c:if>
    <p>-----------------------------</p>
</c:forEach>
<a href="form">Back to Form</a>
</body>
</html>