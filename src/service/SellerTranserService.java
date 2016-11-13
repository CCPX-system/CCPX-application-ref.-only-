package service;

import model.SellerStatusInfo;
import model.Seller_transferInfoBean;

/*
 * @description  transfer point in and out
 * @group Seller function
 * @author:KEN
 * @datetime: 2016-11-02
 * */
public interface SellerTranserService {
		/*
		 * @description query point  from virtual seller point system
		 * @param name 
		 * @param password 
		 * @param seller_id 
		 * @param trade_type 0:transfer in,1:transfer out,2:query point
		 * @points points transfer in or out
		 * @return point seller have 
		 * */
		public SellerStatusInfo point(Seller_transferInfoBean transferbean);
		
		

}
