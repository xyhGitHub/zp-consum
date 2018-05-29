<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/17
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%@include file="bootstrapjs.txt"%>
<body>
<a href="javascript:void(0)" onclick="gsjibeninfo()" ><i class="icon-white icon-home"></i>公司基本信息</a>
<table class="table table-striped table-bordered table-hover" id="gongsi-table" >
</table>

<script type="text/javascript">
    /*$("gsjibeninfo").click(function(){
     alert("ds")
     });*/

        //查询
    $("#gongsi-table").bootstrapTable({
        url: "<%=request.getContextPath()%>/gongsiController/gongsilistu.do",
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
            field: 'comid',
            title: 'ID'
        }
            ,{
                field: 'comname',
                title: '公司名称'
            }
            ,{
                field: 'comphoto',
                title: '公司头像',
                width:100,align:'center',
                formatter: function(value,row,index) {
//                    alert(row.comphoto)
                    //如下的写法太复杂了,注意只有数字才这么写.
                    return "<img width='120px' height='60px' border='0' src ='"+row.comphoto+"'/>";
                }
                },{
                field: 'comjieshao',
                title: '公司介绍'
            }, {
                field: 'comshenhe', title: '公司审核状态', formatter:function(value, row, index) {
                    var st= JSON.stringify(row);
                    var result = "";
                    if (value==2){
                        result +='已经通过审核';
                    }
                    if (value==1){
                        result += '审核未通过';
                    }
                    return result;
                }

            }, {
                field: 'comaddress',
                title: '公司地址'
            },{
                field: 'comguimo',
                title: '公司规模'
            } ,{field: 'tool',title: '操作', align: 'center', formatter:function(value, row, index) {

                var st= JSON.stringify(row);

                var result = "";

                result +='<button  onclick=" xiangqing ('+row.comid+')" type="button" class="btn btn-danger" data-toggle ="modal" '+

                    '<i class="glyphicon glyphicon-trash"></i>查看详情 </button>';

                result +='<button  onclick=" delFollow ('+row.comid+' )" type="button" class="btn btn-danger" data-toggle= "modal" '+

                    '<i class="glyphicon glyphicon-trash"></i>拒绝公司 </button>';

                return result;

            }
            }
        ]
    });

        function  delFollow(comid) {
            alert(comid)
            $.ajax({
                url:"<%=request.getContextPath()%>/gongsiController/delgongsi.do?comid="+comid,
                type:"post",
                success:function(result){
                    if (result) {
                        window.location.reload();
                    }
                }
            })
        }
                function xiangqing(comid) {
            BootstrapDialog.show({
                title:comid,
                cssClass: 'login-dialog',
                message: $('<div></div>').load('/gongsiController/selectall.do?comid='+comid),
                buttons: [{
                    label: '关闭',
                    action: function(dialog) {
                        //更改弹框标题
                        BootstrapDialog.closeAll();
                    }
                }]
            });
        }
    function tongguo(comid) {
        $.ajax({
            url:"<%=request.getContextPath()%>/gongsiController/updatatongguo.do?id="+comid,
            type:"post",
            dataType:"json",
            success:function(result){
                if(result==2){
                    $("#gongsi-table").bootstrapTable("refresh");

                }
            },
            error:function () {
                $("#gongsi-table").bootstrapTable("refresh");
            }
        })

    }
        <%--function  butongguo() {--%>
            <%--$.ajax({--%>
                <%--url:"<%=request.getContextPath()%>/gongsiController/delgongsi.do",--%>
                <%--type:"post",--%>
                <%--success:function(result){--%>
                    <%--if (result) {--%>
                        <%--window.location.reload();--%>
                    <%--}--%>
                <%--}--%>
            <%--})--%>
        <%--}--%>
</script>

</body>
</html>
