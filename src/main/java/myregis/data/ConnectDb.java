package myregis.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class ConnectDb {
	private  final static String username = "root";
	private  final static String password = "";
	public  static Connection con;
	private static String dbURL;
	
	public ConnectDb()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbURL = "jdbc:mysql://localhost/regis?characterEncoding=utf-8";
			con = DriverManager.getConnection(dbURL,getUsername(),getPassword());
		} catch (ClassNotFoundException e) {
			System.out.println("ค้นหา Class ไม่เจอ" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("คำสั่ง SQL ไม่ถูกต้อง" + e.getMessage());
		}
		
	}

	public static  String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static Connection getCon() {
		return con;
	}

	public  static void setCon(Connection con) {
		con = con;
	}

	public String getDbURL() {
		return dbURL;
	}

	public static void setDbURL(String dbURL) {
		dbURL = dbURL;
	}
	
	public static void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
