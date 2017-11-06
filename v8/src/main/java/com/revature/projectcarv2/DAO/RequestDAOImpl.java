package com.revature.projectcarv2.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.projectcarv2.beans.Request;
import com.revature.projectcarv2.connection.ConnFactory;

public class RequestDAOImpl implements RequestDAO
{
	public ConnFactory cf = ConnFactory.getInstance();

	
	@Override
	public void createRequest(int empID, int reqType, String description, String justification, 
			String locName, String locStreet, String locCity, String locState, String locZip, double cost, 
			Date EventStartDate, Date EventEndDate, double hoursMissed)
	{
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "REQ_ID";
		
		String sql = "INSERT INTO REQUEST(REQ_EMP_ID, REQ_TYPE, REQ_DESCRIPTION, REQ_JUSTIFICATION,"
				+" REQ_LOC_NAME, REQ_LOC_STREET, REQ_LOC_CITY, REQ_LOC_STATE, REQ_LOC_ZIP, REQ_COST, "
				+ "REQ_EVENT_START, REQ_EVENT_END, REQ_HOURS_MISSED) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = cf.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
			
			stmt.setInt(1, empID);
			stmt.setInt(2, reqType);
			stmt.setString(3, description);
			stmt.setString(4, justification);
			stmt.setString(5, locName);
			stmt.setString(6, locStreet);
			stmt.setString(7, locCity);
			stmt.setString(8, locState);
			stmt.setString(9, locZip);
			stmt.setDouble(10, cost);
			stmt.setDate(11, EventStartDate);
			stmt.setDate(12, EventEndDate);
			stmt.setDouble(13, hoursMissed);		
			//stmt.setInt(14, 0);
			//stmt.setInt(15, getBenCo());

			stmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	
	}
	
/*	@Override
	public void createRequest(Request r) 
	{
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "REQ_ID";
		
		String sql = "INSERT INTO REQUEST(REQ_EMP_ID, REQ_TYPE, REQ_DESCRIPTION, REQ_JUSTIFICATION,"
				+" REQ_LOC_NAME, REQ_LOC_STREET, REQ_LOC_CITY, REQ_LOC_STATE, REQ_LOC_ZIP, REQ_COST, "
				+ "REQ_EVENT_START, REQ_EVENT_END, REQ_HOURS_MISSED, REQ_STATUS, REQ_BENCO) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = cf.getConnection();)
		{
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
			
			stmt.setInt(1, r.getEmp_id());
			stmt.setInt(2, r.getType());
			stmt.setString(3, r.getDescription());
			stmt.setString(4, r.getJustification());
			stmt.setString(5, r.getLocName() );
			stmt.setString(6, r.getLocStreet() );
			stmt.setString(7, r.getLocCity() );
			stmt.setString(8, r.getLocState() );
			stmt.setString(9, r.getLocZip() );
			stmt.setDouble(10, r.getCost());
			stmt.setDate(11, r.getEventStartDate());
			stmt.setDate(12, r.getEventEndDate());
			stmt.setDouble(13, r.getHoursMissed());		
			stmt.setInt(14, 0);
			stmt.setInt(15, getBenCo());

			stmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}*/

	@Override
	public Request getRequestById(int req_id) throws SQLException 
	{
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM REQUEST WHERE REQ_ID = " + req_id);
		Request r = null;
		
		while(rs.next())
		{	
			r = extractRequest(rs);
		}
		
		conn.close();
		return r;
	}
	
