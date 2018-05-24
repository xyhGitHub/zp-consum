<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/my97/WdatePicker.js" ></script> --%>
<jsp:include page="common.jsp"  flush="true"></jsp:include>
</head>
<body>
	
	<!-- 定义面板容器 -->
	<div id="role_tree"></div>
	<div class="easyui-panel" style="height:70%; padding:0px; margin:opx">
		<span id ="rolebtnSpan" style="display:none">
				<div id="role_edit_btn" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</div>	
				<div id="role_tree_btn" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">分配权限</div>	
		</span>
		<!-- 定义表格容器 -->
		<table id="role_dg"></table>
		
		<!-- 定义工具栏容器 -->
		
		<div id="role_tool_div">
			<div onclick="open_role_add_dialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</div>
			<div onclick="delete_all_checked_role()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</div>
		</div>
		
	</div>
	<script type="text/javascript">
	$(function(){
		//加载数据
		$('#role_dg').datagrid({
	    url:"role/queryRole.do",
	    fit:true,
	     //按ctrl多选
	     ctrlSelect:true,
	    //开启分页
	    pagination:true,
	    //每页条数
	    pageSize:3,
	    pageList:[1,3,5,7,9],
	    //引入工具栏
	    toolbar:"#role_tool_div",
	    columns:[[
	        {field:'roleId',title:'角色id',width:300},
	        {field:'roleName',title:'角色称呼',width:300},
	        {field:'sdfsdf',title:'操作',width:150,
	        	formatter:function(value,row,index){
	        		$("#role_edit_btn").attr("onClick","open_role_edit_dialog("+row.roleId+")");
	        		$("#role_tree_btn").attr("onClick","open_role_tree_dialog("+row.roleId+")");
        				return $("#rolebtnSpan").html();
      			  }},
	   	 	]],
		});

	});
	
	//重置方法
	function emp_search_reset(){
		
		$("#role_from_search").form("reset");
		
	}
	
	//打开添加对话框
	function open_role_add_dialog(){
		var role_add_dialog = $("<div></div>").dialog({
			title:"添加角色",
			width: 400,    
			height: 400,    
			href:"role/toRoleAdd.do",
			modal: true,
		    buttons:[{
				text:'保存',
				handler:function(){
					$('#role-form').form('submit', {    
					    url:"<%=request.getContextPath()%>/role/insertRole.do",    
					    onSubmit: function(){    
					    	return $('#role-form').form('validate');
					    },    
					    success:function(data){
					    	
							alert("角色添加成功");  
							role_add_dialog.dialog("destroy");
					    	   $('#role_dg').datagrid('reload')
					    }    
					}); 
					
				}
			},{
				text:'关闭',
				handler:function(){
					
					role_add_dialog.dialog("destroy");
				}
			}]
		}); 
	}
	//批量删除选中的员工
	function delete_all_checked_role(){
		var arr = $('#role_dg').datagrid("getSelections");
		if(0<arr.length){
			$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
			    if (r){
			   		var aa="";
			        for(var i=0;i<arr.length;i++){
			       	  aa+=arr[i].roleId+",";
			        }
			        //ajax删除数据
			        $.ajax({
			        	url:"<%=request.getContextPath()%>/role/deleteRoleByIds.do?",
			        	type:"post",
// 			        	dataType:"json",
			        	data:{ids:aa},
			        	success:function(data){
			        		$.messager.alert('提示','删除成功');
			        		//刷新数据表格
							$('#role_dg').datagrid("load");
			        	}
			        })
			    }    
			});  
		}else{
			$.messager.alert('提示','请至少选择一条数据');  
		}
	}
	
	//打开员工编辑对话框
	function open_role_edit_dialog(roleId){
		$("#role_tree").dialog({
			title:"编辑员工",
			href:"<%=request.getContextPath()%>/role/toRoleById.do?roleId="+roleId,
			modal:true,
			width:900,
			height:490,
			buttons:[{
				text:'保存',
				iconCls:"icon-add",
				handler:function(){
					//ajax向后台发送添加请求 回调函数中销毁对话框  刷新数据表格
					$.ajax({
							url:"role/updateRoleById.do",
							type:"post",
							data:return_edit_emp_data(),
// 							dataType:"json",
							success:function(data){
								alert("修改成功");
								//销毁对话框
								$('#role_tree').dialog("close");
					    	   $('#role_dg').datagrid('reload')
							},
							
						})
				}
			},{
				text:'取消',
				iconCls:"icon-cancel",
				handler:function(){
					//销毁对话框
					$("#role_tree").dialog("close");
// 					$('#role_dg').datagrid('reload')
				}
			}]
		})
	}
	function open_role_tree_dialog(roleId){
		$("#role_tree").dialog({
			title:"分配权限",
			href:"<%=request.getContextPath()%>/role/toRoleTreeById.do?roleId="+roleId,
			modal:true,
			width:900,
			height:490,
			buttons:[{
				text:'保存',
				iconCls:"icon-edit",
				handler:function(){
					var node=$("#tree_role").tree("getChecked");
  					var ids ="";
  					 for (var i = 0; i < node.length; i++) {
						ids+=","+node[i].id;
					}
  					 ids=ids.substring(1);
					//ajax向后台发送添加请求 回调函数中销毁对话框  刷新数据表格
					$.ajax({
						url:"<%=request.getContextPath()%>/treeController/addTreeRoleRelation.do?ids="+ids+"&roleId="+roleId,
									dataType:"json",
		      						type:"post",
// 							data:return_edit_emp_data(),
// 							dataType:"json",
							success:function(data){
								alert("修改成功");
								//销毁对话框
									$("#role_tree").dialog("close");
// 								emp_edit_dialog.dialog("destroy");
// 					    	   $('#role_dg').datagrid('reload')
							},
							
						})
				}
			},{
				text:'取消',
				iconCls:"icon-cancel",
				handler:function(){
					//销毁对话框
					$("#role_tree").dialog("close");
				}
			}]
		})
	}
	</script> 
</body>
</html>