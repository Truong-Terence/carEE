<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../css/style.css"/>
    <script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<c:import url="partials/anonymous-navbar.jsp"></c:import>
<h1>Home</h1>


<section class="container d-flex">
        <c:forEach var="car" items="${cars}">
            <div class="card">
                <img src="${car.image}" class="card-img-top" alt="${car.name}">
                <div class="card-body">
                    <h5 class="card-title">${car.name}</h5>
                    <p class="card-text">${car.category.name}</p>
                    <c:if test="${!empty car.car_id}">
                    <a href="car-view?car_id=${car.car_id}" class="btn btn-primary">View Car</a>
                    </c:if>
                </div>
            </div>
        </c:forEach>
</section>
<c:import url="partials/services.jsp"></c:import>
<section>
    <div class="banner" style="background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)), url(https://www.sauvageboris.fr/training/javaee/carEE/resources/img/sunset.jpg);">
        <div class="container">
            <h1>CARS AVAILABLE</h1>
        </div>
    </div>
</section>
<c:import url="partials/whatAreYouwaittingFor.jsp"></c:import>

<c:import url="partials/getInTouch.jsp"></c:import>
<c:import url="partials/footer.jsp"></c:import>
</body>
</html>