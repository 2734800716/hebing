package com.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.util.PrintUtil;
import com.liu.util.ReturnResult;

import cn.bdqn.entity.Login;
import cn.bdqn.entity.Menu;
import cn.bdqn.entity.User;
import cn.bdqn.service.QuanService;
import cn.bdqn.service.QuanServiceimpl;

/**
 * Servlet implementation class SelectList
 */
@WebServlet("/SelectList")
public class SelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QuanService qs=new QuanServiceimpl();
		String userName=request.getParameter("name");
		String password =request.getParameter("pwd");
		
		ReturnResult result = new ReturnResult();
		Login lo=new QuanServiceimpl().Login(userName, password);
		if (lo!= null) {	//验证用户名) 
			if (lo.getUserName().equals(userName)&&lo.getPassword().equals(password)) {//验证密码
				List<Menu> list=new QuanServiceimpl().ann(Integer.valueOf(lo.getHuid()));
				request.getSession().setAttribute("lo", lo);
				request.getSession().setAttribute("list", list);
				PrintUtil.write(true, response);
				
			}
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
