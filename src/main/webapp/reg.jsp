<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>阿里巴巴第七组</title>
<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" src="<%=request.getContextPath() %>/js/css/default.min.css">
<link rel="stylesheet" src="<%=request.getContextPath() %>/js/css/style.css" />
</head>

<style>
.wrap{
	width:1500px;
	height:750px;
}  
.cell{  
 margin-bottom:10px;
	/* top:0px;
 	 width:5px;
	 height:5px; */
}  
.codeerror{  

 	 width:200px;
	 height:40px; 
}  
.checked{  
  border: 2px solid #c00;  
  padding: 6px 6px 6px 6px;  
} 
.container{
 margin-bottom:10px;
}
 .register-box{

	width:400px;
	height:540px;
	 padding: 6px 6px 6px 6px;
} 
 .reg-form{
	height:5px;
 	padding: 6px 6px 6px 6px; 
} 
.css{

	background: url(images/timg1.jpg);
	height:750px;
}

</style>


<!-- inpit/assembly 1.4 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/inpitassembly-2.0.js"></script>

<!-- inpit/assembly 2.1 ~ 2.3 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/inpitassembly-2.0.js"></script>
<!-- jquery 2.1 -->				
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>

<!-- inpit/assembly 2.0 +  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/inpitassembly-2.0.js"></script>
		
<!-- 这是jquery的核心包  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- 这是easyui的核心包  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/util-js.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>


<!-- jqeuy默认的css样式 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/default/easyui.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/icon.css">
<script>
function F5(obj){
	obj.src="<%=request.getContextPath()%>/loginController/validateCode.do?"+Math.random();
} 


</script>
<body>

<!-- 代码begin -->
<div class="wrap">
	<div class="banner-show" id="js_ban_content">
		<div class="css" >
			<div class="con">
			</div>
		</div>
		<div class="cell bns-02" style="display:none;">
			<div class="con">
				<a href="" target="_blank" class="banner-link">
				<i>求职</i></a> </div>
		</div>
		<div class="cell bns-03" style="display:none;">
			<div class="con">
				<a href="" target="_blank" class="banner-link">
				<i>求职</i></a> </div>
		</div>
	</div>
	<!-- <div class="banner-control" id="js_ban_button_box">
		<a href="javascript:;" class="left">左</a>
		<a href="javascript:;" class="right">右</a> </div> -->
<form id="zhuce">
	<div class="container">
		<div class="register-box">
			<div class="reg-slogan">
				用户注册</div>
			<div class="reg-form" id="js-form-mobile">
				
				<div class="cell" style="width:20px,height:20px" >
					<input type="text" name="loginname" id="loginname" class="text" maxlength="11" placeholder="登录名" />
				</div>
				
				<div class="cell">
					
					<input type="password" name="pwd" id="pwd_ipt" class="text" height="10px" placeholder="请输入密码"/>
					 </div>
				
				<div class="cell">
					
					<input type="password" name="pwd1" id="pwd_ipt1" class="text" height="20px" placeholder="确认密码"/>
					 </div> 
				<div class="cell">
					
					<input type="text" name="username" id="username" class="text" height="20px" placeholder="姓名"/>
					 </div> 
					 <!-- <div>  
			注册职位:  <span class='unchecked'  name='typeid' value ="1"  checked='false' onclick='change(this);' >公司职员</span> 
					<span class='unchecked' name='typeid' value ="2" checked='false' onclick='change(this);' >应聘者</span>  
					<span class='unchecked' name='typeid' value ="3" checked='false' onclick='change(this);' >企业</span>  
			</div>  <br> -->
				<font size="3">注册职位:&nbsp;&nbsp;<input type="radio" name="typeid" value="1">公司职员&nbsp;&nbsp;
				<input type="radio" name="typeid" value="3">企业&nbsp;&nbsp;
				<input type="radio" name="typeid" value="2">应聘者</font><br><br>
				<!-- 确认密码:<div class="cell">
					
					<input type="password" name="pwd1" id="pwd_ipt1" class="text" />
					 </div>  -->
				
					 <input type="tel" class="codeerror" id="add_phone" value="" name="userphone" placeholder="请输入您的手机号码" />
						<input type="button" class="close_tel" id="addSendCode" value="获取验证码" onClick="sendAddmes()" style="width:100px;height:40px"/><br><br>
					<input type="number" name="checkPhone" class="codeerror" id="code" value="" placeholder="请输入验证码" /><br><br>
				<%-- 输入验证码<div class="cell vcode">
					<input type="text" name="checkcode" id="code_ipt" class="text" maxlength="6" />
					<img id="codeimg" src="<%=request.getContextPath()%>/loginController/validateCode.do" onclick="F5(this)"/><br/>
					<span id = "message"></span>
					 </div> --%>
				
				<div class="bottom">
					<a id="js-mobile_btn" href="javascript:;" class="button btn-green">
					立即注册</a></div>
			</div>
			
		</div>
	</div>	
