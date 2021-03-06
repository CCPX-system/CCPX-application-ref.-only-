package server;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody;

import utils.CommonUtil;
import utils.MD5Util;
import dao.impl.UserDaoImpl;
import database.JdbcUtils_C3P0;
import entity.User;
@Controller  
@RequestMapping(value ="/user")
public class UserController {  

    @RequestMapping(value = "/register", method = RequestMethod.POST)  
    @ResponseBody
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException{
        response.setCharacterEncoding("UTF-8"); 
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String wechat = request.getParameter("wechat");
        User user = new User();
        user.setId(CommonUtil.getcount()+1);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(MD5Util.MD5(password));
        user.setFullname(fullname);
        user.setWechatid(wechat);
        user.setToken(MD5Util.MD5(name+password));
        UserDaoImpl impl = new UserDaoImpl();
        impl.add(user);
    	PrintWriter out = response.getWriter();
        String message = "{'message':'success'}";  
        JSONObject json = JSONObject.fromObject( message );
         out.print(json);
         out.close();
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)  
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
    	response.setCharacterEncoding("UTF-8"); 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    	String name = request.getParameter("name");
    	String password = request.getParameter("password");
    	UserDaoImpl impl = new UserDaoImpl();
    	int flag = impl.checklogin(name, MD5Util.MD5(password));
    	String message = null;
    	if(flag==0){
    		message = "{'message':'username or password is not correct'}";
    		JSONObject json = JSONObject.fromObject( message );
    		out.print(json);
    		out.close();
    		return;
    	}
    	else {
    		User user = impl.findById(flag);
    		JSONObject json = JSONObject.fromObject(user);
    		out.print(json);
    		out.close();
    	}
    }
    @RequestMapping(value = "/modify", method = RequestMethod.POST)  
    @ResponseBody
    public void modify(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException{
        response.setCharacterEncoding("UTF-8"); 
        response.setContentType("text/html");
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String wechat = request.getParameter("wechat");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setFullname(fullname);
        user.setWechatid(wechat);
        UserDaoImpl impl = new UserDaoImpl();
        impl.update(user);
    	PrintWriter out = response.getWriter();
        String message = "{'message':'success'}";  
        JSONObject json = JSONObject.fromObject( message );
         out.print(json);
         out.close();
    }
    public static void main(String[] args) {
    	 String message = "{'message':'success'}";  
         JSONObject json = JSONObject.fromObject( message );
         System.out.println(json);
	}
}  