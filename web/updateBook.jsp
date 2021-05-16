<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/11/18
  Time: 16:00
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
    <title>修改图书</title>
</head>
<body>
    修改书籍<br>
    <s:form action="updateBook" method="post" enctype="multipart/form-data">
        <s:textfield name="book.isbn" label="书号" value="%{book.isbn}" readonly="true" class="form-control"/><br>
        <s:textfield name="book.title" label="书名" value="%{book.title}" class="form-control"/><br>
        <s:textfield name="book.price" label="价格" value="%{book.price}" class="form-control"/><br>
        <s:file name="upload" label="简介" value="%{book.intro}"/><br>
        <s:textfield name="book.author.name" label="作者名" value="%{book.author.name}" class="form-control"/><br>
        <s:textfield name="book.author.tell" label="作者电话" value="%{book.author.tell}" class="form-control"/><br>
        <s:textfield name="book.author.mail" label="作者邮箱" value="%{book.author.mail}" class="form-control"/><br>
        <s:submit value="修改"/><br>
    </s:form>
        <span><s:property value="message"/></span><br>
        <a href="listBook.jsp" target="_self"><button class="btn btn-success">浏览查询</button></a>
        <a href="main.jsp" target="_self"><button class="btn btn-success">返回主页</button></a>
</body>
</html>
