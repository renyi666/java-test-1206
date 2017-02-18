<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/16
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="/user/registercheck">

        <td>
            <input type="text" name="name">
        </td>

        <td>
            <input type="text" name="password">

        </td>
        <td>
            <input type="text" name="mobile">
        </td>
        <td>
            <input type="text" name="email">
        </td>
        <td>
            <input type="text" name="address">
        </td>
        <td>
            <input type="submit" name="submit" value="submit">
        </td>
    </form>


</table>
</body>
</html>
