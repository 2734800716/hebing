function Btn(id,url) {
				var item = {
					"id" : id,
					"url":url
				}
				$("#cc #right").load(contextPath+"/"+url, item);
				var sc =  document.createElement("script");
		         sc.src= "/BG/userList.js"; //是你数据表格的js
		         $(".childrenBody").append(sc);
		        // alert(url)
			}