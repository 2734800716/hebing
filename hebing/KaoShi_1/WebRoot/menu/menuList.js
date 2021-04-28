layui.use(['layer','table','treeTable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var treeTable = layui.treeTable;
        var layer = layui.layer;
        
        /*------------- 加载用户数据 --------------------------------*/
        var tableIns = treeTable.render({
            elem: '#CaiList',
            url : '/KaoShi_1/QuanXianChaXun',
            toolbar: '#toolbarDemo',
            page : true,
            height: 'full-145',
            limit : 10,
            limits : [10,15,20,25],
            tree: {
                iconIndex: 2,           // 折叠图标显示在第几列
                isPidData: true,        // 是否是id、pid形式数据
                idName: 'id',  // id字段名称
                pidName: 'fatherid'     // pid字段名称
            },
            cols : [[
            	{fixed:"left",type: "radio", width:50},
                {field: 'id', title: '编号',  align:'center'},
                {field: 'mname', title: '功能', minWidth:100, align:"center"},
                {field: 'fatherid', title: '父级id',  align:'center'},
                {field: 'type', title: '类型', align:'center'},
                {field: 'url', title: '地址', align:'center'},
                {field: 'btn', title: '触发按钮',  align:'center'}         
            ]]
        });
		//监听工具栏
		treeTable.on('toolbar(CaiList)', function(obj){
		    switch(obj.event){
		      case 'btn-expand':	//全部展开
		    	  insTb.expandAll('#demoTreeTb');
		      break;
		      
		      case 'btn-fold':	//全部折叠
		    	  insTb.foldAll('#demoTreeTb');
		      break;
		      
		      case 'addMenu':	//新增权限
		    	  layer.open({
		        		title : "添加权限",
		        		type : 2,
		        		content : "/KaoShi_1/menu/menuAdd.jsp",
		        		area:['420px','420px'],
		    	  })
		      break;
		      
		      case 'upMenu':	//修改权限
					updataMenu();
		      break;
			        
		      case 'delMenu':	//删除权限
		    	  layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
						delMenu();
						layer.close(index);
		            });
		      break;
		    };
		 });
		
	   //---------删除权限-------
		function delMenu(){
	    	var menuid = '';
	    	JSON.stringify(tableIns.checkStatus().map(function (d) {
	    		menuid = d.id;
	        }));
	    	if(menuid == null || menuid == ""){
	    		layer.msg("请选中一个节点进行删除");
	    	}else{
	    		$.ajax({
	    			url:"/KaoShi_1/sanQuanXian",
	    			data:{"menuid":menuid},
	    			type:"post",
	    			dataType:"json",
	    			success:function(data){
	    				//var info = eval("("+data+")");
	    				if(data.status == 1){
	    					layer.msg("删除失败");
	    					insTb.reload();
	    				}else{
	    					layer.msg("删除成功");
	    				}
	    			}
	    		})
	    	}
	    }

       /*---------修改权限------*/
        function updataMenu(){
        	var authorityId =1;
        	JSON.stringify(tableIns.checkStatus().map(function (d) {
				 authorityId = d.id;
            }));
        	if(authorityId == null || authorityId==""){
        		layer.msg('请选择一个进行修改');
        	}else{
        		layer.open({
              		 type:2,
              		 title:"修改权限",
              		 area:['420px','420px'],
              		 content:"/KaoShi_1/menu/menuInfo.jsp",
              		 success:function(layero, index){
              			 $.post("/KaoShi_1/ChaQuanXiu",{"id":authorityId},function(data){
              				var info = eval('(' + data + ')')
              				var body = layui.layer.getChildFrame('body', index);
              				body.find("#id").val(info.id);
              				body.find("#mname").val(info.mname);  //权限名
              				body.find("#mfunction").val(info.url);	//请求路径
              				body.find("#mbtn").val(info.mbtn);		//按钮代码
              				var select = 'dd[lay-value='+info.type+']';
              				body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
              				body.find("#fatherid").val(info.fatherid);
              				body.find("#type").val(info.type);
              				
              				var menuid3 = info.fatherid;
              				alert(menuid3)
              				//上级的下拉框
                 			 $.post("/KaoShi_1/ChaQuanXiu",{"id":menuid3},function(res){
             					var cs = eval('(' + res + ')');
     		                    body.find("#fatherType2").val(cs.mname);
                 			 })
                 			 
              			 })
                	}
          	    })
        	}
        };
});