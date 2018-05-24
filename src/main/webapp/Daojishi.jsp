<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var times = 60 * 100; // 60秒
		countTime = setInterval(function() {
			times = --times < 0 ? 0 : times;
			var ms = Math.floor(times / 100).toString();

			if(ms.length <= 1) {
				ms = "0" + ms;
			}
			var hm = Math.floor(times % 100).toString();
			if(hm.length <= 1) {
				hm = "0" + hm;
			}
			if(times == 0) {
				alert("游戏结束");
				clearInterval(countTime);
			}
			// 获取分钟、毫秒数
			$(".a").html(ms);
			$(".b").html(hm);
		}, 10);
	});
</script>
<style>
	.warp{
		width: 100%;
		height: 100px;
		line-height: 100px;
		text-align: center;
		font-size: 40px;
		font-family: "微软雅黑";
	}
	.warp strong{
		width: 100px;
		display: inline-block;
		text-align: center;
		font-family: georgia;
		color: #C9302C;
	}
</style>
<body>

<div>
	<strong class="a">111</strong>秒 <strong class="b"></strong>毫秒
</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
	

</body>
</html>