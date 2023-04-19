<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Car View</title>
  <link href="../css/style.css"  rel="stylesheet">
  <script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<c:import url="partials/anonymous-navbar.jsp"></c:import>
<h1>Car View</h1>

<section class="container">
  <div class="card" style="width: 18rem;">
    <img src="${car.image}" class="card-img-top" alt="${car.name}">
    <div class="card-body">
      <h5 class="card-title">${car.name}</h5>
      <p class="card-text">${car.description}</p>
      <p class="card-text">${car.price}</p>
    </div>
  </div>
</section>


<c:import url="partials/getInTouch.jsp"></c:import>
<c:import url="partials/footer.jsp"></c:import>
</body>
</html>
