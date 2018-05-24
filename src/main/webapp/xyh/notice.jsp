<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/21
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告页面</title>
</head>
<body>
<!-- 条件查询 -->
<div id="p" class="easyui-panel" title="条件查询"
     style="width:100%;height:150px;padding:10px;"
     data-options="iconCls:'icon-save',closable:true,    
                collapsible:true,minimizable:true,maximizable:true">
    <form id="ff" >
        <div>
            <!-- 		        <label for="name">姓名:</label>    -->
            <!-- 		        <input class="easyui-textbox" id="noticeTitle"  type="text"  style="width:100px;"/>    -->
        </div>
        <div>
            <label >公告类型:</label>
                <select id="noticeTypeSelect" class="easyui-combobox" name="noticeType" style="width:100px;">
                    <option value="0">请选择类型</option>
                    <option value="1">活动预热</option>
                    <option value="2">系统更新</option>
                    <option value="3">警告专版</option>
                </select>
            </select>
        </div>
    </form>
    <div id="btn" class="easyui-linkbutton" onclick="whereSelect()" data-options="iconCls:'icon-search'">搜索</div>
</div>

<div id="dialog_add">
</div>
<div id="dialog_update">
</div>
<div id="dialog_addrole">
</div>
<table id="dgarid">
    <div id="crud" >
        <div  class="easyui-linkbutton" onclick="addInfo()" data-options="iconCls:'icon-add',plain:true">新增</div>
        <div  class="easyui-linkbutton" onclick="deleteSome()" data-options="iconCls:'icon-remove',plain:true">删除</div>
        <div  class="easyui-linkbutton" onclick="updateInfo()" data-options="iconCls:'icon-edit',plain:true">修改</div>
        <!-- 		<div  class="easyui-linkbutton" onclick="updateInfo()" data-options="iconCls:'icon-edit',plain:true">修改</div> -->
    </div>
</table>

<script type="text/javascript">

    //获取条件查询选择的value值
    function whereSelect(){
        var names=$("#noticeType").textbox('getValue');
        $('#dgarid').datagrid('load',{
            "noticeType":noticeType
        });

    }


    //修改
    function updateInfo(){
        //先获取到需要修改的数据id,且只能选一个
        var updateId = $("#dgarid").datagrid("getSelections");
        if(updateId.length != 1){
            $.messager.alert('请看屏幕','选择一条','warning');
        }else{
            $("#dialog_update").dialog({
                title:'修改公告信息',
                width: 400,
                height:200,
                closed:false,
                cache: false,
                href:"<%=request.getContextPath()%>/noticeController/toUpdateNoticeJsp.do?noticeId="+updateId[0].noticeId,
                modal:true,
                toolbar:[{
                    text:'保存',
                    iconCls:'icon-edit',
                    handler:function(){
                        $.ajax({
                            url:"<%=request.getContextPath()%>/noticeController/updateNoticeById.do",
                            data:$("#editNoticeForm").serialize(),
                            type:"post",
                            success:function(){
                                $("#dialog_update").dialog("close");
                                $("#dgarid").datagrid("reload");

                            },
                            error:function(){
                                $.messager.alert('警告','报错了呀','warning');
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




    function deleteSome(){
        //获取到被选中的id
        var ids = $("#dgarid").datagrid("getSelections");
        var idList = [];
        if(ids.length > 0){
            $.messager.confirm('确认框','确定要删除?',function(r){
                if(r){
                    for (var i = 0; i < ids.length; i++) {
                        idList.push(ids[i].noticeId);
                    }
                    $.ajax({
                        url:"<%=request.getContextPath()%>/noticeController/deleteSome.do",
                        data:{"idList":idList.toString()},
                        type:"post",
                        success:function(){
                            $("#dgarid").datagrid("reload");
                        },error:function(){
                            $.messager.alert('警告','报错了呦','info');
                        }


                    })
                }
            })
        }
    }


    //新增
    function addInfo(){

        $("#dialog_add").dialog({
            title:'新增',
            width: 400,
            height:200,
            closed:false,
            cache: false,
            href:"<%=request.getContextPath()%>/noticeController/toAddNotice.do",
            modal:true,
            toolbar:[{
                text:'保存',
                iconCls:'icon-edit',
                handler:function(){
                    $.ajax({
                        url:"<%=request.getContextPath()%>/noticeController/addNotice.do",
                        data:$("#addNoticeForm").serialize(),
                        type:"post",
                        success:function(){
                            $("#dialog_add").dialog("close");
                            $("#dg").datagrid("reload");
                        },
                        error:function(){
                            $.messager.alert('警告','报错了呀','warning');
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



    //加载数据表格
    $(function(){
        $('#dgarid').datagrid({
            url:'<%=request.getContextPath()%>/noticeController/queryNoticeInfo.do',
            striped:true,
            fitColumns:true,
            ctrlSelect:true,
            loadMsg:"数据加载中······",
            pagination:true,
            pagePosition:'bottom',
            pageNumber:1,
            pageSize:5,
            pageList:[1,3,5,10,20],
            columns:[[
                {field:'noticeId',title:'编号',width:100},
                {field:'noticeTitle',title:'标题',width:100},
                {field:'noticeType',title:'类型',width:100,
                    formatter: function(value,row,index){
                        if(row.noticeType == 1){
                            return "活动预热";
                        }else if(row.noticeType == 2) {
                            return "系统更新";
                        }else if(row.noticeType == 3) {
                            return "警告专版";
                        }
                        return "未选择";
                    }
                },
                {field:'noticeContent',title:'内容',width:100},
            ]]
        });
    })


    /* 查询各个公告的详细人员信息*/

    function queryDeptInfo(noticeId){
        $("#dialog_deptNum").dialog({
            title: '公告人员',
            width: 460,
            height: 300,
            closed: false,
            cache: false,
            href:"<%=request.getContextPath()%>/noticeController/toDeptNum.do?noticeId="+noticeId,
            modal: true ,
            toolbar:[{
                handler:function(){
                    <%-- $.ajax({
                        url:"<%=request.getContextPath()%>/noticeController/queryDeptNum.do",
                        data:$("#"),
                        dataType:"json",
                        type:"post",
                        success:function(data){
                            $("#dialog_deptNum").dialog("close");
                            
                        },error:function(){
                             $.messager.alert('警告','报错','warning'); 
                        }
                    }) --%>

                }
            },{
//       				text:'取消',
//       				iconCls:'icon-cancel',
                handler:function(){
                    $("#dialog_deptNum").dialog("close");
                }
            }]
        })
    }

    //加载条件查询的下拉公告
    <%--$.ajax({--%>
        <%--url:"<%=request.getContextPath()%>/noticeController/queryNoticeType.do",--%>
        <%--type:"post",--%>
        <%--dataType:"json",--%>
        <%--data:"",--%>
        <%--async:false,--%>
        <%--success:function(result){--%>
            <%--var inputs="<option value=''>--请选择--</option>";--%>
            <%--$.each(JSON.parse(result),function(){--%>
                <%--inputs+="<option value='"+this.noticeId+"'>"+this.noticeTitle+"</option>";--%>
            <%--});--%>
            <%--$("#noticeTypes").html(inputs);--%>
        <%--},--%>
        <%--error:function(){--%>
            <%--alert("加载下拉失败");--%>
        <%--}--%>
    <%--})--%>

</script>
</body>
</html>
