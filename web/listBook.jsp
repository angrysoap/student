<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/main.css" rel="stylesheet">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图书浏览和查询</title>
</head>
<body class="find">
<br/><br/><br/>
<table class="table table-hover text-center">
    <tr>
        <th class="text-center">书号</th>
        <th class="text-center">书名</th>
        <th class="text-center">作者</th>
        <th class="text-center">价格</th>
        <th class="text-center">作者电话</th>
        <th class="text-center">作者邮箱</th>
        <th colspan="3" class="text-center">操作</th>
    </tr>
    <s:iterator value="books">
        <tr>
            <td class="text-center"><s:property value="isbn"/></td>
            <td class="text-center"><s:property value="title"/></td>
            <td class="text-center"><s:property value="author.name"/></td>
            <td class="text-center"><s:property value="price"/></td>
            <td class="text-center"><s:property value="author.tell"/></td>
            <td class="text-center"><s:property value="author.mail"/></td>
            <td class="text-center"><s:a action="readBook">intro
                <s:param name="book.intro" value="%{intro}"/>
            </s:a></td>
            <td class="text-center"><s:a action="updateBook"> update
                <s:param name="book.isbn" value="%{isbn}"/>
                <s:param name="book.title" value="%{title}"/>
                <s:param name="book.author.name" value="%{author.name}"/>
                <s:param name="book.price" value="%{price}"/>
                <s:param name="book.intro" value="%{intro}"/>
                <s:param name="book.author.tell" value="%{author.tell}"/>
                <s:param name="book.author.mail" value="%{author.mail}"/></s:a></td>
            <td><s:a action="deleteBook">
                <s:param name="book.isbn" value="isbn"/>delete</s:a></td>
        </tr>
    </s:iterator>
</table>
<div align="center">
    <s:form action="listBook" method="post">
        <s:textfield type="text" label="搜索条件" name="condition" class="form-control"/>
        <s:submit value="查询" class="btn btn-success"/>
    </s:form>
    <br/><br/>
</div>
<div align="center">
    <s:a action="listBook1">
        <button class="btn btn-success">查询所有</button>
    </s:a>
    <a href="main.jsp" target="_self" class="btn btn-success">返回主页</a>
</div>
</body>
</html>
