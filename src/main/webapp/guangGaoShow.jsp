<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/23
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
   <%-- <style type="text/css">
        {   background-color: #fff;
            left: 50%;
            margin: -高/2 0 0 -宽/2;
            position: fixed;
            top: 50%;
            width: 300px;
            height: 300px;
            z-index: 25;
        }
    </style>--%>



</head>
<body style="height:100%">
<link rel="stylesheet" href="<%=request.getContextPath()%>/uploadify/uploadify.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/uploadify/jquery.uploadify.js"></script>
<%--条件查询
<div class="panel panel-primary">
    <div>
        <form class="form-inline">
            <div class="form-group">
                <label class="sr-only" >车主名称:</label>
                <input type="text" class="form-control" placeholder="请输入名称" name="selTaixName">
            </div>
            <div class="form-group">
                <label >车辆类型:</label>
                <select class="form-control selectpicker" name="selTaixType" id="slpk"></select>
            </div>
            <div class="form-group">
                <label class="sr-only" >注册日期:</label>
                <input type="text" class="form-control"  name="stratTime">
                <input type="text" class="form-control" name="endTime">
            </div>
        </form>
    </div>
    <button type="button" class="btn btn-primary" onclick="search_list()">搜索</button>

</div>--%>

<%--条形的条件查询--%>

<br/><br/>
<div class="input-group col-md-6" style="margin-top:0px positon:relative">
    <input type="text" class="form-control"placeholder="请输入字段名" id="nn"/>
    <span class="input-group-btn">
               <button class="btn btn-info btn-search" onclick="queryBrand()">查找</button>
       <button type="button" class=" btn btn-info btn-search " style="margin-left:3px" onclick="clearsearch()">清空搜索条件</button>
               <button class="btn btn-info btn-search" style="margin-left:3px" data-toggle="modal" id="exportExcepButton">导出EXCEL</button><%--data-target="#exportExcelDialog"--%>
               <%--<button class="btn btn-info btn-search" style="margin-left:3px">导出DOC</button>--%>
        <button type="button" class="btn btn-info btn-search " style="margin-left:3px" data-toggle="modal" data-target="#myaddModal">新增</button>
       <button type="button" class=" btn btn-info btn-search " style="margin-left:3px" onclick="upCheck()">批量删除</button>
            </span>
</div>

<%--条形的条件查询End--%>

<%--条件查询End--%>
<%--展示页面--%>
<div class="table-responsive">
<table id="advertlist" class="table table-bordered"></table>
</div>
<%--选择性导出excel--%>
<div class="modal fade" id="exportExcelDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form  method="post" id="exportExcelForm">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="form-signin-heading">导出广告excel</h4>
                </div>
                <div class="modal-body">
                    导出标题:<input type="text" class="form-control" name="daochubiaoti"/><br/>
                    <table>
                        <tr height="40px;">
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px"  name="check" value="guangGaoId;ID" checked>ID</label></td>
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px"  name="check" value="guangGaoName;名称" checked>名称</label></td>
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px"  name="check" value="guangGaoShuoMing;说明">说明</label></td>
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px" name="check" value="guangGaoStart;起始时间">起始时间</label></td>
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px" name="check" value="guangGaoEnd;结束时间">结束时间</label></td>
                            <td style="width: 130px;"><label> <input type="checkbox" style="margin-left:7px" name="check" value="guangGaoWidth;长度">长度</label></td>
                        </tr>
                        <tr height="40px;">
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px" name="check" value="guangGaoHeight;宽度">宽度</label></td>
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px" name="check" value="guangGaoprice;金额">金额</label></td>
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px" name="check" value="guangGaoNum;位序号">位序号</label></td>
                            <td style="width: 130px;">
                                <label><input type="radio" style="margin-left:7px" name="check" value="1">上架</label>
                                <label><input type="radio" style="margin-left:7px" name="check" value="2">下架</label>

                            </td>
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px" name="check" value="guangGaoStatus;上架状态">上架状态</label></td>
                            <td style="width: 130px;"><label><input type="checkbox" style="margin-left:7px" name="check" value="guangGaoNum;序号">序号</label></td>
                        </tr>
                    </table>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" >导出</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div><%--选择性导出excel END--%>
