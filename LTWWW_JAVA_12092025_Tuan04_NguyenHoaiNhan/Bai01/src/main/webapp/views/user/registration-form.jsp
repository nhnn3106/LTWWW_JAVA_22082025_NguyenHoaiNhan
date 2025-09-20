<%--
  Created by IntelliJ IDEA.
  User: NHAN
  Date: 9/17/2025
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>
<body>
<div class="form-submit">
    <h1>User Registration Form</h1>
    <form action="${pageContext.request.contextPath}/users?action=insert" method="post">
        <c:if test="${errors != null}">
            <p style="text-align: left; color: red;">
                <c:out value="${errors}" escapeXml="false"></c:out>
            </p>
        </c:if>
        <div>
            <input type="text" name="firstName" placeholder="First Name"/>
            <input type="text" name="lastName" placeholder="Last Name"/>
        </div>
        <div>
            <input type="text" name="email" placeholder="Your Email"/>
        </div>
        <div>
            <input type="text" name="re-enter-email" placeholder="Re-enter Email"/>
        </div>
        <div>
            <input type="text" name="password" placeholder="New Password"/>
        </div>
        <div>
            <label>Birthday</label><br>
            <select name="month">
                <option value="">Month</option>
                <% for(int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <%}%>
            </select>
            <select name="day">
                <option value="">Day</option>
                <% for(int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <%}%>
            </select>
            <select name="year">
                <option value="">Year</option>
                <% for(int i = 1583; i <= 2025; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <%}%>
            </select>
        </div>
        <div>
            <label><input type="radio" name="gender" value="male"/>Male</label>
            <label><input type="radio" name="gender" value="female"/>Female</label>
        </div>
        <div><input type="submit" value="Sign Up"/></div>
    </form>
</div>
</body>
</html>