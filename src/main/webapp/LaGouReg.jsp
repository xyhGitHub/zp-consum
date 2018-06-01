<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="alternate" media="handheld"  />
    <!-- end 云适配 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册-拉勾网-最专业的招聘平台</title>
    <meta property="qc:admins" content="23635710066417756375" />
    <meta content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网" name="description">
    <meta content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招" name="keywords">

    <meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

    <!-- <div class="web_root"  style="display:none">h</div> -->
    <script type="text/javascript">
        var ctx = "h";
        console.log(1);
    </script>

    <%--/*验证码*/--%>
    <style>
        .upload-awrp {
            overflow: hidden;
            margin: 120px 0;
        }

        .code {
            font-family: Arial;
            font-style: italic;
            font-size: 30px;
            border: 0;
            padding: 2px 3px;
            letter-spacing: 3px;
            font-weight: bolder;
            float: left;
            cursor: pointer;
            width: 130px;
            height: 40px;
            line-height: 60px;
            text-align: center;
            vertical-align: middle;
            border: 1px solid #6D6D72;
        }
    </style>
    <link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
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
                    <input type="hidden" value="0" name="userType" id="work"/>
                <%--</li>--%>
                <%--<li>--%>
                    <%--招人--%>
                    <%--<input type="radio" value="1" name="userType" id="user"/>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <input type="text" id="loginName" name="loginName" tabindex="1" placeholder="请输入常用邮箱地址/手机号" style="width: 300px"/><span class="error" style="display:none;" id="beError"></span>
            <input type="password" id="loginPwd" name="loginPwd" tabindex="2" placeholder="请输入密码" style="width: 300px"/>
            <input type="password" id="loginPwd2" name="loginPwd2" tabindex="3" placeholder="请再次输入密码" style="width: 300px"/>
                <!--随机验证码-->
                <div id="check-code" style="overflow: hidden;">
                    <div class="code" id="data_code"></div>
                    <input type="text" id="checkCode" name="checkCode" placeholder="请输入验证码" style="width: 150px"/>
                    <span class="error" style="display:none;" id="codeError"></span>
                </div>
                <label class="fl registerJianJu" for="checkbox">
                    <input type="checkbox" id="checkbox" name="checkbox" checked  class="checkbox valid" />我已阅读并同意<a href="h/privacy.html" target="_blank">《拉勾用户协议》</a>
                </label>
        </form>
        <input type="submit" id="submitLogin" onclick="submitLogin()" value="注 &nbsp; &nbsp; 册" />
        <div class="login_right">
            <div>已有拉勾帐号</div>
            <a  href="LaGouLogin.jsp"  class="registor_now">直接登录</a>
            <div class="login_others">使用以下帐号直接登录:</div>
            <a  href="https://weibo.com/"  target="_blank" class="icon_wb" title="使用新浪微博帐号登录"></a>
            <a  href="h/ologin/auth/qq.html"  class="icon_qq" target="_blank" title="使用腾讯QQ帐号登录" ></a>
        </div>
    </div>
    <div class="login_box_btm"></div>
</div>

<script type="text/javascript">
    /**
     * 验证码
     * @param {Object} o 验证码长度
     */
    $.fn.code_Obj = function(o) {
        var _this = $(this);
        var options = {
            code_l: o.codeLength,//验证码长度
            codeChars: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
            ],
            codeColors: ['#f44336', '#009688', '#cddc39', '#03a9f4', '#9c27b0', '#5e4444', '#9ebf9f', '#ffc8c4', '#2b4754', '#b4ced9', '#835f53', '#aa677e'],
            code_Init: function() {
                code = "";
                var codeColor = "";
                var checkCode = _this.find("#data_code");
                for(var i = 0; i < this.code_l; i++) {
                    var charNum = Math.floor(Math.random() * 52);
                    code += this.codeChars[charNum];
                }
                for(var i = 0; i < this.codeColors.length; i++) {
                    var charNum = Math.floor(Math.random() * 12);
                    codeColor = this.codeColors[charNum];
                }
                console.log(code);
                if(checkCode) {
                    checkCode.css('color', codeColor);
                    checkCode.className = "code";
                    checkCode.text(code);
                    checkCode.attr('data-value', code);
                }
            }
        };

        options.code_Init();//初始化验证码
        _this.find("#data_code").bind('click', function() {
            options.code_Init();
        });
    };
</script>
<script type="text/javascript">
    /**
     * 验证码
     * codeLength:验证码长度
     */
    $('#check-code').code_Obj({
        codeLength: 5
    });
