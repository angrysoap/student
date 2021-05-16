<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/13
  Time: 21:50
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
修改用户<br>
<s:form action="updateUser" method="post" enctype="multipart/form-data">
    <s:textfield name="user1.username" label="用户姓名" value="%{user1.username}" readonly="true" class="form-control"/><br>
    <s:textfield name="user1.password" label="用户密码" value="%{user1.password}" class="form-control"/><br>
    <s:textfield name="user1.role" label="角色" value="%{user1.role}" readonly="true" class="form-control"/><br>
    <s:submit value="修改"/><br>
</s:form>
<span><s:property value="message"/></span><br>
<a href="listUser.jsp"><button class="btn btn-success">用户管理</button></a><br>
<a href="main.jsp"><button class="btn btn-success">返回主页</button></a><br>
</body>
</html>
