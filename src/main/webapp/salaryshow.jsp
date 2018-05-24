<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:#FFCCCC ;width:100%;height:5000px;padding:10px;">
<div id="p" class="easyui-panel" title="My Panel"     
        style="width:100%;height:150px;padding:10px;"   
        data-options="iconCls:'icon-save',closable:true,    
                collapsible:true,minimizable:true,maximizable:true">   
	 <form id="ff" >   
	    <div>   
	        <label for="username">总薪资人员信息:</label>   <br>
	        最小薪资：<input class="easyui-textbox" id="SalarySum1"  type="text" name="salarysum" data-options="required:true" />---
	     最大薪资    <input class="easyui-textbox" id="maxSalary"  type="text" name="salarysum2" data-options="required:true" />   
	    </div>   
	    
	</form>  
    <div id="btn" href="#" class="easyui-linkbutton" onclick="whereSelect()" data-options="iconCls:'icon-search'">查询</div> 
</div>   

<div id="dialog_add" style="background-color:#FFFFCC"></div>  
<div id="dialog_update" style="background-color:#FFFFCC"></div>  
<div id="dialog_addRole" style="background-color:#FFFFCC"></div>  
<div id="dialog_selectuser" style="background-color:#FFFFCC"></div>  


<table  id="dg" >  
	<div id="tbb" style="background-color:#FFCCCC">
		<div  class="easyui-linkbutton" onclick="addSalary()" data-options="iconCls:'icon-add',plain:true">新增</div>
		<div  class="easyui-linkbutton" onclick="deleteSalary()" data-options="iconCls:'icon-remove',plain:true">删除</div>
		<div  class="easyui-linkbutton" onclick="updateSalary()" data-options="iconCls:'icon-edit',plain:true">修改</div>
	</div>
 
</table>
</div>
<script type="text/javascript">
 $(function(){
	$('#dg').datagrid({    
	    url:'<%=request.getContextPath()%>/salaryController/salarylist.do',   
	    fitColumns:true,
	    striped:true,
	    remoteSort:false,
	    ctrlSelect:true,
	    pagination:true,
	    pagePosition:"bottom",//放在底部
	    pageNumber:1,
		pageSize:3,
		pageList: [3,4,12,16],
	    columns:[[    
	        {field:'salaryid',title:'薪资编号',width:100},    
	        {field:'salaryjibie',title:'薪资级别',width:100
	        	,sortable:true,sorteer:function(a,b){
		        	return (a>b?1:1);
		        }	
	        
	        },    
	        {field:'salarybase',title:'基本工资',width:100
	        ,sortable:true,sorteer:function(a,b){
	        	return (a>b?1:1);
	        }	
	        },    
	        {field:'salaryjn',title:'技能工资',width:100
	        	,sortable:true,sorteer:function(a,b){
		        	return (a>b?1:1);
		        }	
	        },    
	        {field:'salsryyj',title:'业绩工资',width:100
	        	,sortable:true,sorteer:function(a,b){
		        	return (a>b?1:1);
		        }	
	        },    
	        {field:'salaryqq',title:'全勤工资',width:100
	        	,sortable:true,sorteer:function(a,b){
		        	return (a>b?1:1);
		        }	
	        },
	        {field:'salarysum',title:'总薪资',width:100
	        	,sortable:true,sorteer:function(a,b){
		        	return (a>b?1:1);
		        }	
	        
	        },
	        {
	        	formatter: function(value,row,index){
	        		return "";
	        	},
	        	
	        }   
	        
	    ]]    
	});  

})


  function whereSelect(){
		  var Salarysum1=$("#SalarySum1").textbox('getValue');
		  var maxSalary=$("#maxSalary").textbox('getValue');
		
			 $("#dialog_selectuser").dialog({
     		    title: '超过所查薪资的用户',    
     		    width: 400,    
     		    height: 200,    
     		    closed: false,    
     		    cache: false,
     		    href:"<%=request.getContextPath()%>/salaryController/toselectuser.do?salarysum="+Salarysum1+"&maxSalary="+maxSalary,
     		  
     	 })
		 
		   
	   }









//新增
function addSalary(){
        	 $("#dialog_add").dialog({
        		    title: '新增用户',    
        		    width: 400,    
        		    height: 200,    
        		    closed: false,    
        		    cache: false,
        		    href:"<%=request.getContextPath()%>/salaryController/toSalary.do",
        		    modal: true ,
        		    toolbar:[{
        				text:'保存',
        				iconCls:'icon-edit',
        				handler:function(){
        				//	alert($("#add_form").serialize());
        					$.ajax({
        						url:"<%=request.getContextPath()%>/salaryController/addsalary.do",
        						data:$("#add_form").serialize(),
        						type:"post",
        						success:function(){
        							$("#dialog_add").dialog("close");
        							$("#dg").datagrid("reload");
        							
        						},error:function(){
        							 $.messager.alert('警告','1报错'); 
        						}
        					})
        					
        				}
        			},{
        				text:'取消',
        				iconCls:'icon-cancel',
        				handler:function(){
        					$("#dialog_add").dialog("close");
        				}
        			}]
        	 })
         }
//删除	
function deleteSalary(){
	var ids=$("#dg").datagrid("getSelections");
	
	   var salaryids=[];
	   if(ids.length>0){
		   $.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
			    if (r){
			    	for (var i = 0; i < ids.length; i++) {
			    		salaryids.push(ids[i].salaryid);
						}
			    	//	alert(salaryids)
			    	$.ajax({
			    		url:"<%=request.getContextPath()%>/salaryController/deleteSalary.do",
			    		data:{"salaryid":salaryids.toString()},
			    		type:"post",
			    		success:function(){
			    			$("#dg").datagrid("reload");
			    		},error:function(){
			    			 $.messager.alert('警告','报错'); 
			    		}
			    			
			    	})
			    }    
			});  
	   }else{
		   $.messager.alert('警告','请选择要删除的项'); 
	   }
}
	//修改
	
       function updateSalary(){
     	  var ids=$("#dg").datagrid("getSelections");
     	  if(ids.length!=1){
     		  $.messager.alert('警告','请大爷选择要修改的项'); 
     		 
     	  }else{
     		// alert(ids[0].salaryid)
     		  $("#dialog_update").dialog({
     			  title:"修改用户",
     			  width: 400,    
       		      height: 200,    
       		      closed: false,    
       		      cache: false,
       		      href:"<%=request.getContextPath()%>/salaryController/toUpdateSalary.do?salaryid="+ids[0].salaryid,
       		    toolbar:[{
     				text:'保存',
     				iconCls:'icon-edit',
     				handler:function(){
     					$.ajax({
     						url:"<%=request.getContextPath()%>/salaryController/updateSalary.do",
     						data:$("#update_form").serialize(),
     						dataType:"json",
     						type:"post",
     						success:function(data){
     							$("#dialog_update").dialog("close");
     							$("#dg").datagrid("reload");
     							
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
       }

	
	
	
	
	


</script>

</body>
</html>