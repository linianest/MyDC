package com.ln.mybaits.bean;

public class Employee {
	
	private Integer id;
	private String lastName;
	private String email;
	private String gender;
	//员工状态
	private EmpStatus empStatus=EmpStatus.LOGOUT;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public EmpStatus getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(EmpStatus empStatus) {
		this.empStatus = empStatus;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + "]";
	}
	public Employee() {
		super();
	}
	public Employee(String lastName, String email, String gender) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}
	
}
