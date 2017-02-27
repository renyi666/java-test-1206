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
    <title>注册页面</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../css/cover.css" rel="stylesheet">

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

<div class="container">

    <form class="form-signin" action="/user/registercheck" method="post">
        <h2 class="form-signin-heading">Please Register</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="Email address" name="name" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password"  name="password" required>
        <label for="confirmPassword" class="sr-only">Password</label>
        <input type="password" id="confirmPassword" class="form-control" placeholder="Password"  name="confirmpassword" required>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputMobile" class="form-control" placeholder="Mobile" name="mobile" required >
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputAddress" class="form-control" placeholder="address" name="address" required >
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me" name="remember"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div>
</body>
</html>
