package com.revature.projectcarv2.beans;

import java.sql.Date;

public class Request {

	private int req_id;
	private int emp_id;
	private int type;
	private String description;
	private String justification;
	private String locName;
	private String locStreet;
	private String locCity;
	private String locState;
	private String locZip;
	private double cost;
	private double reimb;
	private String reason;
	private Date appDate;
	private Date eventStartDate;
	private Date eventEndDate;
	private double hoursMissed;
	private int status;
	private int benCo_id;	
	
	public Request(int req_id, int emp_id, int type, String description, String justification, String locName,
			String locStreet, String locCity, String locState, String locZip, double cost, double reimb, String reason,
			Date appDate, Date eventStartDate, Date eventEndDate, double hoursMissed, int status, int benCo_id) {
		super();
		this.req_id = req_id;
		this.emp_id = emp_id;
		this.type = type;
		this.description = description;
		this.justification = justification;
		this.locName = locName;
		this.locStreet = locStreet;
		this.locCity = locCity;
		this.locState = locState;
		this.locZip = locZip;
		this.cost = cost;
		this.reimb = reimb;
		this.reason = reason;
		this.appDate = appDate;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.hoursMissed = hoursMissed;
		this.status = status;
		this.benCo_id = benCo_id;
	}
	

	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public String getLocStreet() {
		return locStreet;
	}
	public void setLocStreet(String locStreet) {
		this.locStreet = locStreet;
	}
	public String getLocCity() {
		return locCity;
	}
	public void setLocCity(String locCity) {
		this.locCity = locCity;
	}
	public String getLocState() {
		return locState;
	}
	public void setLocState(String locState) {
		this.locState = locState;
	}
	public String getLocZip() {
		return locZip;
	}
	public void setLocZip(String locZip) {
		this.locZip = locZip;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getReimb() {
		return reimb;
	}
	public void setReimb(double reimb) {
		this.reimb = reimb;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public Date getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	public Date getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	public double getHoursMissed() {
		return hoursMissed;
	}
	public void setHoursMissed(double hoursMissed) {
		this.hoursMissed = hoursMissed;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBenCo_id() {
		return benCo_id;
	}
	public void setBenCo_id(int benCo_id) {
		this.benCo_id = benCo_id;
	}
	
	
	
}
