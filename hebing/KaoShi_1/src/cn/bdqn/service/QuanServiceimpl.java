package cn.bdqn.service;

import java.util.List;

import com.liu.util.TransferArray;

import cn.bdqn.dao.QuanDao;
import cn.bdqn.dao.QuanDaoimpl;
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

public class QuanServiceimpl implements QuanService{
private QuanDao qu=new QuanDaoimpl();

@Override
public Login Login(String userName, String password) {
	// TODO Auto-generated method stub
	return qu.Login(userName,password);
}

@Override
public List<Menu> ann(int id) {
	// TODO Auto-generated method stub
	return qu.ann(id);
}

@Override
public List<Menu> Quan(int id) {
	// TODO Auto-generated method stub
	return qu.Quan(id);
}

@Override
public List<Menu> Cai(String gong, int startIndex, int maxlength) {
	return qu.Cai(gong, startIndex, maxlength);
}

@Override
public layui<MenudtreeData> allMenu() {
	// TODO Auto-generated method stub
	return qu.allMenu();
}

@Override
public List<MenudtreeData> allMenu(int id) {
	// TODO Auto-generated method stub
	return qu.allMenu(id);
}

@Override
public int fenpei(int id, String[] num) {
	int row = qu.deleteqx(id);	//先根据用户id去删除权限
	int[] arrs = TransferArray.StringToInt(num);
	int count = 0;
	if(row != -1) {
		for (int i = 0; i < arrs.length; i++) {
			int yes = qu.insertqx(id, arrs[i]);	//循环增加数据
			if(yes > 0) {	
				count++;//如果添加成功++ 记录增加了几条数据
			}
		}
	}
	return count;
}

@Override
public List<Btn> selectBtn() {
	return qu.selectBtn();
}

@Override
public boolean insertQx(Menu ys) {
	int num=this.qu.insertQx(ys);
	if (num>0) {
		return true;
	}
	return false;
}

@Override
public List<Menu> seqxList(int type) {
	// TODO Auto-generated method stub
	return qu.seqxList(type-1);
}

@Override
public layui<User> seleList() {
	// TODO Auto-generated method stub
	layui<User> layui=new layui<User>();
	layui.setCode(0);
	layui.setMsg("");
	layui.setCount(5);
	
	layui.setData(qu.seleList());
	return layui;
}

@Override
public layui<Menu> selemenu() {
	// TODO Auto-generated method stub
		layui<Menu> layui=new layui<Menu>();
		layui.setCode(0);
		layui.setMsg("");
		layui.setCount(5);
		
		layui.setData(qu.seleMenu());
		return layui;
}

@Override
public boolean insertd(User ys) {
	int num=this.qu.insertd(ys);
	if (num>0) {
		return true;
	}
	return false;
}

@Override
public List<Bumen> selectBumen() {
	// TODO Auto-generated method stub
	return qu.selectBumen();
}

@Override
public layui<User> selectrenbiao() {
	layui<User> layui=new layui<User>();
	layui.setCode(0);
	layui.setMsg("");
	layui.setCount(5);
	
	layui.setData(qu.selectrenbiao());
	return layui;
}

@Override
public List<Role> selectRole() {
	// TODO Auto-generated method stub
	return qu.selectRole();
}

@Override
public List<ZhiCheng> seleZhiCheng() {
	// TODO Auto-generated method stub
	return qu.seleZhiCheng();
}

@Override
public boolean updated(User ys) {
	int num=this.qu.updated(ys);
	if (num>0) {
		return true;
	}
	return false;
}

@Override
public User updateid(int id) {
	// TODO Auto-generated method stub
	return qu.updateid(id);
}

@Override
public int deleted(int id) {


	return qu.deleted(id);
}

@Override
public int updated(Menu ys) {
	// TODO Auto-generated method stub
	return qu.updated(ys);
}

@Override
public Menu updatemenu(int id) {
	// TODO Auto-generated method stub
	return qu.updatemenu(id);
}

@Override
public boolean deletequanxian(int id) {
	int num=this.qu.deletequanxian(id);
	if (num>0) {
		return true;
	}
	return false;
}

@Override
public int deletednew(int id) {
	int num=this.qu.deletednew(id);
	if (num>1) {
		return 0;
	}
	return 1;
}

@Override
public boolean insertdnew(yongshu ys) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean updatednew(yongshu ys) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public yongshu updateidnew(int id) {
	// TODO Auto-generated method stub
	return qu.updateidnew(id);
}

@Override
public List<yongshu> selectYongshu() {
	// TODO Auto-generated method stub
	return qu.selectYongshu();
}

	


}
