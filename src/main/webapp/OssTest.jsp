<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/17
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传测试</title>
</head>
<%@include file="bootstrapjs.txt"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/uploadify/jquery.uploadify.min.js"></script>
<link  rel="stylesheet"  href="<%=request.getContextPath()%>/jquery/uploadify/uploadify.css"/>
<body>
<%--<form action="<%=request.getContextPath()%>/ossController/saveFile.do" method="post" enctype="multipart/form-data">--%>
    <%--<div class="form-group">--%>
        <%--<label for="exampleInputFile">File input</label>--%>
        <%--<input type="file" id="exampleInputFile" name="image">--%>
    <%--</div>--%>
<input type="file" id="file" name="image">

<div id="show">
    <%--<button type="submit" class="btn btn-default">Submit</button>--%>
<%--</form>--%>

</body>
<script type="text/javascript">
    $("#file").uploadify({
        //插件自带  不可忽略的参数
        'swf': '${pageContext.request.contextPath}/jquery/uploadify/uploadify.swf',
        //前台请求后台上传文件的url  不可忽略的参数
        'uploader': '${pageContext.request.contextPath}/uploadController/uploadFile.do',
        //给div的进度条加背景  参数为<div>id属性值  不可忽略
        'queueID': 'fileQueue',
        //上传文件文件名   和file文件域的name属性一致   和后台接受的属性名对应
        'fileObjName' : 'image',
        //给上传按钮设置文字
        'buttonText': '上传',
        //如果为true 为自动上传  在选择文件后, 为false 那么它就要我们自己手动点上传按钮
        'auto': true,
        //可以同时选择多个文件 默认为true  不可忽略
        'multi': false,
        //上传后队列是否消失
        'removeCompleted': true,
        //队列消失时间
        'removeTimeout' : 1,
        //最大上传文件数量
        'uploadLimit':  10,
        //制定可以文件上传
        'fileExt': '*.jpg;*.jpeg;*.gif;*.png;*.doc;*.docx;*.xls;*.xlsx;*.pdf;*.txt',
        'onUploadSuccess' : function(file, data, response) {
            alert(data);
            var html = '<img src='+data+' width="100" height="100">';
            $("#show").append(html);
            $("[name='fileid']").val(data);


        }

    })
</script>
</html>
