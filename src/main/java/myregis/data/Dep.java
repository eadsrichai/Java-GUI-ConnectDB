package myregis.data;

public class Dep {
	private String id_dep;
	private String name_dep;
	public Dep() {
		
	}
	
	public Dep(String id_dep, String name_dep) {
		super();
		this.id_dep = id_dep;
		this.name_dep = name_dep;
	}

	public String getId_dep() {
		return id_dep;
	}
	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}
	public String getName_dep() {
		return name_dep;
	}
	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}
	
}
