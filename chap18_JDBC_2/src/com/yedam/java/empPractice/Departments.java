package com.yedam.java.empPractice;

public class Departments {

	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	public int getdepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "Departments [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}
	
	
}
