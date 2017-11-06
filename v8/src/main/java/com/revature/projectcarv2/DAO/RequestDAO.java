package com.revature.projectcarv2.DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.projectcarv2.beans.Request;

public interface RequestDAO 
{
	//public void createRequest(Request r);

	public void createRequest(int empID, int reqType, String description, String justification, 
			String locName, String locStreet, String locCity, String locState, String locZip, double cost, 
			Date EventStartDate, Date EventEndDate, double hoursMissed);
	
	public Request getRequestById(int id) throws SQLException;
	
	public ArrayList<Request> getRequestsByEmpID(int emp_id)  throws SQLException;
	
	public ArrayList<Request> getRequestsForBenCoInitApp(int benCo_id)  throws SQLException;
	
	public ArrayList<Request> getRequestsForDSInitApp(int dS_id) throws SQLException;
	
	public ArrayList<Request> getRequestsForDH(int dH_id) throws SQLException;
	
	public void dSApproval(int dS_id, int req_id) throws SQLException;
	
	public void dHApproval(int dH_id, int req_id) throws SQLException;
	
	public void bCApproval(int bC_id, int req_id) throws SQLException;
}
