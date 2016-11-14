package controller;

import java.util.List;
import model.Notification;
import model.Offer;
import model.Request;
import model.user_to_seller;
import dao.PlatformDao;
import dao.PlatformDaoImp;


public class PlatformController {
	
	
		
		
	
		public void RemoveOffer(){
			
		}
		public void RemoveExchange(){
			
		}
		public void DeclineExchange(){
			
		}
		public void AcceptRequest(){
			
		}
	
		 public List<Request> showLatestTransaction(Integer sellerFrom, Integer sellerTo){
			return new PlatformDaoImp().showLatestTransaction(sellerFrom, sellerTo);
		 }
		 
		 public List<Offer> searchExchange(Integer sellerFrom, Integer sellerTo, Integer pointsFrom, Integer pointsToMin){
				return new PlatformDaoImp().searchExcahnge(sellerFrom, sellerTo, pointsFrom, pointsToMin); 
			 }
		 
		 public List<Offer> showRecommendationList(Integer sellerFrom, Integer sellerTo, Integer pointsFrom, Integer pointsToMin){
				return new PlatformDaoImp().searchExcahnge(sellerFrom, sellerTo, pointsFrom, pointsToMin); 
			 }
		 
}
