<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/15
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="/user/logincheck" method="post">
<td>
    <input type="text" name="name" value="">
</td>
    <td>
        <input type="text" name="password" value="">

    </td>
        <td>

            <input type="submit" name="submit" value="登录">
            <a href="../index.jsp"><input type="button" name="submit" value="取消"/></a>

        </td>
    </form>
</table>
</body>
</html>
