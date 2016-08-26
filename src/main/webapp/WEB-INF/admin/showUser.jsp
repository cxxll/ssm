<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>用户页</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/admin/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${pageContext.request.contextPath}/resources/admin/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/font-awesome.min.css">
<script>
    function deleteDraft(the,id){
    $.messager.confirm('删除草稿提醒', '</br>确定删除这篇草稿吗?</br></br>',function(r){
    if(r){
    $.ajax({
    type : "post",
    url : "http://localhost:8090/webplus3/_web/sns/delBlog.do?_p=YXM9Mw__&id=" + id,
    success : function(data) {
    if(data == "success") {
    $(the).parents("li").remove();
    parent.initDraft();
    }
    }
    });
    }
    });
    }
</script>
    <script type="text/javascript" src="resources/upload/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="resources/upload/jquery.form.js"></script>

    <script type="text/javascript">
        //JS校验form表单信息
        function checkData(){
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if("" == fileDir){
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if(".xls" != suffix && ".xlsx" != suffix ){
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }
        </script>
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
                <li class="active"><a href="${pageContext.request.contextPath}/file/UserPage"><i class="fa fa-wrench"></i> 用户页</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/themes"><i class="fa fa-file"></i> 公告添加页</a></li>
                <li ><a href="${pageContext.request.contextPath}/board/selectTitleByPage"><i class="fa fa-file"></i> 显示公告页</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/logout"><i class="fa fa-file"></i> 注销</a></li>
            </ul>



        </div><!-- /#page-wrapper -->
    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div>
                    <div  style="text-align:center">
                        <h1>用户栏：</h1>
                    </div>
                    <form action="${pageContext.request.contextPath}/excel/download"  >
                        <input type="submit" value="Excel导出"/>
                    </form>
                    <form method="POST" enctype="multipart/form-data"   action="${pageContext.request.contextPath}/excel/upload">
                            <tr>
                                <td>导入文件（导入数据ID必须和数据库ID不同）: </td>
                                <td> <input id="upfile" type="file" name="excel"></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="提交" onclick="return checkData()"></td>
                            </tr>
                    </form>
                    <br/>
                                <div class="panel-body">
                                        <table width="100%" class="table table-striped table-bordered table-hover" >
                                            <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>登录账号</th>
                                                <th>登录密码</th>
                                                <th>邮箱</th>
                                                <th>性别</th>
                                                <th>姓名</th>
                                                <th>电话号码</th>
                                                <th>年龄</th>
                                                <th>删除</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <c:forEach items="${pageList.recordList }" var="user">
                                                <tr >
                                                    <td>${user.id}</td>
                                                    <td>${user.loginName}</td>
                                                    <td>${user.password}</td>
                                                    <td>${user.email}</td>
                                                    <td>${user.gender}</td>
                                                    <td>${user.name}</td>
                                                    <td>${user.phoneNumber}</td>
                                                    <td>${user.age}</td>
                                                    <td><a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">删除</a></td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                    <%@ include file="/resources/admin/common.jspf" %>

                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

 </div>
</div><!-- /#wrapper -->


<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/admin/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/bootstrap.js"></script>



</body>
</html>