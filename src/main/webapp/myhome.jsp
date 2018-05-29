<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/17
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的公司</title>
</head>
<link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script src="style/js/additional-methods.js" type="text/javascript"></script>
<body onload="checkLogin()">
<script type="text/javascript">
    var youdao_conv_id = 271546;
</script>
<script src="style/js/conv.js" type="text/javascript"></script>
<script src="style/js/ajaxCross.json" charset="UTF-8"></script>
<div id="body">
    <input type="hidden" value="${laGouComSession.loginName}" id="ifLoginGs">
    <div id="header">
        <div class="wrapper">
            <a class="logo" href="#">
                <img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
            </a>
            <ul id="navheader" class="reset">
                <%--<li><a href="#">首页</a></li>--%>
                <li class="current"><a href="companylist.jsp">公司</a></li>
                <li><a target="_blank" href="">论坛</a></li>
                <li>
                    <a rel="nofollow" href="">简历管理</a>
                </li>
                <li><a rel="nofollow" href="creatzhiwei.jsp">发布职位</a></li>
            </ul>
            <dl class="collapsible_menu">
                <dt>
                    <span>${laGouComSession.loginName}&nbsp;</span>
                    <span class="red dn" id="noticeDot-1"></span>
                    <i></i>
                </dt>
                <dd><a href="creatzhiwei.jsp">我发布的职位</a></dd>
                <dd><a href="">我收到的简历</a></dd>
                <dd class="btm"><a href="myhome.jsp">我的公司主页</a></dd>
                <%--<dd><a href="jianli.jsp">我要找工作</a></dd>--%>
                <%--<dd><a href="accountBind.html">帐号设置</a></dd>--%>
                <dd class="logout"><a rel="nofollow" onclick="tuichu()">退出</a></dd>
            </dl>
        </div>
    </div><!-- end #header -->
    <div id="container">
        <div class="clearfix">
            <div class="content_l">
                <div class="c_detail">
                    <div style="background-color:#fff;" class="c_logo" id="editshow">

                        <a title="上传公司LOGO" id="logoShow" class="inline cboxElement" href="#logoUploader">
                            <img width="190" height="190" alt="公司logo" src="${com.list.comphoto}">

                        </a>
                    </div>
                    <div class="c_box companyName">
                        <h2 title="${com.list.comname}">${com.list.comname}</h2>

                        <em class="unvalid"></em>
                        <span class="va dn" id="shenhe" ></span>

                        <a target="_blank" class="applyC" href="renzheng.jsp">${com.list.comshenhe}</a>

                        <div class="clear">${com.list.comshenhe}</div>

                        <form class="clear editDetail dn"  href="<%=request.getContextPath()%>/gongsiController/editgongshiname.do" id="editDetailForm">
                            <input  type="text" placeholder="请输入公司简称" maxlength="15" value="${com.list.comshenhe}" name="comname" id="companyShortName">
                        <br/>公司规模 <input type="text" placeholder="一句话描述公司优势，核心价值，限50字" maxlength="50" value="${com.list.comguimo}" name="comguimo" id="companyFeatures">
                            <input type="hidden" value="${com.list.comid}"  name="comid">
                            <input type="submit" value="保存" id="saveDetail" class="btn_small">
                            <a id="cancelDetail" class="btn_cancel_s" >取消</a>
                        </form>

                        <div class="clear oneword"><img width="17" height="15" src="style/images/quote_l.png">&nbsp; <span>测试的发打发打发大范德萨发</span> &nbsp;<img width="17" height="15" src="style/images/quote_r.png"></div>
                        <h3 class="dn">已选择标签</h3>
                        <ul style="overflow:auto" id="hasLabels" class="reset clearfix">
                            <li><span>年终分红</span></li>
                            <li><span>五险一金</span></li>
                            <li><span>弹性工作</span></li>
                            <li><span>岗位晋升</span></li>
                            <li class="link">编辑</li>
                        </ul>
                        <div class="dn" id="addLabels">
                            <a id="changeLabels" class="change" href="javascript:void(0)">换一换</a>
                            <input type="hidden" value="${laGouComSession.comid}" id="labelPageNo">
                            <input type="submit" value="贴上" class="fr" id="add_label">
                            <input type="text" placeholder="添加自定义标签" name="label" id="label" class="label_form fr">
                            <div class="clear"></div>
                            <ul class="reset clearfix"> </ul>
                            <a id="saveLabels" class="btn_small" href="javascript:void(0)">保存</a>
                            <a id="cancelLabels" class="btn_cancel_s" href="javascript:void(0)">取消</a>
                        </div>
                    </div>
                    <a title="编辑基本信息" class="c_edit" id="editCompanyDetail" href="javascript:void(0);"></a>
                    <div class="clear"></div>
                </div>

                <div class="c_breakline"></div>

                <div id="Profile">
                    <div class="profile_wrap">
                        <!--无介绍 -->
                        <dl class="c_section dn">
                            <dt>
                            <h2><em></em>公司介绍</h2>
                            </dt>
                            <dd>
                                <div class="addnew">
                                    详细公司的发展历程、让求职者更加了解你!<br>
                                    <a id="addIntro" href="javascript:void(0)">+添加公司介绍</a>
                                </div>
                            </dd>
                        </dl>
                        <!--编辑介绍-->
                        <dl class="c_section newIntro dn">
                            <dt>
                            <h2><em></em>公司介绍</h2>
                            </dt>
                            <dd>
                                <form id="companyDesForm">
                                    <textarea placeholder="请分段详细描述公司简介、企业文化等" name="comjieshao" id="comjieshao">
                                    </textarea>
                                    <div class="word_count fr">你还可以输入 <span>1000</span> 字</div>
                                    <div class="clear"></div>
                                    <input type="submit" value="保存" id="submitProfile" class="btn_small">
                                    <a id="delProfile" class="btn_cancel_s" href="javascript:void(0)">取消</a>
                                </form>
                            </dd>
                        </dl>

                        <!--有介绍-->
                        <dl class="c_section">
                            <dt>
                            <h2><em></em>公司介绍</h2>
                            </dt>
                            <dd>
                                <div class="c_intro">                                                                           ${com.list.comjieshao}
                                </div>
                                <a title="编辑公司介绍" id="editIntro" class="c_edit" href="javascript:void(0)"></a>
                            </dd>
                        </dl>
                    </div>

                </div><!-- end #Profile -->

                <!--[if IE 7]> <br /> <![endif]-->

                <!--无招聘职位-->
                <dl id="noJobs" class="c_section">
                    <dt>
                    <h2><em></em>招聘职位</h2>
                    </dt>
                    <dd>
                        <div class="addnew">
                            发布需要的人才信息，让伯乐和千里马尽快相遇……<br>
                            <a href="creatzhiwei.jsp">+添加招聘职位</a>
                        </div>
                    </dd>
                </dl>

                <input type="hidden" value="" name="hasNextPage" id="hasNextPage">
                <input type="hidden" value="" name="pageNo" id="pageNo">
                <input type="hidden" value="" name="pageSize" id="pageSize">
                <div id="flag"></div>
            </div>	<!-- end .content_l -->

            <div class="content_r">
                <div id="Tags">
                    <div id="c_tags_show" class="c_tags solveWrap">
                        <table>
                            <tbody><tr>
                                <td width="45">地点</td>
                                <td>  ${com.list.comaddress}</td>
                            </tr>

                            <tr>
                                <td>规模</td>
                                <td>  ${com.list.comguimo}</td>
                            </tr>

                            </tbody></table>
                        <a id="editTags" class="c_edit" href="javascript:void(0)"></a>
                    </div>
                    <div id="c_tags_edit" class="c_tags editTags dn">
                        <form id="tagForms">
                            <table>
                                <tbody><tr>
                                    <td>地点</td>
                                    <td>
                                        <input type="text" placeholder="请输入地点" value="${com.list.comaddress}" name="comaddress" id="city">
                                    </td>
                                </tr>

                                <tr>
                                    <td>规模</td>
                                    <td>
                                        <input type="hidden" value=" ${com.list.comguimo}" id="companySize" name="comguimo">
                                        <input type="button" value="150-500人" id="select_sca" class="select_tags">
                                        <div class="selectBox dn" id="box_sca" style="display: none;">
                                            <ul class="reset">
                                                <li>少于15人</li>
                                                <li>15-50人</li>
                                                <li>50-150人</li>
                                                <li class="current">150-500人</li>
                                                <li>500-2000人</li>
                                                <li>2000人以上</li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>

                                </tbody></table>

                            <input type="submit" value="保存" id="submitFeatures" class="btn_small">
                            <a id="cancelFeatures" class="btn_cancel_s" href="javascript:void(0)">取消</a>
                            <div class="clear"></div>
                        </form>
                    </div>
                </div><!-- end #Tags -->

                <div id="Member">
                    <!--有创始团队-->
                    <dl class="c_section c_member">
                        <dt>
                        <h2><em></em>创始团队</h2>
                        <a title="添加创始人" class="c_add" href="javascript:void(0)"></a>
                        </dt>
                        <dd>

                            <div class="member_wrap">

                                <!-- 无创始人 -->
                                <div class="member_info addnew_right dn">
                                    展示公司的领导班子，<br>提升诱人指数！<br>
                                    <a class="member_edit" href="javascript:void(0)">+添加成员</a>
                                </div>

                                <!-- 编辑创始人 -->
                                <div class="member_info newMember dn">
                                    <form class="memberForm">
                                        <div class="new_portrait">
                                            <div class="portrait_upload dn portraitNo">
                                                <span>上传创始人头像</span>
                                            </div>
                                            <div class="portraitShow">
                                                <img width="120" height="120" src="style/images/leader_default.png">
                                                <span>更换头像</span>
                                            </div>
                                            <input type="file" value="" title="支持jpg、jpeg、gif、png格式，文件小于5M" onchange="member_check(this,'http://www.lagou.com/c/upload.json','portraitNo','portraitShow','type','leaderInfos');" name="myfiles" id="profiles0">
                                            <input type="hidden" value="7" name="type" class="type">
                                            <input type="hidden" value="images/leader_default.png" name="photo" class="leaderInfos">
                                            <em>
                                                尺寸：120*120px <br>
                                                大小：小于5M
                                            </em>
                                        </div>
                                        <input type="text" placeholder="请输入创始人姓名" value="孙泰英" name="name">
                                        <input type="text" placeholder="请输入创始人当前职位" value="ceo" name="position">
                                        <input type="text" placeholder="请输入创始人新浪微博地址" value="http://weimob.weibo.com" name="weibo">
                                        <textarea placeholder="请输入创始人个人简介" maxlength="500" class="s_textarea" name="remark">写一个个人的查询，放到session，显示简介</textarea>
                                        <div class="word_count fr">你还可以输入 <span>500</span> 字</div>
                                        <div class="clear"></div>
                                        <input type="submit" value="保存" class="btn_small">
                                        <a class="btn_cancel_s member_delete" href="javascript:void(0)">删除</a>
                                        <input type="hidden" value=" ${com.list.comid}" class="leader_id">
                                    </form>
                                </div>

                                <!-- 显示创始人 -->
                                <div class="member_info">
                                    <a title="编辑创始人" class="c_edit member_edit" href="javascript:void(0)"></a>
                                    <div class="m_portrait">
                                        <div></div>
                                        <img width="120" height="120" alt=" ${com.list.comguimo}" src="style/images/leader_default.png">
                                    </div>
                                    <div class="m_name">
                                        孙泰英
                                        <a target="_blank" class="weibo" href="http://weimob.weibo.com"></a>
                                    </div>
                                    <div class="m_position">ceo</div>
                                    <div class="m_intro">发放的发达范德萨范德萨范德萨发的复大发大水发生的</div>
                                </div>

                            </div><!-- end .member_wrap -->
                        </dd>
                    </dl>
                </div> <!-- end #Member -->


                <!--公司深度报道-->
                <div id="Reported">
                    <!--无报道-->
                    <dl class="c_section c_reported">
                        <dt>
                        <h2><em></em>公司深度报道</h2>
                        <a title="添加报道" class="c_add" href="javascript:void(0)"></a>
                        </dt>
                        <dd>
                            <!-- 编辑报道 -->
                            <ul class="reset"><li>
                                <a style="" class="article" title="随便写" target="_blank" href="http://www.baidu.com">随便写</a>
                                <a title="编辑报道" class="c_edit dn" href="javascript:;" style="display: inline;"></a>
                                <form class="reportForm dn">
                                    <input type="text" placeholder="请输入文章标题" value="" name="articleTitle" class="valid">
                                    <input type="text" placeholder="请输入文章链接" value="" name="articleUrl" class="valid"><span for="articleUrl" generated="true" class="error" style="display: none;">请输入有效的文章链接</span>
                                    <input type="submit" value="保存" class="btn_small">
                                    <a class="btn_cancel_s report_delete" href="javascript:;">删除</a>
                                    <input type="hidden" value="5235" class="article_id">
                                </form>
                            </li><li>
                                <a style="" class="article" title="随便写" target="_blank" href="http://www.baidu.com">随便写</a>
                                <a title="编辑报道" class="c_edit dn" href="javascript:;" style="display: inline;"></a>
                                <form class="reportForm dn">
                                    <input type="text" placeholder="请输入文章标题" value="" name="articleTitle" class="valid">
                                    <input type="text" placeholder="请输入文章链接" value="" name="articleUrl" class="valid">
                                    <input type="submit" value="保存" class="btn_small">
                                    <a class="btn_cancel_s report_delete" href="javascript:;">删除</a>
                                    <input type="hidden" value="5236" class="article_id">
                                </form>
                            </li></ul>

                            <!-- 无报道 -->
                            <div class="addnew_right reported_info dn">
                                展示外界对公司的深度报道，<br>便于求职者了解公司！<br>
                                <a class="report_edit" href="javascript:void(0)">+添加报道</a>
                            </div>

                            <ul class="newReport dn">
                                <li>
                                    <a style="display:none;" class="article" title="" target="_blank" ></a>
                                    <a title="编辑报道" class="c_edit dn" href="javascript:;"></a>
                                    <form class="reportForm">
                                        <input type="text" placeholder="请输入文章标题" value="" name="articleTitle">
                                        <input type="text" placeholder="请输入文章链接" value="" name="articleUrl">
                                        <input type="submit" value="保存" class="btn_small">
                                        <a class="btn_cancel_s report_cancel" href="javascript:;">取消</a>
                                        <input type="hidden" value="" class="article_id">
                                    </form>
                                </li>
                            </ul>
                        </dd>
                    </dl><!-- end .c_reported -->
                </div><!-- end #Reported -->

            </div>
        </div>

        <!-------------------------------------弹窗lightbox  ----------------------------------------->
        <div style="display:none;">
            <div style="width:650px;height:470px;" class="popup" id="logoUploader">


                公司头像：<img width="190" height="190" alt="公司logo" src="${com.list.comphoto}">

                <input type="file" id="file" name="image">
                <input type="hidden" id="comid" value="${com.list.comid}" name="id">

                <div id="show"></div>

            </div><!-- #logoUploader -->
        </div>
        <!------------------------------------- end ----------------------------------------->
        <script type="text/javascript" src="<%=request.getContextPath()%>/jquery/uploadify/jquery.uploadify.min.js"></script>
        <link  rel="stylesheet"  href="<%=request.getContextPath()%>/jquery/uploadify/uploadify.css"/>
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
                    var html = ' <img width="190" height="190" alt="公司logo"src='+data+'>';
                   var comid= $("#comid").val(); //取value值
