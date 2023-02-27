<%@ page import="com.wjx.pojo.User" %>
<%@ page import="com.wjx.utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2023/2/26
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${blogName}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/heard.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/showBlog.css" type="text/css">
<%--    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/bootstrap/5.1.0/css/bootstrap.min.css">--%>
    <style>
        body {
            padding-top: 0rem;
            padding-bottom: 5rem;
        }
        .card {
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
<%@ include file="/heard/head.html" %>
<div class="container">
    <h1 class="text-center mb-4">${title}</h1>
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <div class="card">
                <img src="${pageContext.request.contextPath}/images${cover}" class="card-img-top" alt="...">
                <div class="card-body">
                    <p>${content}</p>
                    <p class="card-text"><small class="text-muted">创建时间：${createTime}</small></p>
                </div>
            </div>
        </div>
    </div>
</div>

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
