<%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2023/2/25
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>博客发布成功</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
    <h1 class="text-center mb-4">博客发布成功！</h1>
    <div class="card">
        <div class="card-body">
            <p class="card-text">您的博客已成功发布。</p>
            <a href="${pageContext.request.contextPath}/" class="btn btn-primary">返回</a>
        </div>
    </div>
</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>

