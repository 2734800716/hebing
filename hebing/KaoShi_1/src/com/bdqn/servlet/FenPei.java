package com.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.util.PrintUtil;
import com.liu.util.ReturnResult;

import cn.bdqn.service.QuanServiceimpl;



/**
 * Servlet implementation class FenPei
 */
@WebServlet("/FenPei")
public class FenPei extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenPei() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		String[] menuidList = request.getParameterValues("array");
		ReturnResult result = new ReturnResult();
		int row = new QuanServiceimpl().fenpei(userid, menuidList);
		if(row != 0 ) {
			result.returnYes("分配权限成功");
		}
		PrintUtil.write(result, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
