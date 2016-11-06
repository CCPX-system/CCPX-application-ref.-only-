package dao;

import model.Offer;
import model.Request;

public interface PlatformDao {

	public Request showLatestTransaction(Integer sellerFrom, Integer sellerto);  
	
	public Offer searchExcahnge(Integer sellerFrom, Integer sellerTo, Integer pointsFrom, Integer pointsToMin);
	
	public Offer showRecommendationList(String sellerFrom, String sellerTo, String pointsFrom, String pointsToMin);
	
	
}
