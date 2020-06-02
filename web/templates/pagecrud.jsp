<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Tarasov CRUD</title>
</head>
<body>

<h1>Задача 1.1.4</h1>
<table border="3">
    <tr>
        <td>Айди</td>
        <td>Имя</td>
        <td>Телефон</td>
        <td>Действия</td>
    </tr>
    <c:forEach var="variable" items="${users}">
        <form action="/updateuser" method="post">
            <tr>
                <td>
                    <input type="text" name="id" value="${variable.id}">
                </td>
                <td>
                    <input type="text" name="name" value="${variable.name}">
                </td>
                <td>
                    <input type="text" name="telephone" value="${variable.telephone}">
                </td>
                <td>

                    <input type="submit" value="Редактировать">
        </form>
        <form action="/deleteuser" method="post">
            <input type="hidden" name="id" value="${variable.id}">
            <input type="hidden" name="name" value="${variable.name}">
            <input type="hidden" name="telephone" value="${variable.telephone}">
            <input type="submit" value="Удалить">
        </form>

        </tr>
    </c:forEach>
</table>
<h1>Добавить нового юзера</h1>
<table border="3">
    <form action="/adduser" method="post">
        <tr>
            <td>
                <input type="text" name="name" value="Имя юзера">
            </td>
            <td>
                <input type="text" name="telephone" value="Телефон юзера">
            </td>
            <td>
                <input type="submit" value="Добавить юзера"></td>
        </tr>
    </form>
</table>
</body>
</html>