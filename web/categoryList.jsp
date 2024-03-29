<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019-11-13
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分类列表</title>
</head>
<body>
<center>
    <table width="60%" border="1px">
        <tr align="center">
            <td colspan="5">
                <h2 style="color: blue">图书分类表</h2>
            </td>
        </tr>
        <tr align="center">
            <td>分类编号</td>
            <td>分类名称</td>
            <td>分类描述</td>
            <td>操作1</td>
            <td>操作2</td>
        </tr>
        <c:forEach items="${data}" var="c">
            <tr align="center">
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/categoryServlet?method=findCategoryById&id=${c.id}">修改</a>
                </td>
                <td>
                    <a href="JavaScript:deleteCategory('${c.id}')">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="5">
                <a href="addCategory.jsp"><h4 style="border: blue">添加分类</h4></a>
            </td>
        </tr>
        <tr align="center">
            <td colspan="5">
                <a href="index.jsp"><h3 style="color: red">返回主页</h3></a>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
<script>
    /**
     * 删除分类的方法
     * @param id
     */
    function deleteCategory(id) {
        var sure = window.confirm("您确定要删除吗？");
        if (sure){
            window.location.href ="${pageContext.request.contextPath}/categoryServlet?method=deleteCategory&id="+id;
        }
        //不用写else
    }

    /**
     * 修改分类的方法
     * @param id
     */
    function editCategor(id) {
        var sure = window.confirm("您确定要修改吗？");
        if (sure){
            window.location.href = "${pageContext.request.contextPath}/categoryServlet?method=findCategoryById&id="+id
        }
    }
</script>
