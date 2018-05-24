<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="addUser_form">
       <table>
			<tr>
				<td>用户姓名:</td>
				<td>
					<input type="text" class="easyui-textbox" name="username"  data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>用户性别:</td>
				<td>
					<input type="radio" name="usersex" value="1" />&nbsp;男
					<input type="radio" name="usersex" value="2" />&nbsp;女
				</td>
			</tr>
			<tr>
				<td>登录账号:</td>
				<td>
					<input type="text" class="easyui-textbox" name="loginname"  data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>用户密码:</td>
				<td>
					<input type="text" class="easyui-textbox" name="pwd"  data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>所属部门:</td>
				<td>
					<select id="deptidShow_select_add" class="easyui-combobox" name="deptid" style="width:150px;" >
					</select>
				</td>
			</tr>
			<tr>
				<td>用户类型:</td>
				<td>
				<select id="typeShow_select_add" class="easyui-combobox" name="typeid" style="width:150px;" >
					</select>
<!-- 					<input type="text" class="easyui-textbox" name="typeid" id="typeid"  data-options="min:0"></input> -->
				</td>
			</tr>
		
		</table>
        </form>
        <script type="text/javascript">
        $('#deptidShow_select_add').combobox({    
		    url:'<%=request.getContextPath()%>/userController/querySeclect.do',    
		    valueField:'deptid',    
		    textField:'deptname',
		    onChange:(function(newValue,oldValue){
// 				newdeptValue = newValue;

			})
		})
        $('#typeShow_select_add').combobox({    
		    url:'<%=request.getContextPath()%>/userController/queryTypeListSelect.do',    
		    valueField:'typeid',    
		    textField:'typename',
		    onChange:(function(newValue,oldValue){
// 				newdeptValue = newValue;

			})
		})
        	<%-- $(function(){
        		//联系方式
        		
        			
        			$.ajax({
        				 url:"<%=request.getContextPath()%>/userController/querySeclect.do",
        				 type:"post",			 
        				 data:{"userid":userid},
        				 async:false,
        				 dataType:"json",
        				 success:function(data){
        					$(data).each(function(){
        						
        					})
        				 },
        				 error:function(){
        					 alert("联系方式程序错误")
        				 }
        			 })
        			 
        		
        	}) --%>
        
        </script>

</body>
</html>