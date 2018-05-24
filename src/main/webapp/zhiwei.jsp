<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/21
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>职位查看</title>
</head>
<%@include file="bootstrapjs.txt"%>
<body>
<a href="javascript:void(0)" onclick="gsjibeninfo()" ><i class="icon-white icon-home"></i>发布的职位</a>
<table class="table table-striped table-bordered table-hover" id="zhiwei-table" >
</table>

<script type="text/javascript">
    /*$("gsjibeninfo").click(function(){
     alert("ds")
     });*/

    //查询
    $("#zhiwei-table").bootstrapTable({
        url: "<%=request.getContextPath()%>/zhiweiController/queryzhiweishow.do",
        striped: true,
        search: true,
        searchOnEnterKey: true,
        showHeader: true,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        pagination: false,		   //开启分页
        pageNumber:1,              //初始化加载第几页,默认第1页
        pageSize: 3,               //每页几条数据,超过总条数右下角将没分页
        pageList: [2, 4, 6, 8],    //每页条数,设置为All将展示全部记录,超过总条数底部将不显示条数下拉框
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",	//必须的否则条件查询时会乱码
        sidePagination: "server",  //分页方式:client客户端分页,server服务端分页
        queryParams: function (params) {
            return params ;
        },columns: [
           {
                field: 'comname',
                title: '个人公司名称'
            },{
                field: 'name',
                title: '职位'
            },{
                field: 'xingzhi',
                title: '薪资'
            },{
                field: 'city',
                title: '工作地点'
            } ,{
                field: 'jingyan',
                title: '工作经验'
            },{
                field: 'xueli',
                title: '学历'
            },{
                field: 'youhuo',
                title: '公司诱惑'
            },{
                field: 'xueli',
                title: '学历展示'
            }
        ]
    });
</script>


</body>
</html>
