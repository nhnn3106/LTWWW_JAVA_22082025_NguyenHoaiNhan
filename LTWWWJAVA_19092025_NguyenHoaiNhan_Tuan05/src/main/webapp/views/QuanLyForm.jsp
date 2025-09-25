<%--
  Created by IntelliJ IDEA.
  User: NHAN
  Date: 9/25/2025
  Time: 9:45 PM
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản Lý Điện Thoại</title>
    <style>
        .error { color: red; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .delete-btn { background-color: #ff4444; color: white; border: none; padding: 5px 10px; cursor: pointer; }
        .delete-btn:hover { background-color: #cc0000; }
    </style>
</head>
<body>
<h1>Quản Lý Điện Thoại</h1>

<c:if test="${not empty error}">
    <div class="error">
        <c:out value="${error}"/>
    </div>
</c:if>

<h2>Danh Sách Điện Thoại</h2>
<table>
    <thead>
    <tr>
        <th>Mã Điện Thoại</th>
        <th>Tên Điện Thoại</th>
        <th>Năm Sản Xuất</th>
        <th>Cấu Hình</th>
        <th>Hình Ảnh</th>
        <th>Mã Nhà Cung Cấp</th>
        <th>Thao Tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dt" items="${dienThoais}">
        <tr>
            <td><c:out value="${dt.getMaDT()}"/></td>
            <td><c:out value="${dt.getTenDT()}"/></td>
            <td><c:out value="${dt.getNamSanXuat()}"/></td>
            <td><c:out value="${dt.getCauHinh()}"/></td>
            <td>
                <img src="${pageContext.request.contextPath}/images/${dt.getHinhAnh()}" width="50" alt="Hình ảnh"/>
            </td>
            <td><c:out value="${dt.getNhaCungCap().getMaNCC()}"/></td>
            <td>
                <form action="${pageContext.request.contextPath}/quanLyForm" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa điện thoại này?');">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="maDT" value="${dt.getMaDT()}"/>
                    <button type="submit" class="delete-btn">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty dienThoais}">
        <tr>
            <td colspan="7">Không có điện thoại nào trong danh sách.</td>
        </tr>
    </c:if>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/dienThoai">Quay lại danh sách</a>
<a href="${pageContext.request.contextPath}/dienThoaiForm">Thêm điện thoại mới</a>
</body>
</html>