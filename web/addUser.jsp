<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/13
  Time: 16:20
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
    <title>添加用户</title>
</head>
<body>
<br>
<div align="center">
    <s:form action="addUser" method="post">
        <s:textfield name="user1.username" label="用户名" class="form-control"/><br>
        <s:textfield name="user1.password" label="密码" class="form-control"/><br>
        <s:select name="user1.role" list="{'管理员','用户'}" label="角色" class="form-control"/><br>
        <s:submit value="提交" class="btn btn-success"/>
    </s:form>
    <span><s:property value="message"/></span>
    <a href="main.jsp" target="_self"><button class="btn btn-success">返回主页</button></a>
</div>
</body>
</html>
