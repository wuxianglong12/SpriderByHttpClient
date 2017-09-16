package com.ustc.sse.DB;
import java.sql.*;
public class Dbhelper {
	//连接语句，localhost代表本地连接，也可以通过获取本地ip地址填写ip地址
	private static final String url = "jdbc:mysql://127.0.0.1:3306/news?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC ";
	//用户名，可在数据库的安全性里面找到，注意要开启
	private static final String username="root";
	//用户密码；和用户名一起设置
	private static final String password="123456";
	//private static final String Driver="";

	static{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
	}

	private static Connection getconnection() throws SQLException{
		//DriverManager.getConnection(url,username,password);
		//System.out.println("----------------------------------------------------");
		return DriverManager.getConnection(url,username,password);
	}


	public static int ExecUpdate(String sql) throws SQLException
	{
		System.out.println("Update:\n" +sql + "\n on " + System.currentTimeMillis());
		Connection con = getconnection();
		PreparedStatement state = con.prepareStatement(sql);
		int res=0;
		try{
			res = state.executeUpdate();
			System.out.println("Update Compelete!");
			con.close();
			return res;
		}
		catch(Exception ww){
			return 0;
		}
	}

	public static ResultSet ExecQuery(String sql) throws SQLException
	{
		System.out.println("Query:\n" +sql + "\n on " + System.currentTimeMillis());
		Connection con = getconnection();
		PreparedStatement state = con.prepareStatement(sql);
		ResultSet res = state.executeQuery();
		System.out.println("Query Compelete!");
		return res;
	}

	public static void main(String[] args) throws SQLException {
		getconnection();
	}


}

