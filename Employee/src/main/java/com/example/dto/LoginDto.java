package com.example.dto;

public class LoginDto {
	private String email;
	private String empid;
	
	private String password;
	private String role;
	private String fullname;
	
	public LoginDto(String email,String empid, String password, String role, String fullname) {
		super();
		this.email = email;
		this.empid = empid;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
	}

	
	
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmpid() {
		return empid;
	}



	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
