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
	//��¼
	public Login Login(String userName,String password);
	//�����
	List<Menu> ann(int id);
     
	public List<Menu>Quan(int id);
	
	
     
//     public layui<shenfen>shen(String usershen,int currPageNo,int pageSize);
//     public int countLimtshen(String usershen);
//     
//     public layui<yongshu>selectLimt(String uname,int currPageNo,int pageSize);
//     public int countLimt(String uname);
     
	public List<Menu>Cai(String gong,int startIndex,int maxlength);
     //public int countLimtcai(String gong);
     
     
     //�û�ɾ��
     public int deleted(int id);
	
     //�û��޸�
     public boolean updated(User ys);
     public User updateid(int id);
     
     //��ѯȨ��
     public layui<MenudtreeData> allMenu();
     //��ȡȨ��id
     public List<MenudtreeData> allMenu(int id);
     
     //��������ɾ��
     public int fenpei(int id,String[] num);
     //��ѯ��ť
     public List<Btn> selectBtn();
     //����Ȩ��
     public boolean insertQx(Menu ys);
     //��ѯȨ��type
     public List<Menu> seqxList(int type);
     //��ԃ�Ñ�
     public layui<User> seleList();
   //��ԃȨ��
     public layui<Menu> selemenu();
   //�û�����
 	public boolean insertd(User ys);
 	//��������
 	public List<Bumen> selectBumen();
    //��ɫ������
    public List<Role> selectRole();
    //ְ��������
    public List<ZhiCheng> seleZhiCheng();
 	//��ɫ��ѯ
 	public layui<User> selectrenbiao();
 	//�޸�Ȩ���Լ���ѯ
 	 public int updated(Menu ys);
     public Menu updatemenu(int id);
     //ɾ��Ȩ��
     public boolean deletequanxian(int id);
     //ɾ��
     public int deletednew(int id);
     //����
     public boolean insertdnew(yongshu ys);
     //�޸�
     public boolean updatednew(yongshu ys);
     public yongshu updateidnew(int id);
     //��ѯ
     public List<yongshu> selectYongshu();
 	
 	
 	
 	
 	
 	
 	
 	
}