<!--新增页面  -->
<div class="modal fade" id="myaddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form  method="post" id="guanggaoform">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="form-signin-heading">新增广告</h4>
                </div>
                <div class="modal-body">
                    <div class="input-group">
                        <span class="input-group-addon">广告名称</span>
                        <input type="text" name="guangGaoName"   class="form-control" id="guangGaoName" placeholder="请填入广告名称"  required autofocus>
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">广告说明</span>
                        <input type="text" name="guangGaoShuoMing"   class="form-control" id="guangGaoShuoMing" placeholder="请填入广告说明"  required autofocus>
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">广告起始时间</span>
                        <!--指定 date标记-->
                        <div class='input-group date' id='datetimepicker1'>
                            <input type="text" name="guangGaoStart"   class="form-control" id="guangGaoStart" placeholder="请填入广告起始时间"  required autofocus style="width:420px">
                            <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div><!--指定 date标记END-->

                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">广告结束时间</span>
                        <!--指定 date标记-->
                        <div class='input-group date' id='datetimepicker2'>
                            <input type="text" name="guangGaoEnd"   class="form-control" id="guangGaoEnd" placeholder="请填入广告结束时间"  required autofocus style="width:420px"><br>
                            <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div> <!--指定 date标记END-->

                    </div>
                    <br>




                    <input type="hidden" name="guangGaoPhoto" id="guangGaoPhotoid"/>
                     广告图片：</label><input type="file" name="guangGaoPhotoOss"   class="projectfile" id="guangGaoPhotoOss" placeholder="广告图片" value=""  required autofocus><br>
                    <div class="input-group">
                        <span class="input-group-addon">广告长度(单位px)</span>
                        <input type="text" name="guangGaoWidth"   class="form-control" id="guangGaoWidth" placeholder="请填入广告长度(单位px)"  required autofocus><br>
                    </div>
                    <br>

                    <div class="input-group">
                        <span class="input-group-addon">广告宽度(单位px)</span>
                        <input type="text" name="guangGaoHeight"   class="form-control" id="guangGaoHeight" placeholder="请填入广告宽度(单位px)"  required autofocus><br>
                    </div>
                    <br>

                    <div class="input-group">
                        <span class="input-group-addon">广告金额</span>
                        <input type="text" name="guangGaoprice"   class="form-control" id="guangGaoprice" placeholder="请填入广告金额"  required autofocus><br>
                    </div>
                    <br>

                    <div class="input-group">
                        <span class="input-group-addon">广告位置编号</span>
                        <input type="text" name="guangGaoNum"   class="form-control" id="guangGaoNum" placeholder="请填入广告位置"  required autofocus><br>
                    </div>
                    <br>





                    <div class="input-group">
                      <span class="input-group-btn">
                        <button class="btn btn-primary" type="button" id="searchclear">测试网络</button>
                      </span>
                        <input type="text" name="guangGaoGuanWang"   class="form-control" id="searchinput" placeholder="请填入广告目标网址,例如:http://www.baidu.com" value="http://" required autofocus style="width:488px"/>
                    </div>





                    <%--<input type="text" name="guangGaoGuanWang"   class="form-control" id="guangGaoGuanWang" placeholder="广告目标网址"  required autofocus>--%>
                    <%--<div class="btn-group">
                        &lt;%&ndash;<input  type="search" class="form-control">&ndash;%&gt;

                        <span class="	glyphicon glyphicon-send"></span>
                    </div>--%>
                    <br>
                    <div class="input-group" data-toggle="buttons">
                        <%--<span class="input-group-btn">广告上架状态</span>--%>
                        <label class="btn btn-default active">
                            <input type="radio" disabled>广告上架状态：
                        </label>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input type="radio" style="margin-left:7px" name="guangGaoStatus" value="1">上架</label>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input type="radio" style="margin-left:7px" name="guangGaoStatus" value="2">下架</label>
                    </div>


                    <br>
                    <%--<input type="text" name="guangGaoStatus"   class="form-control" id="guangGaoStatus" placeholder="广告上架状态"  required autofocus>--%>
