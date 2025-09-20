<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Danh sách tin tức</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f7fa;
            margin: 0;
            padding: 20px;
        }

        .news-container {
            padding: 24px;
            display: flex;
            flex-direction: column;
            gap: 20px;
            max-width: 900px;
            margin: 0 auto;
        }

        .news-card {
            background: #ffffff;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
            cursor: pointer;
        }

        .news-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 6px 18px rgba(0,0,0,0.15);
        }

        .news-card h5 {
            margin: 0 0 10px;
            font-size: 22px;
            color: #333;
        }

        .news-card p {
            font-size: 16px;
            color: #555;
            line-height: 1.5;
        }

        .news-meta {
            margin-top: 12px;
            display: flex;
            gap: 20px;
            font-size: 14px;
            color: #888;
        }

        .news-link a {
            color: #007BFF;
            text-decoration: none;
        }

        .news-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="news-container">
    <c:forEach var="news" items="${newsList}">
        <div class="news-card">
            <h5>${news.title}</h5>
            <p>${news.content}</p>
            <div class="news-meta">
                <span>Loại: ${news.category.name}</span>
                <span class="news-link">
                    <a href="${news.link}" target="_blank">Xem chi tiết</a>
                </span>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
