<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/20
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <!--IE Compatibility modes-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--Mobile first-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login Page</title>

    <meta name="description" content="Free Admin Template Based On Twitter Bootstrap 3.x">
    <meta name="author" content="">

    <meta name="msapplication-TileColor" content="#5bc0de" />
    <meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/resources/admin/metis-tile.png" />
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/bootstrap.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/font-awesome.css">

    <!-- Metis core stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/main.css">

    <!-- metisMenu stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/metisMenu.css">

    <!-- animate.css stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/animate.css">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body class="login">

<div class="form-signin">
    <div class="text-center">
        <img src="${pageContext.request.contextPath}/resources/admin/logo.png" alt="Metis Logo">
    </div>
    <hr>
    <div class="tab-content">
        <div id="login" class="tab-pane active">
            <form action="${pageContext.request.contextPath }/admin/login" method="post">
                <p class="text-muted text-center">
                    输入你的登录账号和密码
                </p>
                <input type="text" placeholder="账号" class="form-control top" name="adminUser">
                <input type="password" placeholder="密码" class="form-control middle" name="adminPassword">

                <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
            </form>
        </div>

        <div id="signup" class="tab-pane">
            <form action="${pageContext.request.contextPath }/admin/add" method="post">
                <input type="text" placeholder="账号" class="form-control top" name="adminUser">
                <input type="password" placeholder="密码" class="form-control middle" name="adminPassword">
                <button class="btn btn-lg btn-success btn-block" type="submit">注册</button>
            </form>
        </div>
    </div>
    <hr>
    <div class="text-center">
        <ul class="list-inline">
            <li><a class="text-muted" href="#login" data-toggle="tab">登录页面</a></li>
            <li><a class="text-muted" href="#signup" data-toggle="tab">注册页面</a></li>
        </ul>
    </div>
</div>


<!--jQuery -->
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>

<!--Bootstrap -->
<script src="${pageContext.request.contextPath}/resources/admin/bootstrap.js"></script>


<script type="text/javascript">
    (function($) {
        $(document).ready(function() {
            $('.list-inline li > a').click(function() {
                var activeForm = $(this).attr('href') + ' > form';
                //console.log(activeForm);
                $(activeForm).addClass('animated fadeIn');
                //set timer to 1 seconds, after that, unload the animate animation
                setTimeout(function() {
                    $(activeForm).removeClass('animated fadeIn');
                }, 1000);
            });
        });
    })(jQuery);
</script>
</body>

</html>

