<%@ page import="com.wjx.utils.Constants" %>
<%@ page import="com.wjx.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wjx.pojo.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <link href="css/heard.css" rel="stylesheet" type="text/css">
  <link href="css/index.css" rel="stylesheet" type="text/css">
  <body>
  <%@ include file="heard/head.html" %>
  <c:forEach items="${PostList}" var="post">
    <div class="container">
      <div class="blog-list">
        <div class="blog-item">
          <img src="${pageContext.request.contextPath}/images${post.postThumbnail}" alt="Blog 1">
          <div class="blog-meta">
            <div class="blog-author">作者编号：${post.articleOwner}</div>
            <div class="blog-date">${post.createTime}</div>
          </div>
          <h2>${post.postTitle}</h2>
          <p>${post.postSummary}</p>
          <a href="${pageContext.request.contextPath}/blog?blogid=${post.id}">Read more</a>
        </div>
      </div>
    </div>
  </c:forEach>

  <footer>
    <p>Copyright © My Blog</p>
  </footer>
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
  <!--判断是否登入失败-->
  <script>
    <% String loginfailed = request.getParameter("loginfailed"); %>
    <%
    if (loginfailed != null){
    %>
    alert("登入失败")
    <%}%>
  </script>
  </body>
</html>
