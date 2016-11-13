package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SellerManagementService;
//dash
@Controller()
public class AjaxController {
	@Resource(name = "sellerManagementServiceImp")
	private SellerManagementService sellerManagementServiceImp;

	@RequestMapping("/ajaxVerifycode")
	public void ajaxVerifyCode(HttpServletRequest req,
			HttpServletResponse resp, String verifyCode) throws IOException {
		System.out.println(verifyCode);
		if (verifyCode.equalsIgnoreCase((String) req.getSession().getAttribute(
				"vCode"))) {
			resp.getWriter().print(true);
		} else {
			resp.getWriter().print(false);
		}

	}



}
