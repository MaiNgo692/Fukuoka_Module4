<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 3/11/2024
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Chi tiết</title>
</head>
<body>
<h1>Chi tiết ${id}</h1>
<f:form method="post" modelAttribute="acc" action="/home/create">
    <b>Tài khoản:</b><f:input path="userName" /> <br>
    <b>Password:</b><f:input path="password" /> <br>
    <b>SĐT:</b><f:input path="phone" /> <br>
    <button>Đăng ký</button>
</f:form>
</body>
</html>
