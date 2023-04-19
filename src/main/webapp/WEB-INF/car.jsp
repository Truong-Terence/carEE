<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../css/style.css"  rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Car list</title>
</head>
<body>
<c:import url="partials/anonymous-navbar.jsp"></c:import>
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
<c:import url="partials/footer.jsp"></c:import>
</body>
</html>