<br>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="guanggaotijiao">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--新增END--%>






<!--修改页面  -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form  id="fg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="form-signin-heading">修改广告</h4>
                </div>
               <div class="modal-body">
                    <input type="hidden" name="guangGaoId" value="" id="guanggaoupdateid"/>
                   <div class="input-group">
                       <span class="input-group-addon">广告名称</span>
                       <input type="text" name="guangGaoName"   class="form-control" id="guangGaoNameXiu" placeholder="请填入广告名称" value="" required autofocus>
                   </div>
                   <br>

                   <div class="input-group">
                       <span class="input-group-addon">广告说明</span>
                       <input type="text" name="guangGaoShuoMing"   class="form-control" id="guangGaoShuoMing2" placeholder="请填入请填入广告说明" value=""  required autofocus>
                   </div>
                   <br>
                   <div class="input-group">
                       <span class="input-group-addon">广告起始时间</span>
                       <!--指定 date标记-->
                       <div class='input-group date' id='datetimepicker3'>
                           <input type="text" name="guangGaoStart"   class="form-control" id="guangGaoStart2" placeholder="请填入广告起始时间" value=""  required autofocus style="width:420px">
                           <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                       </div><!--指定 date标记END-->

                   </div>
                   <br>
                   <div class="input-group">
                       <span class="input-group-addon">广告结束时间</span>

                       <!--指定 date标记-->
                       <div class='input-group date' id='datetimepicker4'>
                           <input type="text" name="guangGaoEnd"   class="form-control" id="guangGaoEnd2" placeholder="请填入广告结束时间" value=""  required autofocus style="width:420px">
                           <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                       </div> <!--指定 date标记END-->

                   </div>
                   <br>




                   <label>  广告图片：</label>
                   <input type="file" name="guangGaoPhotoOss" id="uploadfiy"   class="projectfile"  placeholder="广告图片" value=""  required autofocus>
                   <input type="hidden" name="guangGaoPhoto" id="guangGaoPhotoUploadfiy"/>
                   <div id="fileQueue"></div>
                   <div id="show"></div>
                   <br>


                   <div class="input-group">
                       <span class="input-group-addon">广告长度(单位px)</span>
                       <input type="text" name="guangGaoWidth"   class="form-control" id="guangGaoWidth2" value="" placeholder="请填入广告长度(单位px)"  required autofocus><br>
                   </div>
                   <br>

                   <div class="input-group">
                       <span class="input-group-addon">广告宽度(单位px)</span>
                       <input type="text" name="guangGaoHeight"   class="form-control" id="guangGaoHeight2" value="" placeholder="请填入广告宽度(单位px)"  required autofocus><br>
                   </div>
                   <br>

                   <div class="input-group">
                       <span class="input-group-addon">广告金额</span>
                       <input type="text" name="guangGaoprice"   class="form-control" id="guangGaoprice2" value="" placeholder="请填入广告金额"  required autofocus><br>
                   </div>
                   <br>

                   <div class="input-group">
                       <span class="input-group-addon">广告位置编号</span>
                       <input type="text" name="guangGaoNum"   class="form-control" id="guangGaoNum2" value="" placeholder="请填入广告位序号"  required autofocus><br>
                   </div>
                   <br>

                   <div class="input-group">
                      <span class="input-group-btn">
                        <button class="btn btn-primary" type="button" id="searchclear2">测试网络</button>
                      </span>
                       <input type="text" name="guangGaoGuanWang"   class="form-control" id="guangGaoGuanWang2"  style="width:488px" value="" placeholder="广告目标网址,点击可以测试是否可用哦,例如:http://www.baidu.com" value="http://" required autofocus>
                   </div>










                   <div class="btn-group">
                        <%--<input  type="search" class="form-control">--%>

                        <%--<span  class="	glyphicon glyphicon-send"></span>--%>
                    </div>
                    <br>

                   <div class="input-group" data-toggle="buttons">
                       <%--<span class="input-group-btn">广告上架状态</span>--%>
                       <label class="btn btn-default active">
                           <input type="radio" disabled>广告上架状态：
                       </label>
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <label><input type="radio" style="margin-left:7px" name="guangGaoStatus" value="1">上架</label>
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <label><input type="radio" style="margin-left:7px" name="guangGaoStatus" value="2">下架</label>
                   </div>


                   <br>
                    <%--<input type="text" name="guangGaoStatus"   class="form-control" id="guangGaoStatus2" value="" placeholder="广告上架状态"  required autofocus><br>--%>
                <%--   <label><input type="radio" style="margin-left:7px" name="guangGaoStatus" value="1">上架</label>
                   <label><input type="radio" style="margin-left:7px" name="guangGaoStatus" value="2">下架</label><br>--%>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="button" data-dismiss="modal">关闭</button>
                    <button class="btn btn-danger" type="button"  onclick="update()">修改</button>
                </div>
           </div>
        </form>
    </div>
