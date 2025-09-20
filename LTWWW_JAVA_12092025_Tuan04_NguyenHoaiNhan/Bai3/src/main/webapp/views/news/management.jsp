<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý tin tức</title>
    <style>
        table {
            border-collapse: collapse;
            width: 90%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #dcdcdc;
            padding: 10px;
            text-align: left;
        }
        th {
            background: #f2f2f2;
            white-space: nowrap;
        }
        .delete-btn {
            border-radius: 4px;
            background-color: red;
            padding: 10px 18px;
            text-align: center;
            color: white;
            border: none;
            cursor: pointer;

        }

        .delete-btn:hover {
            opacity: 0.7;
        }
    </style>
</head>
<body>
<div>
    <h1 style="text-align: center">Quản lý tin tức</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Liên kết</th>
            <th>Danh mục</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="n" items="${newsList}">
            <tr>
                <td>${n.id}</td>
                <td>${n.title}</td>
                <td>${n.content}</td>
                <td><a href="${n.link}" target="_blank">${n.link}</a></td>
                <td>${n.category.name}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/news" method="post" style="display:flex; justify-content: center;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${n.id}">
                        <button type="submit" class="delete-btn"
                                onclick="return confirm('Bạn có chắc muốn xóa tin này?')">
                            Xóa
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
