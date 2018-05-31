<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	
</head>
<body>
		<div id="u" class="easyui-panel" title="My Panel"     
        style="width:100%;height:220px;padding:10px;"   
        data-options="iconCls:'icon-save',closable:true,    
                collapsible:true,minimizable:true,maximizable:true"> 
                  
	 	<form id="ff" >   
		<div> 
		 <%--@declare id="username"--%><label for="username">用户姓名:</label>
	        <input class="easyui-textbox" id="usernamecriteria"  type="text" name="usernamecriteria" data-options="" />  
	       <br/>
	        <label for="username">用户类型:</label>
	            <select id="userlxShow_select" class="easyui-combobox" name="typeidcriteria" style="width:200px;"></select>
	        	
			
			<br/>
			
			 <label for="username">登录账号:</label>  
			  <input class="easyui-textbox" id="loginnamecriteria"  type="text" name="loginnamecriteria" data-options="" /> 
	      
	        <br/>
				
	       	  用户性别:
	        <input type="radio" name="usersexcriteria" value="1" />&nbsp;男
			<input type="radio" name="usersexcriteria" value="2" />&nbsp;女 
	           <br/>
	    </div>   
	    
	</form>  
	
    <div id="btn" href="#" class="easyui-linkbutton" onclick="whereSelect()" data-options="iconCls:'icon-search'">查询</div>    
   <br/>
    <div id="resetButton" href="#" class="easyui-linkbutton" onclick="resetButton()" data-options="iconCls:'icon-flush'">重置</div>    
	</div>  
	
	<div id="dialog_addUser"></div>  
	<div id="dialog_xg"></div> 
	<div id="showResume_dialog"></div> 
	
	
	<table  id="ta">  
		<div id="tbb">
		<div  class="easyui-linkbutton" onclick="addUser()" data-options="iconCls:'icon-add',plain:true">新增</div>
		<div  class="easyui-linkbutton" onclick="deleteUsers()" data-options="iconCls:'icon-remove',plain:true">删除</div>
		<div  class="easyui-linkbutton" onclick="updateUserById()" data-options="iconCls:'icon-edit',plain:true">修改</div>
		</div>
		
	</table>
	<div id="usershow_dialog"></div>
	
	
	
	
	
		<script type="text/javascript">
	function resetButton(){
			$("#ff")[0].reset();
			$("#usernamecriteria").val("");
			$("#usersexcriteria").val("");
			$("#deptidcriteria").val("");
			$("#typeidcriteria").val("");
			$("#loginnamecriteria").val("");
			

		}
		
		 
		//刷新页面查询数据
		
		$(function(){
			$('#ta').datagrid({    
			    url:'<%=request.getContextPath()%>/userController/queryUserList.do', 
			    //自适应行
			    fitColumns:true,
			    //是否显示斑马线效果。
			    striped:true, 
			    //允许使用Ctrl键+鼠标点击的方式进行多选操作
			    ctrlSelect:true,
			    //如果为true，则在DataGrid控件底部显示分页工具栏
			    pagination:true,
			    //放在底部
			    pagePosition:"bottom",
			    //开始条数
			    pageNumber:1,
			    //每页条数
				pageSize:3,
				//设置分页属性的时候 初始化页面大小选择列表
				pageList: [1,3,8,12,16],
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
			        {field:'loginname',title:'登录账号',width:100},    
			        {field:'pwd',title:'登录密码',width:100},    
			        {field:'deptname',title:'所属部门',width:100},    
			        {field:'typename',title:'用户类型',width:100},    
			        {field:'',title:'分配角色', width:100,
						formatter: function(value,row,index){
							var st = "";
							//分配角色
// 							st += "<button  onclick=setRoles('"+row.userid+"') data-options='iconCls:'icon-add',plain:true'>分配角色</button>";
							
							if(row.typeid == 1){
								st+= "<button  onclick=setRoles('"+row.userid+"') data-options='iconCls:'icon-add',plain:true'>分配角色</button>";
								//职工,分配角色
								return st;
							
							}else if(row.typeid == 2){
								//求职者,查看简历
								st+= "<button  onclick=lookResume('"+row.userid+"') data-options='iconCls:'icon-add',plain:true'>查看简历</button>";
								return st;
							
							}else if(row.typeid == 3){
								//企业,查看公司名称
								st+= "<button  onclick=lookCompany('"+row.userid+"') data-options='iconCls:'icon-add',plain:true'>查看公司</button>";
								return st;
								
							}else{
								//联系方式
								st+= "<button  onclick=lookPhone('"+row.userid+"') data-options='iconCls:'icon-add',plain:true'>联系方式</button>";
								return st;
							}
							
								
						}
					}
			    ]]    
			});  
		})
		
		//联系方式
		function lookPhone(userid){
			
			$.ajax({
				 url:"<%=request.getContextPath()%>/userController/lookCompany.do",
				 type:"post",			 
				 data:{"userid":userid},
				 async:false,
				 dataType:"json",
				 success:function(data){
					$.messager.alert("联系方式",data.username+"  的联系方式为:  "+data.userphone);
				 },
				 error:function(){
					 alert("联系方式程序错误")
				 }
			 })
			 
		}
		
		//查看公司名称
		function lookCompany(userid){
			$.ajax({
				 url:"<%=request.getContextPath()%>/userController/lookCompany.do",
				 type:"post",			 
				 data:{"userid":userid},
				 async:false,
				 dataType:"json",
				 success:function(data){
					$.messager.alert("所属公司",data.username+"  所属的公司为:  "+data.companyname);
				 },
				 error:function(){
					 alert("查看公司名称程序错误")
				 }
			 })
			
		}
		//查看简历
		function lookResume(userid){
			$('#showResume_dialog').dialog({    
			    title: '查看简历',   
			    href:"<%=request.getContextPath()%>/userController/queryUserResumeList.do?typeidcriteria="+userid,
			    width: 400,    
			    height: 200,    
			    closed: false,    
			    cache: false,        
			    modal: true ,
			    toolbar:[{
					text:'简历详情',
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						$("#usershow_dialog").dialog("close");
					}
					
					
				}]

			});
		}
		//查看公司
		function setType(typeid){
			$('#usershow_dialog').dialog({    
			    title: 'My Dialog',   
			    href:"<%=request.getContextPath()%>/userController/queryRoleByUserid.do?id="+id,
			    width: 400,    
			    height: 200,    
			    closed: false,    
			    cache: false,        
			    modal: true ,
			    toolbar:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						$.ajax({
							 url:"<%=request.getContextPath()%>/userController/saveRolesByUserId.do",
							 type:"post",			 
							 data:$("#roleShow_form").serialize(),
							 async:false,
							 dataType:"text",
							 success:function(data){
								 $("#usershow_dialog").dialog("close");
								 $("#ta").datagrid("reload");
							 },
							 error:function(){
								 alert("查询用户角色程序错误")
							 }
						 })
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						$("#usershow_dialog").dialog("close");
					}
				}]

			});
		}
	//分配角色
		function setRoles(id){
			$('#usershow_dialog').dialog({    
			    title: 'My Dialog',   
			    href:"<%=request.getContextPath()%>/userController/queryRoleByUserid.do?id="+id,
			    width: 400,    
			    height: 200,    
			    closed: false,    
			    cache: false,        
			    modal: true ,
			    toolbar:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						$.ajax({
							 url:"<%=request.getContextPath()%>/userController/saveRolesByUserId.do",
							 type:"post",			 
							 data:$("#roleShow_form").serialize(),
							 async:false,
							 dataType:"text",
							 success:function(data){
								 $("#usershow_dialog").dialog("close");
								 $("#ta").datagrid("reload");
							 },
							 error:function(){
								 alert("查询用户角色程序错误")
							 }
						 })
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						$("#usershow_dialog").dialog("close");
					}
				}]

			});
		}
