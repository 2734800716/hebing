package com.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.bdqn.entity.yongshu;
import com.liu.util.PrintUtil;

import cn.bdqn.entity.User;
import cn.bdqn.service.QuanService;
import cn.bdqn.service.QuanServiceimpl;

/**
 * Servlet implementation class XiuGai
 */
@WebServlet("/XiuGai")
public class XiuGai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiuGai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		QuanService qs=new QuanServiceimpl();
		
	   String idd =request.getParameter("id");
	   Integer id=Integer.valueOf(idd);
	 
       String contact=request.getParameter("uname");
       int bumen=Integer.valueOf(request.getParameter("type"));
       int zhichengid=Integer.valueOf(request.getParameter("type2"));
       int jueseid=Integer.valueOf(request.getParameter("type3"));
       User ys=new User();
       ys.setId(id);
       ys.setContact(contact);
       ys.setBumen(bumen);
       ys.setZhichengid(zhichengid);
       ys.setJueseid(jueseid);
       
       
       int num=-1;
       if (qs.updated(ys)){
    	   num=1;
    	   System.out.println("dd"+num);
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
