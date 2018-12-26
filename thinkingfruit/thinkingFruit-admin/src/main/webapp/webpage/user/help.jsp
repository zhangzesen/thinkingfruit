<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>用户操作手册</legend>
</fieldset>
<ul class="layui-timeline">
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">关于爱因思果</h3>
      <p>
      爱因思果是一个专门针对分销的管理系统
        <br>因小而大，因弱而强。
        <br>无论它能走多远，抑或如何支撑？至少我曾倾注全心，无怨无悔 。<i class="layui-icon"></i>
      </p>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">关于首页</h3>
      <p>首页共有三个模块，分别是</p>
      <ul>
        <li>数据统计:有总/月/日的数据统计，也有折线图可以分析每日数据变化，更为直观，最后全国大数据可以分析各个省份的订单量</li>
        <li>消息:这里包含了代理注册,升级,从云仓提货以及公司直属下级交易订单的消息</li>
        <li>帮助文档:记录了管理平台各个模块的帮助手册</li>
      </ul>
    </div>
  </li>
  
   <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">关于商城管理</h3>
      <p>商城管理有对商品,代理,订单等相关操作</p>
      <ul>
        <li>商品管理:对商品的添加/修改/删除/查看,商品有商品的展示图和详情图</li>
        <li>订单列表:分为公司总仓发货订单和公司直属代理交易订单，两者都可以导出excel表,发货和查看详情,按搜索条件搜索特定订单</li>
        <li>佣金管理:佣金列表可以查看每条订单产生的佣金和邀请金,个人佣金可以查看每个人的佣金和邀请金还有商品销售额</li>
        <li>文章编辑:可以编辑一些新闻和公告,可以上传一些图片</li>
        <li>代理管理:代理列表有所有注册审核通过代理,代理注册审核有代理注册列表需同意代理注册和取消,代理升级审核有代理升级列表需同意代理升级和取消,代理邀请有邀请二维码,可以保存,扫描二维码就可以注册</li>
        <li>设置:分佣比例修改及关于我们的修改</li>
        <li>提现管理:有代理申请提现，可以选择确认提现</li>
      </ul>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">关于系统</h3>
      <ul>
        <li>角色管理:可以添加不同的角色,不同的角色有不同的权限</li>
        <li>权限管理:有所有的权限</li>
        <li>权限树:可以查看权限树,将所有权限分类</li>
        <li>用户管理:可以添加用户,并给用户不同的角色,这样用户就有不同的权限</li>
      </ul>
    </div>
  </li>
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>源盛科技有限公司</legend>
</fieldset>
</ul>
	<jsp:include page="/context/js-tags.jsp" />
</body>
</html>