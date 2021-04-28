package cn.bdqn.dao;

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

public interface QuanDao {
		//登录
		public Login Login(String userName,String password);
		//侧边栏
		List<Menu> ann(int id);
//       public List<shenfen>shen(String usershen,int startIndex,int maxlength);
//       public int countLimtshen(String usershen);
//       
		public List<Menu>Quan(int id);
//       
//       public List<yongshu>selectLimt(String uname,int startIndex,int maxlength);
//       public int countLimt(String uname);
//      
		public List<Menu>Cai(String gong,int startIndex,int maxlength);
//       public int countLimtcai(String gong);
//       
       //员工删除
       public int deleted(int id);
       //员工修改
       public int updated(User ys);
       public User updateid(int id);
		//员工增加
		public int insertd(User ys);
       
       
       
       //查询权限
       public layui<MenudtreeData> allMenu();
       //获取权限id
       public List<MenudtreeData> allMenu(int id);
       //分配删除
       public int deleteqx(int id);
       //分配增加
       public int insertqx(int shenid,int quanid);
       //查询按钮
       public List<Btn>selectBtn();
       //增加权限
       public int insertQx(Menu ys);
       //查询权限type
       public List<Menu> seqxList(int type);
       //查詢用戶
       public List<User> seleList();
       //查询权限
       public List<Menu> seleMenu();
       //部门下拉框
       public List<Bumen> selectBumen();
       //角色下拉框
       public List<Role> selectRole();
       //职称下拉框
       public List<ZhiCheng> seleZhiCheng();
       //查询角色
       public List<User> selectrenbiao();
       
       //查询权限修改
       public int updated(Menu ys);
     
       //权限修改
       public Menu updatemenu(int id);
       
       //分配删除
       public int deletequanxian(int id);
       
       //查询
       public List<yongshu> selectYongshu();
       //删除
       public int deletednew(int id);
       //修改
       public int updatednew(yongshu ys);
       public yongshu updateidnew(int id);
       //增加
       public int insertdnew(yongshu ys);
       
}
