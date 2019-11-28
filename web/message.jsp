<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019-11-13
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提示界面</title>
</head>
<body>
<center>
    <h2 style="color: red">${message}</h2>
    <hr>
    <a href="${pageContext.request.contextPath}/categoryServlet?op=findAllCategories"><h2 style="color: red">查看全部分类</h2></a>
    <hr>
    <a href="${pageContext.request.contextPath}/bookServlet?op=findAllBooks"><h2 style="color: red">查看全部图书</h2></a>
</center>
</body>
</html>
