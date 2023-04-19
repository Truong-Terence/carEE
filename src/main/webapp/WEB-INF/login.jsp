<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="../css/style.css"  rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <title>Login</title>
</head>
<body>
<c:import url="partials/anonymous-navbar.jsp"></c:import>
<div class="container">
  <form action="${pageContext.request.contextPath}/login" method="post">
    <div class="mb-3">
      <label  class="form-label">Username</label>
      <input type="text" name="username" class="form-control">
    </div>
    <div class="mb-3">
      <label for="exampleInputPassword1" class="form-label">Password</label>
      <input type="password" name="password" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
  </form>

  <a href="/register"><button type="button" class="btn btn-warning">Register</button></a>
  <c:if test="${isError == true}">
    <p>Bad credentials.</p>
  </c:if>
</div>
<c:import url="partials/footer.jsp"></c:import>
</body>
</html>
