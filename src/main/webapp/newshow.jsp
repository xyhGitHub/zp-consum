<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/18
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%@include file="bootstrapjs.txt"%>
<body>
<a href="javascript:void(0)" onclick="gsjibeninfo()" ><i class="icon-white icon-home"></i>公司新闻</a>
<table class="table table-striped table-bordered table-hover" id="news-table" >
</table>


<script type="text/javascript">

    /*$("gsjibeninfo").click(function(){
     alert("ds")
     });*/
    //查询
    $("#news-table").bootstrapTable({
        url: "<%=request.getContextPath()%>/newController/querynews.do",
        striped: true,
        search: true,
        searchOnEnterKey: true,
        //searchText:"大爷，搜我",
        showHeader: true,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        pagination: true,		   //开启分页
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
    }
        ,{
            field: 'name',
            title: '公司报道'
        },{
            field: 'address',
                title: '报道路径'
            } ,{field: 'tool',title: '操作', align: 'center', formatter:function(value, row, index) {

                var st= JSON.stringify(row);
                console.info(st)
                var result = "";

                result +='<button  onclick=" HuanFollow ('+row.id+')" type="button" class="btn btn-danger" data-toggle ="modal" '+

                    '<i class="glyphicon glyphicon-trash"></i>修改 </button>';

                result +='<button  onclick=" delFollow ('+row.id+' )" type="button" class="btn btn-danger" data-toggle= "modal" '+

                    '<i class="glyphicon glyphicon-trash"></i>删除 </button>';
                result +='<button  onclick=" addFollow ('+row.id+' )" type="button" class="btn btn-danger" data-toggle= "modal" '+

                    '<i class="glyphicon glyphicon-trash"></i>新增 </button>';
                return result;
            }
            },
        ]
    });

    <%--function  delFollow(id) {--%>
        <%--alert(id)--%>
        <%--$.ajax({--%>
            <%--url:"<%=request.getContextPath()%>/newController/delnews.do",--%>
            <%--data:{id:id},--%>
            <%--type:"post",--%>
            <%--success:function(){--%>
                   <%--$("#news-table").bootstrapTable("refresh");--%>
                 <%--//   window.location.reload();--%>

            <%--}--%>
        <%--})--%>

    function delFollow(id){
        $.ajax({
            url:"<%=request.getContextPath()%>/newController/delnews.do",
            type:"post",
            data:{"id":id},
            dataType:"text",
            success:function(){
                alert("删除成功")
            },
            error:function(){
                alert("删除成功")
                $("#news-table").bootstrapTable("refresh");
            }
        })
    }
</script>
</body>
</html>
