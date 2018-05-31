<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/30
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公司已经发布的职位</title>
</head><script type="text/javascript">
    var ctx = "http://www.lagou.com";
    console.log(1);
</script>
<link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script src="style/js/additional-methods.js" type="text/javascript"></script>
<!--[if lte IE 8]>
<script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
    var youdao_conv_id = ${laGouComSession.comid};
</script>
<script src="style/js/conv.js" type="text/javascript"></script>
<script src="style/js/ajaxCross.json" charset="UTF-8"></script></head>
<body>
<div id="body">
    <div id="header">
        <div class="wrapper">
            <a class="logo" href="http://www.lagou.com/">
                <img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
            </a>
            <ul id="navheader" class="reset">
                <li><a href="index.html">首页</a></li>
                <li><a href="companylist.html">公司</a></li>
                <li><a target="_blank" href="http://www.lagou.com/toForum.html">论坛</a></li>
                <li><a rel="nofollow" href="jianli.html">我的简历</a></li>
            </ul>
            <dl class="collapsible_menu">
                <dt>
                    <span>${laGouComSession.loginName}&nbsp;</span>
                    <span class="red" id="noticeDot-0"></span>
                    <i></i>
                </dt>
                <dd><a rel="nofollow" href="jianli.html">我的简历</a></dd>
                <dd><a href="collections.html">我收藏的职位</a></dd>
                <dd><a href="delivery.html">我投递的职位 <span id="noticeNo" class="red">(1)</span></a></dd>
                <dd class="btm"><a href="subscribe.html">我的订阅</a></dd>
                <dd><a href="create.html">我要招人</a></dd>
                <dd><a href="accountBind.html">帐号设置</a></dd>
                <dd class="logout"><a rel="nofollow" href="login.html">退出</a></dd>
            </dl>
            <div id="noticeTip">
                <span class="bot"></span>
                <span class="top"></span>
                <a target="_blank" href="delivery.html"><strong>1</strong>条新投递反馈</a>
                <a class="closeNT" href="javascript:;"></a>
            </div>
        </div>
    </div><!-- end #header -->
    <div id="container">
        <div class="sidebar">
            <a class="btn_create" href="create.html">发布新职位</a>
            <dl class="company_center_aside">
                <dt>我收到的简历</dt>
                <dd>
                    <a href="unHandleResumes.html">待处理简历</a>
                </dd>
                <dd>
                    <a href="canInterviewResumes.html">待定简历</a>
                </dd>
                <dd>
                    <a href="haveNoticeResumes.html">已通知面试简历</a>
                </dd>
                <dd>
                    <a href="haveRefuseResumes.html">不合适简历</a>
                </dd>
                <dd class="btm">
                    <a href="autoFilterResumes.html">自动过滤简历</a>
                </dd>
            </dl>
            <dl class="company_center_aside">
                <dt>我发布的职位</dt>
                <dd class="current">
                    <a href="positions.html">有效职位</a>
                </dd>
                <dd>
                    <a href="positions.html">已下线职位</a>
                </dd>
            </dl>
        </div><!-- end .sidebar -->
        <div class="content" id="showzhiwei">
            <%--<dl class="company_center_content">--%>
                <%--<dt>--%>
                <%--<h1>--%>
                    <%--<em></em>--%>
                    <%--有效职位 <span>（共<i style="color:#fff;font-style:normal" id="positionNumber">1</i>个）</span>                        </h1>--%>
                <%--</dt>--%>

        </div><!-- end .content -->
        <script src="style/js/job_list.min.js" type="text/javascript"></script>
        <div class="clear"></div>
        <input type="hidden" value="74fb1ce14ebf4e2495270b0fbad64704" id="resubmitToken">
        <a rel="nofollow" title="回到顶部" id="backtop"></a>
    </div><!-- end #container -->
</div><!-- end #body -->
<div id="footer">
    <div class="wrapper">
        <a rel="nofollow" target="_blank" href="about.html">联系我们</a>
        <a target="_blank" href="http://www.lagou.com/af/zhaopin.html">互联网公司导航</a>
        <a rel="nofollow" target="_blank" href="http://e.weibo.com/lagou720">拉勾微博</a>
        <a rel="nofollow" href="javascript:void(0)" class="footer_qr">拉勾微信<i></i></a>
        <div class="copyright">&copy;2013-2014 Lagou <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备14023790号-2</a></div>
    </div>
</div>

<script src="style/js/core.min.js" type="text/javascript"></script>
<script src="style/js/popup.min.js" type="text/javascript"></script>
<script src="style/js/tongji.js" type="text/javascript"></script>
<!--  -->
<script src="style/js/analytics01.js" type="text/javascript"></script><script type="text/javascript" src="style/js/h.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:"<%=request.getContextPath()%>/zhiweiController/selectJianLIlist.do",
            type:"post",
            dataType:"json",
            async:true,
            success:function(data){
                var str ="";
                for (var i=0 ;i<data.length;i++) {
                    str+="<li class='clearfix'><div class='hot_pos_l'><div class='mb10'>职位名称：<a href='#' target='_blank'>"+data[i].name+"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class='c9'>"+data[i].city+"</span> &nbsp;&nbsp;&nbsp;<span><em class='c7'> 薪资情况:</em>"+data[i].xinzi+"</span></br> <span><em class='c7'>工作经验:</em>"+data[i].jingyan+"</span><br/></div> <div class='hot_pos_r'><a  href='javascript:void(0)' onclick='bianji("+data[i].id+",+"+data[i].daid+",+"+data[i].xiaoid+")'>编辑</a>&nbsp;&nbsp;&nbsp;<a  href='javascript:void(0)' onclick='shanchu("+data[i].id+",+"+data[i].daid+",+"+data[i].xiaoid+")'>删除</a>&nbsp;&nbsp;&nbsp;<a  href='javascript:void(0)' onclick='zhuangtai("+data[i].id+",+"+data[i].daid+",+"+data[i].xiaoid+")'>下架</a></div> <span>----------------------------------------------------</span></li>";

                }
                $("#showzhiwei").html(str);

            },
            error:function () {
                alert("错误")

            }
        });
    })

    /**
     *编辑简历
     * @param id
     * @param daid
     * @param xiaoid
     */
function bianji(zhiweiid,daid,xiaoid) {
    $.ajax({
        url:"<%=request.getContextPath()%>/zhiweiController/updatajianli.do?xiaoid="+xiaoid,
        type:"post",
        data:{"zhiweiid":zhiweiid,"daid":daid},
        success:function () {
            window.open("UpdataZhiWei.jsp");
        }

    })
}
    /**
     * 简历显示删除
     * @param id
     * @param daid
     * @param xiaoid
     */
    function  shanchu(id,daid,xiaoid) {
    $.ajax({
        url:"<%=request.getContextPath()%>/zhiweiController/deleteJianLIById.do?xiaoid="+xiaoid,
        type:"post",
        data:{"zhiweiid":id,"daid":daid},
        datatype:"json",
        async:"true",
        success: function () {
            alert("删除成功")
            window.location.reload();
        },
        error :function () {
            alert("错误")
        },

    })
}
</script>

<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div></body></html>
