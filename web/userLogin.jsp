<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/13
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="model.User" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/main.css" rel="stylesheet">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录界面</title>

</head>
<body>
<div align="center">
    <h1>图书管理系统</h1>
    <s:form action="user" method="post" >
        <s:textfield name="user1.username" size="20" label="姓名" class="form-control"/><br>
        <s:password name="user1.password" size="20" label="密码" class="form-control"/><br>
        <s:submit  value="登录" class="btn btn-success"/>
    </s:form>
</div>
</body>
</html>
