<%--
  Created by IntelliJ IDEA.
  User: NHAN
  Date: 9/19/2025
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Suppliers</title>
</head>
<body>
    Đây là trang nhà cung cấp
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
        <c:forEach var="nhaCungCap" items="${result}">
            <tr>
                <td><c:out value="${nhaCungCap.maNCC}"/></td>
                <td><c:out value="${nhaCungCap.tenNCC}"/></td>
                <td><c:out value="${nhaCungCap.diaChi}"/></td>
                <td><c:out value="${nhaCungCap.sdt}"/></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
