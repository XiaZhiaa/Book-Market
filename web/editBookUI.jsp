<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019-11-16
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改图书</title>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/bookServlet?op=updateBook&id=${book.id}" method="post">
        <table border="1px" width="600px">
            <tr align="center">
                <td colspan="2"><h3 style="color: red">修改图书</h3></td>
            </tr>
            <tr align="center">
                <td >图书名称：</td>
                <td>
                    <input type="text" name="bookName" value="${book.bookName}">
                </td>
            </tr>
            <tr align="center">
                <td >图书描述：</td>
                <td >
                    <input type="text" name="bookDescription" value="${book.bookDescription}">
                </td>
            </tr>
            <tr align="center">
                <td >价格：</td>
                <td >
                    <input type="text" name="bookPrice" value="${book.bookPrice}">
                </td>
            </tr>
            <tr align="center">
                <td >出版社：</td>
                <td >
                    <input type="text" name="publish" value="${book.publish}">
                </td>
            </tr>
            <tr align="center">
                <td >作者：</td>
                <td >
                    <input type="text" name="author" value="${book.author}">
                </td>
            </tr>
            <tr align="center">
                <td >图片</td>
                <td >
                    <input type="text" name="path" value="##">
                </td>
            </tr>
            <tr align="center">
                <td >分类</td>
                <td >
                    <input type="text" name="categoryId" value="####">
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="修改图书">
                </td>
            </tr>
        </table>
    </form>
    <a href=${pageContext.request.contextPath}/bookServlet?op=findAllBooks>返回</a>
</center>
</body>
</html>
