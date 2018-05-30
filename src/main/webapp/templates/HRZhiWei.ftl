<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <style type="text/css">
  table.gridtable {
      font-family: verdana,arial,sans-serif;
     font-size:11px;
      color:#333333;
      border-width: 1px;
      border-color: #666666;
      border-collapse: collapse;
 }
 table.gridtable th {
     border-width: 1px;
     padding: 8px;
     border-style: solid;
     border-color: #666666;
     background-color: #dedede;
 }
 table.gridtable td {
     border-width: 1px;
     padding: 8px;
     border-style: solid;
     border-color: #666666;
     background-color: #ffffff;
 }
 </style>
</head>
<body>
    <center>
          <table class="gridtable" border="1">
            <tr>
              <th>编号</th>
              <th>应聘职位</th>
              <th>应聘者电话</th>
              <th>应聘者性别</th>

            </tr>
              <#list  list as  user>
              <tr>
                <td>${user.userid}</td>
                <td>${user.zhiweiname}</td>
                <td>${user.userphone}</td>
                <td>${user.usersex}</td>
              </tr>
              </#list>
          </table>
        
        </center>
  
  
              </body>
</html>