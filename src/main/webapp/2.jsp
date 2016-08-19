<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/20
  Time: 4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="resources/upload/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="resources/upload/jquery.form.js"></script>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript">
        //ajax 方式上传文件操作
        $(document).ready(function(){
            $('#btn').click(function(){
                if(checkData()){
                    $('#form1').ajaxSubmit({
                        url:'user/ajaxUpload.do',
                        dataType: 'text',
                        success: resutlMsg,
                        error: errorMsg
                    });
                    function resutlMsg(msg){
                        alert(msg);
                        $("#upfile").val("");
                    }
                    function errorMsg(){
                        alert("导入excel出错！");
                    }
                }
            });
        });

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

        //ajax 方式下载文件操作
        $(document).ready(function(){
            $('#exportExcel').click(function(){
                $('#form2').ajaxSubmit({
                    dataType: 'text',
                    error: errorMsg
                });
                function errorMsg(){
                    alert("导出excel出错！");
                }
            });
        });
    </script>
</head>
<body>
<form method="POST" enctype="multipart/form-data" id="form1" action="user/ajaxUpload.do">
    <tr>
        <td>上传文件: </td>
        <td> <input id="upfile" type="file" name="upfile"></td>
    </tr>
<tr>
    <td><input type="submit" value="提交" onclick="return checkData()"></td>
    <td><input type="button" value="ajax方式提交" id="btn" name="btn" ></td>
</tr>
    </form>
</body>
</html>
