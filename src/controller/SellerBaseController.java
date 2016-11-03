/**
 * 
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SellerStatusInfo;

import org.apache.log4j.Logger;


/**
 * @author KEN
 
 */
public class SellerBaseController  {
	 protected Logger logger = Logger.getLogger(getClass());

	    protected HttpServletRequest request;
	    protected HttpServletResponse response;
	    protected HttpSession session;
	    
	    public SellerStatusInfo CreateStatus(){
	    	return new SellerStatusInfo();
	    }
}
