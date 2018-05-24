<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <input type="hidden" id="roleId" value="${roleId }">
     <div class="easyui-tree" id="tree_role"></div>
     <script type="text/javascript">
       $(function(){
    	   $.ajax({
    		   url:"<%=request.getContextPath()%>/treeController/queryRoleTree.do",
    		   data:{"roleId":$("#roleId").val()},
    		   type:"post",
    		   dataType:"json",
    		   success:function(data){
    			   $("#tree_role").tree({
    				   method:"post",
    			      checkbox:true,
    			      parentField:'pid',//实体类定义的pid一致
    			      data:data
    			   })
    		   },error:function(){
    			   alert("000");
    		   }
    		   
    	   })
       })
     
     </script>
</body>
</html>