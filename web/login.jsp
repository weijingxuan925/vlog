<%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2023/2/20
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入</title>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link href="css/heard.css" rel="stylesheet" type="text/css">
    <link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<header id="header"></header>
<script>
    // 使用 XMLHttpRequest 对象获取 header.html 文件内容
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'heard/head.html', true);
    xhr.onload = function() {
        if (xhr.status === 200) {
            // 将导航栏 HTML 代码插入到页面中的 header 元素中
            document.getElementById('header').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
</script>
<div class="login-page">
    <div class="login-form">
        <h1>Login</h1>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Login</button>
        </form>
    </div>
</div>
</body>
</html>
