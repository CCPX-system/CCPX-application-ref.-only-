package model;

public class user_to_seller {
	private int u_id;
	private int seller_id;
	private int points;
	private int points_blocked;
	
	public int getu_id() {
		return u_id;
	}
	public void setu_id(int u_id) {
		this.u_id = u_id;
	}
	
	public int getseller_id() {
		return seller_id;
	}
	public void setseller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public int getpoints() {
		return points;
	}
	public void setpoints(int points) {
		this.points = points;
	}
	
	public int getpoints_blocked() {
		return points_blocked;
	}
	public void setpoints_blocked(int points_blocked) {
		this.points_blocked = points_blocked;
	}
}
