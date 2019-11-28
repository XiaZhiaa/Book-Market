<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019-11-16
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
<center>
    <table width="70%" border="1px" style="border: red">
        <tr align="center">
            <td colspan="10">
                <h2 style="color: blue">图书列表</h2>
            </td>
        </tr>
        <tr align="center">
            <th>图书编号</th>
            <th>图书名称</th>
            <th>图书描述</th>
            <th>价格</th>
            <th>出版社</th>
            <th>作者</th>
            <th>路径</th>
            <th>名称</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${list}" var="bl">
            <tr align="center">
                <td>${bl.id}</td>
                <td>${bl.bookName}</td>
                <td>${bl.bookDescription}</td>
                <td>${bl.bookPrice}</td>
                <td>${bl.publish}</td>
                <td>${bl.author}</td>
                <td>${bl.path}</td>
                <td>${bl.photoName}</td>
                <td><a href="${pageContext.request.contextPath}/bookServlet?op=updateBookUI&id=${bl.id}">修改</a></td>
                <td><a href="JavaScript:deleteBook('${bl.id}')">删除</a></td>
            </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="10">
                <a href="addBook.jsp"><h3 style="color: red;">添加图书</h3></a>
            </td>
        </tr>
        <tr align="center">
            <td colspan="10">
                <a href="index.jsp"><h3 style="color: red">返回主页</h3></a>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
<script>
    function deleteBook(id) {
        var sure = window.confirm("您确定要删除吗？");
        if (sure){
            window.location.href ="${pageContext.request.contextPath}/bookServlet?op=deleteBook&id="+id;
        }else{
            alert("尚未删除");
        }
    }
</script>
