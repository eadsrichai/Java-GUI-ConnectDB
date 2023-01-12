package myregis.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DepDAO {
private Connection con;
	
	public void connectDb(String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost/regis?characterEncoding=utf-8";
		con = DriverManager.getConnection(dbURL,user,password);
	}
	
	public Dep[] getAllDep() throws SQLException {
		ArrayList<Dep> list = new ArrayList<Dep>();
		Dep deps[];
		String sql = "SELECT id_dep,name_dep FROM dep";
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String id_dep = rs.getString(1);
			String name_dep = rs.getString(2);
			list.add(new Dep(id_dep,name_dep));
		}
		deps = new Dep[list.size()];
		list.toArray(deps);
		return deps;
		
	}
}
