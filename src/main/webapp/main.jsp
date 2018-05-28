<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理页面</title>
<!-- 这是jquery的核心包  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- 这是easyui的核心包  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/util-js.js"></script>
<!-- jqeuy默认的css样式 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/default/easyui.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui/themes/icon.css">
<!-- 中文样式 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- 上传文件 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadify/jquery.uploadify.min.js"></script>
<link  rel="stylesheet"  href="<%=request.getContextPath()%>/js/uploadify/uploadify.css"/>

<!-- Echars 主题引用 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Echars/customed.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Echars/echarts.min.js"></script>

</head>



<body class="easyui-layout" onload="historys()">

   <div data-options="region:'north',title:'上边',split:true" style="height:100px;" >
	<div style="float:right">
		<font size="3" >欢迎</font>&nbsp; 
		<font size="5" color="red">${user.username }</font>
		&nbsp; <font size="3" >登陆</font>
	   	<br>
	   <button id="loginOut" class="easyui-linkbutton" data-options="iconCls:'icon-remove'"
		style="float:right">注销</button>
	 </div>
   </div>   
    <div data-options="region:'west',title:'左边',split:true" style="width:200px;">

	    <div id="aa" data-options="fit:true" class="easyui-accordion" style="width:300px;height:200px;">   
	    <div title="系统菜单" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;background-color:#b0e0e6">   
	          <div id="tt" class="easyui-tree">   
	          
              </div>  
	    </div>   
	    <%--<div title="等待开发" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;background-color:#b0e0e6">--%>
	          <%--<div id="tt2" class="easyui-tree">--%>
              <%--</div>--%>
	    <%--</div>--%>
	       
	</div>  
    </div>   
    <div  data-options="region:'center',title:'中间'" style="padding:5px;background-color:#b0e0e6">

    	<div id="tabs" class="easyui-tabs" data-options="fit:true" style="background-color:#b0e0e6">
			<table id="history">


			</table>
		</div>
    </div>
    
    
  
    <script type="text/javascript">

        <%--$(function(){--%>
            <%--$('#history').datagrid({--%>
                <%--url:"<%=request.getContextPath()%>/loginController/getHistory.do",--%>
                <%--fitColumns:true,--%>
                <%--striped:true,--%>
                <%--ctrlSelect:true,--%>
                <%--pagination:true,--%>
                <%--pagePosition:"bottom",//放在底部--%>
                <%--pageNumber:1,--%>
                <%--pageSize:3,--%>
                <%--pageList: [3,8,12,16],--%>
                <%--columns:[[--%>
                    <%--{field:'title',title:'标题',width:100},--%>
                    <%--{field:'pic',title:'图片',width:100,--%>
                        <%--formatter:function(value,row,index){--%>
                        <%--alert(row.pic);--%>
                            <%--return "<img src='row.pic' width='80' height='80'>";--%>
                        <%--}},--%>
                    <%--{field:'des',title:'描述',width:150},--%>
                    <%--{field:'lunar',title:'时间',width:100},--%>
                <%--]]--%>
            <%--});--%>

        <%--})--%>


    $("#loginOut").click(function(){
    	 location.href="<%=request.getContextPath()%>/loginController/loginOut.do";
    })
    
      $("#tt").tree({
    	  
    	  url:"<%=request.getContextPath()%>/treeController/getRoleTreeList.do",
    	  method:"post",
    	  
    	  onSelect:function(node){
    		  
    		  if(node.url !="" && node.url !=null){
    		   var flag= $('#tabs').tabs('exists',node.text);
    			  if(flag){
    				  
    				  $('#tabs').tabs('select',node.text);
    			  }else{
    			  
    			//alert(node.text);  // 在用户点击的时候提示
    			$('#tabs').tabs('add',{    
    				iconCls:'icon-filter',
    			    title:node.text,    
    			    href:"<%=request.getContextPath()%>/"+node.url,    
    			    closable:true,    
    			    tools:[{    
    			        iconCls:'icon-mini-refresh',    
    			        handler:function(){    
    			        }
    			    }]    
    			}); 
    			}
    		  }
    		},

    	  parentField:'pid',//实体类定义的pid一致
    	   
      })
    
    <%--function historys() {--%>
        <%--$.ajax({--%>
            <%--url:"<%=request.getContextPath()%>/loginController/getHistory.do",--%>
            <%--data:{"phone":phone},--%>
            <%--type:"post",--%>
            <%--dataType:"json",--%>
            <%--success:function () {--%>
                <%--$("#history").html();--%>
            <%--},--%>
        <%--})--%>
    <%--}--%>


    </script>

	
</body>
</html>