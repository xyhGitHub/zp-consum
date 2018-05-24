<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <!-- 这是jquery的核心包  -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <!-- 这是easyui的核心包  -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/util-js.js"></script>
    <!-- jqeuy默认的css样式 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/default/easyui.css">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/icon.css">

</head>
<body>

			<nav class="navbar navbar-default" align="center" style="background:#4F2F4F;height:100px;">
			  <div class="container-fluid"  align="center">
			     	 <h1 style="color:#FAFAD2"><center><b>欢迎登录诚聘管理系统 <b></center></h1>
			  </div>
			</nav>

            <table id="dg">


            </table>
		

    <script type="text/javascript">

        $(function(){
            $('#dg').datagrid({
                url:"<%=request.getContextPath()%>/treeController/queryputongTree.do",
                fitColumns:true,
                striped:true,
                ctrlSelect:true,
                pagination:true,
                pagePosition:"bottom",//放在底部
                pageNumber:1,
                pageSize:3,
                pageList: [3,8,12,16],
                columns:[[
                    {field:'id',title:'编号',width:100},
                    {field:'text',title:'名称',width:100},
                ]]
            });

        })


    </script>

</body>
</html>