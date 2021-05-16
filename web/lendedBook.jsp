<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/14
  Time: 17:29
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
<div align="center">
    <h1><s:property value="user1.username"/>(用户)已借阅的图书</h1>
<table class="table table-hover text-center">
    <tr>
        <th class="text-center">书号</th>
        <th class="text-center">书名</th>
        <th class="text-center">作者姓名</th>
        <th class="text-center">价格</th>
        <th class="text-center">操作</th>
    </tr>
    <s:iterator value="lends">
        <tr>
            <td class="text-center"><s:property value="isbn"/></td>
            <td class="text-center"><s:property value="title"/></td>
            <td class="text-center"><s:property value="price"/></td>
            <td class="text-center"><s:property value="name"/></td>
            <td class="text-center"><s:a action="returnBook">
                <s:param name="lend.isbn" value="isbn"/>
                <s:param name="lend.title" value="title"/>还书</s:a></td>
        </tr>
    </s:iterator>
</table>
<span><s:property value="message"/></span><br>
<s:a action="show"><button class="btn btn-success">显示所有</button></s:a>
<a href="main1.jsp" target="_self"><button class="btn btn-success">返回主页</button></a>
</div>
</body>
</html>
