<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="update_form">
		<font color="red">因为密码是保密项目,请重新设定</font>
					<input type="hidden"  name="userid"  value="${user.userid }" style="width:100px">
       <table>
			
				<tr>
				<td>用户姓名:</td>
				<td>
					<input type="text" class="easyui-textbox" name="username" value="${user.username }" data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>用户性别:</td>
				<td>
				
					<input type="radio" name="usersex" value="1"
						<c:if test="${user.usersex==1 }">checked</c:if>
					/>&nbsp;男
					<input type="radio" name="usersex" value="2" 
						<c:if test="${user.usersex==2 }">checked</c:if>
					/>&nbsp;女
					
				</td>
			</tr>
			<tr>
				<td>登录名称:</td>
				<td>
					<input type="text" class="easyui-textbox" name="loginname" value="${user.loginname }"  data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>用户密码:</td><!-- value="${user.pwd }" -->
				<td>
					<input type="text" class="easyui-textbox" name="pwd"   data-options="min:0,required:true"></input>
				</td>
			</tr>
			<tr>
				<td>所属部门:</td>
				<td>
					<input id="deptidShow_select_update" class="easyui-combobox" name="deptid" value="${user.deptid }" style="width:150px;" />
					
					<%-- <input type="text" class="easyui-textbox" name="deptid" id="deptid" value="${user.deptid }"  data-options="min:0"></input> --%>
				</td>
			</tr>
			<tr>
				<td>用户类型:</td>
				<td>
					<input id="typeShow_select_update" class="easyui-combobox" value="${user.typeid }" name="typeid" style="width:150px;"/>
					
					<%-- <input type="text" class="easyui-textbox" name="typeid" id="typeid" value="${user.typeid }"  data-options="min:0"></input> --%>
				</td>
			</tr>
			
			
			
		</table>
        </form>
        <script type="text/javascript">
        $('#deptidShow_select_update').combobox({    
		    url:'<%=request.getContextPath()%>/userController/querySeclect.do',    
		    valueField:'deptid',    
		    textField:'deptname',
		    onChange:(function(newValue,oldValue){
// 				newdeptValue = newValue;
			})
		})
		
        $('#typeShow_select_update').combobox({    
		    url:'<%=request.getContextPath()%>/userController/queryTypeListSelect.do',    
		    valueField:'typeid',    
		    textField:'typename',
		    onChange:(function(newValue,oldValue){
// 				newdeptValue = newValue;

			})
		})
        
        </script>

</body>
</html>