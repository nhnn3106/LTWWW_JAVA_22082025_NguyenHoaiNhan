<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html >
<head>
    <title>JSP - Hello World</title>
</head>
<style>
    .header {
        display: flex;
        justify-content: start;
        width: 100%;
        background-color: #e0f6fd;
    }

    .panner {
        padding-left: 200px;
        height: 150px;
    }

    .nav {
        display: flex;
        justify-content: center;
        gap: 50px;
        list-style: none;
        background-color: #21cef6;
        color: white;
        margin: 0;
    }

    .nav .link {
        display: block;
        padding: 12px 14px;
        text-decoration: none;
        font-size: 20px;
        font-weight: 700;
        color: white;
    }

    .nav .link:hover {
        opacity: 0.7;
    }
</style>
<body style="padding: 0; margin: 0">
<header class="header">
    <img class="panner" src="images/pannerNews.png" alt="panner">
</header>
<div style="width: 100% ; height: 1000px">
    <ul class="nav">
        <li class="item">
            <a class="link" href="news?action=list">Danh sách tin tức</a>
        </li>
        <li class="item">
            <a class="link" href="news?action=add"> Thêm tin tức</a>
        </li>
        <li class="item">
            <a class="link" href="news?action=management">Quản lý tin tức</a>
        </li>
    </ul>
    <c:if test="${not empty page}">
        <jsp:include page="${page}" />
    </c:if>

</div>



<div>

</div>
</body>
</html>