package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CustomerDao;
import com.revature.users.Accounts;
import com.revature.users.Customer;
import com.revature.users.Accounts.accountType;
import com.revature.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createCustomer(Customer cust) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into \"Customers\" values(DEFAULT,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, cust.getFirstName());
		ps.setString(2, cust.getLastName());
		ps.setString(3, cust.getAddress());
		ps.setString(4, cust.getEmail());
		ps.setString(5, cust.getPhone());
		ps.setString(6, cust.getUsername());
		ps.setString(7, cust.getPassword());
		ps.executeUpdate();

		
	}		
		
	public Customer findCustomerbyLogin(String username, String password) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "select * from \"Customers\" where \"username\"= ? and \"password\" = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
		}
			return cust;
		}
	
	public Customer getCustomerInfobyID(int custID) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "select * from \"Customers\" where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,custID);
		ResultSet rs = ps.executeQuery();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer(custID, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
		}
			return cust;
		}

	public List<Customer> getAllCustomers() throws SQLException {
		
		List<Customer> custList= new ArrayList<Customer>();
		Connection conn= cf.getConnection();
		String sql = "select * from \"Customers\"";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			custList.add(c);
		}
		return custList;
	}
	
	public Customer updateFirstNamebyID(String newVal, int custID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update \"Customers\" set \"firstname\"=? where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newVal);
		ps.setInt(2, custID);
		ps.executeUpdate();
		
		String sql2 = "select * from \"Customers\" where \"USER_ID\"= ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setInt(1,custID);
		ResultSet rs2 = ps2.executeQuery();
		Customer c = null;
		while(rs2.next()) {
			c = new Customer(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8));
		}
			return c;
	}
	
	public Customer updateLastNamebyID(String newVal, int custID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update \"Customers\" set \"lastname\"=? where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newVal);
		ps.setInt(2, custID);
		ps.executeUpdate();
		
		String sql2 = "select * from \"Customers\" where \"USER_ID\"= ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setInt(1,custID);
		ResultSet rs2 = ps2.executeQuery();
		Customer c = null;
		while(rs2.next()) {
			c = new Customer(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8));
		}
			return c;
		
	}
	public Customer updateAddressbyID(String newVal, int custID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update \"Customers\" set \"address\"=? where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newVal);
		ps.setInt(2, custID);
		ps.executeUpdate();
		
		String sql2 = "select * from \"Customers\" where \"USER_ID\"= ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setInt(1,custID);
		ResultSet rs2 = ps2.executeQuery();
		Customer c = null;
		while(rs2.next()) {
			c = new Customer(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8));
		}
			return c;
	}
	public Customer updateEmailbyID(String newVal, int custID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update \"Customers\" set \"email\"=? where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newVal);
		ps.setInt(2, custID);
		ps.executeUpdate();
		
		String sql2 = "select * from \"Customers\" where \"USER_ID\"= ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setInt(1,custID);
		ResultSet rs2 = ps2.executeQuery();
		Customer c = null;
		while(rs2.next()) {
			c = new Customer(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8));
		}
			return c;
	}
	public Customer updatePhonebyID(String newVal, int custID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update \"Customers\" set \"phone\"=? where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newVal);
		ps.setInt(2, custID);
		ps.executeUpdate();
		
		String sql2 = "select * from \"Customers\" where \"USER_ID\"= ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setInt(1,custID);
		ResultSet rs2 = ps2.executeQuery();
		Customer c = null;
		while(rs2.next()) {
			c = new Customer(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8));
		}
			return c;
	}
	
	public void deleteCust(int custID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from \"Customers\" where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, custID);
		ps.executeUpdate();
	}
}

