<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>Title</title>
</head>
<%@include file="bootstrapjs.txt"%>
<body>
<a href="logtongji.jsp" ><i class="icon-white icon-home">异常统计</i></a>
<table class="table table-striped table-bordered table-hover" id="rizhi-table" >
</table>
<!-- 	</div> -->
	<script type="text/javascript">

        $("#rizhi-table").bootstrapTable({
            url: "<%=request.getContextPath()%>/logs/querylogs.do",
            striped: true,
            search: true,
            searchOnEnterKey: true,
            //searchText:"大爷，搜我",
            showHeader: true,
            showColumns: true,
            showRefresh: true,
            showToggle: true,
            pagination: false,		   //开启分页
            pageNumber:1,              //初始化加载第几页,默认第1页
            pageSize: 3,               //每页几条数据,超过总条数右下角将没分页
            pageList: [3, 4, 6, 8],    //每页条数,设置为All将展示全部记录,超过总条数底部将不显示条数下拉框
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",	//必须的否则条件查询时会乱码
            sidePagination: "server",  //分页方式:client客户端分页,server服务端分页
            queryParams: function (params) {

                return params ;
            },columns: [  {
                field: 'logId',
                title: 'ID'
            }
                ,{
                    field: 'clazzName',
                    title: '类名'
                },{
                    field: 'methodName',
                    title: '方法名'
                },{
                    field: 'params',
                    title: '参数'
                }, {
                    field: 'exception',
                    title: '异常'
                }
            ]
        });
//	$(function(){
//		//加载数据
//		$('#role_dg').datagrid({
//	    url:"logs/querylogs.do",
//	    fit:true,
//	     //按ctrl多选
//	     ctrlSelect:true,
//	    //开启分页
//	    pagination:true,
//	    //每页条数
//	    pageSize:3,
//	    pageList:[1,3,5,7,9],
//	    //引入工具栏
//	    toolbar:"#role_tool_div",
//	    columns:[[
//	        {field:'logId',title:'角色id',width:300},
//	        {field:'clazzName',title:'类名',width:300},
//	        {field:'methodName',title:'方法名',width:300},
//	        {field:'params',title:'参数与参数名',width:300},
//	        {field:'exception',title:'异常信息',width:300},
//	        {field:'user',title:'操作人',width:300},
//
//	   	 	]],
//		});
//
//	});
//
//
//	//重置方法
//	function emp_search_reset(){
//
//		$("#role_from_search").form("reset");
//
//	}
//
	//打开添加对话框
	</script>
</body>
</html>