<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="../css/style.css"  rel="stylesheet">
  <title>List of Categories</title>
</head>
<body>
<c:import url="partials/anonymous-navbar.jsp"></c:import>
<h1>List of Categories</h1>
  <c:forEach var="category" items="${categories}">
    <tr>
      <td>${category.name}</td>
    </tr>
  </c:forEach>
<c:import url="partials/services.jsp"></c:import>
<c:import url="partials/whatAreYouwaittingFor.jsp"></c:import>

<c:import url="partials/footer.jsp"></c:import>
</body>
</html>