// 		条件查询
		 function whereSelect(){
			  var userName=$("#usernamecriteria").textbox('getValue');
			  var userSex=$("[name=usersexcriteria]:checked").val();
			  var userLogin=$("#loginnamecriteria").textbox('getValue');
			  $('#ta').datagrid('load', {    
				    "usernamecriteria":userName,
				    "usersexcriteria":userSex,
				    "loginnamecriteria":userLogin,
				    "deptidcriteria":newdeptValue,
				    "typeidcriteria":newTypeValue
				    
				}); 
		   }
		   //所属部门列表改变事件
		  var newdeptValue="";
		 $('#deptidShow_select').combobox({    
			    url:'<%=request.getContextPath()%>/userController/queryDeptIdSelect.do',    
			    valueField:'deptid',    
			    textField:'deptname',
			    
			    onChange:(function(newValue,oldValue){
					newdeptValue = newValue;

				})
			})
			//用户类型动态加载以及内容改变事件的 方法
		 var newTypeValue = "";
		 $('#userlxShow_select').combobox({    
			    url:'<%=request.getContextPath()%>/userController/queryUserTypeSelect.do',    
			    valueField:'typeid',    
			    textField:'typename',
			    onChange:(function(newValue,oldValue){
					newTypeValue = newValue;

				})
			}); 
	//删除
	 function deleteUsers(){
// 		alert(123)
		 var ids=$("#ta").datagrid("getSelections");
		var str = "";
// 		var userLength = ids.length;
		if(ids.length>0){
			$.messager.confirm('确认','您确认想要删除这记录吗？',function(r){
				if(r){
					for (var i = 0; i < ids.length; i++) {
// 						idss.push(ids[i].id);
						str += ","+ids[i].userid;
					}
				}
// 				alert(str)
				var strs = str.substr(1);
				$.ajax({
		    		url:"<%=request.getContextPath()%>/userController/deleteUserByIds.do",
		    		data:{"str":strs},
		    		type:"post",
		    		success:function(){
		    			$("#ta").datagrid("reload");
		    		},error:function(){
		    			 $.messager.alert('警告','删除报错'); 
		    		}
		    		
		    			
		    	})

			})   
			
		}else{
// 			alert(123)
			$.messager.alert("警告","请选择要删除的项!")
		}
	}
