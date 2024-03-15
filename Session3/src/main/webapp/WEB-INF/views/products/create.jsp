<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 3/13/2024
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
</head>
<body>
<h1>Thông tin sản phẩm</h1>
<f:form  method="post" modelAttribute="product" enctype="multipart/form-data">
    <table>
        <tr>
            <th>Mã sp</th>
            <td><f:input path="id" /></td>
        </tr>
        <tr>
            <th>Tên sp</th>
            <td><f:input path="name" /></td>
        </tr>
        <tr>
            <th>Giá sp</th>
            <td><f:input path="price" /></td>
        </tr>
        <tr>
            <th>Ảnh sp</th>
            <td><f:input type="file" path="image" /></td>
        </tr>
        <tr>
            <th>Ngày tạo:</th>
            <td><f:input type="date" path="created" /></td>
        </tr>
        <tr>
            <th>Trạng thái sp</th>
            <td><f:input path="status" /></td>
        </tr>
    </table>
<button>Lưu</button>
</f:form>
</body>
</html>
