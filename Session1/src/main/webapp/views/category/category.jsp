<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 3/8/2024
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
<button type="button" id="addButton">Thêm mới Category</button>
<form id="addCategory" action="/category" method="post" style="display: none">
    <h2>Tên Category: <input type="text" name="categoryName" ></h2>
    <h2>Mô tả:<input type="text" name="description"> </h2>
    <button>Add</button>
</form>
<form action="/category">
    <h2>Search: <input type="text" name="key" placeholder="Tìm theo tên"></h2>
    <button type="submit">Search</button>
</form>

<c:if test="${findCategory!= null}"><span>Tên Categoty : ${findCategory.categoryNam}</span>
    <span>Mô tả : ${findCategory.description}</span></c:if>
<h1>Danh sách Category:</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Tên Category</th>
        <th>Mô tả</th>
        <th>Trạng thái</th>
    </tr>
    <c:forEach items="${lstCategory}" var="category">
        <tr>
            <th>${category.id}</th>
            <th>${category.categoryNam}</th>
            <th>${category.description}</th>
            <th>${category.status}</th>
        </tr>
    </c:forEach>
</table>
<script>
    document.getElementById("addButton").onclick = function () {
        document.getElementById("addCategory").style.display = 'block';
    };

</script>
</body>
</html>
