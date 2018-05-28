<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="alternate" media="handheld"  />
    <!-- end 云适配 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>企业注册-拉勾网-最专业的招聘平台</title>
    <meta property="qc:admins" content="23635710066417756375" />
    <meta content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网" name="description">
    <meta content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招" name="keywords">

    <meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

    <!-- <div class="web_root"  style="display:none">h</div> -->
    <script type="text/javascript">
        var ctx = "h";
        console.log(1);
    </script>
    <link rel="Shortcut Icon" href="h/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="style/css/style.css"/>

    <script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>

    <script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
    <script type="text/javascript" src="style/js/core.min.js"></script>


    <script type="text/javascript">
        var youdao_conv_id = 271546;
    </script>
    <script type="text/javascript" src="style/js/conv.js"></script>
</head>

<body id="login_bg">
<div class="login_wrapper">
    <div class="login_header">
        <a href="h/"><img src="style/images/logo_white.png" width="285" height="62" alt="拉勾招聘" /></a>
        <div id="cloud_s"><img src="style/images/cloud_s.png" width="81" height="52" alt="cloud" /></div>
        <div id="cloud_m"><img src="style/images/cloud_m.png" width="136" height="95"  alt="cloud" /></div>
    </div>

    <input type="hidden" id="resubmitToken" value="9b207beb1e014a93bc852b7ba450db27" />
    <div class="login_box">
        <form id="loginForm">
            <%--<ul class="register_radio clearfix">--%>
            <%--<li>--%>
            <%--找工作--%>
            <%--<input type="hidden" value="0" name="userType" id="work"/>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--招人--%>
            <input type="hidden" value="1" name="userType" id="user"/>
            <%--</li>--%>
            <%--</ul>--%>
            <input type="text" id="loginName" name="loginName" tabindex="1" placeholder="请输入手机号" style="width: 300px"/>
            <span class="error" style="display:none;" id="beError"></span>
            <input type="password" id="loginPwd" name="loginPwd" tabindex="2" placeholder="请输入密码" style="width: 300px"/>
            <input type="password" id="loginPwd2"  tabindex="3" placeholder="请再次输入密码" style="width: 300px"/>
            <label class="fl registerJianJu" for="checkbox">
                <input type="checkbox" id="checkbox" name="checkbox" checked  class="checkbox valid" />我已阅读并同意<a href="h/privacy.html" target="_blank">《拉勾用户协议》</a>
            </label>
            <input type="submit" id="submitLogin" value="注 &nbsp; &nbsp; 册" />

            <input type="hidden" id="callback" name="callback" value=""/>
            <input type="hidden" id="authType" name="authType" value=""/>
            <input type="hidden" id="signature" name="signature" value=""/>
            <input type="hidden" id="timestamp" name="timestamp" value=""/>
        </form>
        <div class="login_right">
            <div>已有企业帐号 ?</div>
            <a  href="GsLaGouLogin.jsp"  class="registor_now">直接登录</a>
            <%--<div class="login_others">使用以下帐号直接登录:</div>--%>
            <%--<a  href="https://weibo.com/"  target="_blank" class="icon_wb" title="使用新浪微博帐号登录"></a>--%>
            <%--<a  href="h/ologin/auth/qq.html"  class="icon_qq" target="_blank" title="使用腾讯QQ帐号登录" ></a>--%>
        </div>
    </div>
    <div class="login_box_btm"></div>
</div>

<script type="text/javascript">

    $(document).ready(function(e) {
        $('.register_radio li input').click(function(e){
            $(this).parent('li').addClass('current').append('<em></em>').siblings().removeClass('current').find('em').remove();
        });

        $('#loginName').focus(function(){
            $('#beError').hide();
        });
        //验证表单
        $("#loginForm").validate({
            rules: {
                userType:{
                    required: true
                },
                loginName: {
                    required: true,
                },
                loginPwd: {
                    required: true,
                    rangelength: [6,16]
                },
                checkbox:{required:true}
            },
            messages: {
                userType:{
                    required:"请选择使用拉勾的目的"
                },
                loginName: {
                    required: "请输入手机号",
                },
                loginPwd: {
                    required: "请输入密码",
                    rangelength: "请输入6-16位密码，字母区分大小写"
                },
                checkbox: {
                    required: "请接受拉勾用户协议"
                }
            },
            errorPlacement:function(label, element){/*
             if(element.attr("type") == "radio"){
             label.insertAfter($(element).parents('ul')).css('marginTop','-20px');
             }else if(element.attr("type") == "checkbox"){
             label.inserresult.contenttAfter($(element).parent()).css('clear','left');
             }else{
             label.insertAfter(element);
             } */
                /*modify nancy*/
                if(element.attr("userType") == "radio"){
                    label.insertAfter($(element).parents('ul')).css('marginTop','-20px');
                }else if(element.attr("userType") == "checkbox"){
                    label.insertAfter($(element).parent()).css('clear','left');
                }else{
                    label.insertAfter(element);
                };
            },
            submitHandler:function(form){
                var userType =$('input[userType="radio"]:checked',form).val();
                var loginName =$('#loginName').val();
                var loginPwd =$('#loginPwd').val();
                var resubmitToken = $('#resubmitToken').val();

                var callback = $('#callback').val();
                var authType = $('#authType').val();
                var signature = $('#signature').val();
                var timestamp = $('#timestamp').val();

                $(form).find(":submit").attr("disabled", true);

                $.ajax({
                    type:'POST',
                    data: $("#loginForm").serialize(),
                    url:"<%=request.getContextPath()%>/loginController/laGouReg.do",
                    dataType:'json',
                    success:function (data) {
                        if(data==0){
                            alert("注册失败");
                        }else if(data==1){
                            $.ajax({
                                url:"<%=request.getContextPath()%>/loginController/updateComIdByName.do",
                                data:{loginName:loginName},
                                success:function () {
                                    location.href="<%=request.getContextPath()%>/GsLaGouLogin.jsp";
                                },
                                error:function () {
                                    alert("修改id失败");
                                }

                            })
                        }
                    },
                    error:function () {

                        alert("注册失败");
                    }
                }).done(function(result) {
                    $('#resubmitToken').val(result.resubmitToken);
                    if(result.success){
                        window.location.href=result.content;
                    }else{
                        $('#beError').text(result.msg).show();
                    }
                    $(form).find(":submit").attr("disabled", false);
                });
            }
        });
    });
</script>
</body>
</html>
