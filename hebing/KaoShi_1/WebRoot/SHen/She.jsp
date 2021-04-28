<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path ;
			pageContext.setAttribute("path", basePath);

%>   
<script type="text/html" id="toolbarDemo">
				<c:forEach var="b" items="${list1}">	
	   ${b.btn}
	  </c:forEach>
</script>
		<table id="shenList" lay-filter="shenList"></table>  
	  	<script src="SHen/shen.js" charset="utf-8"></script>