</script>

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
                loginPwd2: {
                    required: true,
                    rangelength: [6,16]
                },
                checkCode: {
                    required: true,
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
                loginPwd2: {
                    required: "请输入确认密码",
                    rangelength: "请输入6-16位密码，字母区分大小写"
                },
                checkCode: {
                    required: "请输入验证码",
                },
                checkbox: {
                    required: "请接受拉勾用户协议"
                }
            },
            <%--errorPlacement:function(label, element){/*--%>
             <%--if(element.attr("type") == "radio"){--%>
             <%--label.insertAfter($(element).parents('ul')).css('marginTop','-20px');--%>
             <%--}else if(element.attr("type") == "checkbox"){--%>
             <%--label.inserresult.contenttAfter($(element).parent()).css('clear','left');--%>
             <%--}else{--%>
             <%--label.insertAfter(element);--%>
             <%--} */--%>
                <%--/*modify nancy*/--%>
                <%--if(element.attr("userType") == "radio"){--%>
                    <%--label.insertAfter($(element).parents('ul')).css('marginTop','-20px');--%>
                <%--}else if(element.attr("userType") == "checkbox"){--%>
                    <%--label.insertAfter($(element).parent()).css('clear','left');--%>
                <%--}else{--%>
                    <%--label.insertAfter(element);--%>
                <%--};--%>
            <%--},--%>
            <%--submitHandler:function(form) {--%>
                <%--var userType = $('input[userType="radio"]:checked', form).val();--%>
                <%--var loginName = $('#loginName').val();--%>
                <%--var loginPwd = $('#loginPwd').val();--%>


                <%--var checkCode = $('#checkCode').val();--%>

                <%--$(form).find(":submit").attr("disabled", true);--%>
                <%--if (code == checkCode) {--%>
                    <%--$.ajax({--%>
                        <%--type: 'POST',--%>
                        <%--data: $("#loginForm").serialize(),--%>
                        <%--url: "<%=request.getContextPath()%>/loginController/laGouReg.do",--%>
                        <%--dataType: 'json',--%>
                        <%--success: function (data) {--%>
                            <%--if (data == 0) {--%>
                                <%--alert("注册失败");--%>
                            <%--} else if (data == 1) {--%>
                                <%--$.ajax({--%>
                                    <%--url: "<%=request.getContextPath()%>/loginController/updateUserIdByName.do",--%>
                                    <%--data: {loginName: loginName},--%>
                                    <%--success: function () {--%>
                                        <%--location.href = "<%=request.getContextPath()%>/LaGouLogin.jsp";--%>
                                    <%--},--%>
                                    <%--error: function () {--%>
                                        <%--alert("修改失败");--%>
                                    <%--}--%>

                                <%--})--%>
                            <%--}--%>
                        <%--},--%>
                        <%--error: function () {--%>

                            <%--alert("注册失败");--%>
                        <%--}--%>
                    <%--}).done(function (result) {--%>
                        <%--$('#resubmitToken').val(result.resubmitToken);--%>
                        <%--if (result.success) {--%>
                            <%--window.location.href = result.content;--%>
                        <%--} else {--%>
                            <%--$('#beError').text(result.msg).show();--%>
                        <%--}--%>
                        <%--$(form).find(":submit").attr("disabled", false);--%>
                    <%--});--%>
                <%--}else{--%>
                    <%--$('#codeError').text("验证码错误").show();--%>
                <%--}--%>
            <%--}--%>
        });
    });


    function submitLogin() {
        //验证表单
        var loginName = $('#loginName').val();
        var loginPwd = $('#loginPwd').val();
        var checkCode = $('#checkCode').val();
        if (code == checkCode) {
            $.ajax({
                type: 'POST',
                data: $("#loginForm").serialize(),
                url: "<%=request.getContextPath()%>/loginController/laGouReg.do",
                dataType: 'json',
                success: function (data) {
                    if (data == 0) {
                        alert("注册失败");
                    } else if (data == 1) {
                        $.ajax({
                            url: "<%=request.getContextPath()%>/loginController/updateUserIdByName.do",
                            data: {loginName: loginName},
                            success: function () {
                                location.href = "<%=request.getContextPath()%>/LaGouLogin.jsp";
                            },
                            error: function () {
                                alert("修改失败");
                            }

                        })
                    }
                },
                error: function () {

                    alert("注册失败");
                }
            }).done(function (result) {
                $('#resubmitToken').val(result.resubmitToken);
                if (result.success) {
                    window.location.href = result.content;
                } else {
                    $('#beError').text(result.msg).show();
                }
                $(form).find(":submit").attr("disabled", false);
            });
        }else{
            $('#codeError').text("验证码错误").show();
        }
    }


    //发送手机验证码
    $("#addSendCode").click(function(){
        var phone = $("#add_phone").val();
        $.ajax({

            url:"<%=request.getContextPath()%>/loginController/setPhone.do",
            data:{"phone":phone},
            type:"post",
            dataType:"json",
        })
    })
</script>
</body>
</html>
