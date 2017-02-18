<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/16
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${user.nickname}
<table>

    <c:forEach items="${list}" var="_list">

        <td>
                ${_list.title}
        </td>
        <td>
                ${_list.content}
        </td>


    </c:forEach>
</table>
</body>
</html>
