package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class dbConnect {
	
	private static Properties pr = new Properties();
	private static String driverName = null;
	private static String userName = null;
	private static String userPassword = null;
	private static String url = null;
	
	public dbConnect() {
		// TODO Auto-generated constructor stub
	}
	
	// 装入工具类时只执行一次
	static{
		try {
			pr.load(dbConnect.class.getClassLoader().getResourceAsStream(
					"db.properties"));
			System.out.println("连接properties成功!");
		} catch (IOException e) {
			System.out.println("连接properties失败!");
		}
		driverName = pr.getProperty("driver_mysql");
		url = pr.getProperty("url_mysql");
		userName = pr.getProperty("username");
		userPassword = pr.getProperty("userpassword");
	}
	
	public static Connection getdbConnection(){	
		try {
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url,userName,userPassword);
			System.out.println("加载驱动成功！并连接成功");
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeDB(Connection con,PreparedStatement pstm, ResultSet rs) throws SQLException{
		if(rs!=null)rs.close();
		if(pstm!=null)pstm.cancel();
		if(con!=null)con.close();
	}
}
