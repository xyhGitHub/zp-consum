<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/21
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增公告</title>
</head>
<body>
    <form id="addNoticeForm">
        <input type="hidden" id="noticeId" name="noticeId" >
        公告标题<input name="noticeTitle" class="easyui-textbox" style="width:150px;"/><br>
        公告类型
            <select id="noticeTypeSelect" class="easyui-combobox" name="noticeType" style="width:150px;">
                <option value="0">请选择类型</option>
                <option value="1">活动预热</option>
                <option value="2">系统更新</option>
                <option value="3">警告专版</option>
            </select><br>
        公告内容<textarea name="noticeContent" placeholder="最多150字"  required="requirde"></textarea>
    </form>

</body>
</html>
