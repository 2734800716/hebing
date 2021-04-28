<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path ;
			pageContext.setAttribute("path", basePath);

%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户中心</title>
	<link rel="stylesheet" href="<%=basePath %>/lib/layui-v2.5.5/css/layui.css" media="all" />
	<link rel="stylesheet" href="<%=basePath %>/css/public.css" media="all" />
	<link rel="stylesheet" href="<%=basePath %>/admin/js/lay-module/layui_ext/dtree/dtree.css">
  	<link rel="stylesheet" href="<%=basePath %>/admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body class="childrenBody">
<script type="text/html" id="roleDemo1">
				<c:forEach var="b" items="${list1}">	
	   ${b.btn}
	  </c:forEach>
			</script>
		<table id="newsList1" lay-filter="newsList1"></table>  
		
	  	<script src="role/roleList.js" charset="utf-8"></script>
	  	</body> 	
	  	</html>