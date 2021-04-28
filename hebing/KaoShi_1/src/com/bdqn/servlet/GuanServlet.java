package com.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.Login;
import cn.bdqn.entity.Menu;
import cn.bdqn.entity.User;
import cn.bdqn.service.QuanService;
import cn.bdqn.service.QuanServiceimpl;

/**
 * Servlet implementation class GuanServlet
 */
@WebServlet("/GuanServlet")
public class GuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		   request.setCharacterEncoding("UTF-8");
		   String name=request.getParameter("deng");
		   String pwd=request.getParameter("mi");
		   Login yh=new Login();
		   HttpSession session =request.getSession();		   
		   QuanService qs=new QuanServiceimpl();
		   yh=qs.Login(name,pwd);
		   List<Menu>list=qs.ann(1);	   
		   for (Menu gongneng : list) {
			System.out.println(gongneng.getUrl());
		}
		   session.setAttribute("list", list);
		   response.sendRedirect("Cha.jsp");   
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
