<%--
  Created by IntelliJ IDEA.
  User: NHAN
  Date: 9/25/2025
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Điện Thoại và Nhà Cung Cấp</title>
</head>
<body>
<%-- Debugging output, can be removed in production --%>
<%--<c:out value="${nhaCungCaps.toString()}"/>--%>
<%--<c:out value="${dienThoais.toString()}"/>--%>

<form action="${pageContext.request.contextPath}/dienThoai?action=search" method="post">
    <table>
        <thead>
        <tr>
            <th colspan="2">Tìm kiếm sản phẩm theo nhà cung cấp</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Chọn từ khóa</td>
            <td>
                <select name="keyword">
                    <option value="ma" <c:if test="${keyword == 'ma'}">selected</c:if>>Mã</option>
                    <option value="ten" <c:if test="${keyword == 'ten'}">selected</c:if>>Tên</option>
                    <option value="dia-chi" <c:if test="${keyword == 'dia-chi'}">selected</c:if>>Địa chỉ</option>
                    <option value="sdt" <c:if test="${keyword == 'sdt'}">selected</c:if>>Số điện thoại</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Nội dung</td>
            <td><input name="value" value="${value != null ? value : ''}"/></td>
        </tr>
        </tbody>
    </table>
    <button type="submit">Tìm kiếm</button>
</form>

<h1>Nhà cung cấp</h1>
<table>
    <thead>
    <tr>
        <th>Mã nhà cung cấp</th>
        <th>Tên nhà cung cấp</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ncc" items="${nhaCungCaps}">
        <tr>
            <td><c:out value="${ncc.getMaNCC()}"/></td>
            <td><c:out value="${ncc.getTenNhaCC()}"/></td>
            <td><c:out value="${ncc.getDiaChi()}"/></td>
            <td><c:out value="${ncc.getSoDienThoai()}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h1>Danh sách sản phẩm theo nhà cung cấp</h1>
<table>
    <thead>
    <tr>
        <th>Mã nhà cung cấp</th>
        <th>Mã điện thoại</th>
        <th>Tên điện thoại</th>
        <th>Năm sản xuất</th>
        <th>Cấu hình</th>
        <th>Hình ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dt" items="${dienThoais}">
        <tr>
            <td><c:out value="${dt.getNhaCungCap().getMaNCC()}"/></td>
            <td><c:out value="${dt.getMaDT()}"/></td>
            <td><c:out value="${dt.getTenDT()}"/></td>
            <td><c:out value="${dt.getNamSanXuat()}"/></td>
            <td><c:out value="${dt.getCauHinh()}"/></td>
            <td><img src="${pageContext.request.contextPath}/images/${dt.getHinhAnh()}" width="50"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>