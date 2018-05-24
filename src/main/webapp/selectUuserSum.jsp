<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="tata">
<input type="text" id="salarysum1" value="${salarysum}"/>
<input type="text" id="salarysum2" value="${salarysum2}"/>

</div>  


<script type="text/javascript">


$(function(){
	var salarysum=$("#salarysum1").val();
	var salarysum2=$("#salarysum2").val();

	$('#tata').datagrid({    
	    url:'<%=request.getContextPath()%>/salaryController/selectuser.do?salarysum='+salarysum+"&salarysum2="+salarysum2, 
	    //自适应行
	    fitColumns:true,
	    //是否显示斑马线效果。
	    striped:true, 
	    //允许使用Ctrl键+鼠标点击的方式进行多选操作
	    columns:[[    
	    			{field:'userid',title:'主键id',width:100},    
	    			{field:'username',title:'用户姓名',width:100},    
	    			{field:'usersex',title:'用户性别',width:100,
	    				//value：字段值。row：行记录数据。index: 行索引。 
	    				formatter: function(value,row,index){
	    					if(value == 1){
	    						return "男";
	    					}
	    					if(value == 2){
	    						return "女";
	    					}
	    				}
	    			},    
	    ]]    
   
	});  
})






</script>
</body>
</html>