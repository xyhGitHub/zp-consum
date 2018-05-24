<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="update_form">
				<input  type="hidden" value="${tree.id}" name="id" />
				<input  type="hidden" value="${tree.pid}" name="pid" />
               tree名：<input class="easyui-textbox" value="${tree.text }" name="text" style="width:100px"> <br>
               tree的url：<input class="easyui-textbox" value="${tree.url }" name="url" style="width:100px"> <br>
	</form>

</body>
</html>