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

    <title>Title</title>
</head>
<body>
<%--//登录--%>
<div class="loginPage">
    <img src="../js/a.jpg">


    <tr><input type="text" name="nickname" class="name"></tr>
    <tr><input type="text" name="password" class="pass"></tr>
    <tr><input type="button" value="submit" class="login"></tr>
</div>
<%--//注册--%>
<div class="registerPage">

    <tr><input type="text" class="name1"></tr>
    <tr><input type="text" class="pass1"></tr>
    <tr><input type="button" class="register"></tr>

</div>

<%--上传--%>
<form action="./sumbitFile" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/> <input type="submit" value="Submit" /></form>
</body>


<script src="../js/jquery.min.js"></script>


<script>


    $('.login').click(function () {
        var name = $('.name').val();
        var password = $('.pass').val();

        $.ajax(
                {
                    url: "./ver",
                    data: {
                        name: name,
                        password: password
                    },
                    dataType: 'json',
                    method: 'post',
                    success: function (data) {

                        if (data.msg == "success") {

                            alert("success");
                        } else {

                            alert("fail");
                        }

                    }
                }
        )

    })
    $('.register').click(function () {

        var name1   =   $('.name1').val();
        var password1   =   $('.pass1').val();
        $.ajax({
            url:"./register",
            data: {
                name: name1,
                password: password1
            },
            dataType: 'json',
            method: 'post',
            success: function (data) {

                if (data.msg == "success") {

                    alert("success");
                } else {

                    alert("fail");
                }

            }

        })
    })


</script>
</html>
