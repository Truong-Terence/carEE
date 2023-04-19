<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>car list</title>
  <link href="../css/style.css"  rel="stylesheet">
  <script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<c:import url="partials/anonymous-navbar.jsp"></c:import>
<a href="/create-car" class="btn btn-primary">Create Car</a>
<section class="container d-flex">
    <c:forEach var="car" items="${cars}">
        <div class="card">
            <img src="${car.image}" class="card-img-top" alt="${car.name}">
            <div class="card-body">
                <h5 class="card-title">${car.name}</h5>
                <p class="card-text">${car.category.name}</p>
                <a href="car-view?car_id=${car.car_id}" class="btn btn-success">Details</a>
                <form method="POST" action="list-car">
                    <input type="hidden" name="car_id" value="${car.car_id}" />
                    <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this car?')">Delete</button>
                </form>
            </div>
        </div>
    </c:forEach>
</section>



<c:import url="partials/getInTouch.jsp"></c:import>
<c:import url="partials/footer.jsp"></c:import>
</body>
</html>