</form>	
	

</div>
<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
<script type="text/javascript">

$("#addSendCode").click(function(){
		var phone = $("#add_phone").val();
	$.ajax({
		
		url:"<%=request.getContextPath()%>/loginController/setPhone.do",
		data:{"phone":phone},
		type:"post",
		dataType:"json",
	})
})

//用户注册
$("#js-mobile_btn").click(function(){
	$.ajax({
			url:"<%=request.getContextPath()%>/loginController/addUser.do",
	
			data:$("#zhuce").serialize(),
			type:"post",
			dataType:"json",
			success:function(datas){
				if(datas !="注册成功"){
					alert(datas)
				 $.messager.alert('提示',datas);
				}else if(datas="注册成功"){
					 location.href="login.jsp";
				}
			},error:function(){
				alert('警告','报错了','warning'); 
			}
		
		})
			
			
			
			
			
			
			
			
		<%-- 	
			type:"post",
			data:$("#zhuce").serialize(),
			dataType:"json",
			async:false,
			success:function(result){
				if (result==3) {
					
					location.replace("<%=request.getContextPath()%>" + '/main.jsp');
	
				}if(result==2){
					location.replace("<%=request.getContextPath()%>" + '/Deptment.jsp');
					
				}if(result==1){
					location.replace("<%=request.getContextPath()%>" + '/showtree.jsp');
					
				}if(result==4){
					alert("登录名不能为空");
					$("#js_ban_content").datagrid("reload");
				}if(result==5){
					alert("密码不能为空");
					$("#js_ban_content").datagrid("reload");
				}else{
					$.messager.alert('提示', result, '登录失败', function() {
						$('#loginBtn').linkbutton('enable');
					});
				}
				
				},
			error:function(){
				alert("登录失败，请联系管理员！");
				}	
		}) --%>
	
		})



		
		
		
		
		
            (function(){
                    
                    var defaultInd = 0;
                    var list = $('#js_ban_content').children();
                    var count = 0;
                    var change = function(newInd, callback){
                        if(count) return;
                        count = 2;
                        $(list[defaultInd]).fadeOut(400, function(){
                            count--;
                            if(count <= 0){
                                if(start.timer) window.clearTimeout(start.timer);
                                callback && callback();
                            }
                        });
                        $(list[newInd]).fadeIn(400, function(){
                            defaultInd = newInd;
                            count--;
                            if(count <= 0){
                                if(start.timer) window.clearTimeout(start.timer);
                                callback && callback();
                            }
                        });
                    }
                    
                    var next = function(callback){
                        var newInd = defaultInd + 1;
                        if(newInd >= list.length){
                            newInd = 0;
                        }
                        change(newInd, callback);
                    }
                    
                    var start = function(){
                        if(start.timer) window.clearTimeout(start.timer);
                        start.timer = window.setTimeout(function(){
                            next(function(){
                                start();
                            });
                        }, 8000);
                    }
                    
                    start();
                    
                    $('#js_ban_button_box').on('click', 'a', function(){
                        var btn = $(this);
                        if(btn.hasClass('right')){
                            //next
                            next(function(){
                                start();
                            });
                        }
                        else{
                            //prev
                            var newInd = defaultInd - 1;
                            if(newInd < 0){
                                newInd = list.length - 1;
                            }
                            change(newInd, function(){
                                start();
                            });
                        }
                        return false;
                    });
                    
                })
</script>
<!-- 代码 end -->
</body>
</html>
