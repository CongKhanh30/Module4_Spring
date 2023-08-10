
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="mt-3">
        <h1 style="color: blue">Add Girl</h1>
    </div>
    <form action="/products/add" method="post">

<%--        <div class="form-group">--%>
<%--            <label for="id">ID</label>--%>
<%--            <input type="text" class="form-control" id="id" name="id" >--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="img">Ảnh</label>
            <input type="text" class="form-control" id="img" name="img"  >
        </div>
        <div class="form-group">
            <label for="name">Tên sản phẩm</label>
            <input type="text" class="form-control" id="name" name="name" >
        </div>
        <div class="form-group">
            <label for="price">Giá</label>
            <input type="text" class="form-control" id="price" name="price" >
        </div>
        <button type="submit" class="btn btn-outline-primary">Add</button>

    </form>
</div>

</body>
</html>
