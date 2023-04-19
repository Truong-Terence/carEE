<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Users</title>
</head>
<body>
<h1>Users</h1>
<table>
  <thead>
  <tr>
    <th>Name</th>
    <th>Prénom</th>
    <th>Email</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.lastName}</td>
      <td>${user.firstName}</td>
      <td>${user.email}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
