<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/14
  Time: 21:18
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
<br/><br/>
    <table class="table table-hover text-center">
        <tr>
            <th class="text-center">书号</th>
            <th class="text-center">书名</th>
            <th class="text-center">作者姓名</th>
            <th class="text-center">价格</th>
            <th colspan="2" class="text-center">操作</th>
        </tr>
        <s:iterator value="books">
            <tr>
                <td class="text-center"><s:property value="isbn"/></td>
                <td class="text-center"><s:property value="title"/></td>
                <td class="text-center"><s:property value="author.name"/></td>
                <td class="text-center"><s:property value="price"/></td>
                <td class="text-center"><s:a action="read">简介
                    <s:param name="book.intro" value="%{intro}"/>
                </s:a></td>
                <td class="text-center"><s:a action="lend">借书
                    <s:param name="book.isbn" value="%{isbn}"/>
                    <s:param name="book.title" value="%{title}"/>
                    <s:param name="book.price" value="%{price}"/>
                    <s:param name="book.author.name" value="%{author.name}"/>
                </s:a></td>
            </tr>
        </s:iterator>
    </table>
    <s:form action="find1" method="post">
        <s:textfield label="搜索条件" name="condition"/>
        <s:submit value="查询" class="btn btn-success"/>
    </s:form>
    <span><s:property value="message"/></span><br>
    <s:a action="find"> <button class="btn btn-success">查询所有</button></s:a>
    <a href="main1.jsp" target="_self" class="btn btn-success">返回主页</a>
</div>
</body>
</html>
