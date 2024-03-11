<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 3/9/2024
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:if test="${action == 'create'}">
        <title>Thêm mới</title>
    </c:if>
    <c:if test="${action == 'edit'}">
        <title>Sửa thông tin </title>
    </c:if>

</head>
<body>
<c:if test="${action == 'create'}">
    <h1>Thêm mới sản phẩm</h1>
</c:if>
<c:if test="${action == 'edit'}">
    <h1>Sửa sản phẩm</h1>
</c:if>
<form action="/products" method="post">
    <c:if test="${action == 'create'}">
        <input type="hidden" name="action" value="postCreate">
    </c:if>
    <c:if test="${action == 'edit'}">
        <input type="hidden" name="action" value="postEdit">
    </c:if>
    <table border="0">
        <tr>
            <th>Mã sản phẩm</th>
            <td><input type="text" name="id" value="${product.getProductId()}"></td>
        </tr>
        <tr>
            <th>Tên sản phẩm</th>
            <td><input type="text" name="name" value="${product.getProductName()}"></td>
        </tr>
        <tr>
            <th>Nhà sản xuất</th>
            <td><input type="text" name="manufacturer" value="${product.getManufacturer()}"></td>
        </tr>
        <tr>
            <th>Số lô</th>
            <td><input type="text" name="batch" value="${product.getBatch()}"></td>
        </tr>
        <tr>
            <th>Số lượng</th>
            <td><input type="number" min="1" name="quantity" value="${product.getQuantity()}"></td>
        </tr>
        <tr>
            <th>Trạng thái</th>
            <td>
                <label for="sttTrue">
                    <input type="radio" id="sttTrue" name="status" value="true" <c:if test="${product.isProductStatus()==true}">checked </c:if>> Hoạt động
                </label> <br>
                <label for="sttFalse">
                    <input type="radio" id="sttFalse" name="status" value="false"<c:if test="${product.isProductStatus()==false}">checked </c:if>> Không hoạt động
                </label> <br>
            </td>
        </tr>
        <tr>
            <th>Ngày tạo</th>
            <td>
                <input type="date" id="created" name="created" value="${product.getCreated()}" >
            </td>
        </tr>
        <tr>
            <th>&nbsp;</th>
            <td>
                <c:if test="${action == 'create'}">
                    <button>Thêm mới</button>
                    <a href="/products?action=index">Trở lại</a>
                </c:if>
                <c:if test="${action=='edit'}">
                    <button>Sửa</button> |
                    <a href="/products?action=index">Trở lại</a>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
