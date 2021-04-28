package com.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.util.PrintUtil;

import cn.bdqn.entity.Menu;
import cn.bdqn.service.QuanService;
import cn.bdqn.service.QuanServiceimpl;

/**
 * Servlet implementation class QxianInsert
 */
@WebServlet("/QxianInsert")
public class QxianInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QxianInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QuanService qs=new QuanServiceimpl();
		String gong=request.getParameter("mname");
		String url=request.getParameter("mfunction");
		
		String type2=request.getParameter("type2");
		int type=Integer.valueOf(type2);
		
		String faid=request.getParameter("father");
		int faidd=Integer.valueOf(faid);
		
		String btnString=request.getParameter("mbtn");
		Menu g=new Menu();
		g.setMname(gong);
		g.setUrl(url);
		g.setType(type);
		g.setFatherid(faidd);
		g.setBtn(btnString);
		int num=-1;
	       if (qs.insertQx(g)){
	    	   num=1;
		}
	      
	       PrintUtil.write(num, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
