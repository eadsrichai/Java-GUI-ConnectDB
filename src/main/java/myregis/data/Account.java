package myregis.data;

public class Account {
	private int id_account;
	private String id_type;
	private String username;
	private String password;
	
	public Account() {
		
	}
	public Account(int id_account, String id_type, String username, String password) {
		this.id_account = id_account;
		this.id_type = id_type;
		this.username = username;
		this.password = password;
	}
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
	}
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
