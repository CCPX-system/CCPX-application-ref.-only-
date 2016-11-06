package model;

public class Notification {
	private int notifiID; 
	private int userID; 
	private char content; 
	private int status; 
	private int seen;
	public int getNotifiID() {
		return notifiID;
	}
	public void setNotifiID(int notifiID) {
		this.notifiID = notifiID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public char getContent() {
		return content;
	}
	public void setContent(char content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSeen() {
		return seen;
	}
	public void setSeen(int seen) {
		this.seen = seen;
	} 

}
