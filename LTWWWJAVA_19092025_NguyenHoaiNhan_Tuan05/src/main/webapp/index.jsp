<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<div>
  Hình ảnh
</div>
<div>
  <a href="${pageContext.request.contextPath}/dienThoai">Danh sách sản phẩm</a>
  <a href="${pageContext.request.contextPath}/dienThoaiForm">Thêm mới sản phẩm</a>
  <a href="${pageContext.request.contextPath}/quanLyForm">Chức năng quản lí</a>
</div>
</body>
</html>