	public ArrayList<Request> getRequestsByEmpID(int emp_id) throws SQLException 
	{
		ArrayList<Request> empReqs = new ArrayList<Request>();
		
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
			rs = stmt.executeQuery("SELECT * FROM REQUEST WHERE REQ_EMP_ID = " + emp_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(rs.next())
		{			
			empReqs.add(  extractRequest(rs));
		}
		
		conn.close();
		
		if (empReqs.isEmpty())
			return null;
		else return empReqs;
	}

	@Override
	public ArrayList<Request> getRequestsForBenCoInitApp(int benCo_id) throws SQLException {

		ArrayList<Request> benCoReqs = new ArrayList<Request>();
		
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
			rs = stmt.executeQuery("SELECT * FROM REQUEST WHERE REQ_BENCO = " + benCo_id +"AND REQ_STATUS = 2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(rs.next())
		{			
			benCoReqs.add( extractRequest(rs));
		}
		
		conn.close();
		
		if (benCoReqs.isEmpty())
			return null;
		else return benCoReqs;
	}

	@Override
	public ArrayList<Request> getRequestsForDSInitApp(int dS_id) throws SQLException {

		ArrayList<Request> dSReqs = new ArrayList<Request>();
		
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
			rs = stmt.executeQuery("SELECT * FROM REQUEST WHERE REQ_EMP_ID IN (SELECT EMP_ID FROM EMPLOYEE WHERE EMP_REPORTSTO = " + dS_id +") AND REQ_STATUS = 0");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(rs.next())
		{			
			dSReqs.add( extractRequest(rs));
		}
		
		/*if (dSReqs.isEmpty())
			return null;
		else*/ return dSReqs;
	}
	
	@Override
	public ArrayList<Request> getRequestsForDH(int dH_id) throws SQLException {
		
		ArrayList<Request> dHReqs = new ArrayList<Request>();
		
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
			rs = stmt.executeQuery("SELECT * FROM REQUEST WHERE REQ_EMP_ID IN (SELECT EMP_ID FROM EMPLOYEE WHERE EMP_DEPARTMENT IN ( SELECT DEPARTMENT_ID FROM DEPARTMENT WHERE DEPARTMENT_HEAD = " + dH_id +")) AND REQ_STATUS = 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(rs.next())
		{			
			dHReqs.add( extractRequest(rs));
		}
		
		conn.close();
		
		if (dHReqs.isEmpty())
			return null;
		else return dHReqs;
	}
	
	@Override
	public void dSApproval(int dS_id, int req_id) throws SQLException {
		// TODO Auto-generated method stub
			
		//String sql = "EXECUTE DS_APPROVAL(?,?)";
		
		Connection conn = cf.getConnection();
			
		CallableStatement proc = null;
		
		proc = conn.prepareCall("{ call DS_APPROVAL(?,?) }");
		proc.setInt(1, dS_id);
		proc.setInt(2, req_id);
		proc.execute();
		
		proc.close();
		
		conn.close();
		
		/*PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, dS_id);
		stmt.setInt(2, req_id);
		
		stmt.executeUpdate();*/
		
		return;
	}
	
	@Override
	public void dHApproval(int dH_id, int req_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		
		CallableStatement proc = null;
		
		proc = conn.prepareCall("{ call DH_APPROVAL(?,?) }");
		proc.setInt(1, dH_id);
		proc.setInt(2, req_id);
		proc.execute();
		
		proc.close();
		
		conn.close();
		
		return;
	}
	
	@Override
	public void bCApproval(int bC_id, int req_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		
		CallableStatement proc = null;
		
		proc = conn.prepareCall("{ call BC_APPROVAL(?,?) }");
		proc.setInt(1, bC_id);
		proc.setInt(2, req_id);
		proc.execute();
		
		proc.close();
		
		conn.close();
		
		return;
	}
	
	private Request extractRequest(ResultSet rs) throws SQLException
	{
		int req_id = rs.getInt(1);
		int empid = rs.getInt(2);
		int type = rs.getInt(3);
		String description = rs.getString(4);
		String justification = rs.getString(5);
		
		String locName = rs.getString(6);
		String locStreet = rs.getString(7);
		String locCity = rs.getString(8);
		String locState = rs.getString(9);
		String locZip = rs.getString(10);
		
		double cost = rs.getDouble(11);
		double reimb = rs.getDouble(12);
		String reason = rs.getString(13);
		
		Date appDate = rs.getDate(14);
		Date eventStart = rs.getDate(15);
		Date eventEnd = rs.getDate(16);
		double hoursMissed = rs.getDouble(17);
		
		int status = rs.getInt(18);
		int benCo = rs.getInt(19);
		
		return new Request(req_id, empid, type, description, justification, locName, locStreet, locCity, locState, locZip, 
				cost, reimb, reason, appDate, eventStart, eventEnd, hoursMissed, status, benCo);
	}



	




}
