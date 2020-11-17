package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountsDao;
import com.revature.users.Accounts;
import com.revature.users.Accounts.accountType;
import com.revature.users.Customer;
import com.revature.util.ConnFactory;

public class AccountsDaoImpl implements AccountsDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createAccount(Accounts acct) throws SQLException {
		
		String enumType = acct.getType().toString();
		
		Connection conn = cf.getConnection();
		String sql = "insert into \"Accounts\" values(DEFAULT,?,?,0.0)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, acct.getUser_id());
		ps.setString(2, enumType);
		ps.executeUpdate();
	}

	@Override
	public List<Accounts> getAllAccounts(Customer cust) throws SQLException {
		
		List<Accounts> acctList= new ArrayList<Accounts>();
		Connection conn= cf.getConnection();
		String sql = "select * from \"Accounts\" where \"USER_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cust.getUser_id());
		ResultSet rs = ps.executeQuery();

		Accounts a = null;
		while(rs.next()) {
			a= new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
			acctList.add(a);
		}
		return acctList;
	}
	
	public Accounts getAccountbyID(int option) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from \"Accounts\" where \"BANK_ACCOUNT_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, option);
		ResultSet rs = ps.executeQuery();
		
		Accounts a = null;
		while(rs.next()) {
			a= new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
		}
		
		return a;
	}
	
	public double getBalance(Accounts a) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from \"Accounts\" where \"BANK_ACCOUNT_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, a.getBankAccountID());
		ResultSet rs = ps.executeQuery();
		double balance = 0.0;
		if(rs != null) {
			while(rs.next()) {
				balance = rs.getDouble(4);
				return balance;
				}
			}
		return 0;
	}
	
	public void deposit(Accounts a, double deposit) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from \"Accounts\" where \"BANK_ACCOUNT_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, a.getBankAccountID());
		ResultSet rs = ps.executeQuery();
		double balance = 0.0;
		if(rs != null) {
			while(rs.next()) {
				balance = rs.getDouble(4);
				}
			}
		double updateBalance = balance + deposit;
		
		String sql2 = "update \"Accounts\" set \"balance\"=? where \"BANK_ACCOUNT_ID\"= ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setDouble(1, updateBalance);
		ps2.setInt(2, a.getBankAccountID());
		
		ps2.executeUpdate();
		
	}
	
	public void withdraw(Accounts a, double withdraw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from \"Accounts\" where \"BANK_ACCOUNT_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, a.getBankAccountID());
		ResultSet rs = ps.executeQuery();
		double balance = 0.0;
		if(rs != null) {
			while(rs.next()) {
				balance = rs.getDouble(4);
				}
			}
		double updateBalance = balance - withdraw;
		
		String sql2 = "update \"Accounts\" set \"balance\"=? where \"BANK_ACCOUNT_ID\"= ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setDouble(1, updateBalance);
		ps2.setInt(2, a.getBankAccountID());
		
		ps2.executeUpdate();
	}
	
	public void deleteCustAcct(Accounts a) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from \"Accounts\" where \"BANK_ACCOUNT_ID\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, a.getBankAccountID());
		ps.executeUpdate();
		
	}
}
