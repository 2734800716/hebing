layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

/*  var userid = $("#uid").val();
  alert(userid);*/
/*  $.ajax({
	  url:"/MenuTest/RoleServlet?action=allRole",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role1");
		  $.ajax({
			  url:"/MenuTest/UserServlet?action=",	//查询用户是否有角色有返回1,没有返回0
		  })
		  var html = '<option value="0">无角色</option>';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.rname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })*/
  $.ajax({
	  url:"/KaoShi_1/BuMenXia?action=xiabumen",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#type");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.bname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })

   $.ajax({
	  url:"/KaoShi_1/BuMenXia?action=xiarole",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#type3");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.roleName+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
   $.ajax({
	  url:"/KaoShi_1/BuMenXia?action=xiazhicheng",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#type2");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.userCode+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
/*  //自定义验证规则
  var isyan = form.verify({
	uname: function(value){
      if(value.length < 3){
        return '登录名不能小于3位数';
      }
      if(!/[^\u4e00-\u9fa5]/.test(value)){
    	  return "登录名不能为中文";
      }
    },
    password: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ],
    content: function(value){
      layedit.sync(editIndex);
    }
  });*/
  
 /* function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"/Control/XiuGai?action=updated",
		  data:{"uname":uname},
		  async:false,
		  type:"post",
		  success:function(data){
			  if(data == 0){
				  is = true;
			  }else{
				  is = false;
			  }
		  }
	  })
	  return is;
  }
  
  $("#uname").blur(function(){
	  var name = $("#uname").val();
	  var name2 = $("#uname2").val();
	  if(name !=null && name!=name2 ){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入");
		  }
	  }
  })
  */
  
  $("#xiugai").click(function(){
	  var id= $("#id").val();
	  var contact = $("#uname").val();
	  var bumen = $("#type").val();
	  var zhichengid = $("#type2").val();
	  var jueseid = $("#type3").val();
	  var data = {
			  "id":id,
			  "uname":contact,
			  "type":bumen,
			  "type2":zhichengid,
			  "type3":jueseid
	  }
	  /*if(name.length<3){
		  layer.alert("登录名不能小于3位数")
		  return false;
	  }else if(pass.length < 5 || pass.length > 19){
		  layer.alert('密码必须6到12位，且不能出现空格');
		  return false;
	  }else if(realName.length == "" || realName.length == null){
		  layer.alert('用户名不能为空');
		  return false;
	  }else if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
		  layer.alert("邮箱格式不正确！请重新输入");
		  return false;
	  }else if(phone.length != 11){
		  layer.alert("手机格式不正确! 请重新输入");
		  return false;
	  }else if(name !=null && name!=name2 ){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入")
			  return false;
		  }
	  }*/
	  
	  $.ajax({
	  		url:"/KaoShi_1/XiuGai",
			data:data,
			tyep:"post",
			success:function(data){
					layer.msg("用户信息修改成功");
					setTimeout(function(){
						layer.closeAll("iframe");
			            //刷新父页面
			            parent.location.reload();
		        	},1000);
			}
	  })
	  return false;
  })
  
});
/*jQuery(function($){ 
	  $.ajax({
		  url:"/MenuTest/RoleServlet?action=allRole",
		  type:"post",
		  success:function(data){
			  var info = eval("("+data+")");
			  var role = $("#role");
			  var html = '';
			  $.each(info.data,function(index,datas){
				  html += '<option value="'+datas.id+'">'+datas.rname+'</option>';
			  })
			  role.html(html);
		  }
		  
	})
}); */