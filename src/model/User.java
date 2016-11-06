package model;

public class User {

	int id;
	String wechatid;
	String name;
	String email;
	String password;
	String fullname;
	String token;
	
	public User(){};
	public User(int id, String wechatid, String name, String email,
			String password, String fullname, String token) {
		super();
		this.id = id;
		this.wechatid = wechatid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.token = token;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWechatid() {
		return wechatid;
	}
	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
