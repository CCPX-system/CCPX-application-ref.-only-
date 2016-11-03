package service;

import javax.annotation.Resource;
import model.seller;
import org.springframework.stereotype.Service;
import dao.SellerManagementDao;

@Service("sellerManagementServiceImp")
public class SellerManagementServiceImp implements SellerManagementService {

     
	@Resource(name = "sellerManagementDaoImp")
	private SellerManagementDao sellerManagementDaoImp;

	@Override
	public seller checkSeller(String username, String password) {

		return sellerManagementDaoImp.checkSeller(username, password);
	}

}
