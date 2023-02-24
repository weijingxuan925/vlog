<%@ page import="com.wjx.utils.Constants" %>
<%@ page import="com.wjx.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2023/2/20
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <link href="css/heard.css" rel="stylesheet" type="text/css">
  <link href="css/index.css" rel="stylesheet" type="text/css">
  <body>
  <%@ include file="heard/head.html" %>
  <div class="container">
    <h1>My Blog</h1>
    <div class="blog-list">
      <div class="blog-item">
        <img src="" alt="Blog 1">
        <div class="blog-meta">
          <div class="blog-author">John Doe</div>
          <div class="blog-date">2023-02-15</div>
        </div>
        <h2>Blog 1</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis euismod odio vel neque dapibus commodo.</p>
        <a href="#">Read more</a>
      </div>
      <div class="blog-item">
        <img src="" alt="Blog 2">
        <div class="blog-meta">
          <div class="blog-author">Jane Smith</div>
          <div class="blog-date">2023-02-10</div>
        </div>
        <h2>Blog 2</h2>
        <p>Phasellus ut nisi sed felis viverra tincidunt. Fusce vel nibh quis lorem egestas fringilla.</p>
        <a href="#">Read more</a>
      </div>
      <div class="blog-item">
        <img src="" alt="Blog 3">
        <div class="blog-meta">
          <div class="blog-author">Bob Johnson</div>
          <div class="blog-date">2023-02-05</div>
        </div>
        <h2>Blog 3</h2>
        <p>Donec vel justo vitae elit tincidunt aliquet. Sed faucibus nunc quis erat bibendum, ut feugiat velit lobortis.</p>
        <a href="#">Read more</a>
      </div>
    </div>
  </div>

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
