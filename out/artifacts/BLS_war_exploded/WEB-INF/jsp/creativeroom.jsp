<%@ page import="com.wjx.pojo.User" %>
<%@ page import="com.wjx.utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2023/2/24
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创作间</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/heard.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/creativeroom.css" type="text/css">
</head>
<body>
<%@ include file="/heard/head.html" %>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center mb-4">我的博客列表</h1>
                    <button class="btn btn-primary" id="manage-blog-btn">管理博客</button>
                    <button class="btn btn-success" id="create-blog-btn">创建新博客</button>
                </div>
                <div class="blog-list">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">博客标题</h5>
                            <p class="card-text">博客内容摘要</p>
                            <a href="#" class="btn btn-primary">查看博客</a>
                        </div>
                    </div>
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">博客标题</h5>
                            <p class="card-text">博客内容摘要</p>
                            <a href="#" class="btn btn-primary">查看博客</a>
                        </div>
                    </div>
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">博客标题</h5>
                            <p class="card-text">博客内容摘要</p>
                            <a href="#" class="btn btn-primary">查看博客</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 引入jQuery库 -->
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function(){
        // 点击创建新博客按钮
        $('#create-blog-btn').click(function(){
            window.location.href = '${pageContext.request.contextPath}/user/editblog';
        });
        // 点击管理博客按钮
        $('#manage-blog-btn').click(function(){
            window.location.href = 'manage_blog.jsp';
        });
    });
</script>

<script>
    <% User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
    String username = "null";
    if (user == null){
      username = "null";
    }else {
      username = user.getUserName();
    }
    %>
    updateLoginButton("<%=username%>")
</script>
</body>
</html>
