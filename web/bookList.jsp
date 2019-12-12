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

    <table width="70%" border="1px" style="margin:50px auto; border: red" cellpadding="0" cellspacing="0" >
        <tr align="center">
            <td colspan="11">
                <h2 style="color: blue">图书列表</h2>
            </td>
        </tr>
        <tr align="center">
            <th>
                <input type="checkbox">
            </th>
            <th>图书编号</th>
            <th>图书名称</th>
            <th>图书描述</th>
            <th>图书价格</th>
            <th>图书厂家</th>
            <th>图书作者</th>
            <th>图书分类</th>
            <th>图片</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${page.records}" var="p">
            <tr align="center">
                <td>
                    <input type="checkbox">
                </td>
                <td>${p.id}</td>
                <td>${p.bookName}</td>
                <td>${p.bookDescription}</td>
                <td>${p.bookPrice}</td>
                <td>${p.publish}</td>
                <td>${p.author}</td>
                <td>####</td>
                <td>
                    <img src="${p.path}${p.photoName}">
                </td>
                <td><a href="${pageContext.request.contextPath}/bookServlet?method=findBookById&id=${p.id}">修改</a></td>
                <td><a href="JavaScript:deleteBook('${p.id}')">删除</a></td>
            </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="11">
                <a href="${pageContext.request.contextPath}/bookServlet?method=findAllBooks&pageNum=1">首页</a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/bookServlet?method=findAllBooks&pageNum=${page.prePageNum}">上一页</a> &nbsp;&nbsp;
                第${page.currentPage}页&nbsp;&nbsp;
                共${page.totalPage}页&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/bookServlet?method=findAllBooks&pageNum=${page.nextPageNum}">下一页</a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/bookServlet?method=findAllBooks&pageNum=${page.totalPage}">尾页</a>&nbsp;&nbsp;
            </td>
        </tr>
        <tr align="center">
            <td colspan="11">
                <a href="addBook.jsp"><h3 style="color: red;">添加图书</h3></a>
            </td>
        </tr>
        <tr align="center">
            <td colspan="11">
                <a href="index.jsp"><h3 style="color: red">返回主页</h3></a>
            </td>
        </tr>
    </table>

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
