<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 3/15/2024
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h1>Đăng ký</h1>
<p style="color: red">${msg}</p>
<f:form method="post" modelAttribute="acc" >
    <table>
        <tr>
            <th>Tài khoản:</th>
            <td><f:input path="user" /></td>
        </tr>
        <tr>
            <th>Số điện thoại:</th>
            <td><f:input path="phone" /></td>
        </tr>
        <tr>
            <th>Ngày sinh: </th>
            <td><f:input type="date" path="birthday" /></td>
        </tr>
        <tr>
            <th>Mật khẩu: </th>
            <td><f:input type="password" path="password" /></td>
        </tr>
        <tr>
            <th>Nhập lại Mật khẩu: </th>
            <td><input type="password" name="repass" /></td>
        </tr>
    </table>
    <button>Đăng ký</button>
</f:form>
</body>
</html>
