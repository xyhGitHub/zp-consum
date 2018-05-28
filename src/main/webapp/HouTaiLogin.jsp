<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<%@include file="bootstrapjs.txt"%>--%>
    <script src="<%=request.getContextPath()%>/jquery/jquery.min.js"></script>
    <title>欢迎登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="./houtai/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="./houtai/css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="./houtai/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->
    <!-- web font -->
    <!--<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">-->
    <!-- //web font -->

</head>
<body>
<div class="snow-container">
    <div class="snow foreground"></div>
    <div class="snow foreground layered"></div>
    <div class="snow middleground"></div>
    <div class="snow middleground layered"></div>
    <div class="snow background"></div>
    <div class="snow background layered"></div>
</div>

<div class="top-buttons-agileinfo">
    <a href="xyh/HouTaiLoginGS.jsp"  class="active">公司登录</a>
    <%--<a href="HouTaiReg.jsp">注册</a>--%>
</div>
    <h1></h1>
<div class="main-agileits">
    <!--form-stars-here-->
    <div class="form-w3-agile">
        <h2 class="sub-agileits-w3layouts">欢迎登录</h2>
        <form id="dengluFrom">
            <input type="text" name="loginname" placeholder="用户名" required="" />
            <input type="password" name="pwd" placeholder="密码" required="" />
            <%--<a href="#" class="forgot-w3layouts">忘记密码 ?</a>--%>
            <p class="p-bottom-w3ls"><a href="HouTaiReg.jsp">点击注册</a>如果你没有一个帐户。.</p>
        </form>
        <div class="submit-w3l">
            <input type="submit" value="登录" id="denglu">
            <%--<button id="denglu">登录</button>--%>
        </div>
    </div>
</div>
<script>

    $("#denglu").click(function () {
//        alert($("#dengluFrom").serialize())
        $.ajax({
            url:"<%=request.getContextPath()%>/loginController/login.do",
            type:"post",
            data:$("#dengluFrom").serialize(),
            dataType:"json",
            async:false,
            success:function(result){

                if(result==1){
                    location.href="main.jsp";
//                    window.open('main.jsp');
                }if(result==4){
                    alert("登录名不能为空");
//                    $("#js_ban_content").datagrid("reload");
                }if(result==5){
                    alert("密码不能为空");
//                    $("#js_ban_content").datagrid("reload");
                }if(result==0){
                    alert("登录名或密码错误");
                    $.messager.alert('提示', result, '登录失败', function() {
                        $('#denglu').linkbutton('enable');
                    });
                }

            },
            error:function(){
                alert("登录失败，请联系管理员！");
            }
        })
    })
    $(document).keydown(function(event){
        if(event.keyCode == 13){ //绑定回车
            $('#denglu').click();
            //自动触发登录按钮
        }
    });

</script>
<!--//form-ends-here-->
<!-- copyright -->
<div class="copyright w3-agile">
    <p> © 2018</p>
</div>
<!-- //copyright -->
<script type="text/javascript" src="./houtai/js/jquery-2.1.4.min.js"></script>

</body>
</html>