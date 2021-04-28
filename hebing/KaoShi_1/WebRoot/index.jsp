<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.bdqn.entity.Login"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
   
 <html>
	<head>
		<meta charset="utf-8">
		<title></title>
	
		  
		<link href="/KaoShi_1/lib/layui-v2.5.5/css/layui.css" rel="stylesheet">
	</head>
	<body>
		<form class="layui-form"  action="javascript:;" method="post">
		  <div class="layui-form-item">
		    <label class="layui-form-label">输入框</label>
		    <div class="layui-input-block">
		      <input type="text" name="title" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">密码框</label>
		    <div class="layui-input-inline">
		      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		    <div class="layui-form-mid layui-word-aux">辅助文字</div>
		  </div>
		 
		    
		    
		 
		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交<tton>
		      <button type="reset" class="layui-btn layui-btn-primary">重置<tton>
		    </div>
		  </div>
		</form>
		 
	 
		
		         
			 <script src="/KaoShi_1/lib/layui-v2.5.5/layui.js"></script>
		 
<script>
    layui.use(['form','jquery'], function () {
        var $ = layui.jquery,
            form = layui.form,
            layer = layui.layer;

        // 登录过期的时候，跳出ifram框架
        if (top.location != self.location) top.location = self.location;

        $('.bind-password').on('click', function () {
            if ($(this).hasClass('icon-5')) {
                $(this).removeClass('icon-5');
                $("input[name='password']").attr('type', 'password');
            } else {
                $(this).addClass('icon-5');
                $("input[name='password']").attr('type', 'text');
            }
        });

        $('.icon-nocheck').on('click', function () {
            if ($(this).hasClass('icon-check')) {
                $(this).removeClass('icon-check');
            } else {
                $(this).addClass('icon-check');
            }
        });

        // 进行登录操作
        form.on('submit(formDemo)', function (data) {
            data = data.field;
              
            if (data.title == '') {
                layer.msg('用户名不能为空');
              
                return false;
            }
            if (data.password == '') {
                layer.msg('密码不能为空');
                return false;
            }
           
            
            
            $.ajax({
            	url:"<%=basePath%>/SelectList",
            	type:"post",
            	data:{
            		"name":data.title,
            		"pwd":data.password
            	},
            	dataType:"json",
           		success:function(data){
           		var aa=eval("("+data+")");
           			if(true == aa){
           				layer.msg(data.message);
           				setTimeout(function(){
	        	            //top.layer.close(index);
	        	            window.location = 'Cha.jsp';
        	        	},1000);
           			}else{
           				layer.msg(data.message);
           			}
           		}
            })
            return false;
        });
    });
</script>
		
	</body>
<html>