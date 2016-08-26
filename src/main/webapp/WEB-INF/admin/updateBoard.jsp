<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/22
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>公告栏页</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
        var editor = null;
        window.onload = function(){
            editor = CKEDITOR.replace('textarea'); //参数‘content’是textarea元素的name属性值，而非id属性值
            editor.setData('${Boards.textarea}');
            editor.getData();
        }
    </script>
    <script type="text/javascript">
        function submit(){
            var stemTxt=CKEDITOR.instances.CKEditor1.document.getBody().getText(); //取得纯文本
            editor.updateElement(); //非常重要的一句代码

            //前台验证工作
            //提交到后台

            var action ="${pageContext.request.contextPath}/admin/updateUeditor";
            document.all.form.action = action;
            document.all.form.submit();
        }
    </script>
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
                <li class="active"><a href="${pageContext.request.contextPath}/admin/themes"><i class="fa fa-file"></i> 公告添加页</a></li>
                <li ><a href="${pageContext.request.contextPath}/board/selectTitleByPage"><i class="fa fa-file"></i> 显示公告页</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/logout"><i class="fa fa-file"></i> 注销</a></li>
            </ul>


        </div><!-- /#page-wrapper -->
    </nav>

    <form action="${pageContext.request.contextPath}/board/updateEditor?id=${Boards.id}"  method="post">
        <div  style="text-align:center">
            <h1> 公告名: <input name="title" id="title" type="text" value="${Boards.title}"></h1>
        </div>

        <textarea id="textarea" name="textarea" value="${Boards.textarea}">公告内容</textarea>
        <input type="submit" value="提交" id="submit" onclick="submit()" />
    </form>
</div><!-- /#wrapper -->


<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/admin/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/bootstrap.js"></script>



</body>
</html>