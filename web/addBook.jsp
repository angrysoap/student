<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/11/17
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
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
<br/><br/>
<div align="center">
    <s:form action="addBook" method="post" enctype="multipart/form-data">
        <s:textfield name="book.isbn" label="书号" class="form-control"/><br>
        <s:textfield name="book.title" label="书名" class="form-control"/><br>
        <s:textfield name="book.price" label="价格" class="form-control"/><br>
        <s:file name="upload" label="简介"/>
        <s:textfield name="book.author.name" label="作者姓名" class="form-control"/>
        <s:textfield name="book.author.tell" label="作者电话" class="form-control"/>
        <s:textfield name="book.author.mail" label="作者邮箱" class="form-control"/>
        <s:submit value="提交" class="btn btn-success"/>
    </s:form>
    <span><s:property value="message"/></span>
    <a href="main.jsp" target="_self"><button class="btn btn-success">返回主页</button></a>
</div>
</body>
</html>
