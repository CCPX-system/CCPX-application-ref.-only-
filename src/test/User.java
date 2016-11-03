package test;

public class User {

	int id;
	String name;
	String password;
	String wechat;
	
	
	public User(int id, String name, String password, String wechat) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.wechat = wechat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	
	
}
