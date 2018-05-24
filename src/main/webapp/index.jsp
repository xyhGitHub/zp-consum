<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司后台系统</title>
    <%@include file="bootstrapjs.txt"%>
</head>
<body>

			<nav class="navbar navbar-default" align="center" style="background:pink;height:100px;">
                <div class="container-fluid"  align="center">
                         <h1 style="color:#FAFAD2"><center><b>欢迎登录勾手管理系统 <b></center></h1>
                </div>
			</nav>
	<%--<div class="container">
			<div class="row clearfix">
			<div class="col-md-3 column" style="position:relative;right:100px;bottom:20px">
				 <div id="tree"  class="icon-th-list "></div>
			</div>

			<div class="col-md-9 column">
					<ul class="nav nav-tabs" style="background:#333366;position:relative;right:100px;bottom:20px ">
					</ul>
					<div class="tab-content" style="position:relative;right:100px;bottom:20px ">

					</div>
				</div>
			</div>
		</div>--%>

			<div class="container-fluid">
				<div class="row" style="height:  625px;">
					<div class="col-xs-2"  style="height: 100%;">
						<div id="tree"></div>
					</div>
					<div class="col-xs-10 " style="height: 100%;">
						<div class="nav nav-tabs"></div>
						<div class="tab-content"></div>
					</div>
				</div>
			</div>

			<script type="text/javascript">

        function getTree(){
            var value;
            $.ajax({
                url:"<%=request.getContextPath()%>/treeController/getTree.do",
                type:"post",
                dataType:"json",
                async:false,
                success:function(data){
                    value =data;
                }
            })
            return value;
        }

        $("#tree").treeview({
            data:getTree(),
            collapseIcon:"glyphicon glyphicon-star-empty",
            expandIcon:"glyphicon glyphicon-star",
            onNodeSelected: function(event, node) {
                if(node.nodes == undefined){
                    if(node.url!=null){
                        $.ajax({
                            url:node.url,
                            type:"post",
                            dataType:"html",
                            success:function(data){
                                $.addtabs.add({
                                    title:node.text,
                                    content:data
                                })
                            }
                        })
						/* $.addtabs.add({
						 title:node.text,
						 url:node.url
						 })
						 $.addtabs.close({id:node.id}) */
                    }
                }


            }
        })

	</script>
</body>
</html>