<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/11
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String bashPath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<head>

    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<%--//登录--%>

<section class="container">
    <div class="login">
        <h1>Register to Web App</h1>
        <%--<form method="post" action="index.html">--%>
        <p><input type="text" name="login" value="" class="name" placeholder="Username or Email"></p>
        <p><input type="password" name="password" value="" class="pass" placeholder="Password"></p>
        <p class="remember_me">
            <label>
                <input type="checkbox" name="remember_me" id="remember_me">
                Remember me on this computer
            </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Register"></p>
        <%--</form>--%>
        <div class="tishi"><p class="message"></p></div>
    </div>

    <%--<div class="login-help">--%>
    <%--<p>register <a href="#">Click here to reset it</a>.</p>--%>
    <%--</div>--%>

</section>


<%--<div class="loginPage">--%>


<%--&lt;%&ndash;<img src="../js/a.jpg">&ndash;%&gt;--%>


<%--<tr><input type="text" name="nickname" class="name"></tr>--%>
<%--<tr><input type="text" name="password" class="pass"></tr>--%>
<%--<tr><input type="button" value="submit" class="login"></tr>--%>
<%--</div>--%>
<%--//注册--%>
<%--<div class="registerPage">--%>

<%--<tr><input type="text" class="name1"></tr>--%>
<%--<tr><input type="text" class="pass1"></tr>--%>
<%--<tr><input type="button" class="register"></tr>--%>

<%--</div>--%>

<%--&lt;%&ndash;上传&ndash;%&gt;--%>
<%--<form action="./sumbitFile" method="post" enctype="multipart/form-data">--%>
<%--<input type="file" name="file"/> <input type="submit" value="Submit" /></form>--%>
</body>


<script src="../js/jquery.min.js"></script>
<script src="../js/jquerycookie.js"></script>


<script>


    $('.submit').click(function () {
        var name = $('.name').val();
        var password = $('.pass').val();
        if (name == "" || name == null || typeof(name) == "undefined") {

            $('.message').text("重新填写")

            return;
        }
        if (password == "" || password == null || typeof (password) == "undefined" || isNaN(password)) {

            $('.message').text("密码错误");
            return;
        }

        $.ajax(
                {
                    url: "${pageContext.request.contextPath}/Test/register",
                    data: {
                        name: name,
                        password: password
                    },
                    dataType: 'json',
                    method: 'post',
                    success: function (data) {

                        if (data.msg == "success") {
                            $.cookie('username',name);
                            $.cookie('password',password);
                            var url = "${pageContext.request.contextPath}/Test/login";
                            window.location.href = url;

                            alert("success");
                        } else {

                            alert("fail");
                        }

                    }
                }
        )

    })



</script>
</html>
