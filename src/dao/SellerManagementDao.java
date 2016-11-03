package dao;

import model.seller;

public interface SellerManagementDao {

	public seller checkSeller(String username, String password);
}
