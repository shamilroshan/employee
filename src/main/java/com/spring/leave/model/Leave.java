package com.spring.leave.model;

import org.springframework.stereotype.Component;

@Component
public class Leave {
	
	private int id;
	private int emp_id;
	private String month;
	private String casual_leave_available;
	private String sick_leave_available;
	private String paid_leave_available;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getCasual_leave_available() {
		return casual_leave_available;
	}
	public void setCasual_leave_available(String casual_leave_available) {
		this.casual_leave_available = casual_leave_available;
	}
	public String getSick_leave_available() {
		return sick_leave_available;
	}
	public void setSick_leave_available(String sick_leave_available) {
		this.sick_leave_available = sick_leave_available;
	}
	public String getPaid_leave_available() {
		return paid_leave_available;
	}
	public void setPaid_leave_available(String paid_leave_available) {
		this.paid_leave_available = paid_leave_available;
	}

}
