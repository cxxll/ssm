<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/6
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
错误码： <%=request.getAttribute("javax.servlet.error.status_code")%> <br>
	     信息： <%=request.getAttribute("javax.servlet.error.message")%> <br>
	     异常： <%=request.getAttribute("javax.servlet.error.exception_type")%> <br>
<SCRIPT language=javascript>
    function go()
    {
        window.history.go(-1);
    }
    setTimeout("go()",3000);
</SCRIPT>
</body>
</html>