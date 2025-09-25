<%--
  Created by IntelliJ IDEA.
  User: NHAN
  Date: 9/25/2025
  Time: 9:30 PM
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Điện Thoại</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
<h1>Thêm Điện Thoại Mới</h1>

<c:if test="${not empty errors}">
    <div class="error">
        <c:out value="${errors}" escapeXml="false"/>
    </div>
</c:if>

<form action="${pageContext.request.contextPath}/dienThoaiForm" method="post" enctype="multipart/form-data">
    <table>
        <thead>
        <tr>
            <th colspan="2">Nhập thông tin điện thoại</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Tên điện thoại:</td>
            <td><input type="text" name="ten" value="${ten != null ? ten : ''}" required/></td>
        </tr>
        <tr>
            <td>Năm sản xuất:</td>
            <td><input type="text" name="nam-sx" value="${namSx != null ? namSx : ''}" required pattern="\d{4}"/></td>
        </tr>
        <tr>
            <td>Cấu hình:</td>
            <td><input type="text" name="cau-hinh" value="${cauHinh != null ? cauHinh : ''}" required maxlength="255"/></td>
        </tr>
        <tr>
            <td>Hình ảnh:</td>
            <td><input type="file" name="hinh-anh" accept=".png,.jpg,.jpeg" required/></td>
        </tr>
        <tr>
            <td>Nhà cung cấp:</td>
            <td>
                <select name="mancc" required>
                    <option value="">-- Chọn nhà cung cấp --</option>
                    <c:forEach var="ncc" items="${nhaCungCaps}">
                        <option value="${ncc.getMaNCC()}" <c:if test="${maNcc == ncc.getMaNCC()}">selected</c:if>>
                            <c:out value="${ncc.getTenNhaCC()}"/>
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        </tbody>
    </table>
    <button type="submit">Thêm</button>
    <a href="${pageContext.request.contextPath}/dienThoai">Quay lại</a>
</form>
</body>
</html>