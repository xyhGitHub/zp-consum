<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/19
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="bootstrapjs.txt"%>
<body>
<input type="hidden" id="comid"  value="${comid }">

<a href="javascript:void(0)"  ><i class="icon-white icon-home"></i>公司基本信息</a>
<table class="table table-striped table-bordered table-hover" id="all-table" >
</table>
<script type="text/javascript">


//        var aa = document.getElementById("comid").value;
         var aa= $("#comid").val();

        $("#all-table").bootstrapTable({

            url:"<%=request.getContextPath()%>/gongsiController/queryall.do?id="+aa,
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
            pageList: [2, 4, 6, 8],    //每页条数,设置为All将展示全部记录,超过总条数底部将不显示条数下拉框
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",	//必须的否则条件查询时会乱码
            sidePagination: "server",  //分页方式:client客户端分页,server服务端分页
            queryParams: function (params) {

                return params ;
            },columns: [  {
                field: 'id',
                title: 'ID'
            },{
                    field: 'renname',
                    title: '个人名字'
                },{
                    field: 'renphoto',
                    title: '个人照片'
                }, {
                    field: 'renzhiwei',
                    title: '个人职位'
                }, {
                    field: 'renweibo',
                    title: '个认微博'
                },{
                    field: 'jianjie',
                    title: '个人简介'
                }
            ]
        })


</script>





</body>
</html>
