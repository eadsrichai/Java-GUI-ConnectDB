package myregis.data;

public class Student {
	private String id_stu;
	private String pre_stu;
	private String fname_stu;
	private String lname_stu;
	private double gpa_stu;
	private Dep dep;
	public Dep getDep() {
		return dep;
	}
	public void setDep(Dep dep) {
		this.dep = dep;
	}
	public Student() {
	}
	public Student(String id_stu, String pre_stu, String fname_stu, String lname_stu, double gpa_stu, Dep dep) {
		this.id_stu = id_stu;
		this.pre_stu = pre_stu;
		this.fname_stu = fname_stu;
		this.lname_stu = lname_stu;
		this.gpa_stu = gpa_stu;
		this.dep = dep;
	}
	public String getId_stu() {
		return id_stu;
	}
	public void setId_stu(String id_stu) {
		this.id_stu = id_stu;
	}
	public String getPre_stu() {
		return pre_stu;
	}
	public void setPre_stu(String pre_stu) {
		this.pre_stu = pre_stu;
	}
	public String getFname_stu() {
		return fname_stu;
	}
	public void setFname_stu(String fname_stu) {
		this.fname_stu = fname_stu;
	}
	public String getLname_stu() {
		return lname_stu;
	}
	public void setLname_stu(String lname_stu) {
		this.lname_stu = lname_stu;
	}
	public double getGpa_stu() {
		return gpa_stu;
	}
	public void setGpa_stu(double gpa_stu) {
		this.gpa_stu = gpa_stu;
	}	
}
