<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 3/15/2024
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thông tin sản phẩm</h1>
<f:form action="/products/edit" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <th>Ảnh sp</th>
            <td><input name="image" type="file" /></td>
        </tr>
    </table>
    <button>Upload</button>
</f:form>
</body>
</html>
