package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.users.Customer;
import com.revature.util.ConnFactory;

public class CustomerDaoImplTest {
	static CustomerDaoImpl cdi = new CustomerDaoImpl();
	static ConnFactory cf = ConnFactory.getInstance();
	static Connection conn = cf.getConnection();
	
	//p.execute is true/false
	//p.executeQuery for resultset object
	//p.executeUpdate for insert, delete, update statements
	
	@After
	public void deleteNewData() {
		try {
			PreparedStatement p = conn.prepareStatement("delete from \"Customers\" where \"username\"='testUser'");
			p.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete problems");
			e.printStackTrace();
		}
	}
	@Test
	public void testCreateCustomer() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		try {
			cdi.createCustomer(cust);
			PreparedStatement ps = conn.prepareStatement("select * from \"Customers\" where \"username\"=\'testUser\'");
			ResultSet rs = ps.executeQuery();
			Customer c = null;
			if(rs!=null) {
				while(rs.next()) {
					c = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
							rs.getString(7),rs.getString(8));
					System.out.println(cust.toString());
				}
			}else {
				fail("Test failure");
		} 
			}catch (SQLException e) {
			System.out.println("testNewCustomer problem");
			e.printStackTrace();
		}
		
	}
	@Test
	public void testFindCustomerbyLogin() {
		String username = "testUser";
		String password = "testPass";
		try {
			cdi.findCustomerbyLogin(username, password);
			PreparedStatement ps = conn.prepareStatement("select * from \"Customers\" where \"username\"= ? and \"password\" = ?");
			ps.setString(1,username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			Customer c = null;
			if(rs!=null) {
				while(rs.next()) {
					c = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
							rs.getString(7),rs.getString(8));
					System.out.println(c.toString());
				}
			}else {
				fail("Test failure");
		} 
			}catch (SQLException e) {
			System.out.println("testFindCustbyLogin problem");
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetCustomerInfobyID() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int id = c.getUser_id();
			Customer c2 = cdi.getCustomerInfobyID(id);
			assertEquals("first", c2.getFirstName());
	
			}catch (SQLException e) {
			System.out.println("testGetCustInfo problem");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllCustomers() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		
		try {
			cdi.createCustomer(cust);
			List<Customer> custList = cdi.getAllCustomers();
			assertTrue(custList.size() > 0);
		}catch (SQLException e) {
				System.out.println("testGetAllCust problem");
				e.printStackTrace();
			}
		}

	@Test
	public void testUpdateFirstNamebyID() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		String newVal = "first_name";
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			Customer c2 = cdi.updateFirstNamebyID(newVal, custID);
			assertEquals(newVal, c2.getFirstName());
			}catch (SQLException e) {
			System.out.println("testUpdateFirstName problem");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateLastNamebyID() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		String newVal = "last_name";
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			Customer c2 = cdi.updateLastNamebyID(newVal, custID);
			assertEquals(newVal, c2.getLastName());
			}catch (SQLException e) {
			System.out.println("testUpdateLastName problem");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateAddressbyID() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		String newVal = "789 Test St., City, State, Zip Code";
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			Customer c2 = cdi.updateAddressbyID(newVal, custID);
			assertEquals(newVal, c2.getAddress());
			}catch (SQLException e) {
			System.out.println("testUpdateAddress problem");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateEmailbyID() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		String newVal = "email@email.com";
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			Customer c2 = cdi.updateEmailbyID(newVal, custID);
			assertEquals(newVal, c2.getEmail());
			}catch (SQLException e) {
			System.out.println("testUpdateEmail problem");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdatePhonebyID() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		String newVal = "987654321";
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			Customer c2 = cdi.updatePhonebyID(newVal, custID);
			assertEquals(newVal, c2.getPhone());
			}catch (SQLException e) {
			System.out.println("testUpdatePhone problem");
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteCust() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		try {
			boolean test;
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			cdi.deleteCust(custID);
			PreparedStatement ps = conn.prepareStatement("delete from \"Customers\" where \"USER_ID\"= ?");
			ps.setInt(1,custID);
			ResultSet rs = ps.executeQuery();
			  if(rs!=null) {
	                while(rs.next()) {
	                    test = true;
	                }
	            }test = false;
	            assertEquals(false,test);
		} catch (SQLException e) {
			System.out.println("delete problems");
		}
	}

//	@Test
//	public void testGetCustomerByUsername(){
//		Customer c = new Customer("firsttest","mtest","lasttest","123 Test st","City","ST","12345","TestUsertest","TestPasswordtest",0);
//		try {
//			cdi.newCustomer(c);
//			boolean test;
//			test = cdi.getCustomerByUsername("TestUsertest");
//			assertEquals(test,true);
//		} catch (SQLException e) {
//			System.out.println("testGetCustomerByUsername problem");
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testgetIDByUsername() {
//		Customer c = new Customer("firsttest","mtest","lasttest","123 Test st","City","ST","12345","TestUsertest","TestPasswordtest",0);
//		try {
//			long test = 0;
//			cdi.newCustomer(c);
//			test = cdi.getCustIDByUsername("TestUsertest");
//			System.out.println(test);
//			assertTrue(test>0);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}


//	@Test
//	public void testUpdateCustomerPassword() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateCustomerAddress() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateCustomerAccounts() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteCustomer() {
//		fail("Not yet implemented");
//	}

}
