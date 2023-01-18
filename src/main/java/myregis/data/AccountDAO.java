package myregis.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDAO {
	private PreparedStatement pstm;
	private ConnectDb con;
	
	public AccountDAO() {
		con = new ConnectDb();
	}
	
	public boolean getAccount(String u, String p) throws SQLException {
		boolean status = false;
		String sql = "SELECT * FROM account WHERE username like ? AND password like ?";
		
		pstm = con.getCon().prepareStatement(sql);
		pstm.setString(1, u);
		pstm.setString(2, p);
		
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			status = true;
		}else {
			status = false;
		}
		return status;
	}
}
