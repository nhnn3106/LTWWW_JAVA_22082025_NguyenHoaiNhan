<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NHAN
  Date: 9/19/2025
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobiles</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/mobiles?action=search" method="post">
        <label>Nhập tên nhà cung cấp</label>
        <input name="name"/>
        <button type="submit">Tìm</button>
    </form>
    <div><c:out value="${result}"/></div>
    <table>
        <thead>
            <tr>
                <th>Mã điện thoại</th>
                <th>Tên</th>
                <th>Cấu hình</th>
                <th>Năm sản xuất</th>
                <th>Tên nhà cung cấp</th>
                <th>Hình ảnh</th>
            </tr>
        </thead>
        <tbody>
        <c:if test="${dienThoais != null && !dienThoais.isEmpty()}">
            <c:forEach var="dienThoai" items="${dienThoais}">
                <%--                    <tr><c:out value="${dienThoai}"/></tr>--%>
                <tr>
                    <td><c:out value="${dienThoai.maDT}"/></td>
                    <td><c:out value="${dienThoai.tenDT}"/></td>
                    <td><c:out value="${dienThoai.cauHinh}"/></td>
                    <td><c:out value="${dienThoai.namSX}"/></td>
                    <td><c:out value="${dienThoai.nhaCungCap.tenNCC}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty dienThoai.hinhAnh}">
                                <img src="${pageContext.request.contextPath}/images/${dienThoai.hinhAnh}" alt="${dienThoai.tenDT}"/>
                            </c:when>
                            <c:otherwise>
                                <span>Không có hình ảnh</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </c:if>



        </tbody>
    </table>
</body>
</html>
