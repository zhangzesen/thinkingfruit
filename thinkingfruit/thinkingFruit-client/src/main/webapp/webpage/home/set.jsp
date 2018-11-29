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
	href="<%=basePath%>/static/css/base.css">
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>/static/css/icon.css">
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>/static/css/home.css">
<link href="iTunesArtwork@2x.png" sizes="114x114"
	rel="apple-touch-icon-precomposed">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/plugin/aui/css/aui.css" />

</head>
<body>

	<section class="aui-flexView">
		<header class="aui-bar aui-bar-nav aui-bar-light" style="color: black;">
    <div class="aui-title">爱因思果</div>
</header>
		<section class="aui-scrollView">
			<section class="aui-content">
			<div class="aui-card-list">
				
				<div class="aui-card-list-content">
					<img src="<%=basePath%>/static/images/banner/shili1.jpg" />
				</div>
			</div>
			
			<div class="aui-card-list-content aui-text-center">
                <div class="aui-font-size-20">商品1</div>
                <p class="aui-text-danger aui-margin-b-10">¥：99.00</p>
               <div class="aui-bar aui-bar-btn" style="width:80%;" type="count" id="demo">
        <div class="aui-bar-btn-item aui-font-size-20">
            <i class="aui-iconfont aui-icon-minus"></i>
        </div>
        <div class="aui-bar-btn-item">
            <input type="number" class="aui-input aui-text-center" id="count" value="1">
        </div>
        <div class="aui-bar-btn-item aui-font-size-20">
            <i class="aui-iconfont aui-icon-plus"></i>
        </div>
    </div>
            </div>
			</section>
			<div class="aui-content-padded">
           <div class="aui-btn aui-btn-block aui-btn-info" tapmode onclick="openDialog('text')">确认购买</div>
            </div> 
		    </section>
		    
            
              
	       </section>
 
 
   
            
		
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/slider.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/tab.js"></script>
		<script type="text/javascript"
		src="<%=basePath%>/static/js/home/set.js"></script>
<script>WEB_ROOT="<%=basePath%>"</script>
</body>
</html>