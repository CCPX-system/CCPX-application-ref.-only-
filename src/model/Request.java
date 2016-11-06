package model;

import java.sql.Date;

public class Request {
	
	private int requestID; 
	private int userIdFrom; 
	private int userIdTo; 
	private int sellerIdFrom; 
	private int sellerIdTo; 
	private int pointsFrom; 
	private int pointsTo; 
	private int offerID; 
	private int status; 
	private Date updateTime;
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public int getUserIdFrom() {
		return userIdFrom;
	}
	public void setUserIdFrom(int userIdFrom) {
		this.userIdFrom = userIdFrom;
	}
	public int getUserIdTo() {
		return userIdTo;
	}
	public void setUserIdTo(int userIdTo) {
		this.userIdTo = userIdTo;
	}
	public int getSellerIdFrom() {
		return sellerIdFrom;
	}
	public void setSellerIdFrom(int sellerIdFrom) {
		this.sellerIdFrom = sellerIdFrom;
	}
	public int getSellerIdTo() {
		return sellerIdTo;
	}
	public void setSellerIdTo(int sellerIdTo) {
		this.sellerIdTo = sellerIdTo;
	}
	public int getPointsFrom() {
		return pointsFrom;
	}
	public void setPointsFrom(int pointsFrom) {
		this.pointsFrom = pointsFrom;
	}
	public int getPointsTo() {
		return pointsTo;
	}
	public void setPointsTo(int pointsTo) {
		this.pointsTo = pointsTo;
	}
	public int getOfferID() {
		return offerID;
	}
	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	} 

}
