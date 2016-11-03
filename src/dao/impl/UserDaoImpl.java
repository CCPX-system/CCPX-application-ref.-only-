package dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.UserDao;
import database.JdbcUtils_C3P0;
import entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void add(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into user(u_id,u_wechat_id,u_name,u_email_address,u_pw_hash,u_full_name,u_token)"
				+ "values(?,?,?,?,?,?,?)";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getWechatid());
			ps.setString(3, user.getName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getFullname());
			ps.setString(7, user.getToken());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("用户注册失败");
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
		String sql = "select u_wechat_id,u_name,u_email_address,u_pw_hash,u_full_name,u_token from user where u_id=?";
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
				user.setPassword(rs.getString(4));
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

	
}
