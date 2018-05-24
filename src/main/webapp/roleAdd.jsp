<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="role-form" method="post">
	角色称呼：<input name="roleName"><br>
	<br>
</form>
<script type="text/javascript">

	function return_edit_emp_data(){
		
		return $("#role-form").serialize();
		
	} 

</script>
</body>
</html>