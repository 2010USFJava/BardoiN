package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.CustomerDao;
import com.revature.users.Customer;
import com.revature.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createCustomer(Customer cust) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into \"Customers\" values(DEFAULT,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, cust.getFirstName());
		ps.setString(2, cust.getLastName());
		ps.setString(3, cust.getAddress());
		ps.setString(4, cust.getCity());
		ps.setString(5, cust.getState());
		ps.setInt(6, cust.getZipcode());
		ps.setString(7, cust.getEmail());
		ps.setString(8, cust.getPhone());
		ps.setString(9, cust.getUsername());
		ps.setString(10, cust.getPassword());
		ps.executeUpdate();

		
	}		
	
//	public boolean findCustomerbyUsername(String username) throws SQLException{
//		Connection conn = cf.getConnection();
//		String sql = "select * from \"Customers\" where \"username\"= ?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1,username);
//		ResultSet rs = ps.executeQuery();
//		Customer cust = null;
//		if(rs != null) {
//		while(rs.next()) {
//			cust = new Customer(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 0, false);
//		return true;
//			}
//		}
//		return false;
//	}
//	
//		
	public Customer findCustomerbyLogin(String username, String password) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "select * from \"Customers\" where \"username\"= ? and \"password\" = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
		}
			return cust;
		}
	

//		
//	public int getCustomerIDbyUser(String username) throws SQLException {
//		Connection conn = cf.getConnection();
//		String sql = "select * from \"Customers\" where \"username\"= ?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1,username);
//		ResultSet rs = ps.executeQuery();
//		int custID = 0;
//		if(rs != null) {
//			while(rs.next()) {
//				custID = rs.getInt(1);
//				return custID;
//				}
//			}
//		return 0;
//		}
	
	public Customer getCustomerInfobyID(int custID) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "select * from \"Customers\" where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,custID);
		ResultSet rs = ps.executeQuery();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer(custID, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
		}
			return cust;
		}
	
}

