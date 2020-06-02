<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Страница авторизации пользователей</title>
    <form action="/login" method="Post">
        <p>Имя</p>
        <input type="text" name="name">
        <br>
        <p>Пароль</p>
        <input type="text" name="password">
        <br>
        <br>
        <input type="submit" value="Login">
    </form>
</head>
<body>

</body>
</html>
