package controller;

import javax.annotation.Resource;

import model.SellerStatusInfo;
import model.Seller_transferInfoBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SellerTranserService;

@Controller
@RequestMapping("seller")
public class SellerTransferController extends SellerBaseController {

	@Resource(name="SellerTranserServiceImp")
	private SellerTranserService transferserviceImp;
	
	
	@RequestMapping(value="transfer",method=RequestMethod.POST)
	@ResponseBody
	public SellerStatusInfo transferpoint(Seller_transferInfoBean transferbean){
		
		SellerStatusInfo si = super.CreateStatus();
		si=transferserviceImp.point(transferbean);
		
		logger.warn(transferbean.toString());
		return si;
	}
	
}
