package com.revature.projectcarv2.test;

import com.revature.projectcarv2.beans.Employee;
import com.revature.projectcarv2.beans.Request;
import com.revature.projectcarv2.connection.ConnFactory;

import java.io.PrintWriter;

import java.sql.Date;
import java.sql.SQLException;

import com.revature.projectcarv2.DAO.EmployeeDAO;
import com.revature.projectcarv2.DAO.EmployeeDAOImpl;
import com.revature.projectcarv2.DAO.RequestDAO;
import com.revature.projectcarv2.DAO.RequestDAOImpl;


public class tester {
	
	public static EmployeeDAOImpl testE= new EmployeeDAOImpl();
	
	public static RequestDAOImpl testR= new RequestDAOImpl();

	public static void main (String[] args) {
	
		try {
			System.out.println(testE.getEmployee(1).getFirstName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		testR.createRequest(34, 0, "Graphic Desgin 101 - Class that teaches the basics of graphic design.",
				"I need to be able to make better designed displays, particularly in regards to readability.",
				"Northern Virginia Community College", "1831 Wiehle Ave", "Reston", "VA", "20190", 350.75, Date.valueOf("2018-01-24"), Date.valueOf("2018-05-02"), 60.50);
		
		try {
			System.out.println(testE.loginValidation("Founder", "masterPass").getFirstName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println( testR.getRequestById(1).getDescription()+ "Requests only");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println( testR.getRequestsByEmpID(34).get(0).getDescription()+"EMP requests");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (!testR.getRequestsForDSInitApp(32).isEmpty())
				System.out.println( testR.getRequestsForDSInitApp(32).get(0).getDescription()+"ds desc");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
				testR.dSApproval(32, 1);
			System.out.println(testR.getRequestById(1).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		try {
			testR.dSApproval(32, 2);
		System.out.println(testR.getRequestById(1).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		try {
			testR.dHApproval(7, 1);
		System.out.println(testR.getRequestById(1).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		try {
			testR.dHApproval(7, 1);
		System.out.println(testR.getRequestById(1).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		try {
			testR.bCApproval(12, 1);
		System.out.println(testR.getRequestById(1).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
		testR.createRequest(20, 0, "Accounting 256 - Class that teaches intermediate accounting.",
		"The design department needs to be better able to manage its funds",
		"Northern Virginia Community College", "1831 Wiehle Ave", "Reston", "VA", "20190", 275.50, Date.valueOf("2018-01-24"), Date.valueOf("2018-05-02"), 60.50);
			
		try {
			System.out.println( testR.getRequestById(21).getDescription()+ "Requests only");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println( testR.getRequestsByEmpID(20).get(0).getDescription()+"EMP requests");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (!testR.getRequestsForDSInitApp(4).isEmpty())
				System.out.println( testR.getRequestsForDSInitApp(4).get(0).getDescription()+"ds desc");
				System.out.println(testR.getRequestById(21).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
				testR.dSApproval(4, 21);
			System.out.println(testR.getRequestById(21).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		try {
			testR.dSApproval(4, 21);
		System.out.println(testR.getRequestById(21).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		try {
			testR.dHApproval(4, 21);
		System.out.println(testR.getRequestById(21).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		try {
			testR.dHApproval(4, 21);
		System.out.println(testR.getRequestById(21).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		try {
			testR.bCApproval(10, 21);
		System.out.println(testR.getRequestById(1).getStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
	}
}
