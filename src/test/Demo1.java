package test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo1 {
	public static void main(String[] args) {
//		List list = new ArrayList();  
//	     list.add("first");  
//	     list.add("second");  
//	     JSONArray jsonArray = JSONArray.fromObject( list );
//	     System.out.println(jsonArray);
		List<User> list1 = new ArrayList<User>();
		User user1 = new User(1, "张三", "1243554", "nihaojfd");
		User user2 = new User(2, "李四", "15676754", "sdpgokh");
		User user3 = new User(3, "王五", "12879054", "xcvbrft");
		list1.add(user1);
		list1.add(user2);
		list1.add(user3);
		JSONArray jsonArray = JSONArray.fromObject(list1);
		JSONObject jsonObject = JSONObject.fromObject(user1);
		System.out.println(jsonObject);
		System.out.println(jsonArray);
		System.out.println("======================");
		JSONObject jso = JSONObject.fromObject("{'message':'true'}");
		System.out.println(jso);
	}
	 
}
