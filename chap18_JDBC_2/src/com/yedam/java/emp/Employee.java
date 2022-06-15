package com.yedam.java.emp;

import java.sql.Date;

//VO클래스 : 한 행에 대한 모든값을 가지고 있어야함.
public class Employee {
	//필드
		// 해당 테이블의 모든 컬럼이 대응됨.
		//
	private int employeeId;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Double salary;
	private Double commission;
	private int managerId;
	private int departmentId;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + ", commission=" + commission + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ "]";
	}
	
	
	
	//getter,setter
	
}
