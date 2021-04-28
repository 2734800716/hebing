package com.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.util.PrintUtil;

import cn.bdqn.service.QuanService;
import cn.bdqn.service.QuanServiceimpl;

/**
 * Servlet implementation class ChaQuanXiu
 */
@WebServlet("/ChaQuanXiu")
public class ChaQuanXiu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaQuanXiu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 String idd =request.getParameter("id"); 
		 Integer id=Integer.valueOf(idd);
		 //System.out.println("id"+id);
		 QuanService qs=new QuanServiceimpl();
		PrintUtil.write(qs.updatemenu(id), response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
