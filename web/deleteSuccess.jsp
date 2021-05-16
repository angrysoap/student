<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/11/18
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/main.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:set var="user" value="#session['user1']"/>
<s:property value="#user.name"/>,你成功删除了书籍。<br>
书号:<s:property value="book.isbn"/><br>
<a href="main.jsp" target="_self"><button class="btn btn-success">返回主页</button></a><br>
</body>
</html>