//                    alert(data)
                        $("#show").append(html);
                    $("[name='fileid']").val(data);
                        var photo =data;
                    $.ajax({
                        url:"<%=request.getContextPath()%>/gongsiController/gongsieditphoto.do?comid="+comid,
                        data:{"photo":photo},
                        type:"post",
                        dataType :"json",
                        success:function(){
                            alert("修改图片成功")
                       //     BootstrapDialog.closeAll();
                        },
                        error:function () {
                            alert("错误")

                        }
                    })

                }

            })

        </script>
        <script src="style/js/company.min.js" type="text/javascript"></script>
        <script>
            var avatar = {};
            avatar.uploadComplate = function( data ){
                var result = eval('('+ data +')');
                if(result.success){
                    jQuery('#logoShow img').attr("src",ctx+ '/'+result.content);
                    jQuery.colorbox.close();
                }
            };
        </script>

        <div class="clear"></div>
        <input type="hidden" value="d1035b6caa514d869727cff29a1c2e0c" id="resubmitToken">
        <a rel="nofollow" title="回到顶部" id="backtop" style="display: inline;"></a>
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

<%--页面加载判断是否登陆--%>
<script>
    function checkLogin(){
        var val = $("#ifLoginGs").val();
        if(!val){
            alert("您未登录,请您前往登录!");
            location.href="GsLaGouLogin.jsp";
        }
    }

</script>

<script type="text/javascript">

    $.ajax({
        url:"<%=request.getContextPath()%>/gongsiController/gongsilist.do",
        type:"post",
        dataType:"json",
        async:true,
        success:function(data){

        },
        error:function () {
            alert("错误")

        }
    })

    /* 加载小类的所有商品 */
    $.ajax({
        url:"<%=request.getContextPath()%>/gongsiController/gongsilist.do",
        type:"post",
        dataType:"json",
        async:true,
        success:function(data){

        },
        error:function () {
            alert("错误")

        }
    })




        //注销
    function tuichu() {
        $.ajax({
            url:"<%=request.getContextPath()%>/loginController/zhuXiaoGs.do",
            type:"post",
            success:function(data){
                location.href="GsLaGouLogin.jsp";
            },
            error:function () {
                alert("请重新注销")
            }
        })
    }


</script>


</body></html>