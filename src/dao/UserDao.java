package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.User;


public interface UserDao {

	public String add(User user) throws SQLException;
	public void delete(int id) throws SQLException;
	public void update(User user) throws SQLException;
	public void updatepassword(User user) throws SQLException; 
	public User findById(int id) throws SQLException;
	public User findByName(String name) throws SQLException;
	public ArrayList<User> findAll() throws SQLException;
	public int checklogin(String username,String password) throws SQLException;
	public boolean token_auth(int u_id,String u_token) throws SQLException;
}