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
	<table>
			
				<tr>
				<td>用户姓名:</td>
				<td>
					<input type="text" disabled class="easyui-textbox" name="username" value="${user.username }" data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>用户性别:</td>
				<td>
					<input type="text" class="easyui-textbox" name="usersex" disabled  data-options="min:0" 
						<c:if test="${user.usersex==1 }">value="男"</c:if>
						<c:if test="${user.usersex==2 }">value="女"</c:if>
					></input>
				</td>
			</tr>
			<tr>
				<td>登录名称:</td>
				<td>
					<input type="text" class="easyui-textbox" disabled name="loginname" value="${user.loginname }"  data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>用户密码:</td>
				<td>
					<input type="text" class="easyui-textbox" disabled name="pwd" value="${user.pwd }"  data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>所属部门:</td>
				<td>
					<input type="text" class="easyui-textbox" disabled name="deptid" id="deptid" value="${user.deptname }"  data-options="min:0"></input>
				</td>
			</tr>
			<tr>
				<td>用户类型:</td>
				<td>
					<input type="text" class="easyui-textbox" disabled name="typeid" id="typeid" value="${user.typename }"  data-options="min:0"></input>
				</td>
			</tr>

</body>
</html>