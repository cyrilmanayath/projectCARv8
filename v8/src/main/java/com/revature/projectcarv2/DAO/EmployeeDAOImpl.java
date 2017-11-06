package com.revature.projectcarv2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.projectcarv2.beans.Employee;
import com.revature.projectcarv2.DAO.EmployeeDAO;
import com.revature.projectcarv2.connection.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO
{
	public ConnFactory cf = ConnFactory.getInstance();

	public Employee getEmployee(int id) throws SQLException
	{
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = " + id);
		Employee e = null;
		
		while(rs.next())
		{
			long newId = rs.getInt(1);
			String username = rs.getString(2);
			//String password = rs.getString(3);
			String firstName = rs.getString(4);
			String lastName = rs.getString(5);
			String midInitial = rs.getString(6);
			String position = rs.getString(7);
			long department = rs.getInt(8);
			
			
			long reportsTo = rs.getInt(9);
			String street = rs.getString(10);
			String city = rs.getString(11);
			String state = rs.getString(12);
			String zip = rs.getString(13);
			
			e = new Employee((int)newId, username,/* password,*/ firstName,
					lastName, midInitial, (int)department, position, (int)reportsTo, 
					street, city, state, zip);
		}
		
		conn.close();
		return e;
	}
	
	@Override
	public Employee loginValidation(String loginUsername, String loginPassword) throws SQLException  {

		Connection conn = cf.getConnection();
		Statement stmt =null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_USERNAME = '" + loginUsername + "' AND EMP_PASSWORD = '" + loginPassword +"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Employee loginOne = null;
		
		while(rs.next())
		{
			long newId = rs.getInt(1);
			String username = rs.getString(2);
			//String password = rs.getString(3);
			String firstName = rs.getString(4);
			String lastName = rs.getString(5);
			String midInitial = rs.getString(6);
			String position = rs.getString(7);
			long department = rs.getInt(8);
			
			
			long reportsTo = rs.getInt(9);
			String street = rs.getString(10);
			String city = rs.getString(11);
			String state = rs.getString(12);
			String zip = rs.getString(13);
			
			loginOne = new Employee((int)newId, username,/* password,*/ firstName,
					lastName, midInitial, (int)department, position, (int)reportsTo, 
					street, city, state, zip);
		}
		
		
		
		
		
		return loginOne;
	}
}
