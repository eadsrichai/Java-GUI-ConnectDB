package pntc.ac.th.p2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import mycal.Cal;
import myregis.data.Dep;
import myregis.data.Student;
import myregis.data.StudentDAO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MyGui {

	private JFrame frame;
	private JTextField txtNumber1;
	private JTextField txtNumber2;
	private JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGui window = new MyGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MyGui() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 250, 253));
		frame.setTitle("ทดสอบระบบ");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumber1 = new JLabel("Number1");
		lblNumber1.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		lblNumber1.setBounds(104, 29, 86, 27);
		frame.getContentPane().add(lblNumber1);
		
		JLabel lblNumber2 = new JLabel("Number2");
		lblNumber2.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		lblNumber2.setBounds(104, 67, 86, 35);
		frame.getContentPane().add(lblNumber2);
		
		txtNumber1 = new JTextField();
		txtNumber1.setText("0.00");
		txtNumber1.setForeground(new Color(0, 0, 128));
		txtNumber1.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		txtNumber1.setBounds(184, 34, 114, 31);
		frame.getContentPane().add(txtNumber1);
		txtNumber1.setColumns(10);
		
		txtNumber2 = new JTextField();
		txtNumber2.setText("0.00");
		txtNumber2.setForeground(new Color(0, 0, 128));
		txtNumber2.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		txtNumber2.setBounds(184, 76, 114, 35);
		frame.getContentPane().add(txtNumber2);
		txtNumber2.setColumns(10);
//		
//		Dep dep = new Dep("09","IT");
//		Student s = new Student("555","นาย","วุฒิวงศ์","เอียดศรีชาย",4.00,dep);
//		StudentDAO stuDAO = new StudentDAO();
//		stuDAO.connectDb("root", "");
//		stuDAO.addStudent(s);
		
		
		JButton btnCal = new JButton("บวกเลข");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			double n1 =	Double.parseDouble(txtNumber1.getText());
			double n2 =	Double.parseDouble(txtNumber2.getText());
				
//			double sum = n1+n2;
//			txtResult.setText(String.valueOf(sum));
				
			Cal c = new Cal();
			c.setNumber1(n1);
			c.setNumber2(n2);
			txtResult.setText(String.valueOf(c.calNumber()));
			
				
			}
		});
		btnCal.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		btnCal.setBounds(181, 121, 117, 35);
		frame.getContentPane().add(btnCal);
		
		txtResult = new JTextField();
		txtResult.setText("0.00");
		txtResult.setForeground(new Color(0, 0, 128));
		txtResult.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		txtResult.setBounds(184, 167, 114, 35);
		frame.getContentPane().add(txtResult);
		txtResult.setColumns(10);
	}
}
