package com.revature.projectcarv2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.projectcarv2.DAO.EmployeeDAOImpl;
import com.revature.projectcarv2.beans.Employee;

//import oracle.net.aso.e;


//@WebServlet("/login")
public class loginServlet extends HttpServlet {
	

    /**
     * Default constructor. 
     */
    public loginServlet() 
    {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		EmployeeDAOImpl eDAO = new EmployeeDAOImpl();
		
		
		/*EmployeeDAOImpl eDAO = new EmployeeDAOImpl();
		ObjectMapper mapper = new ObjectMapper();
		
		Employee e = mapper.readValue(request.getParameter("employee", Employee.class));
		
		e = eDAO.getEmployee(e.getId());
		
		PrintWriter pw = request.getWriter();

		pw.write("{ id: " + e.getId() + " username: " + e.getUsername() + 
				", firstName: " + e.getFirstName() + ", lastName: " +
				e.getLastName() + ", midInitial: " + e.getMidInitial() + 
				", position: " + e.getPosition() + ", department: " + e.getDepartment() + 
				", reportsTo: " + e.getReportsTo() + ", street: " + e.getStreet() +
				", city: " + e.getCity() + ", state: " + e.getState() + ", zip: " +
				e.getZip() + ", country: " + e.getCountry());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.err.println("Poop");
		
		writer.print("something");
		
		System.out.println(request.getParameter("login"));
		
		JSONObject jObj = new JSONObject(request.getParameter("login"));
	    //JSONObject newObj = jObj.getJSONObject(request.getParameter("login"));
		Iterator<e> it = jObj.keys();

		if(it.hasNext())
		{
			String key = it.next();
			String val= jObj.get(key);
			System.out.println(key + val);
		}
		
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    
	    String name = request.getParameter("username");
	    
	    System.out.println(name);
		
	}*/
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		System.out.println("poop");
		
		/*EmployeeDAOImpl eDAO = new EmployeeDAOImpl();
		ObjectMapper mapper = new ObjectMapper();
		
		Employee e = mapper.readValue(request.getParameter("employee", Employee.class));
		e = eDAO.getEmployee(e.getId());
		
		String employee = mapper.writeValueAsString(e);
		response.setContentType("application/json");
		
		PrintWriter pw = request.getWriter();
 
		if(e == null)
		{
			pw.write("");
		}
		else
		{
			pw.write(employee);
		}*/
	}
	
}
