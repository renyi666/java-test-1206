<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/10
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--<%@ page isELIgnored="false" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${result1}" var="_article">

    ${_article.name}


</c:forEach>
</body>
</html>
