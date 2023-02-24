<%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2023/2/24
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑新博客</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/heard.css" type="text/css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.css" />
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/lang/zh-CN.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.js"></script>
    <script>
        KindEditor.ready(function(K) {
            var editor1 = K.create('textarea[name="content1"]', {
                cssPath : '${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.css',
                uploadJson : '${pageContext.request.contextPath}/kindeditor/jsp/upload_json.jsp',
                fileManagerJson : '${pageContext.request.contextPath}/kindeditor/jsp/file_manager_json.jsp',
                allowFileManager : true,
                afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                }
            });
            prettyPrint();
        });
    </script>
</head>
<body>
<script type="text/javascript" charset="UTF-8" src="/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript" charset="UTF-8" src="/kindeditor/lang/zh-CN.js"></script>
<%@ include file="/heard/head.html" %>
<div class="container">
    <h1 class="text-center mb-4">编辑新博客</h1>
    <form action="addBlog.do" method="post">
        <div class="form-group">
            <label for="title">博客标题：</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label>博客内容：</label>
            <textarea name="content1" cols="100" rows="8" style="width:1400px;height:500px;visibility:hidden;"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">发布博客</button>
    </form>
</div>
</body>
</html>

