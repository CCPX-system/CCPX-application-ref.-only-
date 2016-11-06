package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.seller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.SellerManagementService;
import utils.VerifyCode;

@Controller
public class SellerManagementController {
	Calendar c = java.util.Calendar.getInstance(); // yyyy年MM月dd日hh时mm分ss秒
	SimpleDateFormat f = new java.text.SimpleDateFormat("yyyy.MM.dd");

	static Logger log=Logger.getLogger(SellerManagementController.class);
	static{
		log.info("right");
	}
	 
	@Resource(name = "sellerManagementServiceImp")
	private SellerManagementService sellerManagementServiceImp;

	@RequestMapping("/checkSeller")
	public String checkSeller(HttpServletRequest req, String username,
			String password, String verifyCode) {
		if (verifyCode.equalsIgnoreCase((String) req.getSession().getAttribute(
				"vCode"))) {

			seller Seller = sellerManagementServiceImp.checkSeller(username, password);

			if (Seller != null) {
				System.out.println(Seller.getSeller_Email());
				req.getSession().setAttribute("Seller", Seller);

				return "loginSuccess";
			} else {

				req.setAttribute("msg", "用户名或者密码错误");
				return "login";
			}
		} else {
			req.setAttribute("msg", "验证码错误");
			return "login";
		}

	}

	@RequestMapping("/exit")
	public String exit(HttpServletRequest req) {

		req.getSession().removeAttribute("user");

		return "index";
	}

	@RequestMapping("/verifyCode")
	public void verifycode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		VerifyCode vc = new VerifyCode();

		BufferedImage image = vc.getImage();// 获取一次性验证码图片

		// 该方法必须在getImage()方法之后来调用
		// System.out.println(vc.getText());//获取图片上的文本
		VerifyCode.output(image, response.getOutputStream());// 把图片写到指定流中

		// 把文本保存到session中，为验证做准备
		request.getSession().setAttribute("vCode", vc.getText());

	}

}
