package model;

public class Offer {
	private int offerID; 
	private int userID; 
	private int sellerFrom; 
	private int sellerTo; 
	private int pointsFrom; 
	private int pointsToMin; 
	private int status;
	public int getOfferID() {
		return offerID;
	}
	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getSellerFrom() {
		return sellerFrom;
	}
	public void setSellerFrom(int sellerFrom) {
		this.sellerFrom = sellerFrom;
	}
	public int getPointsFrom() {
		return pointsFrom;
	}
	public void setPointsFrom(int pointsFrom) {
		this.pointsFrom = pointsFrom;
	}
	public int getSellerTo() {
		return sellerTo;
	}
	public void setSellerTo(int sellerTo) {
		this.sellerTo = sellerTo;
	}
	public int getPointsToMin() {
		return pointsToMin;
	}
	public void setPointsToMin(int pointsToMin) {
		this.pointsToMin = pointsToMin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	} 
	

}
