<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<style>
    .container {
        margin-top: 40px;
        display: flex;
        justify-content: center;
        width: 100%;
    }

    .input {
        padding-left: 10px;
        height: 40px;
        border-radius: 6px;
    }

    .input-content {
        height: 50px;
        padding: 10px;
        border-radius: 6px;
    }

    .form {
        display: flex;
        flex-direction: column;
        gap: 14px;
        border-radius: 10px;
        width: 50%;
        padding: 20px;
        border: 2px solid #dcdcdc;
        box-shadow: 1px 2px 4px #dcdcdc;
    }

    .input-row {
        display: flex;
        flex-direction: column;
        gap: 10px;
    }

</style>
<body>
<div class="container">
    <form class="form" method="post" action="news">
        <h1>Thêm tin tức mới</h1>
        <div class="input-row">
            <label>Loại tin tức: </label>
           <select name="category" class="input">
               <c:forEach var="category" items="${categories}">
                   <option value="${category.id}">${category.name}</option>
               </c:forEach>
           </select>
        </div>
        <div class="input-row">
            <label>Tiêu đề: </label>
            <input class="input" type="text" name="title" placeholder="Nhập tiêu đề tin tức" value="${param.title}">
            <span class="regex" style="color: red">${errors.title}</span>
        </div>

        <div class="input-row">
            <label>Nội dung: </label>
            <textarea class="input-content" name="content" placeholder="Nhập nội dung">${param.content}</textarea>
            <span class="regex" style="color: red">${errors.content}</span>
        </div>

        <div class="input-row">
            <label>Liên kết: </label>
            <input class="input" type="url" name="link" placeholder="Nhập liên kết của tin tức" value="${param.link}">
            <span class="regex" style="color: red">${errors.link}</span>
        </div>

        <button type="submit"
                name="action" value="add"
                style="height: 40px; font-size: 18px; background-color: #21cef6; color: white; border: 0; cursor: pointer">
            Thêm Mới
        </button>
    </form>

</div>

</body>
</html>