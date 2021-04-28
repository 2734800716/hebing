package cn.bdqn.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class QuanDaoimpl extends BaseDao implements QuanDao{

	Connection conn=getConnection();
	PreparedStatement pre=null;
	ResultSet rs=null;
	@Override
	public Login Login(String userName, String password) {
		Login yo=new Login();
		String sql="SELECT `huid`,`userName`,`password` FROM `yonghu` WHERE `userName`=? AND `password`=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,userName);
			pre.setString(2,password);
			rs=pre.executeQuery();
			while(rs.next()){
				yo.setHuid(rs.getInt(1));
				yo.setUserName(rs.getString(2));
				yo.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yo;
	}
	@Override
	public List<Menu> ann(int id) {
		List<Menu> list=new ArrayList<Menu>();
		
		String sql="SELECT `id`,`mname`,`fatherid`,`type`,url FROM `menu` WHERE `id` IN (SELECT `userid` FROM `quanxian` WHERE `qxid`=?)";
		try {
		 
			pre=conn.prepareStatement(sql);
			
			
			pre.setInt(1, id);
			rs=pre.executeQuery();
			while (rs.next()) {
				Menu mu=new Menu();
				mu.setId(rs.getInt(1));
				mu.setMname(rs.getString(2));
				mu.setFatherid(rs.getInt(3));
				mu.setType(rs.getInt(4));
				mu.setUrl(rs.getString(5));
				list.add(mu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pre, rs);
		}
		
		return list;
	}
	@Override
	public List<Menu> Quan(int id) {
		List<Menu>list=new ArrayList<Menu>();
		conn=getConnection();
		String sql="SELECT id,mname,type,url,btn FROM `Menu` WHERE `fatherid`=?";//sql语句
		try {
			pre=conn.prepareStatement(sql);//获取执行者对象
			//设置参数
			pre.setInt(1,id);//1代表第一个问号占位符
			rs=pre.executeQuery();//执行SQL语句
			while(rs.next()) {
				Menu gg=new Menu();
				gg.setId(rs.getInt(1));
				gg.setMname(rs.getString(2));
				gg.setType(rs.getInt(3));
				gg.setUrl(rs.getString(4));
				gg.setBtn(rs.getString(5));
				list.add(gg);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	@Override
	public List<Menu> Cai(String gong, int startIndex, int maxlength) {
		List<Menu>list=new ArrayList<Menu>();
		List<Object>param =new ArrayList<Object>();
		//获得Connection数据库连接
		conn=getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT`id`,`mname`,`fatherid`,`type`,`url`,`btn` FROM menu WHERE 1=1\n");
		if(gong!=null&&gong.length()>0){
			sb.append(" AND gong LIKE CONCAT('%',?,'%')\n");
			param.add(gong);
			sb.append("LIMIT ?,?");
			param.add(startIndex);
			param.add(maxlength);
		}		
		//使用分页进行查询
		
		 try {
			pre=conn.prepareStatement(sb.toString());
			if(param.size()>0){
				for (int i = 0; i < param.size(); i++) {
					pre.setObject(i+1, param.get(i));
				}
			}
			rs=pre.executeQuery();
			while (rs.next()) {
				Menu ggG=new Menu();
				ggG.setId(rs.getInt(1));
				ggG.setMname(rs.getString(2));
				ggG.setFatherid(rs.getInt(3));
				ggG.setType(rs.getInt(4));
				ggG.setUrl(rs.getString(5));
				ggG.setBtn(rs.getString(6));
				list.add(ggG);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pre, rs);
		}		 
		return list;
	}
	@Override
	public layui<MenudtreeData> allMenu() {
		 List<Menu> allMenu = Cai(null, 0, 0);
			layui<MenudtreeData> layui = new layui<MenudtreeData>();
			layui.setCode(0);
			layui.setCount(0);
			layui.setMsg("");
			List<MenudtreeData> dataList = new ArrayList<MenudtreeData>();
			for (Menu menu : allMenu) {
				MenudtreeData data = new MenudtreeData();
				data.setId(menu.getId());
				data.setParentId(menu.getFatherid());
				data.setTitle(menu.getMname());
				data.setCheckArr("0");
				dataList.add(data);
			}
			layui.setData(dataList);
			return layui;
	}
	@Override
	public List<MenudtreeData> allMenu(int id) {
		conn=this.getConnection();
		List<MenudtreeData> list=new ArrayList<MenudtreeData>();
		String sql="SELECT `userid` FROM `quanxian` WHERE `qxid`=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setObject(1, id);
			rs=pre.executeQuery();
			while (rs.next()) {
				MenudtreeData ys=new MenudtreeData();
				ys.setId(rs.getInt(1));
				list.add(ys);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int deleteqx(int id) {
		conn=this.getConnection();
		String sql="DELETE FROM quanxian WHERE qxid=?";
		// 2.提供替换?的object[]
		Object[] obj = { id };
		// 执行新增操作
		return this.executeUpdate(sql, obj);
	}
	@Override
	public int insertqx(int shenid, int quanid) {
		conn=this.getConnection();
		String sql = "INSERT INTO quanxian(qxid,userid) VALUES(?,?)";
		// 2.提供替换?的object[]
		Object[] obj = { shenid,quanid
				 };
		// 执行新增操作;
		return this.executeUpdate(sql, obj);
	}
	@Override
	public List<Btn> selectBtn() {
		conn=this.getConnection();
		List<Btn> list =new ArrayList<Btn>();
		String sql="SELECT id,btntype FROM `ls_butten`";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while (rs.next()) {
				Btn bb=new Btn();
				bb.setId(rs.getInt(1));
				bb.setBtntype(rs.getString(2));
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int insertQx(Menu ys) {
		conn=this.getConnection();
		String sql="INSERT INTO `menu` (mname,fatherid,`type`,url,btn) VALUES (?,?,?,?,?)";
		Object[] obj= {ys.getMname(),ys.getFatherid(),ys.getType(),ys.getUrl(),ys.getBtn()};
		
		return this.executeUpdate(sql, obj);
	}
	@Override
	public List<Menu> seqxList(int type) {
		conn=this.getConnection();
		List<Menu> list=new ArrayList<Menu>();
		String sql="SELECT `id`,`mname`FROM `menu` WHERE `type`=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setObject(1, type);
			rs = pre.executeQuery();// 无惨方法
			while (rs.next()) {
				Menu g=new Menu();
				g.setId(rs.getInt(1));
				g.setMname(rs.getString(2));
				
				list.add(g);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<User> seleList() {
		List<User> list=new ArrayList<User>();
		String sql="SELECT u.id,u.contact,b.`bname`,z.`userCode`,r.`roleName` FROM `useryuangong` u,`bumen` b,`zhicheng` z,`role` r WHERE u.bumen=b.id AND u.`zhichengid`=z.`id` AND u.jueseid=r.id";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while (rs.next()) {
				User mu=new User();
				mu.setId(rs.getInt(1));
				mu.setContact(rs.getString(2));
				mu.setBumen1(rs.getString(3));
				mu.setJueseid1(rs.getString(4));
				mu.setZhichengid1(rs.getString(5));
				list.add(mu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pre, rs);
		}
		
		return list;
	}
	@Override
	public List<Menu> seleMenu() {
		List<Menu>list=new ArrayList<Menu>();
		conn=getConnection();
		String sql="SELECT id,mname,`fatherid`,type,url,btn FROM `Menu`";//sql语句
		try {
			pre=conn.prepareStatement(sql);//获取执行者对象
			//设置参数
			rs=pre.executeQuery();//执行SQL语句
			while(rs.next()) {
				Menu gg=new Menu();
				gg.setId(rs.getInt(1));
				gg.setMname(rs.getString(2));
				gg.setFatherid(rs.getInt(3));
				gg.setType(rs.getInt(4));
				gg.setUrl(rs.getString(5));
				gg.setBtn(rs.getString(6));
				list.add(gg);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	@Override
	public int insertd(User ys) {
		conn=this.getConnection();
		String sql="INSERT INTO `useryuangong`(contact,bumen,zhichengid,jueseid) VALUES(?,?,?,?)";
		Object[] obj= {ys.getContact(),ys.getBumen(),ys.getZhichengid(),ys.getJueseid()};
		
		return this.executeUpdate(sql, obj);
	}
	@Override
	public List<Bumen> selectBumen() {
		List<Bumen> list=new ArrayList<Bumen>();
		
		String sql="SELECT id,bname FROM `bumen`";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				Bumen bb=new Bumen();
				bb.setId(rs.getInt(1));
				bb.setBname(rs.getString(2));
				list.add(bb);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<Role> selectRole() {
		List<Role> list=new ArrayList<Role>();
		String sql="SELECT id,roleName FROM `role`";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				Role bb=new Role();
				bb.setId(rs.getInt(1));
				bb.setRoleName(rs.getString(2));
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<ZhiCheng> seleZhiCheng() {
		List<ZhiCheng> list=new ArrayList<ZhiCheng>();
		String sql="SELECT id,userCode FROM `zhicheng`";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				ZhiCheng bb=new ZhiCheng();
				bb.setId(rs.getInt(1));
				bb.setUserCode(rs.getString(2));
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<User> selectrenbiao() {
		List<User> list=new ArrayList<User>();
		
		String sql="SELECT r.id,r.roleName,u.contact FROM `role` r,`useryuangong` u WHERE u.jueseid=r.id";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				User bb=new User();
				bb.setJueseid(rs.getInt(1));
				bb.setBumenname(rs.getString(2));
				bb.setContact(rs.getString(3));
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int updated(User ys) {
		String sql = "UPDATE useryuangong SET contact=?,bumen=?,zhichengid=?,jueseid=? WHERE id=?";
		// 2.提供替换?的object[]
		Object[] obj = {ys.getContact(), ys.getBumen(),
				ys.getZhichengid(), ys.getJueseid(),ys.getId()
				 };
		return this.executeUpdate(sql, obj);
	}
	@Override
	public User updateid(int id) {
		conn=this.getConnection();
		User ys=new User();
		String sql="SELECT * FROM `useryuangong`WHERE id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setObject(1, id);
			rs = pre.executeQuery();// 无惨方法
			while (rs.next()) {
			ys.setId(rs.getInt(1));
			ys.setBumen(rs.getInt(3));
			ys.setContact(rs.getString(2));
			ys.setZhichengid(rs.getInt(4));
			ys.setJueseid(rs.getInt(5));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ys;
	}
	@Override
	public int deleted(int id) {
		conn=this.getConnection();
		String sql="DELETE FROM `useryuangong` WHERE id=?";
		// 2.提供替换?的object[]
		Object[] obj = { id };
		// 执行新增操作
		return this.executeUpdate(sql, obj);
	}
	@Override
	public int updated(Menu ys) {
		String sql = "UPDATE `menu` SET mname=?,fatherid=?,`type`=?,url=?,btn=? WHERE id=?";
		// 2.提供替换?的object[]
		Object[] obj = {ys.getMname(), ys.getFatherid(),
				ys.getType(), ys.getUrl(),ys.getBtn(),ys.getId()
				 };
		return this.executeUpdate(sql, obj);
	}
	@Override
	public Menu updatemenu(int id) {
		conn=this.getConnection();
		Menu ys=new Menu();
		String sql="SELECT * FROM `menu`WHERE id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setObject(1, id);
			rs = pre.executeQuery();// 无惨方法
			while (rs.next()) {
			ys.setId(rs.getInt(1));
			ys.setMname(rs.getString(2));
			ys.setFatherid(rs.getInt(3));
			ys.setType(rs.getInt(4));
			ys.setUrl(rs.getString(5));
			ys.setBtn(rs.getString(6));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ys;
	}
	@Override
	public int deletequanxian(int id) {
		conn=this.getConnection();
		String sql="DELETE FROM `menu` WHERE id=?";
		// 2.提供替换?的object[]
		Object[] obj = { id };
		// 执行新增操作
		return this.executeUpdate(sql, obj);
	}
	@Override
	public List<yongshu> selectYongshu() {
		 List<yongshu> list=new ArrayList<yongshu>();
		
		String sql="SELECT id,uname,realname,sex,age FROM `yongshu`";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				yongshu bb=new yongshu();
				bb.setId(rs.getInt(1));
				bb.setUname(rs.getString(2));
				bb.setRealname(rs.getString(3));
				bb.setSex(rs.getInt(4));
				bb.setAge(rs.getInt(5));
				
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int deletednew(int id) {
		conn=this.getConnection();
		String sql="DELETE FROM yongshu WHERE id=?";
		// 2.提供替换?的object[]
		Object[] obj = { id };
		// 执行新增操作
		return executeUpdate(sql, obj);
	}
	@Override
	public int updatednew(yongshu ys) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public yongshu updateidnew(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insertdnew(yongshu ys) {
		// TODO Auto-generated method stub
		return 0;
	}

}
