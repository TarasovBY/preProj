<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Страница пользователя</title>
<h1>Эта страница пользователя</h1>
</head>
<body>
<p>Сервер, который принял запрос: <c:out value="${nameServer}"></c:out></p>
<br>
<p>IP адрес: <c:out value="${nameUser}"></c:out></p>
<br>
<p>Сессия пользователя: <c:out value="${nameSession}"></c:out></p>
</body>
</html>
