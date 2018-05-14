<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/10
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<!-- 这是jquery的核心包  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- 这是easyui的核心包  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/util-js.js"></script>
<!-- jqeuy默认的css样式 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/default/easyui.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/icon.css">

<body>


<table id="dg">


</table>
<script type="text/javascript">0
    $(function(){
        $('#dg').datagrid({
            url:'<%=request.getContextPath()%>/userController/queryUserInfo.do',
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
                {field:'name',title:'名称',width:100},
                {field:'age',title:'年龄',width:100}

            ]]
        });

    })


</script>

</body>
</html>
