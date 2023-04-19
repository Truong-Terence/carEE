<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link href="../../css/style.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f61a6ddc10.js" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/create-car">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br>

  <label for="category">Category:</label>
  <select id="category" name="category" required>
    <option value="1">Category1</option>
    <option value="1">Category1</option>
    <option value="1">Category1</option>
  </select><br>

  <label for="price">Price:</label>
  <input type="number" id="price" name="price" required><br>

  <label for="description">Description:</label>
  <textarea id="description" name="description"></textarea><br>

  <button type="submit">Create Car</button>

</form>

</body>
</html>
