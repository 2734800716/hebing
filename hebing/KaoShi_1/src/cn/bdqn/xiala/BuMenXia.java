package cn.bdqn.xiala;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.util.PrintUtil;
import com.liu.util.ReturnResult;

import cn.bdqn.entity.Bumen;
import cn.bdqn.entity.Role;
import cn.bdqn.entity.User;
import cn.bdqn.entity.ZhiCheng;
import cn.bdqn.entity.layui;
import cn.bdqn.entity.yongshu;
import cn.bdqn.service.QuanService;
import cn.bdqn.service.QuanServiceimpl;

/**
 * Servlet implementation class BuMenXia
 */
@WebServlet("/BuMenXia")
public class BuMenXia extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuMenXia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected ReturnResult xiabumen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		QuanService qs=new QuanServiceimpl();
		 List<Bumen> list=qs.selectBumen();
		 ReturnResult result = new ReturnResult();
			
			result.returnYes(list);
			return result;
	}

	
	protected ReturnResult xiarole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		QuanService qs=new QuanServiceimpl();
		 List<Role> list=qs.selectRole();
		 ReturnResult result = new ReturnResult();
			
			result.returnYes(list);
			return result;
	}
	
	
	
	protected ReturnResult xiazhicheng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		QuanService qs=new QuanServiceimpl();
		 List<ZhiCheng> list=qs.seleZhiCheng();
		 ReturnResult result = new ReturnResult();
			
			result.returnYes(list);
			return result;
	}
	
	protected void selectyongshu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		QuanService qs=new QuanServiceimpl();
		 layui<yongshu> list=new layui<yongshu>();
		 list.setCode(0);
		 list.setCount(5);
		 list.setMsg("");
		 list.setData(qs.selectYongshu());
		 PrintUtil.write(list, response);
	
	
	
	}
	
	protected int yongshushanchu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QuanService qs=new QuanServiceimpl();
		String uname=request.getParameter("roleid");
		int idd=Integer.parseInt(uname);
		int num=qs.deletednew(idd);
		return num;
	
	}
	
	
	
	
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return BuMenXia.class;
	}

}
