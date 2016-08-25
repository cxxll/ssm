<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>招聘XX网</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/user/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/user/font-awesome/css/font-awesome.min.css" />

    <style>
        body{
            font-family: 'microsoft yahei',Arial,sans-serif;
            background-color: #222;
        }

        .redborder {
            border:2px solid #f96145;
            border-radius:2px;
        }

        .row {
            padding: 20px 0px;
        }

        .bigicon {
            font-size: 97px;
            color: #f08000;
        }

        .loginpanel {
            text-align: center;
            width: 300px;
            border-radius: 0.5rem;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: 10px auto;
            background-color: #555;
            padding: 20px;
        }

        input {
            width: 100%;
            margin-bottom: 17px;
            padding: 15px;
            background-color: #ECF4F4;
            border-radius: 2px;
            border: none;
        }

        h2 {
            margin-bottom: 20px;
            font-weight: normal;
            color: #EFEFEF;
        }

        .btn {
            border-radius: 2px;
            padding: 10px;
        }

        .btn span {
            font-size: 27px;
            color: white;
        }

        .buttonwrapper{
            position:relative;
            overflow:hidden;
            height:50px;
        }

        .lockbutton {
            font-size: 27px;
            color: #f96145;
            padding: 10px;
            width:100%;
            position:absolute;
            top:0;
            left:0;
        }

        .loginbutton {
            background-color: #f08000;
            width: 100%;
            -webkit-border-top-right-radius: 0;
            -webkit-border-bottom-right-radius: 0;
            -moz-border-radius-topright: 0;
            -moz-border-radius-bottomright: 0;
            border-top-right-radius: 0;
            border-bottom-right-radius: 0;
            left: -260px;
            position:absolute;
            top:0;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/bootstrap/js/bootstrap.min.js"></script>

</head>
<script type="text/javascript">
    function changeValidateCode(obj){
//获取当前的时间作为参数，无具体意义
        var timenow = new Date().getTime();
//每次请求需要一个不同的参数，否则可能会返回同样的验证码
//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。
        obj.src="${pageContext.request.contextPath}/users/code?d="+timenow;
    }
</script>
<body>

<!-- Interactive Login - START -->
<form action="${pageContext.request.contextPath }/user/login" method="post" >
    <div class="container-fluid">
        <div class="row">
            <div class="loginpanel">
                <i id="loading" class="hidden fa fa-spinner fa-spin bigicon"></i>
                <h2>
                    <span class="fa fa-quote-left "></span> 登录 <span class="fa fa-quote-right "></span>
                </h2>
                <div>
                    <input id="loginName" type="text"  name="loginName" placeholder="登录账号" onkeypress="check_values();">
                    <input id="password" type="password" name="password" placeholder="输入密码" onkeypress="check_values();">
                        <input type="text" id="code" name="code" placeholder="输入验证码" onblur="return checkCode(this.value)" onkeypress="check_values();"/>
                    <div>
                    <img id="codeImg"  src="${pageContext.request.contextPath}/users/code" onclick="changeValidateCode(this)();"/>
                        <span id="myDiv"></span>
                    </div>
                    <div class="buttonwrapper">
                        <button id="loginbtn" class="btn btn-warning loginbutton">
                            <span class="fa fa-check"></span>
                        </button>
                        <span id="lockbtn" class="fa fa-lock lockbutton redborder"></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<script type="text/javascript">

    function check_values() {
        if ($("#loginName").val().length != 0 && $("#password").val().length != 0 && $("#code").val().length != 0) {
            $("#loginbtn").animate({ left: '0' , duration: 'slow'});;
            $("#lockbtn").animate({ left: '260px' , duration: 'slow'});;
        }
    }


    $("#loginbtn").click(function(){
        $('#loading').removeClass('hidden');
        //这里书写登录相关后台处理，例如: Ajax请求用户名和密码验证
        //按钮事件
        {
            function createXMLHttp(){
                if (window.XMLHttpRequest){                     // 创建XMLHttpRequest核心对象
                    xmlHttp = new XMLHttpRequest()                  // 使用FireFox内核
                }else {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");   // 使用IE内核的浏览器
                }
            }
            function checkCode(code){
                createXMLHttp();


                if (code.length==0)
            {
                document.getElementById("code").innerHTML="";//登录中的提示,在未输入信息时清空
                return;
            }
            xmlhttp.open("POST","${pageContext.request.contextPath}/users/validate?code="+code,true);

            xmlHttp.onreadystatechange = checkCodeCallback;
            xmlHttp.send(null); // 发送请求，不设置参数
            }
        }
        function checkCodeCallback(){ // 回调函数
            if (xmlHttp.readyState == 4){           // 数据返回完毕
                if (xmlHttp.status == 200){         // HTTP操作正常
                    var text = xmlHttp.responseText;// 接收返回内容
                    if (text == "true"){
                        document.getElementById("code").innerHTML = "验证码输入正确";
                        alert("code");
                    }else {
                        document.getElementById("code").innerHTML = "验证码输入错误，请重新输入";
                        alert("code");
                    }
                }
            }
        }

    });

</script>

<!-- Interactive Login - END -->

</div>

<div class="container-fluid">
    <div class="row footerbox">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <footer class="text-center">
                <a href="../addUser.jsp"><i class="fa fa-external-link"></i> 注册用户</a>
            </footer>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
</body>
</html>