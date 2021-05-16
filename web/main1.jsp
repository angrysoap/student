<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/13
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
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
<div align="center">
    <h1><s:property value="user1.username"/>(用户)欢迎登录图书管理系统。<a href="userLogin.jsp" target="_self"><button class="btn btn-success">注销账户</button></a></h1>
    <br/><br/><br/><br/>
    <a href="lendedBook.jsp">
        <button class="btn btn-success">已借图书</button>
    </a>
    <a href="lendBook.jsp">
        <button class="btn btn-success">借阅图书</button>
    </a>
</div>
</body>
</html>