// 	修改
	function updateUserById(){
//  		alert(123)
		var idarr = $("#ta").datagrid("getSelections");
// 		alert(idarr[0].costid);
		if(idarr.length != 1){
			$.messager.alert('提示信息','请选择要修改的项');
		}
		
			
		
		$("#dialog_xg").dialog({
			title: '修改用户',    
 		    width: 400,    
 		    height: 200,    
 		    closed: false,    
 		    cache: false,
 		    href:"<%=request.getContextPath()%>/userController/queryUserById.do?id="+idarr[0].userid,
 		    modal:true,
		    toolbar:[{
				text:'保存',
				iconCls:'icon-save',
				handler:function(){
// 					alert($("#update_form").serialize());
					$.ajax({
						url:"<%=request.getContextPath()%>/userController/updateUserById.do",
						data:$("#update_form").serialize(),
						type:"post",
						success:function(){
							$("#dialog_xg").dialog("close");
							$("#ta").datagrid("reload");
// 							$("#ta").datagrid("reload");
							
						},error:function(){
							 $.messager.alert('警告','修改报错'); 
						}
					})
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog_xg").dialog("close");
				}
			}]
		})
		
	}
	//增加方法
         function addUser(){
        	 $("#dialog_addUser").dialog({
        		    title: '新增用户',    
        		    width: 400,    
        		    height: 200,    
        		    closed: false,    
        		    cache: false,
        		    href:"<%=request.getContextPath()%>/userController/toAddUser.do",
        		    modal: true ,
        		    toolbar:[{
        				text:'保存',
        				iconCls:'icon-save',
        				handler:function(){
//         					alert($("#addUser_form").serialize());
        					$.ajax({
        						url:"<%=request.getContextPath()%>/userController/addUserData.do",
        						data:$("#addUser_form").serialize(),
        						type:"post",
        						success:function(){
        							$("#dialog_addUser").dialog("close");
        							$("#ta").datagrid("reload");
        							
        						},error:function(){
        							 $.messager.alert('警告','保存报错'); 
        						}
        					})
        				}
        			},{
        				text:'取消',
        				iconCls:'icon-cancel',
        				handler:function(){
        					$("#dialog_addUser").dialog("close");
        				}
        			}]
        	 })
         }
	
		</script>

</body>
</html>