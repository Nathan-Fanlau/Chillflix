package models;

public class User {
	
	private Integer id; 
	private String name; 
	private String email; 
	private String pass;
	private String role;
	
	public User(Integer id, String name, String email, String pass, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
