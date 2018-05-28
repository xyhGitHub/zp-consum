<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/23
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台公司注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <%--<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>--%>
    <!-- Custom Theme files -->
    <link href="/houtai/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="/houtai/css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/houtai/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->
    <!-- web font -->
    <!--<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    -->
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
    <a href="HouTaiLoginGS.jsp">企业登录</a><a href="#" class="active">企业注册</a>
</div>
<div class="main-agileits">
    <!--form-stars-here-->
    <div class="form-w3-agile">
        <h2 class="sub-agileits-w3layouts">企业注册</h2>
        <form id="zhuceForm">
            <input type="text" name="loginTel" id="loginTel" placeholder="手机号" required="" />
            <input type="password" name="loginPwd" id="loginPwd" placeholder="密码" required="" />
            <input type="password" name="pwd2" id="pwd2" placeholder="确认密码" required="" />
        </form>
        <div class="submit-w3l">
            <input type="submit" value="注册" id="zhuce">
        </div>
    </div>
</div>
<!--//form-ends-here-->
<!-- copyright -->
<div class="copyright w3-agile">
    <p> © 2018 Internship Sign In & Sign Up Form . All rights reserved | Design by <a href="#" target="_blank">W4</a></p>
</div>
<!-- //copyright -->
<script type="text/javascript" src="/houtai/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
    $("#zhuce").click(function(){
        var pwd = $("#loginPwd").val();
        var pwd2 = $("#pwd2").val();
        if(pwd == pwd2){
            $.ajax({
                url:"<%=request.getContextPath()%>/loginController/regGS.do",
                data:$("#zhuceForm").serialize(),
                type:"post",
                dataType:"json",
                success:function(datas){
                    if(datas ==0){
                        alert("填写错误")
                        location.reload();
                    }else if(datas==1){
                        location.href="HouTaiLoginGS.jsp";
                    }
                }
            })
        }else{
            alert("密码不一致")

        }
    })

    $(document).keydown(function(event){
        if(event.keyCode == 13){ //绑定回车
            $('#zhuce').click();
            //自动触发登录按钮
        }
    });

</script>
</body>
</html>
