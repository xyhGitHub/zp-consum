<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- 这是easyui的核心包  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/util-js.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>


<!-- jqeuy默认的css样式 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/default/easyui.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/icon.css">

<title>Insert title here</title>
</head>
<body>
<form id="roleShow_form">
	<input type="hidden" name="userId" value="${k.userid}" id="userId"/><br>
	<div id ="roleShow_checkbox">
		<c:forEach items="${k.list}" var="p">		
			<input type="checkbox" name="roleId" value="${p.roleId }" checked>${p.roleName }
		
		</c:forEach>
	</div>	
</form>
	<script type="text/javascript">
			
			 $.ajax({
				 url:"<%=request.getContextPath()%>/userController/getRoleAll.do",
				 type:"post",
				 dataType:"json",
				 async:false,
				 success:function(data){
					 var str ="";
					 var arr =$('[name="roleId"]');
					 $.each(data,function(){
						var id = this.roleId;
						var f = true;
						$.each(arr,function(){
							//alert($(this).val());
							if($(this).val() == id){
								f = false;
							}
						})
						if(f){
							str += '<input type="checkbox" name="roleId" value="'+this.roleId+'">'+this.roleName;
						}
						
					 })
					 
					 $("#roleShow_checkbox").append(str);
				 },
				 error:function(){
					 alert("查询用户角色程序错误")
				 }
			 })
			 

		
	</script>
</body>
</html>