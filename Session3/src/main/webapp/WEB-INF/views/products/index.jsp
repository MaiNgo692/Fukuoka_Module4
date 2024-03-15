<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 3/13/2024
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<p><a href="/products/create">Thêm mới</a></p>
<table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Image</th>
    </tr>
    <c:forEach var="p" items="${data}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.image}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
