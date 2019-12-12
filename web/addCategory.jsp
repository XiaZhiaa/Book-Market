<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019-11-13
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加分类</title>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/categoryServlet?method=addCategory" method="post">
        <table border="1px" width="600px">
            <tr align="center">
                <td colspan="2"><h3 style="color: red">添加分类</h3></td>
            </tr>
            <tr align="center">
                <td >分类名称：</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr align="center">
                <td >分类描述：</td>
                <td >
                    <input type="text" name="description">
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="添加分类">
                </td>
            </tr>
        </table>
    </form>
    <a href="index.jsp">返回</a>
</center>
</body>
</html>
