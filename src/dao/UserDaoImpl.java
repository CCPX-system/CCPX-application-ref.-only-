package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import com.alibaba.fastjson.parser.ParseContext;

import model.User;
import utils.JdbcUtils_C3P0;
import dao.UserDao;



public class UserDaoImpl implements UserDao{

	@Override
	/*
	 * @return "ok" for ok,
	 * @return "error" for error
	 * */
	public String add(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		
		String sql = "insert into user(u_wechat_id,u_name,u_email_address,u_pw_hash,u_full_name,u_token)"
				+ "values(?,?,?,?,?,?)";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, user.getId());
			ps.setString(1, user.getWechatid());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getFullname());
			ps.setString(6, user.getToken());
			ps.executeUpdate();
			return "ok";

		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
			//throw new SQLException("用户注册失败");
			
		} finally {
			JdbcUtils_C3P0.release(conn, ps, null);
		}
		
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
        String sql = "delete from user where id=?";
        try {
        	conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("用户注销失败");
		} finally {
			JdbcUtils_C3P0.release(conn, ps, null);
		}
		
	}

	@Override
	public void update(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update user set u_wechat_id=?,u_name=?,u_email_address=?,u_full_name=? where id=?";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getWechatid());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setInt(5, user.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("修改用户信息失败");
		} finally {
			JdbcUtils_C3P0.release(conn, ps, null);
		}
		
	}

	@Override
	public User findById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select u_wechat_id,u_name,u_email_address,u_full_name,u_token from user where u_id=?";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
			    user = new User();
				user.setId(id);
				user.setWechatid(rs.getString(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				//user.setPassword(rs.getString(4));
				user.setFullname(rs.getString(4));
				user.setToken(rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("获取用户信息失败");
		} finally {
			JdbcUtils_C3P0.release(conn, ps, null);
		}
		return user;
	}
	
	public User findByName(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select u_id,u_wechat_id,u_name,u_email_address,u_full_name,u_token from user where u_name=?";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()){
			    user = new User();
				user.setId(rs.getInt(1));
				user.setWechatid(rs.getString(2));
				user.setName(rs.getString(3));
				user.setEmail(rs.getString(4));
//				user.setPassword(rs.getString(4));
				user.setFullname(rs.getString(5));
				user.setToken(rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("获取用户信息失败");
		} finally {
			JdbcUtils_C3P0.release(conn, ps, null);
		}
		return user;
	}

	@Override
	public ArrayList<User> findAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> users = new ArrayList<User>();
		String sql = "select u_id,u_wechat_id,u_name,u_email_address,u_pw_hash,u_full_name,u_token from user";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
			    User user = new User();
				user.setId(rs.getInt(1));
				user.setWechatid(rs.getString(2));
				user.setName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setFullname(rs.getString(6));
				user.setToken(rs.getString(7));
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("获取全部用户失败");
		} finally {
			JdbcUtils_C3P0.release(conn, ps, null);
		}
		return users;
	}

	@Override
	public void updatepassword(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update user set u_pw_hash=? where id=?";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setInt(2, user.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("修改用户密码失败");
		} finally {
			JdbcUtils_C3P0.release(conn, ps, null);
		}
		
	}

	@Override
	public int checklogin(String username, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		String sql = "select u_id from user where u_name=? and u_pw_hash=?";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
			BigDecimal lastIdBd = rs.getBigDecimal(1);
		    id = lastIdBd.intValue();}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("登录失败");
		} finally {
			JdbcUtils_C3P0.release(conn, ps, rs);
		}
		return id;
	}
	
	@Override
	public boolean token_auth(int u_id,String u_token) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = -1;
		String sql = "select u_id from user where u_id=? and u_token=?";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_id);
			ps.setString(2, u_token);
			rs = ps.executeQuery();
			if(rs.next()){
			BigDecimal lastIdBd = rs.getBigDecimal(1);
		    id = lastIdBd.intValue();}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("验证错误");
		} finally {
			JdbcUtils_C3P0.release(conn, ps, rs);
		}
		if(id != -1){
			return true;
		}
		return false;
	}

	
}
