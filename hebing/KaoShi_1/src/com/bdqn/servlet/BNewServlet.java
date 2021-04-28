package com.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.Menu;
import cn.bdqn.service.QuanService;
import cn.bdqn.service.QuanServiceimpl;

/**
 * Servlet implementation class BNewServlet
 */
@WebServlet("/BNewServlet")
public class BNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		int id=Integer.parseInt(request.getParameter("id"));		
		//int typeid=Integer.parseInt(request.getParameter("typeid"));				
		QuanService qs=new QuanServiceimpl();
		List<Menu>gg=qs.Quan(id);
		HttpSession session =request.getSession();
		session.setAttribute("list1", gg);
		response.sendRedirect(request.getParameter("new"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
