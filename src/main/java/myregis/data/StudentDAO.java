package myregis.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class StudentDAO {
	private ConnectDb con;
//
//	public void connectDb(String user, String password) throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String dbURL = "jdbc:mysql://localhost/regis?characterEncoding=utf-8";
//		con = DriverManager.getConnection(dbURL, user, password);
//	}
  public StudentDAO() {
	 con = new ConnectDb();
}
	public void addStudent(Student stu) throws SQLException {
		String sql = "INSERT INTO student VALUES ('" + stu.getId_stu() + "','" + stu.getPre_stu() + "','"
				+ stu.getFname_stu() + "','" + stu.getLname_stu() + "','" + stu.getGpa_stu() + "','"
				+ stu.getDep().getId_dep() + "')";
		;
		System.out.println(sql + "....");
		Statement stmt = con.getCon().createStatement();
		int row = stmt.executeUpdate(sql);
		System.out.println(row + " row(s) inserted");
		con.getCon().close();
	}

	public DefaultTableModel getAllStudentToTable() {
		Vector<String> columnNames = new Vector<String>();
		String header[] = {"รหัสนักศึกษา","คำนำหน้า","ชื่อ","นามสกุล","เกรดเฉลี่ย","สาขาวิชา"};
		
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		model.setColumnIdentifiers(header);
		try {
			PreparedStatement pstm = ConnectDb.con.prepareStatement(""
					+ "SELECT id_stu, pre_stu, fname_stu, lname_stu, gpa_stu, "
					+ "name_dep FROM student LEFT JOIN dep ON "
					+ "student.id_dep = dep.id_dep");
			
			ResultSet rs = pstm.executeQuery();
			ResultSetMetaData rsMeta = (ResultSetMetaData) rs.getMetaData();
			int numberOfCols = rsMeta.getColumnCount();

//			for (int i = 1; i <= numberOfCols; i++) {
//				columnNames.add(rsMeta.getColumnName(i));
//			}
				
			while (rs.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= numberOfCols; i++) {
					row.add(rs.getString(i));
				}
				model.addRow(row);
			}
			ConnectDb.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < columnNames.size(); i++) {
			System.out.println(columnNames.get(i));
		}		
		return model;

	}

}