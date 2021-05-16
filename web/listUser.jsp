<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/13
  Time: 21:17
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
    <title>用户浏览和查询</title>
</head>
<body>
<br/><br/>
<div align="center">
    <table class="table table-hover text-center">
        <tr>
            <th class="text-center">用户名</th>
            <th class="text-center">用户密码</th>
            <th class="text-center">角色</th>
            <th colspan="2" class="text-center">操作</th>
        </tr>
        <s:iterator value="users">
            <tr>
                <td class="text-center"><s:property value="username"/></td>
                <td class="text-center"><s:property value="password"/></td>
                <td class="text-center"><s:property value="role"/></td>
                <td class="text-center"><s:a action="updateUser"> 更改
                    <s:param name="user1.username" value="%{username}"/>
                    <s:param name="user1.password" value="%{password}"/>
                    <s:param name="user1.role" value="%{role}"/></s:a></td>
                <td class="text-center"><s:a action="deleteUser">
                    <s:param name="user1.username" value="%{username}"/>删除</s:a></td>
            </tr>
        </s:iterator>
    </table>
    <s:form action="list1User" method="post">
        <s:textfield label="搜索条件" name="condition"/>
        <s:submit value="查询" class="btn btn-success"/>
    </s:form>
    <br/><br/>
    <s:a action="listUser">
        <button class="btn btn-success">查询全部</button>
    </s:a><br/>
    <a href="main.jsp" target="_self"><button class="btn btn-success">返回主页</button></a>
</div>
</body>
</html>
