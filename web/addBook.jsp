<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019-11-16
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/bookServlet?method=addBook" method="post" enctype="multipart/form-data">
        <table border="1px" width="600px">
            <tr align="center">
                <td colspan="2"><h3 style="color: red">添加图书</h3></td>
            </tr>
            <tr align="center">
                <td >图书名称：</td>
                <td>
                    <input type="text" name="bookName">
                </td>
            </tr>
            <tr align="center">
                <td >图书描述：</td>
                <td >
                    <input type="text" name="bookDescription">
                </td>
            </tr>
            <tr align="center">
                <td >价格：</td>
                <td >
                    <input type="text" name="bookPrice">
                </td>
            </tr>
            <tr align="center">
                <td >出版社：</td>
                <td >
                    <input type="text" name="publish">
                </td>
            </tr>
            <tr align="center">
                <td >作者：</td>
                <td >
                    <input type="text" name="author">
                </td>
            </tr>
            <tr align="center">
                <td >路径：</td>
                <td >
                    <input type="file" name="path">
                </td>
            </tr>
            <tr align="center">
                <td >名称：</td>
                <td >
                    <input type="text" name="photoName">
                </td>
            </tr>
            <tr align="center">
                <td>分类：</td>
                <td>
                    <input type="text" name="categoryId">
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="添加图书">
                </td>
            </tr>
        </table>
    </form>
    <a href="index.jsp">返回</a>
</center>
</body>
</html>
