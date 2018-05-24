<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 定义编辑表单 -->
	<form id="editForm">
		<input type="hidden" name="roleId" value="${role.roleId }">
		员工名称<input name="roleName" class="easyui-textbox"
			required="requirde" value="${role.roleName }" />
	</form>
	<script type="text/javascript">

	function return_edit_emp_data(){
		
		return $("#editForm").serialize();
		
	} 

</script>
</body>
</html>