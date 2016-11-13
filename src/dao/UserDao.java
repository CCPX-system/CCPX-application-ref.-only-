package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.User;


public interface UserDao {

	public void add(User user) throws SQLException;
	public void delete(int id) throws SQLException;
	public void update(User user) throws SQLException;
	public void updatepassword(User user) throws SQLException; 
	public User findById(int id) throws SQLException;
	public ArrayList<User> findAll() throws SQLException;
	public int checklogin(String username,String password) throws SQLException;
}