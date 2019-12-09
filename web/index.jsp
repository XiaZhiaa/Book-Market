<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019-11-13
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
  </head>
  <body>
  <center>
    <h2>欢迎来到图书管理系统</h2>
    <a href="addCategory.jsp">添加分类</a>
    <br>
    <a href="${pageContext.request.contextPath}/categoryServlet?method=findAllCategories">查询全部分类</a>
    <hr>
    <a href="addBook.jsp">添加图书</a>
    <br>
    <a href="${pageContext.request.contextPath}/bookServlet?method=findAllBooks">查询全部图书</a>
  </center>
  </body>
</html>
