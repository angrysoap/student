<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/13
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
<h1 align="center"><s:property value="user1.username"/>(管理员)欢迎登录图书管理系统</h1>
<br/><br/><br/><br/>
<div align="center">
    <a href="addUser.jsp" target="_self">
        <button class="btn-success">添加用户</button>
    </a>
    <a href="listUser.jsp" target="_self">
        <button class="btn-success">管理用户</button>
    </a>
    <a href="addBook.jsp" target="_self">
        <button class="btn-success">添加图书</button>
    </a>
    <a href="listBook.jsp" target="_self">
        <button class="btn-success">浏览和查询图书</button>
    </a>
    <br/><br/><br/><br/><br/>
    <a href="userLogin.jsp" target="_self"><button class="btn-success">注销用户</button></a>
</div>
</body>
</html>