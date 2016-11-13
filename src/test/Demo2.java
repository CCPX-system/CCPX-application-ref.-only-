package test;

import java.sql.SQLException;

import dao.impl.UserDaoImpl;
import entity.User;

public class Demo2 {

	public static void main(String[] args) throws SQLException {
		User user = new User( 2,"sldkgj", "张三", "slkdj", "sfgfg", "xklcvvip", "sdnj");
		UserDaoImpl impl = new UserDaoImpl();
		impl.add(user);
	}
}
