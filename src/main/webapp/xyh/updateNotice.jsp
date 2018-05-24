<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/21
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改notice</title>
</head>
<body>
    <form id="editNoticeForm">
        <input type="hidden" id="noticeId" name="noticeId" value="${noticeId}">
        公告标题<input name="noticeTitle" id="noticeTitle" class="easyui-textbox"/><br>
        <%--公告类型<input name="noticeType" id="noticeType" class="easyui-combobox"/><br>--%>
        公告类型<select id="noticeType" class="easyui-combobox" name="noticeType" >
            <option value="0">请选择类型</option>
            <option value="1">活动预热</option>
            <option value="2">系统更新</option>
            <option value="3">警告专版</option>
        </select><br>
        公告内容<textarea name="noticeContent" placeholder="最多150字" id="noticeContent" required="requirde"></textarea>
    </form>

    <script>

       var noticeId = $("#noticeId").val();
        $.ajax({
            url: "<%=request.getContextPath()%>/noticeController/queryNoticeById.do",
            data: {"noticeId":noticeId},
            type: "post",
            success: function (result) {
                var parse = JSON.parse(result);
//                alert(parse.noticeTitle);
                $("#noticeTitle").val(parse.noticeTitle);
                if(parse.noticeType == 3){
                    $("#noticeType").val("警告专版");
                }else  if(parse.noticeType == 2){
                    $("#noticeType").val("系统更新");
                }else if(parse.noticeType == 1){
                    $("#noticeType").val("活动预热");
                }
                $("#noticeContent").html(parse.noticeContent);
            },
            error: function () {
                $.messager.alert('警告', '报错了呀', 'warning');
            }
        })
    </script>
</body>
</html>
