<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/20
  Time: 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr></br>
<div>
    文件以模板的方式导出，模板存放在项目中(WEB-INF/pages/)
</div>
</br>
<form action="user/ajaxExport.do" method="post" id="form2">
    <input type="submit" id="exportExcel" name="exportExcel" value="Excel导出"/>
</form>
</body>
</html>
