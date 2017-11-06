package com.revature.projectcarv2.DAO;

import java.sql.SQLException;

import com.revature.projectcarv2.beans.Employee;
import com.revature.projectcarv2.beans.Request;

public interface EmployeeDAO 
{
	public Employee getEmployee(int id) throws SQLException;
	
	public Employee loginValidation(String loginUsername, String loginPassword) throws SQLException ;
}
