package dao;



import java.util.List;

import model.Offer;
import model.Request;

public interface PlatformDao {

	public List<Request> showLatestTransaction(Integer sellerFrom, Integer sellerto);  
	
	public List<Offer> searchExcahnge(Integer sellerFrom, Integer sellerTo, Integer pointsFrom, Integer pointsToMin);
	
	public List<Offer> showRecommendationList(Integer sellerFrom, Integer sellerTo, Integer pointsFrom, Integer pointsToMin);
	
	
}
