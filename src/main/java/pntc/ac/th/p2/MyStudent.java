package pntc.ac.th.p2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import myregis.data.AccountDAO;
import myregis.data.Dep;
import myregis.data.DepDAO;
import myregis.data.Student;
import myregis.data.StudentDAO;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MyStudent {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtFname;
	private JTextField txtGpa;
	private JTextField txtLname;
	private JComboBox cbPre;
	private JComboBox cbDep;
	private JTable table;
	public static String userName;
	public static String passWord;
	static JLabel lblWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyStudent window = new MyStudent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public MyStudent() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		LoginDialog();
		
		frame = new JFrame();
		frame.setTitle("ระบบฐานข้อมูลนักศึกษา");
		frame.setBounds(100, 100, 922, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("รหัสนักศึกษา");
		lblNewLabel.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		lblNewLabel.setBounds(48, 50, 89, 14);
		frame.getContentPane().add(lblNewLabel);

		txtId = new JTextField();
		txtId.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		txtId.setBounds(164, 50, 86, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("คำนำหน้า");
		lblNewLabel_1.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		lblNewLabel_1.setBounds(48, 76, 74, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ชื่อ-สกุล");
		lblNewLabel_1_1.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(48, 119, 74, 14);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("เกรดเฉลี่ย");
		lblNewLabel_1_1_1.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(48, 144, 74, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("แผนกวิชา");
		lblNewLabel_1_1_1_1.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		lblNewLabel_1_1_1_1.setBounds(48, 177, 74, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);

		txtFname = new JTextField();
		txtFname.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		txtFname.setColumns(10);
		txtFname.setBounds(164, 119, 126, 20);
		frame.getContentPane().add(txtFname);

		txtGpa = new JTextField();
		txtGpa.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		txtGpa.setColumns(10);
		txtGpa.setBounds(164, 144, 86, 20);
		frame.getContentPane().add(txtGpa);

		DepDAO depDAO = new DepDAO();
//		depDAO.connectDb("root", "");
		Dep deps[] = depDAO.getAllDep();
		cbDep = new JComboBox();

		cbDep.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		for (Dep d : deps) {
			cbDep.addItem(d.getName_dep());
		}

		cbPre = new JComboBox();
		cbPre.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		cbPre.setModel(new DefaultComboBoxModel(new String[] { "นาย", "นางสาว" }));
		cbPre.setBounds(164, 81, 86, 27);
		frame.getContentPane().add(cbPre);

//		cbDep.setModel(new DefaultComboBoxModel(new String[] {"ช่างยนต์", "เทคโนโลยีสารสนเทศ"}));
		cbDep.setBounds(164, 176, 186, 22);
		frame.getContentPane().add(cbDep);

		txtLname = new JTextField();
		txtLname.setFont(new Font("CordiaUPC", Font.BOLD, 22));
		txtLname.setColumns(10);
		txtLname.setBounds(324, 115, 92, 23);
		frame.getContentPane().add(txtLname);

		JButton btnAddStudent = new JButton("เพิ่มข้อมูลนักศึกษา");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Student s = new Student();
				s.setId_stu(txtId.getText());
				s.setPre_stu(String.valueOf(cbPre.getSelectedItem()));
				s.setFname_stu(txtFname.getText());
				s.setLname_stu(txtLname.getText());
				s.setGpa_stu(Double.parseDouble(txtGpa.getText()));

				Dep dep = new Dep();

				if (cbDep.getSelectedItem().equals("ช่างยนต์"))
					dep.setId_dep("01");
				else
					dep.setId_dep("09");

				s.setDep(dep);

				StudentDAO stuDAO = new StudentDAO();
				try {
//					stuDAO.connectDb("root", "");
					stuDAO.addStudent(s);
					showTable();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnAddStudent.setBackground(new Color(255, 128, 64));
		btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddStudent.setBounds(164, 209, 217, 44);
		frame.getContentPane().add(btnAddStudent);

		JButton btnShowStudent = new JButton("แสดงข้อมูลนักศึกษา");
		btnShowStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showTable();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowStudent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShowStudent.setBackground(new Color(255, 128, 64));
		btnShowStudent.setBounds(390, 209, 237, 44);
		frame.getContentPane().add(btnShowStudent);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 260, 641, 276);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("CordiaUPC", Font.BOLD, 18));

		showTable();
	}

	private void showTable() throws ClassNotFoundException, SQLException {
		StudentDAO stuDAO = new StudentDAO();
//		stuDAO.connectDb("root", "");

		table.setModel(stuDAO.getAllStudentToTable());
	}

	public static void LoginDialog() {

		JLabel title = new JLabel("Login Username and Password");
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		final JComponent[] inputs = new JComponent[] { 
				title, new JLabel("Username"), username, new JLabel("Password"),
				password };

		JOptionPane.showMessageDialog(null, inputs, "Login", JOptionPane.PLAIN_MESSAGE);
		userName = username.getText();
		passWord = new String(password.getPassword());

		
		
		if (!getLogin()) {
			LoginDialog();
		}
	}

	public static Boolean getLogin() {
		Boolean status = false;
		try {
			if(new AccountDAO().getAccount(userName, passWord)) {
				status = true;
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
		}
}