<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>爱因思果</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>/static/plugin/aui/css/aui.css">
<link href="iTunesArtwork@2x.png" sizes="114x114"
	rel="apple-touch-icon-precomposed">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/plugin/aui/css/aui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/plugin/aui/css/aui-iconfont.ttf" />
<style type="text/css">
      .text-white {
            color: black !important;
        }
        .aui-grid [class*=aui-col-] {
            padding: 0.75rem 0;
        }
        .aui-bg-info {
    background-color: #fff!important;
}
.aui-text-number{color:#f39c26;}
.icon {
    width: 20px;
    height: 20px;
    display: block;
    border: none;
    float: left;
    background-size: 20px;
    background-repeat: no-repeat;
}
#my{
   margin-bottom:-1px;}
   #news{
   margin-bottom:-1px;}
   .aui-flexView{overflow:visible;}
</style>
</head>
<body>
 <!-- 顶部 -->
 <section class="aui-flexView">
		<header class="aui-bar aui-bar-nav aui-bar-light" style="color: black;">
    <div class="aui-title">个人中心</div>
</header>
<section class="aui-scrollView">
    <section class="aui-content" id="user-info">
        <div class="aui-list aui-media-list aui-list-noborder aui-bg-info" style="margin-top: 1px;">
            <div class="aui-list-item aui-list-item-middle" style="height:4.5rem;padding-top: 1%;" id="information">
                <div class="aui-media-list-item-inner" style="height: 4rem;">
                
                    <div class="aui-list-item-media" style="width:4rem;">
                        <img id="avatar" src="http://www.517310.com/thinkingFruit-client/static/plugin/aui/images/gril.jpg" class="aui-img-round" >
                    </div>
                    <div class="aui-list-item-inner aui-list-item-arrow">
                        <div class="aui-list-item-text text-white aui-font-size-18" id="name">暂无姓名</div>
                        <div class="aui-list-item-text text-white">
                        <div><i class="aui-iconfont aui-icon-mobile aui-font-size-14"></i></div>
                           <div id="mobile">暂未设置电话号码</div>
                        </div>
                         <div class="aui-label aui-label-outlined"><i class="aui-iconfont aui-icon-my"></i>完善资料</div>
                    </div>
                    
                </div>
            </div>
        </div>
    </section>
    <section class="aui-content aui-grid aui-margin-b-15" style="margin-top: 2px;">
        <div class="aui-row">
            <div class="aui-col-xs-4 aui-border-r" id="balance">
                <big class="aui-text-number" id="balanceNumber">0.00</big><small> 元</small>
                <div class="aui-gird-lable aui-font-size-10">余额</div>
            </div>
            <div class="aui-col-xs-4 aui-border-r" id="team">
                <big class="aui-text-number" id="teamNumber">0</big><small> 人</small>
                <div class="aui-gird-lable aui-font-size-10">团队</div>
            </div>
            <div class="aui-col-xs-4" id="commision">
                <big class="aui-text-number" id="commisionNumber">0.00</big><small> 元</small>
                <div class="aui-gird-lable aui-font-size-10">推广费</div>
            </div>
        </div>
    </section>
    <section class="aui-content">
        <ul class="aui-list aui-list-in aui-margin-b-15">
            <li class="aui-list-item aui-flex" id="address">
                <div class="aui-course-icon">
                   <img src="<%=basePath%>/static/images/icon/1.png" alt="">
                </div>
                <div class="aui-list-item-inner aui-list-item-arrow">
                    <div class="aui-list-item-title">收货地址</div>
                </div>
            </li>
            <li class="aui-list-item aui-flex" id="order">
                <div class="aui-course-icon">
                    <img src="<%=basePath%>/static/images/icon/4.png" alt="">
                </div>
                <div class="aui-list-item-inner aui-list-item-arrow">
                    <div class="aui-list-item-title">订单列表</div>
                </div>
            </li>
            <li class="aui-list-item aui-flex" id="depot">
                <div class="aui-course-icon">
                    <img src="<%=basePath%>/static/images/icon/14.png" alt="">
                </div>
                <div class="aui-list-item-inner aui-list-item-arrow">
                    <div class="aui-list-item-title">我的商品</div>
                </div>
            </li>
        </ul>
        <ul class="aui-list aui-list-in aui-margin-b-15">
           <li class="aui-list-item aui-flex"  id="invite">
                <div class="aui-course-icon">
                    <img src="<%=basePath%>/static/images/icon/3.png" alt="">
                </div>
                <div class="aui-list-item-inner aui-list-item-arrow">
                    <div class="aui-list-item-title">邀请好友</div>
                    <div class="aui-list-item-right">~</div>
                </div>
            </li>
            
             <li class="aui-list-item aui-flex" id="upLevel">
                <div class="aui-course-icon">
                    <img src="<%=basePath%>/static/images/icon/6.png" alt="">

                </div>
                <div class="aui-list-item-inner aui-list-item-arrow">
                    <div class="aui-list-item-title">升级</div>
                </div>
            </li>
            <li class="aui-list-item aui-flex" id="about">
                <div class="aui-course-icon">
                    <img src="<%=basePath%>/static/images/icon/12.png" alt="">
                </div>
                <div class="aui-list-item-inner aui-list-item-arrow">
                    <div class="aui-list-item-title">关于</div>
                    <div class="aui-list-item-right"></div>
                </div>
            </li>
        </ul>
            <ul class="aui-list aui-list-in aui-margin-b-15" id="loginOut">
            <li class="aui-list-item aui-flex">
                <div class="aui-course-icon">
                    <img src="<%=basePath%>/static/images/icon/11.png" alt="">
                </div>
                <div class="aui-list-item-inner aui-list-item-arrow">
                    <div class="aui-list-item-title">用户退出</div>
                    <div class="aui-list-item-right"></div>
                </div>
            </li>
        </ul>
    </section>
    </section>
    <footer class="aui-footer aui-footer-fixed">
        <div id="home" class="aui-tabBar-item "> <span
                class="aui-tabBar-item-icon"> <i class="icon icon-home"></i>
            </span> <span class="aui-tabBar-item-text">首页</span> </div>
            <div id="news" class="aui-tabBar-item "> <span
                class="aui-tabBar-item-icon"> <i class="icon icon-collage"></i>
            </span> <span class="aui-tabBar-item-text">文章</span> </div>
            <div id="my" class="aui-tabBar-item aui-tabBar-item-active">
            <span class="aui-tabBar-item-icon"> <i class="icon icon-my"></i>
            </span> <span class="aui-tabBar-item-text">我的</span> </span> </div>
    </footer>
    </section>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/slider.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/tab.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/my/index.js"></script>
	<script>WEB_ROOT="<%=basePath%>"</script>
	<script>memberId="<%=session.getAttribute("agentId")%>"</script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/layui/layui.all.js"></script>
		<script type="text/javascript"
		src="<%=basePath%>/static/js/common/common.js"></script>
		<script>WEB_ROOT_ADMIN="<%=admin%>"</script>
</body>
</html>