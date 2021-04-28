package cn.bdqn.dao;

//import java.io.IOException;
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
//import java.util.Properties;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	
	private static String driver;//数据库驱动字符串
	private static String url;//连接URL字符串
	private static String user;//登录用户名
	private static String password;//登录密码
	
	static {
		/*//给静态的属性赋值，涉及代码必须得用静态代码块
		Properties params = new Properties();//一个Properties对象封装一个配置文件的所有信息【一个对象代表一个配置文件】
		String configFile = "axin.properties";//以源文件夹src作为参照
		//字节输入流读取properties配置文件
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		//给Properties对象初始化
		try {
			params.load(is);//load方法执行完毕，Properties对象中才有数据
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//给四个静态属性赋值
		driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("user");
		password = params.getProperty("password");
		*/
		ResourceBundle bundle = ResourceBundle.getBundle("axin", new Locale("zh", "CN"));
		
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
	}

	
	//获得数据库连接对象Connection
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.创建数据库连接Connection对象
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/hxj");
			conn=ds.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		return conn;
	}
	
	//关闭数据库连接资源（代码可以封装）【以父类作为方法的形参，实现多态】
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			// 8.释放资源：
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//增删改数据库操作
	public int executeUpdate(String sql, Object[] params){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int rowcount = -1;//异常
		try {
			// 1.加载驱动
			// 2.创建数据库连接Connection对象
			conn = this.getConnection();
			// 4.创建执行者Statement对象
			pstmt = conn.prepareStatement(sql);
			// 5.sql语句中有没有?，没有则可以省略第5步
			if(params != null){
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);//方法setObject(第几个?, 数据)兼容一切类型的数据
				}
			}
			// 6.选择方法：U方法 - 增删改，返回受影响行数int
			rowcount = pstmt.executeUpdate();//无参方法
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		
		return rowcount;
	}
}
