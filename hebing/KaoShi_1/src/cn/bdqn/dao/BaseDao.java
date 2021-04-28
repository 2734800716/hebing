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
	
	private static String driver;//���ݿ������ַ���
	private static String url;//����URL�ַ���
	private static String user;//��¼�û���
	private static String password;//��¼����
	
	static {
		/*//����̬�����Ը�ֵ���漰���������þ�̬�����
		Properties params = new Properties();//һ��Properties�����װһ�������ļ���������Ϣ��һ���������һ�������ļ���
		String configFile = "axin.properties";//��Դ�ļ���src��Ϊ����
		//�ֽ���������ȡproperties�����ļ�
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		//��Properties�����ʼ��
		try {
			params.load(is);//load����ִ����ϣ�Properties�����в�������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���ĸ���̬���Ը�ֵ
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

	
	//������ݿ����Ӷ���Connection
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			// 1.��������
			Class.forName(driver);
			// 2.�������ݿ�����Connection����
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
	
	//�ر����ݿ�������Դ��������Է�װ�����Ը�����Ϊ�������βΣ�ʵ�ֶ�̬��
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			// 8.�ͷ���Դ��
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
	
	//��ɾ�����ݿ����
	public int executeUpdate(String sql, Object[] params){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int rowcount = -1;//�쳣
		try {
			// 1.��������
			// 2.�������ݿ�����Connection����
			conn = this.getConnection();
			// 4.����ִ����Statement����
			pstmt = conn.prepareStatement(sql);
			// 5.sql�������û��?��û�������ʡ�Ե�5��
			if(params != null){
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);//����setObject(�ڼ���?, ����)����һ�����͵�����
				}
			}
			// 6.ѡ�񷽷���U���� - ��ɾ�ģ�������Ӱ������int
			rowcount = pstmt.executeUpdate();//�޲η���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		
		return rowcount;
	}
}
