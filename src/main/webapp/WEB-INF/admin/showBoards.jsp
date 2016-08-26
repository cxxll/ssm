<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>公告页显示</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/admin/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${pageContext.request.contextPath}/resources/admin/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/font-awesome.min.css">

</head>

<body>


<div id="wrapper">

    <!-- Sidebar -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li><a href="${pageContext.request.contextPath}/file/UserPage"><i class="fa fa-wrench"></i> 用户页</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/themes"><i class="fa fa-file"></i> 公告添加页</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/board/selectTitleByPage"><i class="fa fa-file"></i> 显示公告页</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/logout"><i class="fa fa-file"></i> 注销</a></li>
            </ul>


        </div><!-- /#page-wrapper -->
    </nav>
    <div  style="text-align:center">
        <h1>${Boards.title}</h1>
    </div>
    <br/>
    <br/>
    <br/>
    &nbsp;&nbsp; <h3>${Boards.textarea}</h3>
</div>

</div><!-- /#wrapper -->


<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/admin/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/bootstrap.js"></script>



</body>
</html>
