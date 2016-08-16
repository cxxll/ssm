<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Multi Step Registration Form Template</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/form-elements.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}{pageContext.request.contextPath}/resources/user/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/resources/user/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/resources/user/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/resources/user/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resou rces/user/ico/apple-touch-icon-57-precomposed.png">

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/validata/js/jquery.js"></script>
    <script language="JavaScript">
        var xmlHttp;
        var flag;
        function createXMLHttp(){
            if (window.XMLHttpRequest){                     // 创建XMLHttpRequest核心对象
                xmlHttp = new XMLHttpRequest()                  // 使用FireFox内核
            }else {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");   // 使用IE内核的浏览器
            }
        }

        function checkloginName(loginName){
            createXMLHttp();    //
            xmlHttp.open("POST","user/loginNameIsExist?loginName="+loginName);

            xmlHttp.onreadystatechange = checkLoginNameCallback;
            xmlHttp.send(null); // 发送请求，不设置参数
            document.getElementById("msg").innerHTML = "正在验证……";
        }

        function checkLoginNameCallback(){ // 回调函数

            if (xmlHttp.readyState == 4){           // 数据返回完毕
                if (xmlHttp.status == 200){         // HTTP操作正常
                    var text = xmlHttp.responseText;// 接收返回内容
                    if (text == "true"){
                        flag = false;               // 无法提交表单
                        document.getElementById("msg").innerHTML = "用户名ID重复，无法使用";
                    }else {
                        flag = true;                // 可以提交表单
                        document.getElementById("msg").innerHTML = "恭喜！此用户ID可以注册";
                    }
                }
            }
        }
        function checkForm(){   // 对表单判断能否进行提交操作
            return flag;
        }
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/validata/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/validata/js/jquery.vform.js"></script>
</head>

<body>

<!-- Top menu -->
<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Bootstrap Multi Step Registration Form Template</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
							<span class="li-text">
								Put some text or
							</span>
                    <a href="#"><strong>links</strong></a>
							<span class="li-text">
								here, or some icons:
							</span>
							<span class="li-social">
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-envelope"></i></a>
								<a href="#"><i class="fa fa-skype"></i></a>
							</span>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Bootstrap</strong> Multi Step Registration Form</h1>
                    <div class="description">
                        <p>
                            This is a free responsive multi-step registration form made with Bootstrap.
                            Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">

                    <form id="addUser" role="form" action="${pageContext.request.contextPath }/user/add" method="post" class="registration-form"  onsubmit="return checkForm()">

                        <fieldset>
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Step 1 / 3</h3>
                                    <p>Tell us who you are:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-user"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <div class="form-group">
                                    <label class="sr-only" for="form-login-name">登录账号</label>
                                    <input type="text" name="loginName" placeholder="登录账号" class="form-login-name form-control" id="form-login-name"
                                           onblur="checkloginName(this.value)">
                                    <span id="msg"></span>
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-password">登录密码</label>
                                    <input type="password" name="password" placeholder="登录密码" class="form-password form-control" id="form-password">
                                </div>

                                <button type="button" class="btn btn-next">Next</button>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Step 2 / 3</h3>
                                    <p>Set up your account:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-key"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                            <div class="form-group">
                                <label class="sr-only" for="form-email">邮箱</label>
                                <input name="email" placeholder="邮箱"
                                       class="form-email form-control" id="form-email"
                                       validata-options="validType:'Email',msg:'信箱格式不正确'">
                            </div>
                                <div class="form-group">
                                    <input type="radio" name="gender" value="男" checked />男
                                    <input type="radio" name="gender" value="女" validata-options="validType:'Group',msg:'必须选定一个性别'" />女

                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-name">Password</label>
                                    <input type="text" name="name" placeholder="真实姓名" class="form-name form-control" id="form-name"
                                           validata-options="validType:'Require|Chinese',msg:'不能为空|真实姓名只允许中文,并且大于两个字'">
                                </div>
                                <button type="button" class="btn btn-previous">Previous</button>
                                <button type="button" class="btn btn-next">Next</button>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Step 3 / 3</h3>
                                    <p>Social media profiles:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-twitter"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <div class="form-group">
                                    <label class="sr-only" for="form-phone">phoneNumber</label>
                                    <input type="text" name="phoneNumber" placeholder="电话号码..." class="form-phone form-control" id="form-phone"
                                           validata-options="required:false,validType:'Mobile',msg:'手机号码不正确'">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-age">age</label>
                                    <input type="text" name="age" placeholder="年龄" class="form-age form-control" id="form-age"
                                           validata-options="validType:'Compare',compare:'>18',msg:'年龄必须大于18'">
                                </div>
                                <button type="button" class="btn btn-previous">Previous</button>
                                <button type="submit" class="btn">Sign me up!</button>
                            </div>
                        </fieldset>

                    </form>
                    <script>
                        $('#addUser').checkForm();
                    </script>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- Javascript -->
<script src="${pageContext.request.contextPath}/resources/user/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/user/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/user/js/jquery.backstretch.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/user/js/retina-1.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/user/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="${pageContext.request.contextPath}/resources/user/js/placeholder.js"></script>
<![endif]-->

</body>

</html>