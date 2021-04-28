package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Btn;
import cn.bdqn.entity.Bumen;
import cn.bdqn.entity.Login;
import cn.bdqn.entity.Menu;
import cn.bdqn.entity.MenudtreeData;
import cn.bdqn.entity.Role;
import cn.bdqn.entity.User;
import cn.bdqn.entity.ZhiCheng;
import cn.bdqn.entity.layui;
import cn.bdqn.entity.yongshu;

public interface QuanService {
	//登录
	public Login Login(String userName,String password);
	//侧边栏
	List<Menu> ann(int id);
     
	public List<Menu>Quan(int id);
	
	
     
//     public layui<shenfen>shen(String usershen,int currPageNo,int pageSize);
//     public int countLimtshen(String usershen);
//     
//     public layui<yongshu>selectLimt(String uname,int currPageNo,int pageSize);
//     public int countLimt(String uname);
     
	public List<Menu>Cai(String gong,int startIndex,int maxlength);
     //public int countLimtcai(String gong);
     
     
     //用户删除
     public int deleted(int id);
	
     //用户修改
     public boolean updated(User ys);
     public User updateid(int id);
     
     //查询权限
     public layui<MenudtreeData> allMenu();
     //获取权限id
     public List<MenudtreeData> allMenu(int id);
     
     //分配增加删除
     public int fenpei(int id,String[] num);
     //查询按钮
     public List<Btn> selectBtn();
     //增加权限
     public boolean insertQx(Menu ys);
     //查询权限type
     public List<Menu> seqxList(int type);
     //查詢用戶
     public layui<User> seleList();
   //查詢权限
     public layui<Menu> selemenu();
   //用户增加
 	public boolean insertd(User ys);
 	//下拉框部门
 	public List<Bumen> selectBumen();
    //角色下拉框
    public List<Role> selectRole();
    //职称下拉框
    public List<ZhiCheng> seleZhiCheng();
 	//角色查询
 	public layui<User> selectrenbiao();
 	//修改权限以及查询
 	 public int updated(Menu ys);
     public Menu updatemenu(int id);
     //删除权限
     public boolean deletequanxian(int id);
     //删除
     public int deletednew(int id);
     //增加
     public boolean insertdnew(yongshu ys);
     //修改
     public boolean updatednew(yongshu ys);
     public yongshu updateidnew(int id);
     //查询
     public List<yongshu> selectYongshu();
 	
 	
 	
 	
 	
 	
 	
 	
}
