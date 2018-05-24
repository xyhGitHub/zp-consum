
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="powe_tree"></div>
<div id="add_tree"></div>
<div id="dialog_update"></div>
 
      <div id="mm" class="easyui-menu" style="width:120px;">
	   <div onclick="addtree()" data-options="iconCls:'icon-add'">追加</div>
	   <div onclick="remove()" data-options="iconCls:'icon-remove'">移除</div>
	   <div onclick="edittree()" data-options="iconCls:'icon-remove'">修改</div>
      </div>

   
   <script type="text/javascript">
   $("#powe_tree").tree({
	 	  
	 	  url:"<%=request.getContextPath()%>/treeController/treelist.do",
	 	  method:"post",
	 	  checkbox:true,
	 	  parentField:'pid',//实体类定义的pid一致
	 	 onContextMenu: function(e, node){
	 		e.preventDefault();
	 		// 查找节点
	 		$('#powe_tree').tree('select', node.target);
	 		// 显示快捷菜单
	 		$('#mm').menu('show', {
	 			left: e.pageX,
	 			top: e.pageY
	 		});
	 	}

	   })
	   
 function addtree(){
	   var node=$("#powe_tree").tree("getSelected");//得到查询的内容
	   
	   $("#add_tree").dialog({
		   title: '新增用户',    
		    width: 400,    
		    height: 200,    
		    closed: false,    
		    cache: false,
		    href:"<%=request.getContextPath()%>/treeController/toTree.do?id="+node.id,
		    modal: true ,//他是干啥的？
		    toolbar:[{
		    	text:'保存',
				iconCls:'icon-edit',
				handler:function(){
					$.ajax({
						url:"<%=request.getContextPath()%>/treeController/addTree.do",
						data:$("#add_form").serialize(),
						dataType:"json",
						type:"post",
						success:function(){
							$("#add_tree").dialog("close");
							$("#powe_tree").tree("reload");
							
						},error:function(){
							 $.messager.alert('警告','1报错'); 
						}
					})
					
				}
		    	
		    },{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog_update").dialog("close");
				}

				}]
	   
	   })
	   
	   
	   
   }
	   
   	function remove(){
   	 var node=$("#powe_tree").tree("getSelected");
	   	//	alert(node)
			    	$.ajax({
			    		url:"<%=request.getContextPath()%>/treeController/deleteTrees.do",
			    		data:{"id":node.id},
			    		type:"post",
			    		success:function(){
			    			$("#powe_tree").tree("reload");
			    			$("#tt").tree("reload");
			    		},error:function(){
			    			 $.messager.alert('警告','报错'); 
			    		}
			    		
			    			
			    	})
			    }   
			
   		
   		function edittree(){
   	 	   var node=$("#powe_tree").tree("getSelected");
   	 	  // alert(node.id)
				  $("#dialog_update").dialog({
     			  title:"修改用户",
     			  width: 400,    
       		      height: 200,    
       		      closed: false,    
       		      cache: false,
       		      href:"<%=request.getContextPath()%>/treeController/toUpdateTree.do?id="+node.id,
       		    toolbar:[{
     				text:'保存',
     				iconCls:'icon-edit',
     				handler:function(){
     				//	alert($("#update_form").serialize());
     					$.ajax({
     						url:"<%=request.getContextPath()%>/treeController/updateTree.do",
     						data:$("#update_form").serialize(),
     						dataType:"json",
     						type:"post",
     						success:function(data){
     							$("#dialog_update").dialog("close");
     							$("#tt").tree("reload");
     							$("#powe_tree").tree("reload");
     							
     						},error:function(){
     							 $.messager.alert('警告','报错'); 
     						}
     					})
     					
     				}
     			},{
     				text:'取消',
     				iconCls:'icon-cancel',
     				handler:function(){
     					$("#dialog_update").dialog("close");
     				}
     			}]
     		  })
   			
   		}
   
   </script>
   
</body>
</html>