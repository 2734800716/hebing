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
		//��¼
		public Login Login(String userName,String password);
		//�����
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
       //Ա��ɾ��
       public int deleted(int id);
       //Ա���޸�
       public int updated(User ys);
       public User updateid(int id);
		//Ա������
		public int insertd(User ys);
       
       
       
       //��ѯȨ��
       public layui<MenudtreeData> allMenu();
       //��ȡȨ��id
       public List<MenudtreeData> allMenu(int id);
       //����ɾ��
       public int deleteqx(int id);
       //��������
       public int insertqx(int shenid,int quanid);
       //��ѯ��ť
       public List<Btn>selectBtn();
       //����Ȩ��
       public int insertQx(Menu ys);
       //��ѯȨ��type
       public List<Menu> seqxList(int type);
       //��ԃ�Ñ�
       public List<User> seleList();
       //��ѯȨ��
       public List<Menu> seleMenu();
       //����������
       public List<Bumen> selectBumen();
       //��ɫ������
       public List<Role> selectRole();
       //ְ��������
       public List<ZhiCheng> seleZhiCheng();
       //��ѯ��ɫ
       public List<User> selectrenbiao();
       
       //��ѯȨ���޸�
       public int updated(Menu ys);
     
       //Ȩ���޸�
       public Menu updatemenu(int id);
       
       //����ɾ��
       public int deletequanxian(int id);
       
       //��ѯ
       public List<yongshu> selectYongshu();
       //ɾ��
       public int deletednew(int id);
       //�޸�
       public int updatednew(yongshu ys);
       public yongshu updateidnew(int id);
       //����
       public int insertdnew(yongshu ys);
       
}
