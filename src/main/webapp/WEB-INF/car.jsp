<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car list</title>
</head>
<body>
<h1>Car list</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>img</th>
        <th>price</th>
        <th>Category</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.name}</td>
            <td>${car.image}</td>
            <td>${car.price}</td>
            <td>${car.category.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
