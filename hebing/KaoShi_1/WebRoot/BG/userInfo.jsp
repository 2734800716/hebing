<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>新增用户</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=basePath %>/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="<%=basePath %>/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">

 <div class="layui-form-item">
    <label class="layui-form-label">编号</label>
    <div class="layui-input-inline">
      <input type="text" name="id" id="id" lay-verify="required" placeholder="id" autocomplete="off" readonly="readonly" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-inline">
      <input type="text" name="uname" id="uname" lay-verify="required" placeholder="请输入登录名" autocomplete="off" class="layui-input">
    </div>
  </div>
   
     	<div class="layui-form-item">
    <label class="layui-form-label">选择部门</label>
    <div class="layui-input-inline">
      <select name="type" id="type" lay-filter="role1">
      	
      </select>
   </div>
  </div>
  
  	   	<div class="layui-form-item">
    <label class="layui-form-label">选择职称</label>
    <div class="layui-input-inline">
      <select name="type2" id="type2" lay-filter="role1">
      	
      </select>
   </div>
  </div>
  
<!--   <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-inline">
      <input type="eamil" name="email" id="email" lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
    </div>
  </div>
  --> 
     	<div class="layui-form-item">
    <label class="layui-form-label">选择角色</label>
    <div class="layui-input-inline">
      <select name="type3" id="type3" lay-filter="role1">
      	
      </select>
   </div>
  </div>
  
  <div class="layui-form-item">
    <button class="layui-btn layui-btn-fluid" id="xiugai" lay-filter="addUser">修改用户</button>
  </div>
</form>
<%-- <script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script> --%>
<%-- <script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script> --%>


<script type="text/javascript" src="<%=basePath %>/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<%-- <script type="text/javascript" src="<%=basePath %>admin/pagejs/system/user/userInfo.js"></script> --%>
<script type="text/javascript" src="<%=basePath %>/BG/userInfo.js"></script>
</body>
</html>