</div>
<%--修改 END--%>


<style type="text/css">

    #searchinput {
        width: 570px;
    }



</style>
<link href="<%=request.getContextPath()%>/jquery/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/jquery/bootstrap-datetimepicker-master/js/moment-develop/min/moment-with-locales.js"></script>
<script src="<%=request.getContextPath()%>/jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="<%=request.getContextPath()%>/jquery/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<script>

        $(function(){

           $("#datetimepicker1").datetimepicker({
                format:'yyyy/mm/dd',
                language:'zh-CN',
                minView: "month",
                todayBtn:  1,
                autoclose: 1,
            }).on('show', function (ev) {//在控件显示时就触发事件
                var etime = $("#guangGaoEnd").val();//获取结束时间ID
                $("#datetimepicker1").datetimepicker('setEndDate', etime);//给开始控件设置一个结束的日期。//开始时间DIV的ID
            });
            $("#datetimepicker2").datetimepicker({
                format:'yyyy/mm/dd',
                language:'zh-CN',
                minView: "month",
                todayBtn:  1,
                autoclose: 1,
            }).on('show', function (ev) {
                var stime = $("#guangGaoStart").val();
                $("#datetimepicker2").datetimepicker('setStartDate', stime);//给结束控件设置一个开始日期
            });
           $("#datetimepicker3").datetimepicker({
                format:'yyyy/mm/dd',
                language:'zh-CN',
                minView: "month",
                todayBtn:  1,
                autoclose: 1,
            }).on('show', function (ev) {//在控件显示时就触发事件
                var etime = $("#guangGaoEnd2").val();//获取结束时间ID
                $("#datetimepicker3").datetimepicker('setEndDate', etime);//给开始控件设置一个结束的日期。//开始时间DIV的ID
            });
            $("#datetimepicker4").datetimepicker({
                format:'yyyy/mm/dd',
                language:'zh-CN',
                minView: "month",
                todayBtn:  1,
                autoclose: 1,
            }).on('show', function (ev) {
                var stime = $("#guangGaoStart2").val();
                $("#datetimepicker4").datetimepicker('setStartDate', stime);//给结束控件设置一个开始日期
            });


    })








        //导出excel
    $("#exportExcepButton").click(function (){
//        alert("进来了")
        //询问框
         layer.confirm('确认导出吗?', {
              btn: ['确认','取消'] //按钮
          }, function(){
             window.location.href="<%=request.getContextPath()%>/guanggaoController/ExceportExcel.do";
//             提示信息
             layer.msg('正在打包下载,请稍后');
          }, function(){
          });
    })


    $("#uploadfiy").uploadify({
        //插件自带  不可忽略的参数
        'swf': '${pageContext.request.contextPath}/uploadify/uploadify.swf',
        //前台请求后台上传文件的url  不可忽略的参数
        'uploader': '<%=request.getContextPath()%>/guanggaoController/saveGuangGaoPhotoByModel.do',
        //给div的进度条加背景  参数为<div>id属性值  不可忽略
        'queueID': 'fileQueue',
        //上传文件文件名   和file文件域的name属性一致   和后台接受的属性名对应
        'fileObjName' : 'guangGaoPhotoOss',
        //给上传按钮设置文字
        'buttonText': '上传',
        //如果为true 为自动上传  在选择文件后, 为false 那么它就要我们自己手动点上传按钮
        'auto': true,
        //可以同时选择多个文件 默认为true  不可忽略
        'multi': true,
        //上传后队列是否消失
        'removeCompleted': true,
        //队列消失时间
        'removeTimeout' : 1,
        //最大上传文件数量
        'uploadLimit':  10,
        //制定可以文件上传
        'fileExt': '*.jpg;*.jpeg;*.gif;*.png;*.doc;*.docx;*.xls;*.xlsx;*.pdf;*.txt',
        'onUploadSuccess' : function(file, data, response) {
            //截取字符串第一个和最后一个
            var str = data.substr(1);
            var s = str.substr(0, str.length - 1);
//            alert(s)
            var html = '<img src='+s+' width="100" height="100">';
            $("#show").html(html);
            $("#guangGaoPhotoUploadfiy").val(s);
        }
    })

    //修改的方法
    function   update(){
        alert($("#fg").serialize())
        $.ajax({
            url:"<%=request.getContextPath()%>/guanggaoController/updateGuangGaoById.do",
            type:"post",
            data:$("#fg").serialize(),
            success:function(result){
                $("#advertlist").bootstrapTable('refreshOptions',{pageNumber : 1});
                $('.modal-backdrop').remove();
                $('#myModal2').modal('hide');
                $('body').removeClass('modal-open');
                layer.alert('修改成功!老板', {icon: 6});
//                $("#advertlist").bootstrapTable('load', json);
//                $("").bootstrapTable('refreshOptions',{pageNumber : 1});
               /* $('#myModal2').on('hidden.bs.modal', '.modal', function () {
                    console.log("进来了")
                    $(this).removeData('bs.modal');
                });*/
            }
        })
    }

   /* //选择性导出性EXCEL
    function exportExcelDialog(){
        BootstrapDialog.show({
            title: 'Default Title',
            type: BootstrapDialog.TYPE_DEFAULT,
            closable: false,
            cssClass: 'dialog_mar',
            message: 'Hi Apple!'
        });
    }*/






    $("#searchclear").click(function(){
//        alert(999)
        var val = $("#searchinput").val();
        $.ajax({
            url:"<%=request.getContextPath()%>/guanggaoController/testGuangGaoAddress.do",
            type:"post",
            data:{"guangGaoAddess":val},
            dataType:"text",
//                    dataType:"json",
            async:false,
            success:function(testflag){
                if(testflag==200){
                    layer.alert('测试通过,可以访问', {icon: 6});
                }else{
                    layer.alert('可能有些问题,请再仔细确认哦', {icon: 6});
                }
            },
            error:function(){
                layer.alert('可能有些问题,请再仔细确认哦', {icon: 6});
            }
        });


    });
    $("#searchclear2").click(function(){
//        alert(999)
        var val = $("#guangGaoGuanWang2").val();
        $.ajax({
            url:"<%=request.getContextPath()%>/guanggaoController/testGuangGaoAddress.do",
            type:"post",
            data:{"guangGaoAddess":val},
            dataType:"text",
//                    dataType:"json",
            async:false,
            success:function(testflag){
                if(testflag==200){
                    layer.alert('测试通过,可以访问', {icon: 6});
                }else{
                    layer.alert('可能有些问题,请再仔细确认哦', {icon: 6});
                }
            },
            error:function(){
                layer.alert('可能有些问题,请再仔细确认哦', {icon: 6});
            }
        });


    });





    /*上传图片*/
    $("#guangGaoPhotoOss").fileinput({

        language: 'zh', //设置语言

        uploadUrl:"<%=request.getContextPath()%>/guanggaoController/saveGuangGaoPhotoByModel.do", //上传的地址

        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀

        //uploadExtraData:{"id": 1, "fileName":'123.mp3'},

        uploadAsync: true, //默认异步上传//这个不可更改,更改之后上传成功之后不走成功回调函数//设置后同步时需要用 “filebatchuploadsuccess”接收成功回调。。

//        showUpload:true, //是否显示上传按钮

//        showRemove :true, //显示移除按钮

        showPreview :true, //是否显示预览

        showCaption:false,//是否显示标题

        browseClass:"btn btn-primary", //按钮样式

        dropZoneEnabled: false,//是否显示拖拽区域,注释以后显示区域

        //minImageWidth: 50, //图片的最小宽度

        //minImageHeight: 50,//图片的最小高度

        //maxImageWidth: 1000,//图片的最大宽度

        //maxImageHeight: 1000,//图片的最大高度

        //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小

        //minFileCount: 0,

        maxFileCount:10, //表示允许同时上传的最大文件个数

        enctype:'multipart/form-data',

        validateInitialCount:true,

//        autoReplace:true,//是否自动替换当前图片，设置为true时，再次选择文件，会将当前的文件替换掉。

        previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",

        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
    //加上这个文件自动上传
    }).on("filebatchselected", function(event, files) {
        $(this).fileinput("upload");
    }).on("fileuploaded", function (event, data, previewId, index){
        if(data.response)
        {
            var  response  = data.response;
            layer.alert(response, {icon: 6});
        $("#guangGaoPhotoid").val(response);
        console.info(response)
        }
//
    });

    $("#guanggaotijiao").click(function(){
        $.ajax({
            url:"<%=request.getContextPath()%>/guanggaoController/saveGuangGaoByModel.do",
            type:"post",
            data:$("#guanggaoform").serialize(),
            dataType:"text",
            async:false,
            success:function(delflag){
                if(delflag=="addDataSuccess"){
                    $("#advertlist").bootstrapTable('refreshOptions',{pageNumber : 1});
                    $('#myModal2').modal('hide');//再次打开会出bug
                    //
                    $("#myModal2").remove();

                    $('body').removeClass('modal-open');
                    $('.modal-backdrop').remove();
                    layer.alert('添加成功.恭喜恭喜', {icon: 6});
                    //关闭弹框
                    $('#myaddModal').modal('hide');
//                    $('#myaddModal').on('hide.bs.modal', function () {
//                        alert('模态框关闭了');
//                    });
                }
            },
            error:function(){
                alert("删除程序出错")
            }
        });


    })

        $(function(){
            $("#advertlist").bootstrapTable({
                url: "<%=request.getContextPath()%>/guanggaoController/queryGuangGao.do",
                pagination: true,//显示分页条
                pageNumber: 1,//初始化 页数
                pageSize: 3,//初始化 条数
                pageList:  [ 15, 20, 50, 100, 200, 500,'ALL' ],//初始化 可选择的条数
                paginationLoop: false,//关闭分页的无限循环
                height: 550,//table的高度
                undefinedText: "--",//有数据为空时 显示的内容
                striped: true,//斑马线
//                showFooter: true,//表格底部角
                showColumns: true,//显示选择展示列的按钮
                showRefresh: true,//刷新按钮
                showToggle: true,//切换显示格式
                cardView: false,                    //是否显示showToggle
                showPaginationSwitch: true,//展示所有数据 和分页数据的切换按钮
                detailView: true,//列的详细页
                /*detailFormatter: function(index,row){
                    //格式化详细页
                    return '<a href="#">'+row.bname+'</a>';
                },*/
                paginationHAlign: "left",//分页按钮的显示位置
                paginationDetailHAlign: "right",//总页数 和条数的显示位置
                paginationPreText: "上一页",
                paginationNextText: "下一页",
                clickToSelect: true,//点击选中行
//                dataType: "json",//期待返回数据类型
                toolbar: "#button",
                sidePagination: "server",
//                search: true,//是否显示表格搜索，此搜索是客户端搜索，不会进服务端,所以，个人感觉意义不大
//                searchAlign:"left",//搜索框的显示位置
//                searchOnEnterKey:true, //设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
//                strictSearch:true,//设置精确匹配 true 设置模糊匹配  false 默认模糊匹配false
                method: "post",
                contentType: "application/x-www-form-urlencoded",
                columns: [

                    {checkbox:true},
                    {field:"guangGaoId",title:"编号"},
                    {field:"guangGaoName",title:"姓名"},
                    {field:"guangGaoShuoMing",title:"说明"},
                    {field:"guangGaoStart",title:"开始时间"},
                    {field:"guangGaoPhoto",title:"广告照片",
                        //显示图片
                        formatter:function(value,row,index){
                            var s;
                            if(row.guangGaoPhoto!=null){
                                var url = row.guangGaoPhoto;
                                //var i = row.companyImage.indexOf("webapps");
                                //var url = row.companyImage.substring(i+7,row.companyImage.length);
                                //var url = 'F:\idnex.jpg';
                                s = '<a class = "view"  href="javascript:void(0)"><img style="width:40px;height:40px;"  src="'+url+'" /></a>';
                            }
                            return s;
                        },
                        //定义点击之后放大图片的事件
                        events: 'operateEvents',
                    },
                    {field:"guangGaoWidth",title:"广告长度(单位px)"},
                    {field:"guangGaoHeight",title:"广告宽度(单位px)"},
                    {field:"guangGaoprice",title:"广告价格"},
                    {field:"guangGaoNum",title:"广告位置编号"},
                    {field:"guangGaoGuanWang",title:"广告目标网址"},
                    {field:"guangGaoStatus",title:"广告上架状态",
                        formatter:function(value,row,index){
                        if(value==1){
                            return "上架";

                        }else{

                            return "下架";
                        }
                        }
                    },
                    { field:'ID',
                        title: '操作',
                        width: '150',
                        align: 'center',
                        valign: 'middle',
                        formatter: actionFormatter
                    },
                ]
            })
        })



   //点击之后放大图片//也同样可以获得对象
    window.operateEvents = {

        'click .view': function (e, value, row, index) {
            console.log("进来了");
            var img = "<img src='" + value + "' />";
            layer.open({
                type: 1,
                title: false, //不显示标题
                closeBtn: 0,
                area: ['auto', 'auto'],
//                area: ['400px','400px'],
//              area: [img.width + 'px', img.height+'px'],
                offset: 'auto',
                skin: 'layui-layer-nobg', //没有背景色
                shadeClose: true,
                content: img,//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                cancel: function () {
                    //layer.msg('图片查看结束！', { time: 5000, icon: 6 });
                }
            });
        },
    };//
        /*图标的删除方法*/
        function actionFormatter(value, row, index) {
            var result = "";
            result += "<a href='javascript:;' class='btn btn-xs blue'  data-toggle='modal' data-target='#myModal2' onclick='updateGuangGaoByModel("+JSON.stringify(row)+")' title='修改'><span class='glyphicon glyphicon-pencil'></span></a>";
//            result += "<a href='javascript:;' class='btn btn-xs blue' data-target='#form表单的ID' onclick='updateGuangGaoByModel("+JSON.stringify(this)+")' title='修改'><span class='glyphicon glyphicon-pencil'></span></a>";//用console.info打印并不是那个对象用row才可以
            result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"deleteByIds('" + row.guangGaoId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
            result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"downloadById('" + row.guangGaoPhoto + "')\" title='下载'><span class='glyphicon glyphicon-download-alt'></span></a>";
            return result;
        }
        //修改方法
   function updateGuangGaoByModel(obj){
       setTimeout(function(){
       console.info(obj)
    $("#guanggaoupdateid").val(obj.guangGaoId);
    $("#guangGaoNameXiu").val(obj.guangGaoName);
    $("#guangGaoShuoMing2").val(obj.guangGaoShuoMing);
    $("#guangGaoStart2").val(obj.guangGaoStart);
    $("#guangGaoEnd2").val(obj.guangGaoEnd);
    $("#show").html('<img src='+obj.guangGaoPhoto+' width="100" height="100"/>');
    $("#guangGaoprice2").val(obj.guangGaoprice);
    $("#guangGaoNum2").val(obj.guangGaoNum);
    $("#guangGaoGuanWang2").val(obj.guangGaoGuanWang);
    $("#guangGaoWidth2").val(obj.guangGaoWidth);
    $("#guangGaoHeight2").val(obj.guangGaoHeight);
    $("[name='guangGaoStatus']").val([obj.guangGaoStatus]);
       },500);
   }
        //尝试一下oss下载图片
    function downloadById(guangGaoPhoto){
//            alert(guangGaoPhoto)
        if(guangGaoPhoto != null && guangGaoPhoto != ""){

            location.href="<%=request.getContextPath()%>/guanggaoController/downFile.do?fileUrl="+guangGaoPhoto;
        }else{
            layer.alert('服务器繁忙!请稍后再试', {icon: 6});
        }
    }
        function deleteByIds(id){

            //询问框
            layer.confirm('确认删除吗？大佬', {
                btn: ['确认','点错了'] //按钮
            }, function(){
                $.ajax({
                    url:"<%=request.getContextPath()%>/guanggaoController/deleteGuangGao.do",
                    type:"post",
                    data:{"guangGao":id},
                    dataType:"text",
                    async:false,
                    success:function(delflag){
                        if(delflag=="deleteDataSuccess"){
                            layer.alert('删除成功!恭喜', {icon: 6});
                            //可以刷新表格但是刷新以后是从第一页开始的
                            $("#advertlist").bootstrapTable('refreshOptions',{pageNumber : 1});
                        }
                    },
                    error:function(){
                        alert("删除程序出错")
                    }
                });
            }, function(){
                layer.msg('撤销成功', {
                    time: 20000, //20s后自动关闭
                    btn: ['确定']
                });
            });

        }
        //批量删除
    function upCheck() {
        var arr = $("#advertlist").bootstrapTable("getSelections");
        var ids = [];
        if (arr != '') {
            for (var i = 0; i < arr.length; i++) {
                ids.push(arr[i].guangGaoId)
            }
        }

//alert(ids)
        $.ajax({
            url: "<%=request.getContextPath()%>/guanggaoController/deleteGuangGaoAll.do",
            type: "post",
            //如果Post是string数组或者int数组，则ajax中traditional: true,如果Post是对象数组，则ajax中traditional: false,否则对象将为空
            traditional: true,
            data: {"ids": ids},
            success: function (result) {
                if (result == "deleteDataSuccess") {
                    layer.alert('删除成功!恭喜', {icon: 6});
                    $("#advertlist").bootstrapTable('refreshOptions',{pageNumber : 1});
                }
            }
        })
    }
        function  queryBrand(){

            $("#advertlist").bootstrapTable('refresh',{query:{sname:$("#nn").val()}});

        }
        function clearsearch(){
            //刷新表格
            $("#advertlist").bootstrapTable('refreshOptions',{pageNumber : 1});
        }
</script>

</body>
</html>
