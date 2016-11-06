package model;

public class pointtransfer {
	private int PointTransfer_id;
	private String PointTransfer_Time;
	private int PointTransfer_Points;
	private int PointTransfer_Type;
	private int User_id;
	private int Seller_id;
	private String SellerPointSystem_Username;
	
	public int getPointTransfer_id() {
		return PointTransfer_id;
	}
	public void setPointTransfer_id(int PointTransfer_id) {
		this.PointTransfer_id = PointTransfer_id;
	}
	
	public String getPointTransfer_Time() {
		return PointTransfer_Time;
	}
	public void setPointTransfer_Time(String PointTransfer_Time) {
		this.PointTransfer_Time = PointTransfer_Time;
	}
	
	public int getPointTransfer_Points() {
		return PointTransfer_Points;
	}
	public void setPointTransfer_Points(int PointTransfer_Points) {
		this.PointTransfer_Points = PointTransfer_Points;
	}
	
	public int getPointTransfer_Type() {
		return PointTransfer_Type;
	}
	public void setPointTransfer_Type(int PointTransfer_Type) {
		this.PointTransfer_Type = PointTransfer_Type;
	}
	
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int User_id) {
		this.User_id = User_id;
	}
	
	public int getSeller_id() {
		return Seller_id;
	}
	public void setSeller_id(int Seller_id) {
		this.Seller_id = Seller_id;
	}
	
	public String getSellerPointSystem_Username() {
		return SellerPointSystem_Username;
	}
	public void setSellerPointSystem_Username(String SellerPointSystem_Username) {
		this.SellerPointSystem_Username = SellerPointSystem_Username;
	}
}
