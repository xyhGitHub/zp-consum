<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册人数统计</title>
</head>
<script src="<%=request.getContextPath()%>/jquery/jquery.min.js"></script>
<!-- echars -->
<script src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
<body style="height: 100%; margin: 0">
<div id="containers_regTongji" style="height: 100%"></div>
<script type="text/javascript">
    var dom = document.getElementById("containers_regTongji");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        xAxis: {
            type: 'category',
            //这里是x轴,查询显示类别
            data: []
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            //这里是需要查询的y轴数据,数量
            data: [],
            type: 'line'
        }]
    };
    ;

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var names=[];    //类别数组（实际用来盛放X轴坐标值）
    var nums=[];    //销量数组（实际用来盛放Y坐标值）

    $.ajax({
        type : "post",
        //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        async : true,
        url : "<%=request.getContextPath()%>/loginController/tongJiRegNum.do",
        data : {},
        dataType : "json",        //返回数据形式为json
        success : function(result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                for(var i=0;i<result.length;i++){
                    names.push(result[i].names);    //挨个取出类别并填入类别数组
                }
                for(var i=0;i<result.length;i++){
                    nums.push(result[i].nums);    //挨个取出销量并填入销量数组
                }
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表
                    xAxis: {
                        data: names
                    },
//                    yAxis: {
//                        data: names
//                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '注册人数',
                        data: nums
                    }]
                });

            }

        },
        error : function(errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }

    })
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
</script>
</body>
</html>
