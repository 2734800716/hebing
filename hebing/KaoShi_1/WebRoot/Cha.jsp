<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	pageContext.setAttribute("ctx", basePath);//获取地址
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>管理系统大布局</title>

<link rel="stylesheet" href="<%=basePath%>/css/public.css" media="all" />
<link rel="stylesheet"
	href="<%=basePath%>/admin/js/lay-module/layui_ext/dtree/dtree.css">
<link rel="stylesheet"
	href="<%=basePath%>/admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">后台管理</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				</dl>
				</li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="jpp/第一张.jpg" class="layui-nav-img">twg
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="index.jsp">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<c:forEach var="g" items="${sessionScope.list}">
					<ul class="list">
						<li class="layui-nav-item layui-nav-itemed"><c:if
								test="${g.type==2}">

								<a href="javascript:void(0)" onclick="Btn('${g.id}','${g.url}')">${g.mname}</a>

								<%-- <c:forEach var="f" items="${sessionScope.list}">
								<c:if test="${f.fatherid==g.id}">
									<li><a href="javascript:void(0)" onclick="Btn('${f.id}','${f.url}')">${f.mname}</a></li>
								</c:if>
							</c:forEach> --%>
							</c:if></li>
					</ul>
				</c:forEach>
				</li>
				</ul>
			</div>
		</div>
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div class="layuimini-container">
				<div class="layuimini-main">
					<blockquote class="layui-elem-quote quoteBox">
						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" name="uname" id="likename"
									class="layui-input" placeholder="请输入查找的登录名" />
							</div>
						</div>
						<div class="layui-inline">
							<button type="button" class="layui-btn" lay-filter="doSubmit"
								id="doSubmit">
								<i class="layui-icon layui-icon-search layui-icon-normal"></i>搜索
							</button>
						</div>
						<input type="text" id="loginName" value="${user.id }"
							style="display:none" />
					</blockquote>
				</div>
				<div id="cc">
					<%--   <c:forEach var="b" items="${list1}">	
	   ${b.btn}
	  </c:forEach> --%>
					<div id="right"></div>
				</div>
				<table id="newsList" lay-filter="newsList"></table>
			</div>
		</div>
		<script src="<%=basePath%>/layui/layui.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="zhan.js"></script>
		<script>
    
			//JavaScript代码区域
			layui.use('element', function() {
				var element = layui.element;	
			});
			<%-- function Btn(typeid, id) {
				var item = {
					"id" : id,
					"typeid" : typeid
				}
				$("#cc").load("<%=basePath%>/BtnServlet #cc>*", item);
			} --%>

		</script>
		<script type="text/javascript">
			contextPath = "${ctx}";
		</script>
</body>
<!-- 分配权限 -->
<div style="height: 400px;overflow: auto;display: none;" id="dtree1">
	<ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>


</html>
