package com.liu.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义servlet
 * @author 刘胜
 *
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public abstract Class<?> getServletClass();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//接收前端传递action值
		String action = request.getParameter("action");
		
		Method method = null;
		Object info = null;
		try {
			//判断前端的action的值是否为空
			if(EmptyUtils.isEmpty(action)) {	//为空直接跳回index.jsp页面
				info = toIndex(request,response);
			}else {		
				//通过反射获取子类的方法
				method = getServletClass().getDeclaredMethod(action,HttpServletRequest.class, HttpServletResponse.class);
				//执行子类的方法,并获取方法的返回值
				info = method.invoke(this, request,response);
			}
			//处理这个返回值
			toView(request,response,info);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void toView(HttpServletRequest request, HttpServletResponse response, Object info) throws ServletException, IOException {
		//空为true 	
		if(!EmptyUtils.isEmpty(info)) {
			if(info instanceof String) {	//判断传递的值是否是String类型
				String url = info+".jsp";
				request.getRequestDispatcher(url).forward(request, response);
			}else {		//不是String则转为Json格式
//				System.out.println(info);
				JsonUtil.write(info, response);
			}
		}
	}
	
	protected String toIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/index.jsp";
	}

}
