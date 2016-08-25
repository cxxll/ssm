<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>个人中心</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/theme/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/theme/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/theme/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/theme/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/user/theme">XX招聘网</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="${pageContext.request.contextPath}/user/theme"><i class="fa fa-user fa-fw"></i> 首页</a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/user/updateUI?id=${loginUser.id}"><i class="fa fa-gear fa-fw"></i> 修改信息</a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/user/passwordUI?id=${loginUser.id}"><i class="fa fa-gear fa-fw"></i> 修改密码</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/user/loginout"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                        </div>
                        <!-- /input-group -->
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/resume/list"/><i class="fa fa-bar-chart-o fa-fw"></i> 简历中心<span class="fa arrow"></span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/recruit/getRecListByUid?id=${loginUser.id}"><i class="fa fa-table fa-fw"></i> 招聘页</a>
                    </li>

                    </li>
                    <li class="active">
                        <a href="#"><i class="fa fa-files-o fa-fw"></i> 个人信息<span class="fa arrow"></span></a>
                        <ul class="nav nav-fourth-level">
                            <li>
                                <a class="active" href="${pageContext.request.contextPath}/user/theme">首页</a>
                            </li>
                            <li>
                                <a class="active" href="${pageContext.request.contextPath}/user/passwordUI?id=${loginUser.id}">修改密码</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath }/file/selectTitleByPage">公告栏</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/user/">退出</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <form action="${pageContext.request.contextPath}/user/update?id=${loginUser.id}"  method="post">
                        <fieldset>
                            <div class="row">
                                <div class="col-md-6 col-md-offset-3">
                                    <div class="hidden">
                                        <input name="id" type="hidden" value="${loginUser.id}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="name">姓名</label>
                                        <input class="form-control" id="name" name="name" type="text" value="${loginUser.name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">邮箱</label>
                                        <input class="form-control"  id="email" name="email" type="text" value="${loginUser.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="phoneNumber">电话号码</label>
                                        <input class="form-control"  id="phoneNumber" name="phoneNumber" type="text" value="${loginUser.phoneNumber}">
                                    </div>
                                    <div class="form-group">
                                        <label for="age">年龄</label>
                                        <input class="form-control"  id="age" name="age" type="text" value="${loginUser.age}">
                                    </div>
                                    <div class="form-group">
                                        <label for="submit">提交</label>
                                        <input class="form-control"  id="submit"  type="submit" >

                                    </div>
                            </div>
                                </div>
                        </fieldset>
                    </form>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/theme/dist/js/sb-admin-2.js"></script>

</body>

</html>
