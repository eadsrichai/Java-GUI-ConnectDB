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
	private Connection con;

	public void connectDb(String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost/regis?characterEncoding=utf-8";
		con = DriverManager.getConnection(dbURL, user, password);
	}

	public void addStudent(Student stu) throws SQLException {
		String sql = "INSERT INTO student VALUES ('" + stu.getId_stu() + "','" + stu.getPre_stu() + "','"
				+ stu.getFname_stu() + "','" + stu.getLname_stu() + "','" + stu.getGpa_stu() + "','"
				+ stu.getDep().getId_dep() + "')";
		;
		System.out.println(sql + "....");
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sql);
		System.out.println(row + " row(s) inserted");
	}

	public DefaultTableModel getAllStudentToTable() {
		Vector<String> columnNames = new Vector<String>();
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM student");
			ResultSet resultSet = pStatement.executeQuery();
			ResultSetMetaData rsMeta = (ResultSetMetaData) resultSet.getMetaData();
			int numberOfCols = rsMeta.getColumnCount();

			for (int i = 1; i <= numberOfCols; i++) {
				columnNames.add(rsMeta.getColumnName(i));
			}
			while (resultSet.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= numberOfCols; i++) {
					row.add(resultSet.getString(i));
				}
				model.addRow(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < columnNames.size(); i++) {
			System.out.println(columnNames.get(i));
		}
		model.addColumn(columnNames);
		return model;

	}

}
