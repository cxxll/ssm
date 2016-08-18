<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>测试</title>
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
    <script type="text/javascript">

        function winClose() {
            $('#detailPanel').window('close');
        }

        var showDiv = function(str) {
            var msgw = 350;
            var msgh = 90;
            var bordercolor;
            titleheight =  25; //提示窗口标题高度
            bordercolor = "#00CCCC"; //提示窗口的边框颜色
            titlecolor = "#00CCCC"; //提示窗口的标题颜色
            var sWidth, sHeight;
            //获取当前窗口尺寸
            sWidth = document.body.offsetWidth;
            sHeight = document.body.offsetHeight;
            //背景div
            var bgObj = document.createElement("div");
            bgObj.setAttribute('id', 'alertbgDiv');
            bgObj.style.position = "absolute";
            bgObj.style.top = "0";
            bgObj.style.background = "#E8E8E8";
            bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
            bgObj.style.opacity = "0.6";
            bgObj.style.left = "0";
            bgObj.style.width = sWidth + "px";
            bgObj.style.height = sHeight + "px";
            bgObj.style.zIndex = "10000";
            document.body.appendChild(bgObj);
            //创建提示窗口的div
            var msgObj = document.createElement("div");
            msgObj.setAttribute("id", "alertmsgDiv");
            msgObj.setAttribute("align", "center");
            msgObj.style.background = "white";
            msgObj.style.border = "1px solid " + bordercolor;
            msgObj.style.position = "absolute";
            msgObj.style.left = "50%";
            msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
            //窗口距离左侧和顶端的距离
            msgObj.style.marginLeft = "-280px";
            //窗口被卷去的高+（屏幕可用工作区高/2）-150
            msgObj.style.top = document.body.scrollTop+(window.screen.availHeight/2)- 180 + "px";
            msgObj.style.width = msgw + "px";
            msgObj.style.height = msgh + "px";
            msgObj.style.textAlign = "center";
            msgObj.style.lineHeight ="25px";
            msgObj.style.zIndex = "10001";
            document.body.appendChild(msgObj);
            //提示信息标题
            var title=document.createElement("h4");
            title.setAttribute("id", "alertmsgTitle");
            title.setAttribute("align", "left");
            title.style.margin = "0";
            title.style.padding = "3px";
            title.style.background = bordercolor;
            title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
            title.style.opacity = "0.75";
            title.style.border = "1px solid " + bordercolor;
            title.style.height = "18px";
            title.style.font = "12px Verdana, Geneva, Arial, Helvetica, sans-serif";
            title.style.color = "white";
            title.innerHTML = "提示信息";
            document.getElementById("alertmsgDiv").appendChild(title);
            //提示信息
            var txt = document.createElement("p");
            txt.setAttribute("id", "msgTxt");
            txt.style.margin="16px 0";
            txt.innerHTML = str;
            document.getElementById("alertmsgDiv").appendChild(txt);
        };
        //关闭提示框
        var closeDiv = function() {
            document.body.removeChild(document.getElementById("alertbgDiv"));
            document.getElementById("alertmsgDiv").removeChild(document.getElementById("alertmsgTitle"));
            document.body.removeChild(document.getElementById("alertmsgDiv"));
        };



        //执行批量导入功能
        function importSubmit(){
            var user = $.trim($('#user').val());
            if(user == '') {
                top.$.messager.alert('提示信息', '请选择要批量导入的excel文件!', 'error');
                return;
            }
            $('#fm').form('submit', {
                url: 'user/read.html',
                onSubmit: function() {
                    showDiv("批量导入时间较长，请耐心等待，勿作其它操作，谢谢！");
                },
                success: function(result) {
                    var date = eval('('+result+')');
                    if(date.status == 'ok') {
                        closeDiv(); //关闭提示信息框
                        top.$.messager.alert('提示信息', date.message, 'info', function() {
                            winClose();
                            grid.datagrid('reload');

                        });
                    } else if(date.status == 'fail') {
                        closeDiv(); //关闭提示信息框
                        winClose(); //关闭对话框
                        top.$.messager.alert('提示信息', date.message, 'error');
                        return;
                    }
                },
                error: function() {
                    closeDiv(); //关闭提示信息框
                    winClose(); //关闭对话框
                    return;
                }
            });

        };


    </script>


    <h2><a href="<%=basePath%>user/write.html">下载</a></h2>

    <div class="easyui-layout">
        <div class="p_import">
            <div class="p_import_right">
                <div style="width: 350px;height: 50px;">&nbsp;</div>
                <p>&nbsp;</p>
                <form id="fm"  enctype="multipart/form-data" method="post">
                    选择文件：<input type="file" name="user" id="user" />
                </form>
            </div>
        </div>
        <div style="text-align:right;height:30px;line-height:30px;">
            <a class="easyui-linkbutton" iconCls="icon-ok"  onclick="importSubmit()">导入</a>
            <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="winClose()">取消</a>
        </div>
    </div>
    <div>
        <c:forEach items="${pageList.recordList }" var="user">
            id:${user.id} &nbsp;&nbsp;&nbsp;&nbsp;name:${user.loginName}&nbsp;&nbsp;&nbsp;&nbsp;password:${user.password}<br/>
        </c:forEach>
    </div>

    <!-- 分页功能 -->

    <%@ include file="resources/upload/common.jspf" %>

    </body>


</html>

</html>